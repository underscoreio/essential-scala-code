package part1

object Exercise4PatternMatching:
  // Analogue for foreach
  def greetNTimes(name: String, n: Int): Unit =
    n match
      case 0 => println(s"Hello $name!")
      case n => greetNTimes(name, n - 1)

  // Analogue for contains
  def contains(numbers: List[Int], num: Int): Boolean =
    numbers match
      case Nil          => false
      case head :: tail => head == num || contains(tail, num)

  // Analogue for map
  def doubleEachNumber(numbers: List[Int]): List[Int] =
    numbers match
      case Nil          => Nil
      case head :: tail => head * 2 :: doubleEachNumber(tail)

  // Analogue for fold
  def total(numbers: List[Int]): Int =
    numbers match
      case Nil          => 0
      case head :: tail => head + total(tail)

  // Analogue for append
  def append(a: List[Int], b: List[Int]): List[Int] =
    a match
      case Nil          => b
      case head :: tail => head :: append(tail, b)

  def main(): Unit =
    println("greetNTimes")
    println(greetNTimes("world", 5))
    println(greetNTimes("nope", 0))

    println("contains")
    println(contains(List(1, 2, 3), 2))
    println(contains(List(1, 2, 3), 4))
    println(contains(Nil, 1))

    println("doubleEachNumber")
    println(doubleEachNumber(List(1, 2, 3, 4)))
    println(doubleEachNumber(Nil))

    println("total")
    println(total(List(1, 2, 3, 4)))
    println(total(Nil))

    println("append")
    println(append(List(1, 2, 3), List(4, 5, 6)))
    println(append(Nil, Nil))
