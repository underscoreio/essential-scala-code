package part3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import part2._

class Exercise21EitherCalculatorSpec extends AnyFlatSpec with Matchers {
  // val calc1 = Add(Num(1.1), Mul(Num(2.2), Num(3.3)))
  // val calc2 = Mul(Add(Num(1.1), Num(2.2)), Num(3.3))
  // val calc3 = Div(Num(1.0), Num(0.0))
  // val calc4 = Sqrt(Num(-1.0))

  "EitherCalculator.eval" should "succeed on valid expressions" in {
    pending
    // EitherCalculator.eval(calc1) should equal(Right(1.1 + 2.2 * 3.3))
    // EitherCalculator.eval(calc2) should equal(Right((1.1 + 2.2) * 3.3))
  }

  it should "fail grcefully on division by zero and negative square root" in {
    pending
    // You may want to edit these tests to check your error messages
    // EitherCalculator.eval(calc3) shouldBe a[Left[_, _]]
    // EitherCalculator.eval(calc4) shouldBe a[Left[_, _]]
  }
}
