package part3

import part2.{Expr, Num, Add, Sub, Mul, Div, Sqrt}

object EitherCalculator {
  def eval(expr: Expr): Either[String, Double] =
    expr match {
      case Num(a) =>
        Right(a)

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
          r <- if(b == 0) Left("Division by zero") else Right(a / b)
        } yield r

      case Sqrt(a) =>
        for {
          a <- eval(a)
          r <- if(a < 0) Left("Square root of a negative number") else Right(math.sqrt(a))
        } yield r
    }
}

object Exercise21EitherCalculator {
  def main(args: Array[String]): Unit = {
    println(EitherCalculator.eval(Add(Num(1), Num(2))))
    println(EitherCalculator.eval(Sqrt(Num(-1))))
    println(EitherCalculator.eval(Div(Num(1), Num(0))))
  }
}
