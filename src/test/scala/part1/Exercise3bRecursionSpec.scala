package part1

import org.scalatest._

class Exercise3bRecursionSpec extends FlatSpec with Matchers {
  import Exercise3bRecursion._

  "contains" should "find elements in a list" in {
    pending
    // contains(List(1, 2, 3), 2) should equal(true)
    // contains(List(1, 2, 3), 4) should equal(false)
    // contains(Nil, 1) should equal(false)
  }

  "doubleEachNumber" should "double all elements in a list" in {
    pending
    // doubleEachNumber(List(1, 2, 3)) should equal(List(2, 4, 6))
    // doubleEachNumber(Nil) should equal(Nil)
  }

  "total" should "add up all the elements in a list" in {
    pending
    // total(List(1, 2, 3)) should equal(1 + 2 + 3)
    // total(Nil) should equal(0)
  }

  "range" should "return a range [min,max] inclusive" in {
    pending
    // range(2, 5) should equal(List(2, 3, 4, 5))
    // range(2, 2) should equal(List(2))
    // range(2, 0) should equal(Nil)
  }

  "append" should "append two lists" in {
    pending
    // append(List(1, 2, 3), List(4, 5, 6)) should equal(List(1, 2, 3, 4, 5, 6))
    // append(List(1, 2, 3), Nil) should equal(List(1, 2, 3))
    // append(Nil, List(1, 2, 3)) should equal(List(1, 2, 3))
    // append(Nil, Nil) should equal(Nil)
  }
}
