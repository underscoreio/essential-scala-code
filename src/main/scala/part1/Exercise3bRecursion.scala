package part1

object Exercise3bRecursion:
  // Analogue for contains
  def contains(numbers: List[Int], num: Int): Boolean =
    if numbers.isEmpty then
      false
    else if numbers.head == num then
      true
    else
      contains(numbers.tail, num)

  // Analogue for map
  def doubleEachNumber(numbers: List[Int]): List[Int] =
    if numbers.isEmpty then
      Nil
    else
      numbers.head * 2 +: doubleEachNumber(numbers.tail)

  // Analogue for fold
  def total(numbers: List[Int]): Int =
    if numbers.isEmpty then
      0
    else
      numbers.head + total(numbers.tail)

  // Analogue for range
  def range(from: Int, to: Int): List[Int] =
    if from > to then
      Nil
    else
      from +: range(from + 1, to)

  // Analogue for append
  def append(a: List[Int], b: List[Int]): List[Int] =
    if a.isEmpty then
      b
    else
      a.head +: append(a.tail, b)

  def main(): Unit =
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

    println("range")
    println(range(3, 5))

    println("append")
    println(append(List(1, 2, 3), List(4, 5, 6)))
    println(append(Nil, Nil))
