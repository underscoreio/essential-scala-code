package part2

enum MyList[A]:
  case Pair(head: A, tail: MyList[A])
  case Nil()

  def exists(func: A => Boolean): Boolean =
    this match
      case Pair(head, tail) => func(head) || tail.exists(func)
      case Nil() => false

  def map[B](func: A => B): MyList[B] =
    this match
      case Pair(hear, tail) => Pair(func(hear), tail.map(func))
      case Nil() => Nil()

  def reduce(accum: A, func: (A, A) => A): A =
    this match
      case Pair(head, tail) => tail.reduce(func(accum, head), func)
      case Nil() => accum

  // Harder
  def append(that: MyList[A]): MyList[A] =
    this match
      case Pair(hear, tail) => Pair(hear, tail append that)
      case Nil() => that

  // Harder
  def filter(func: A => Boolean): MyList[A] =
    this match
      case Pair(head, tail) => if func(head) then Pair(head, tail.filter(func)) else tail.filter(func)
      case Nil() => Nil()

object Exercise14aGenericList:
  import MyList._

  val numbers: MyList[Int] =
    Pair(1, Pair(3, Pair(5, Nil())))

  val strings: MyList[String] =
    Pair("foo", Pair("bar", Pair("baz", Nil())))

  val shapes: MyList[Shape] =
    Pair(
      Circle(20, Color(1, 1, 0)),
      Pair(
        Circle(10, Color(1, 1, 0)),
        Pair(
          Rect(30, 20, Color(1, 0, 1)),
          Nil())))

  def main(): Unit =
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
