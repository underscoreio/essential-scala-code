package part2

// A Result is:
//   - a Pass containing a Double result, or
//   - a Fail containing a String error message
enum Result:
  case Pass(value: Double)
  case Fail(message: String)

object SafeCalculator:
  import Expr._
  import Result._

  def eval(calc: Expr): Result =
    calc match
      case Num(a) => Pass(a)

      case Add(a, b) =>
        eval(a) match
          case Pass(x) =>
            eval(b) match
              case Pass(y) => Pass(x + y)
              case Fail(m) => Fail(m)
          case Fail(m) => Fail(m)

      case Sub(a, b) =>
        eval(a) match
          case Pass(x) =>
            eval(b) match
              case Pass(y) => Pass(x - y)
              case Fail(m) => Fail(m)
          case Fail(m) => Fail(m)

      case Mul(a, b) =>
        eval(a) match
          case Pass(x) =>
            eval(b) match
              case Pass(y) => Pass(x * y)
              case Fail(m) => Fail(m)
          case Fail(m) => Fail(m)

      case Div(a, b) =>
        eval(a) match
          case Pass(x) =>
            eval(b) match
              case Pass(y) =>
                if y == 0 then
                  Fail("Division by zero")
                else
                  Pass(x / y)
              case Fail(m) => Fail(m)
          case Fail(m) => Fail(m)

      case Sqrt(a) =>
        eval(a) match
          case Pass(x) =>
            if x >= 0 then
              Pass(math.sqrt(x))
            else
              Fail("Square root of a negative number")
          case Fail(m) => Fail(m)

object Exercise13SafeCalculator:
  import Expr._

  def main(): Unit =
    println(SafeCalculator.eval(Add(Num(1), Num(2))))
    println(SafeCalculator.eval(Sqrt(Num(-1))))
    println(SafeCalculator.eval(Div(Num(1), Num(0))))
