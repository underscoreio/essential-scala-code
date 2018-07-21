package expr

import org.scalatest._

class ExprSpec extends FlatSpec with Matchers {
  import Expr._

  "tacocat" should "be a palindrome" in {
    pending
    // palindrome("tacocat") should equal(true)
  }

  "tacobell" should "NOT be a palindrome" in {
    pending
    // palindrome("tacobell") should equal(false)
  }

  "greet" should "return a greeting (not print it)" in {
    pending
    // greet("Dave") should equal("Hello Dave!")
  }

  "factorial" should "multiply some numbers and stuff" in {
    pending
    // factorial(3) should equal(3 * 2 * 1)
    // factorial(5) should equal(5 * 4 * 3 * 2 * 1)
  }

  "longestTail" should "return the tail of the longest parameter" in {
    pending
    // longestTail(List(1, 2), List(3, 4, 5)) should equal(List(4, 5))
    // longestTail(List(1, 2, 3), List(4, 5)) should equal(List(2, 3))
  }

  "longestTail" should "not fail if both of the parameters are the empty list" in {
    pending
    // longestTail(Nil, Nil) should equal(Nil)
  }
}
