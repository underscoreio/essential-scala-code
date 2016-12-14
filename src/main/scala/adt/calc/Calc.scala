package adt.calc

sealed trait Calc
final case class Num(a: Double) extends Calc
final case class Add(a: Calc, b: Calc) extends Calc
final case class Sub(a: Calc, b: Calc) extends Calc
final case class Mul(a: Calc, b: Calc) extends Calc
final case class Div(a: Calc, b: Calc) extends Calc
final case class Sqrt(a: Calc) extends Calc

sealed trait SafeResult
final case class Passed(value: Double) extends SafeResult
final case class Failed(message: String) extends SafeResult

object Calc {
  def run(calc: Calc): Double =
    calc match {
      case Num(a)    => a
      case Add(a, b) => run(a) + run(b)
      case Sub(a, b) => run(a) - run(b)
      case Mul(a, b) => run(a) * run(b)
      case Div(a, b) => run(a) / run(b)
      case Sqrt(a)   => math.sqrt(run(a))
    }

  def runInt(calc: Calc): Int =
    calc match {
      case Num(a)    => a.toInt
      case Add(a, b) => runInt(a) + runInt(b)
      case Sub(a, b) => runInt(a) - runInt(b)
      case Mul(a, b) => runInt(a) * runInt(b)
      case Div(a, b) => runInt(a) / runInt(b)
      case Sqrt(a)   => math.sqrt(runInt(a)).toInt
    }

  def runSafe(calc: Calc): SafeResult =
    calc match {
      case Num(a) => Passed(a)

      case Add(a, b) =>
        runSafe(a) match {
          case Passed(a) =>
            runSafe(b) match {
              case Passed(b) => Passed(a + b)
              case Failed(m) => Failed(m)
            }
          case Failed(m) => Failed(m)
        }

      case Sub(a, b) =>
        runSafe(a) match {
          case Passed(a) =>
            runSafe(b) match {
              case Passed(b) => Passed(a + b)
              case Failed(m) => Failed(m)
            }
          case Failed(m) => Failed(m)
        }

      case Mul(a, b) =>
        runSafe(a) match {
          case Passed(a) =>
            runSafe(b) match {
              case Passed(b) => Passed(a * b)
              case Failed(m) => Failed(m)
            }
          case Failed(m) => Failed(m)
        }

      case Div(a, b) =>
        runSafe(a) match {
          case Passed(a) =>
            runSafe(b) match {
              case Passed(b) =>
                if(b == 0) {
                  Failed("Divsion by zero")
                } else {
                  Passed(a / b)
                }
              case Failed(m) => Failed(m)
            }
          case Failed(m) => Failed(m)
        }

      case Sqrt(a) =>
        runSafe(a) match {
          case Passed(a) =>
            if(a >= 0) {
              Passed(math.sqrt(a))
            } else {
              Failed("Square root of a negative number")
            }
          case Failed(m) => Failed(m)
        }

    }
}

object Main extends App {
  // TODO:
  // - Calculate and print: 1.1 + 2.2 * 3.3
  val calc1 = Add(Num(1.1), Mul(Num(2.2), Num(3.3)))
  println(Calc.run(calc1))
  println(Calc.runInt(calc1))

  // - Calculate and print: 1.1 * 2.2 + 3.3
  val calc2 = Add(Mul(Num(1.1), Num(2.2)), Num(3.3))
  println(Calc.run(calc2))
  println(Calc.runInt(calc2))

  // TODO:
  // - Implement squaring a number:
  def square(a: Double): Calc =
    Mul(Num(a), Num(a))

  // - Implement pythagoras' theorem using Calc
  def pythag(a: Double, b: Double): Calc =
    Sqrt(Add(square(a), square(b)))

  // - Use your pythagoras implementation to calculate
  //   the hypotenuse of a 3x4 triangle
  println(Calc.run(pythag(3, 4)))
  println(Calc.runSafe(pythag(3, 4)))

  // Demonstrate runSafe fails gracefully:
  println(Calc.runSafe(pythag(-3, -4)))
}
