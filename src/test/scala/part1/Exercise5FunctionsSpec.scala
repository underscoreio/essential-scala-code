package part1

import org.scalatest._

class Exercise5FunctionsSpec extends FlatSpec with Matchers {
  import Exercise5Functions._

  "contains" should "find elements in a list" in {
    contains(List(1, 2, 3), 2) should equal(true)
    contains(List(1, 2, 3), 4) should equal(false)
    contains(Nil, 1) should equal(false)
  }

  "containsEvenNumbers" should "find even elements" in {
    containsEvenNumbers(List(1, 2, 3)) should equal(true)
    containsEvenNumbers(Nil) should equal(false)
  }

  "evenNumbersOnly" should "filter for even elements" in {
    evenNumbersOnly(List(1, 2, 3, 4)) should equal(List(2, 4))
    evenNumbersOnly(Nil) should equal(Nil)
  }

  "doubleEachNumber" should "filter for even elements" in {
    doubleEachNumber(List(1, 2, 3, 4)) should equal(List(2, 4, 6, 8))
    doubleEachNumber(Nil) should equal(Nil)
  }

  "multiplyEachNumberBy" should "filter for even elements" in {
    multiplyEachNumberBy(List(1, 2, 3, 4), 3) should equal(List(3, 6, 9, 12))
    multiplyEachNumberBy(Nil, 3) should equal(Nil)
    multiplyEachNumberBy(List(1, 2, 3, 4), 0) should equal(List(0, 0, 0, 0))
  }

  "evenNumbersOnlyDoubled" should "filter for even elements" in {
    evenNumbersOnlyDoubled(List(1, 2, 3, 4)) should equal(List(4, 8))
    evenNumbersOnlyDoubled(Nil) should equal(Nil)
  }
}
