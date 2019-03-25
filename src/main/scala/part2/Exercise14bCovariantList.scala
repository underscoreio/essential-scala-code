package part2

sealed abstract class MyListB[+A] {
  def exists(func: A => Boolean): Boolean =
    this match {
      case MyPairB(head, tail) =>
        func(head) || tail.exists(func)

      case MyNilB => false
    }

  def map[B](func: A => B): MyListB[B] =
    this match {
      case MyPairB(hear, tail) =>
        MyPairB(func(hear), tail.map(func))

      case MyNilB => MyNilB

    }

  // Harder
  def filter(func: A => Boolean): MyListB[A] =
    this match {
      case MyPairB(head, tail) =>
        if(func(head)) {
          MyPairB(head, tail.filter(func))
        } else {
          tail.filter(func)
        }

      case MyNilB => MyNilB
    }

  // Harder
  def append[B >: A](that: MyListB[B]): MyListB[B] =
    this match {
      case MyPairB(hear, tail) =>
        MyPairB(hear, tail append that)
      case MyNilB => that

    }

  // Harder
  def reduce[B](accum: B, func: (B, A) => B): B =
    this match {
      case MyPairB(head, tail) =>
        tail.reduce(func(accum, head), func)

      case MyNilB => accum
    }
}

final case class MyPairB[A](head: A, tail: MyListB[A]) extends MyListB[A]

case object MyNilB extends MyListB[Nothing]

object Exercise14GenericList {
  val numbers: MyListB[Int] =
    MyPairB(1, MyPairB(3, MyPairB(5, MyNilB)))

  val strings: MyListB[String] =
    MyPairB("foo", MyPairB("bar", MyPairB("baz", MyNilB)))

  val shapes: MyListB[Shape] =
    MyPairB(
      Circle(20, Color(1, 1, 0)),
      MyPairB(
        Circle(10, Color(1, 1, 0)),
        MyPairB(
          Rect(30, 20, Color(1, 0, 1)),
          MyNilB)))

  println("exists")
  println(numbers.exists(n => n > 1))
  println(strings.exists(s => s.startsWith("b")))
  println(shapes.exists(s => s.area > 100))

  println("map")
  println(numbers.map(n => n + 1))
  println(strings.map(s => s + "!"))
  println(shapes.map(s => s.toString))

  println("append")
  println(numbers.append(numbers))
  println(strings.append(strings))
  println(shapes.append(shapes))

  println("filter")
  println(numbers.filter(n => n > 1))
  println(strings.filter(s => s.startsWith("b")))
  println(shapes.filter(s => s.area > 50))
}
