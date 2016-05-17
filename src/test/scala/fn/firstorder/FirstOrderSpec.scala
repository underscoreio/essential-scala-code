package fn.firstorder

import org.scalatest._

class FirstOrderSpec extends FlatSpec with Matchers {
  import FirstOrder._

  "sumSquares" should "sum squares" in {
    pending
    // sumSquares(3, 4) should equal(3*3 + 4*4)
    // sumSquares(5, 7) should equal(5*5 + 7*7)
  }

  "longer" should "determine longness" in {
    pending
    // longer("fooo", "bar") should equal("fooo")
    // longer("foo", "baaar") should equal("baaar")
  }

  "factorial" should "calculate factorials" in {
    pending
    // factorial(5) should equal(5 * 4 * 3 * 2 * 1)
    // factorial(3) should equal(3 * 2 * 1)
    // factorial(1) should equal(1)
  }
}
