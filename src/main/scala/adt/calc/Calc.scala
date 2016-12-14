package adt.calc

sealed trait Calc
final case class Num(a: Double) extends Calc
final case class Add(a: Calc, b: Calc) extends Calc
final case class Sub(a: Calc, b: Calc) extends Calc
final case class Mul(a: Calc, b: Calc) extends Calc
final case class Div(a: Calc, b: Calc) extends Calc
final case class Sqrt(a: Calc) extends Calc

// TODO: Implement a simple interpreter for Calc
object Interpreter {
  def run(calc: Calc): Double =
    calc match {
      case Num(a)    => a
      case Add(a, b) => run(a) + run(b)
      case Sub(a, b) => run(a) - run(b)
      case Mul(a, b) => run(a) * run(b)
      case Div(a, b) => run(a) / run(b)
      case Sqrt(a)   => math.sqrt(run(a))
    }
}

// TODO: Implement an interpreter that uses integer arithmetic
object IntInterpreter {
  def run(calc: Calc): Int =
    calc match {
      case Num(a)    => a.toInt
      case Add(a, b) => run(a) + run(b)
      case Sub(a, b) => run(a) - run(b)
      case Mul(a, b) => run(a) * run(b)
      case Div(a, b) => run(a) / run(b)
      case Sqrt(a)   => math.sqrt(run(a)).toInt
    }
}

// TODO: Implement an interpreter that:
// - reports division-by-zero
// - reports square roots of negatives
//
// This is an example of what we can achieve
// at the end of the ADTs section of the course:
// - no generic types
// - no sequencing methods
// - no library classes
object SafeInterpreter1 {
  sealed trait Result
  final case class Passed(value: Double) extends Result
  final case class Failed(message: String) extends Result

  def run(calc: Calc): Result =
    calc match {
      case Num(a) => Passed(a)

      case Add(a, b) =>
        run(a) match {
          case Passed(a) =>
            run(b) match {
              case Passed(b) => Passed(a + b)
              case Failed(m) => Failed(m)
            }
          case Failed(m) => Failed(m)
        }

      case Sub(a, b) =>
        run(a) match {
          case Passed(a) =>
            run(b) match {
              case Passed(b) => Passed(a + b)
              case Failed(m) => Failed(m)
            }
          case Failed(m) => Failed(m)
        }

      case Mul(a, b) =>
        run(a) match {
          case Passed(a) =>
            run(b) match {
              case Passed(b) => Passed(a * b)
              case Failed(m) => Failed(m)
            }
          case Failed(m) => Failed(m)
        }

      case Div(a, b) =>
        run(a) match {
          case Passed(a) =>
            run(b) match {
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
        run(a) match {
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

// TODO: Implement an interpreter that:
// - handles division-by-zero gracefully
// - handles square roots of negatives gracefully
//
// This is an example of what we can achieve using MyOption
// at the end of the sequencing computations section of the course:
// - no built-in collection types
sealed trait MyOption[A] {
  def map[B](func: A => B): MyOption[B] =
    this match {
      case MySome(value) => MySome(func(value))
      case MyNone()      => MyNone()
    }

  def flatMap[B](func: A => MyOption[B]): MyOption[B] =
    this match {
      case MySome(value) => func(value)
      case MyNone()      => MyNone()
    }
}
final case class MySome[A](value: A) extends MyOption[A]
final case class MyNone[A]() extends MyOption[A]

object SafeInterpreter2 {
  def run(calc: Calc): MyOption[Double] =
    calc match {
      case Num(a) => MySome(a)

      case Add(a, b) =>
        for {
          a <- run(a)
          b <- run(b)
        } yield a + b

      case Sub(a, b) =>
        for {
          a <- run(a)
          b <- run(b)
        } yield a - b

      case Mul(a, b) =>
        for {
          a <- run(a)
          b <- run(b)
        } yield a * b

      case Div(a, b) =>
        for {
          a   <- run(a)
          b   <- run(b)
          ans <- if (b != 0) MySome(a / b) else MyNone()
        } yield ans

      case Sqrt(a) =>
        for {
          a   <- run(a)
          ans <- if(a >= 0) MySome(math.sqrt(a)) else MyNone()
        } yield ans
    }
}

// TODO: Implement an interpreter that:
// - reports division-by-zero
// - reports square roots of negatives
//
// This is an example of what we can achieve
// at the end of the collections section of the course.
object SafeInterpreter3 {
  def run(calc: Calc): Either[String, Double] =
    calc match {
      case Num(a) => Right(a)

      case Add(a, b) =>
        for {
          a <- run(a)
          b <- run(b)
        } yield a + b

      case Sub(a, b) =>
        for {
          a <- run(a)
          b <- run(b)
        } yield a - b

      case Mul(a, b) =>
        for {
          a <- run(a)
          b <- run(b)
        } yield a * b

      case Div(a, b) =>
        for {
          a   <- run(a)
          b   <- run(b)
          ans <- Either.cond(b != 0, a / b, "division by zero")
        } yield ans

      case Sqrt(a) =>
        for {
          a   <- run(a)
          ans <- Either.cond(a >= 0, math.sqrt(a), "square root of negative")
        } yield ans
    }
}

object Main extends App {
  // TODO:
  // - Calculate and print: 1.1 + 2.2 * 3.3
  val calc1 = Add(Num(1.1), Mul(Num(2.2), Num(3.3)))
  println("calc1 " + Interpreter.run(calc1))
  println("calc1 " + IntInterpreter.run(calc1))

  // - Calculate and print: 1.1 * 2.2 + 3.3
  val calc2 = Add(Mul(Num(1.1), Num(2.2)), Num(3.3))
  println("calc2 " + Interpreter.run(calc2))
  println("calc2 " + IntInterpreter.run(calc2))

  // TODO:
  // - Implement squaring a number:
  def square(a: Double): Calc =
    Mul(Num(a), Num(a))

  println("square " + Interpreter.run(Mul(Num(1.1), Num(1.1))))
  println("square " + IntInterpreter.run(Mul(Num(1.1), Num(1.1))))

  // - Implement pythagoras' theorem using Calc
  def pythag(a: Double, b: Double): Calc =
    Sqrt(Add(square(a), square(b)))

  // - Use your pythagoras implementation to calculate
  //   the hypotenuse of a 3x4 triangle
  println("pythag " + Interpreter.run(pythag(3, 4)))
  println("pythag " + IntInterpreter.run(pythag(3, 4)))

  // - Implement factorials using Calc:
  def factorial(n: Int): Calc =
    if(n < 1) Num(1) else Mul(Num(n), factorial(n - 1))

  println("factorial " + Interpreter.run(factorial(10)))
  println("factorial " + IntInterpreter.run(factorial(10)))

  // Demonstrate run fails gracefully:
  println("safe interpreter 1 " + SafeInterpreter1.run(Sqrt(Num(-1))))
  println("safe interpreter 1 " + SafeInterpreter1.run(Div(Num(1), Num(0))))
  println("safe interpreter 1 " + SafeInterpreter1.run(pythag(-3, -4)))

  println("safe interpreter 2 " + SafeInterpreter2.run(Sqrt(Num(-1))))
  println("safe interpreter 2 " + SafeInterpreter2.run(Div(Num(1), Num(0))))
  println("safe interpreter 2 " + SafeInterpreter2.run(pythag(-3, -4)))

  println("safe interpreter 3 " + SafeInterpreter3.run(Sqrt(Num(-1))))
  println("safe interpreter 3 " + SafeInterpreter3.run(Div(Num(1), Num(0))))
  println("safe interpreter 3 " + SafeInterpreter3.run(pythag(-3, -4)))
}
