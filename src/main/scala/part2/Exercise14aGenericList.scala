package part2

sealed abstract class MyList[A] {
  def exists(func: A => Boolean): Boolean =
    this match {
      case MyPair(head, tail) =>
        func(head) || tail.exists(func)

      case MyNil() => false
    }

  def map[B](func: A => B): MyList[B] =
    this match {
      case MyPair(hear, tail) =>
        MyPair(func(hear), tail.map(func))

      case MyNil() => MyNil()

    }

  def reduce(accum: A, func: (A, A) => A): A =
    this match {
      case MyPair(head, tail) =>
        tail.reduce(func(accum, head), func)

      case MyNil() => accum
    }

  // Harder
  def append(that: MyList[A]): MyList[A] =
    this match {
      case MyPair(hear, tail) =>
        MyPair(hear, tail append that)
      case MyNil() => that

    }

  // Harder
  def filter(func: A => Boolean): MyList[A] =
    this match {
      case MyPair(head, tail) =>
        if(func(head)) {
          MyPair(head, tail.filter(func))
        } else {
          tail.filter(func)
        }

      case MyNil() => MyNil()
    }
}

final case class MyPair[A](head: A, tail: MyList[A]) extends MyList[A]

final case class MyNil[A]() extends MyList[A]

object Exercise14aGenericList {
  val numbers: MyList[Int] =
    MyPair(1, MyPair(3, MyPair(5, MyNil())))

  val strings: MyList[String] =
    MyPair("foo", MyPair("bar", MyPair("baz", MyNil())))

  val shapes: MyList[Shape] =
    MyPair(
      Circle(20, Color(1, 1, 0)),
      MyPair(
        Circle(10, Color(1, 1, 0)),
        MyPair(
          Rect(30, 20, Color(1, 0, 1)),
          MyNil())))

  println("exists")
  println(numbers.exists(n => n > 1))
  println(strings.exists(s => s.startsWith("b")))
  println(shapes.exists(s => s.area > 100))

  println("map")
  println(numbers.map(n => n + 1))
  println(strings.map(s => s + "!"))
  println(shapes.map(s => s.toString))

  println("reduce")
  println(numbers.reduce(0, (a, b) => a + b))
  println(strings.reduce("", (a, b) => a + b))

  println("append")
  println(numbers.append(numbers))
  println(strings.append(strings))
  println(shapes.append(shapes))

  println("filter")
  println(numbers.filter(n => n > 1))
  println(strings.filter(s => s.startsWith("b")))
  println(shapes.filter(s => s.area > 50))
}
