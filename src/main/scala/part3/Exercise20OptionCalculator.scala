package part3

import part2.{Expr, Num, Add, Sub, Mul, Div, Sqrt}

object OptionCalculator {
  def eval(calc: Expr): Option[Double] =
    calc match {
      case Num(a) =>
        Some(a)

      case Add(a, b) =>
        for {
          a <- eval(a)
          b <- eval(b)
        } yield a + b

      case Sub(a, b) =>
        for {
          a <- eval(a)
          b <- eval(b)
        } yield a - b

      case Mul(a, b) =>
        for {
          a <- eval(a)
          b <- eval(b)
        } yield a * b

      case Div(a, b) =>
        for {
          a <- eval(a)
          b <- eval(b)
          r <- if(b == 0) None else Some(a / b)
        } yield r

      case Sqrt(a) =>
        for {
          a <- eval(a)
          r <- if(a < 0) None else Some(math.sqrt(a))
        } yield r
    }
}

object Exercise20OptionCalculator {
  def main(args: Array[String]): Unit = {
    println(OptionCalculator.eval(Add(Num(1), Num(2))))
    println(OptionCalculator.eval(Sqrt(Num(-1))))
    println(OptionCalculator.eval(Div(Num(1), Num(0))))
  }
}
