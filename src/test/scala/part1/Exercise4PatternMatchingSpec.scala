package part1

import org.scalatest._

class Exercise4PatternMatchingSpec extends FlatSpec with Matchers {
  import Exercise4PatternMatching._

  "contains" should "find elements in a list" in {
    contains(List(1, 2, 3), 2) should equal(true)
    contains(List(1, 2, 3), 4) should equal(false)
    contains(Nil, 1) should equal(false)
  }

  "doubleEachNumber" should "double all elements in a list" in {
    doubleEachNumber(List(1, 2, 3)) should equal(List(2, 4, 6))
    doubleEachNumber(Nil) should equal(Nil)
  }

  "total" should "add up all the elements in a list" in {
    total(List(1, 2, 3)) should equal(1 + 2 + 3)
    total(Nil) should equal(0)
  }

  "append" should "append two lists" in {
    append(List(1, 2, 3), List(4, 5, 6)) should equal(List(1, 2, 3, 4, 5, 6))
    append(List(1, 2, 3), Nil) should equal(List(1, 2, 3))
    append(Nil, List(1, 2, 3)) should equal(List(1, 2, 3))
    append(Nil, Nil) should equal(Nil)
  }
}
