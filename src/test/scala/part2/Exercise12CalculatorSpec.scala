package part2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Exercise12CalculatorSpec extends AnyFlatSpec with Matchers {
  // val calc1 = Add(Num(1.1), Mul(Num(2.2), Num(3.3)))
  // val calc2 = Mul(Add(Num(1.1), Num(2.2)), Num(3.3))
  // val calc3 = Div(Num(1.0), Num(0.0))
  // val calc4 = Sqrt(Num(-1.0))

  "stringify" should "stringify an expression" in {
    pending
    // calc1.stringify should equal("1.1 + 2.2 * 3.3")
  }

  "Calculator.eval" should "return a double or some weird infinite thing" in {
    pending
    // Calculator.eval(calc1) should equal(1.1 + 2.2 * 3.3)
    // Calculator.eval(calc2) should equal((1.1 + 2.2) * 3.3)
    // Calculator.eval(calc3).isPosInfinity should equal(true)
    // Calculator.eval(calc4).isNaN should equal(true)
  }

  "IntCalculator.eval" should "return an integer or throw an exception" in {
    pending
    // IntCalculator.eval(calc1) should equal(1 + 2 * 3)
    // IntCalculator.eval(calc2) should equal((1 + 2) * 3)
    // intercept[ArithmeticException] { IntCalculator.eval(calc3) }
    // IntCalculator.eval(calc4) should equal(0) // Double.NaN.toInt is apparently 0!
  }

  "pythag" should "produce the correct form of expression" in {
    pending
    // IntCalculator.eval(Expr.pythag(3, 4)) should equal(5)
    // IntCalculator.eval(Expr.pythag(5, 12)) should equal(13)
  }

  "factorial" should "produce the correct form of expression" in {
    pending
    // IntCalculator.eval(Expr.factorial(5)) should equal(5 * 4 * 3 * 2 * 1)
    // IntCalculator.eval(Expr.factorial(3)) should equal(3 * 2 * 1)
    // IntCalculator.eval(Expr.factorial(1)) should equal(1)
  }

  "stringify" should "parenthesise expression correctly (harder)" in {
    pending
    // calc2.stringify should equal("(1.1 + 2.2) * 3.3")
  }
}
