package part3

import part2._

object EitherCalculator {
  def eval(expr: Expr): Either[String, Double] = {
    ???
  }
}

object Exercise21EitherCalculator {
  def main(args: Array[String]): Unit = {
    println("EitherCalculator.eval")
    // println(EitherCalculator.eval(Add(Num(1), Num(2))))
    // println(EitherCalculator.eval(Sqrt(Num(-1))))
    // println(EitherCalculator.eval(Div(Num(1), Num(0))))
  }
}
