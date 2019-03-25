package part2

// A Result is:
//   - a Pass containing a Double result, or
//   - a Fail containing a String error message
sealed abstract class Result
final case class Pass(value: Double) extends Result
final case class Fail(message: String) extends Result

object SafeCalculator {
  def eval(calc: Expr): Result =
    calc match {
      case Num(a) => Pass(a)

      case Add(a, b) =>
        eval(a) match {
          case Pass(x) =>
            eval(b) match {
              case Pass(y) => Pass(x + y)
              case Fail(m) => Fail(m)
            }
          case Fail(m) => Fail(m)
        }

      case Sub(a, b) =>
        eval(a) match {
          case Pass(x) =>
            eval(b) match {
              case Pass(y) => Pass(x - y)
              case Fail(m) => Fail(m)
            }
          case Fail(m) => Fail(m)
        }

      case Mul(a, b) =>
        eval(a) match {
          case Pass(x) =>
            eval(b) match {
              case Pass(y) => Pass(x * y)
              case Fail(m) => Fail(m)
            }
          case Fail(m) => Fail(m)
        }

      case Div(a, b) =>
        eval(a) match {
          case Pass(x) =>
            eval(b) match {
              case Pass(y) =>
                if(y == 0) {
                  Fail("Division by zero")
                } else {
                  Pass(x / y)
                }
              case Fail(m) => Fail(m)
            }
          case Fail(m) => Fail(m)
        }

      case Sqrt(a) =>
        eval(a) match {
          case Pass(x) =>
            if(x >= 0) {
              Pass(math.sqrt(x))
            } else {
              Fail("Square root of a negative number")
            }
          case Fail(m) => Fail(m)
        }

    }
}

object Exercise13SafeCalculator {
  def main(args: Array[String]): Unit = {
    println(SafeCalculator.eval(Add(Num(1), Num(2))))
    println(SafeCalculator.eval(Sqrt(Num(-1))))
    println(SafeCalculator.eval(Div(Num(1), Num(0))))
  }
}
