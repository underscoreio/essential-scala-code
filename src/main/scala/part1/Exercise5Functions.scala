package part1

object Exercise5Functions:
  def contains(numbers: List[Int], num: Int): Boolean =
    numbers.contains(num)

  def containsEvenNumbers(numbers: List[Int]): Boolean =
    numbers.exists(n => n % 2 == 0)

  def evenNumbersOnly(numbers: List[Int]): List[Int] =
    numbers.filter(n => n % 2 == 0)

  def doubleEachNumber(numbers: List[Int]): List[Int] =
    numbers.map(n => n * 2)

  def multiplyEachNumberBy(numbers: List[Int], num: Int): List[Int] =
    numbers.map(n => n * num)

  def evenNumbersOnlyDoubled(numbers: List[Int]): List[Int] =
    numbers.filter(n => n % 2 == 0).map(n => n * 2)

  def main(): Unit =
    println("contains")
    println(contains(List(1, 2, 3), 2))
    println(contains(List(1, 2, 3), 4))
    println(contains(Nil, 1))

    println("containsEvenNumbers")
    println(containsEvenNumbers(List(1, 2, 3)))
    println(containsEvenNumbers(List(1, 3, 5)))
    println(containsEvenNumbers(Nil))

    println("evenNumbersOnly")
    println(evenNumbersOnly(List(1, 2, 3, 4)))
    println(evenNumbersOnly(Nil))

    println("doubleEachNumber")
    println(doubleEachNumber(List(1, 2, 3, 4)))
    println(doubleEachNumber(Nil))

    println("multiplyEachNumberBy")
    println(multiplyEachNumberBy(List(1, 2, 3, 4), 5))
    println(multiplyEachNumberBy(List(1, 2, 3, 4), 10))
    println(multiplyEachNumberBy(Nil, 100))

    println("evenNumbersOnlyDoubled")
    println(evenNumbersOnlyDoubled(List(1, 2, 3, 4)))
    println(evenNumbersOnlyDoubled(Nil))
