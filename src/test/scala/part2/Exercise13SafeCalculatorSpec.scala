package part2

import org.scalatest._

class Exercise13SafeCalculatorSpec extends FlatSpec with Matchers {
  val calc1 = Add(Num(1.1), Mul(Num(2.2), Num(3.3)))
  val calc2 = Mul(Add(Num(1.1), Num(2.2)), Num(3.3))
  val calc3 = Div(Num(1.0), Num(0.0))
  val calc4 = Sqrt(Num(-1.0))

  "SafeCalculator.eval" should "succeed on valid expressions" in {
    SafeCalculator.eval(calc1) should equal(Pass(1.1 + 2.2 * 3.3))
    SafeCalculator.eval(calc2) should equal(Pass((1.1 + 2.2) * 3.3))
  }

  it should "fail grcefully on division by zero and negative square root" in {
    // You may want to edit these tests to check your error messages
    SafeCalculator.eval(calc3) shouldBe a[Fail]
    SafeCalculator.eval(calc4) shouldBe a[Fail]
  }
}
