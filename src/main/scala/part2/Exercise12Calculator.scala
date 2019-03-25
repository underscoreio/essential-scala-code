package part2

// ----------------------------------------------

// Step 1. Write a definition for Expr here!

sealed abstract class Expr

// Handle the following types of equation:
// - addition
// - subtraction
// - multiplication
// - division
// - square root

// Give it a `stringify` method
// that renders the expression as a string.

// ----------------------------------------------

// Step 2. Implement eval
// for each of the "calculator" objects below:

object Calculator {
  def eval(calc: Expr): Double = {
    ???
  }
}

object IntCalculator {
  def eval(calc: Expr): Int = {
    ???
  }
}

// ----------------------------------------------

// Step 3. Write some convenience methods
// for constructing common calculations:

// ----------------------------------------------

object Expr {
  // def pythag(a: Double, b: Double): Expr = {
  //   ???
  // }

  // def factorial(n: Int): Expr = {
  //   ???
  // }
}

object Exercise11Calculator {
  // val calc1 = Add(Num(1.1), Mul(Num(2.2), Num(3.3)))
  // val calc2 = Add(Mul(Num(1.1), Num(2.2)), Num(3.3))

  def main(args: Array[String]): Unit = {
    println("stringify")
    // println(calc1.stringify)
    // println(calc2.stringify)

    println("Calculator.eval")
    // println(Calculator.eval(calc1))
    // println(Calculator.eval(calc2))

    println("IntCalculator.eval")
    // println(IntCalculator.eval(calc1))
    // println(IntCalculator.eval(calc2))

    println("pythag")
    // println(Expr.pythag(3, 4))
    // println(Calculator.eval(Expr.pythag(3, 4)))
    // println(IntCalculator.eval(Expr.pythag(3, 4)))

    println("factorial")
    // println(Expr.factorial(4))
    // println(Calculator.eval(Expr.factorial(4)))
    // println(IntCalculator.eval(Expr.factorial(4)))
  }
}
