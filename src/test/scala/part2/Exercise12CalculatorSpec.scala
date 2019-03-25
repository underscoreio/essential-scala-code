package part2

import org.scalatest._

class Exercise12CalculatorSpec extends FlatSpec with Matchers {
  val calc1 = Add(Num(1.1), Mul(Num(2.2), Num(3.3)))
  val calc2 = Mul(Add(Num(1.1), Num(2.2)), Num(3.3))
  val calc3 = Div(Num(1.0), Num(0.0))
  val calc4 = Sqrt(Num(-1.0))

  def pythag(a: Double, b: Double): Expr =
    Sqrt(Add(Mul(Num(a), Num(a)), Mul(Num(b), Num(b))))

  def factorial(n: Int): Expr =
    if(n < 1) Num(1) else Mul(Num(n), factorial(n - 1))

  "stringify" should "stringify an expression" in {
    calc1.stringify should equal("1.1 + 2.2 * 3.3")
  }

  "Calculator.eval" should "return a double or some weird infinite thing" in {
    Calculator.eval(calc1) should equal(1.1 + 2.2 * 3.3)
    Calculator.eval(calc2) should equal((1.1 + 2.2) * 3.3)
    Calculator.eval(calc3).isPosInfinity should equal(true)
    Calculator.eval(calc4).isNaN should equal(true)
  }

  "IntCalculator.eval" should "return an integer or throw an exception" in {
    IntCalculator.eval(calc1) should equal(1 + 2 * 3)
    IntCalculator.eval(calc2) should equal((1 + 2) * 3)
    intercept[ArithmeticException] { IntCalculator.eval(calc3) }
    IntCalculator.eval(calc4) should equal(0) // Double.NaN.toInt is apparently 0!
  }

  "pythag" should "produce the correct form of expression" in {
    IntCalculator.eval(Expr.pythag(3, 4)) should equal(5)
    IntCalculator.eval(Expr.pythag(5, 12)) should equal(13)
  }

  "factorial" should "produce the correct form of expression" in {
    IntCalculator.eval(Expr.factorial(5)) should equal(5 * 4 * 3 * 2 * 1)
    IntCalculator.eval(Expr.factorial(3)) should equal(3 * 2 * 1)
    IntCalculator.eval(Expr.factorial(1)) should equal(1)
  }

  "stringify" should "parenthesise expression correctly (harder)" in {
    calc2.stringify should equal("(1.1 + 2.2) * 3.3")
  }
}
