package part3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import part2._

class Exercise20OptionCalculatorSpec extends AnyFlatSpec with Matchers {
  val calc1 = Add(Num(1.1), Mul(Num(2.2), Num(3.3)))
  val calc2 = Mul(Add(Num(1.1), Num(2.2)), Num(3.3))
  val calc3 = Div(Num(1.0), Num(0.0))
  val calc4 = Sqrt(Num(-1.0))

  "OptionCalculator.eval" should "succeed on valid expressions" in {
    OptionCalculator.eval(calc1) should equal(Some(1.1 + 2.2 * 3.3))
    OptionCalculator.eval(calc2) should equal(Some((1.1 + 2.2) * 3.3))
  }

  it should "fail grcefully on division by zero and negative square root" in {
    // You may want to edit these tests to check your error messages
    OptionCalculator.eval(calc3) should equal(None)
    OptionCalculator.eval(calc4) should equal(None)
  }
}
