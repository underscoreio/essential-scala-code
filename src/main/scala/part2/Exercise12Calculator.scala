package part2

sealed abstract class Expr {
  def stringify: String = {
    this match {
      case Num(a)    => a.toString
      case Add(a, b) => s"""${a.parenthesise(this)} + ${b.parenthesise(this)}"""
      case Sub(a, b) => s"""${a.parenthesise(this)} - ${b.parenthesise(this)}"""
      case Mul(a, b) => s"""${a.parenthesise(this)} * ${b.parenthesise(this)}"""
      case Div(a, b) => s"""${a.parenthesise(this)} / ${b.parenthesise(this)}"""
      case Sqrt(a)   => s"""sqrt(${a.parenthesise(this)}"""
    }
  }

  private def parenthesise(outer: Expr): String = {
    if(outer.precedence > this.precedence) {
      s"($stringify)"
    } else {
      stringify
    }
  }

  private def precedence: Int = {
    this match {
      case _: Num  => 4
      case _: Sqrt => 3
      case _: Mul  => 2
      case _: Div  => 2
      case _: Add  => 1
      case _: Sub  => 1
    }
  }
}

final case class Num(a: Double) extends Expr
final case class Add(a: Expr, b: Expr) extends Expr
final case class Sub(a: Expr, b: Expr) extends Expr
final case class Mul(a: Expr, b: Expr) extends Expr
final case class Div(a: Expr, b: Expr) extends Expr
final case class Sqrt(a: Expr) extends Expr

object Calculator {
  def eval(calc: Expr): Double =
    calc match {
      case Num(a)    => a
      case Add(a, b) => eval(a) + eval(b)
      case Sub(a, b) => eval(a) - eval(b)
      case Mul(a, b) => eval(a) * eval(b)
      case Div(a, b) => eval(a) / eval(b)
      case Sqrt(a)   => math.sqrt(eval(a))
    }
}

object IntCalculator {
  def eval(calc: Expr): Int =
    calc match {
      case Num(a)    => a.toInt
      case Add(a, b) => eval(a) + eval(b)
      case Sub(a, b) => eval(a) - eval(b)
      case Mul(a, b) => eval(a) * eval(b)
      case Div(a, b) => eval(a) / eval(b)
      case Sqrt(a)   => math.sqrt(eval(a)).toInt
    }
}

object Expr {
  def pythag(a: Double, b: Double): Expr =
    Sqrt(Add(Mul(Num(a), Num(a)), Mul(Num(b), Num(b))))

  def factorial(n: Int): Expr =
    if(n < 1) Num(1) else Mul(Num(n), factorial(n - 1))
}

object Exercise11Calculator {
  val calc1 = Add(Num(1.1), Mul(Num(2.2), Num(3.3)))
  val calc2 = Add(Mul(Num(1.1), Num(2.2)), Num(3.3))

  def main(args: Array[String]): Unit = {
    println("stringify")
    println(calc1.stringify)
    println(calc2.stringify)

    println("Calculator.eval")
    println(Calculator.eval(calc1))
    println(Calculator.eval(calc2))

    println("IntCalculator.eval")
    println(IntCalculator.eval(calc1))
    println(IntCalculator.eval(calc2))

    println("pythag")
    println(Expr.pythag(3, 4))
    println(Calculator.eval(Expr.pythag(3, 4)))
    println(IntCalculator.eval(Expr.pythag(3, 4)))

    println("factorial")
    println(Expr.factorial(4))
    println(Calculator.eval(Expr.factorial(4)))
    println(IntCalculator.eval(Expr.factorial(4)))
  }
}
