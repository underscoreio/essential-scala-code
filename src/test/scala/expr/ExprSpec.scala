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

  "factorial" should "multiply some numbers and stuff" in {  
    pending
    // factorial(3) should equal (3 * 2 * 1)
    // factorial(5) should equal (5 * 4 * 3 * 2 * 1)    
  }
}
