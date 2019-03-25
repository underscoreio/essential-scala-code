package part2

// ----------------------------------------------

// Step 1. Implement a `Result` type

sealed abstract class Result

// A Result is:
//   - a Pass containing a Double result, or
//   - a Fail containing a String error message

// ----------------------------------------------

// Step 2. Implement eval below:

object SafeCalculator {
  def eval(calc: Expr): Result = {
    ???
  }
}

object Exercise13SafeCalculator {
  def main(args: Array[String]): Unit = {
    println("SaveCalculator.eval")
    // println(SafeCalculator.eval(Add(Num(1), Num(2))))
    // println(SafeCalculator.eval(Sqrt(Num(-1))))
    // println(SafeCalculator.eval(Div(Num(1), Num(0))))
  }
}
