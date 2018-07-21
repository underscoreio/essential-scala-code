package expr

object Expr {
  //  _     _ _                 _
  // | |   (_) |_ ___ _ __ __ _| |___
  // | |   | | __/ _ \ '__/ _` | / __|
  // | |___| | ||  __/ | | (_| | \__ \
  // |_____|_|\__\___|_|  \__,_|_|___/

  val literals1 = 123
  val literals2 = 123L
  val literals3 = 123.0
  val literals4 = true
  val literals5 = "a"
  val literals6 = 'a'

  val literals7 = """A string with "double quotes" in it"""

  val literals8 = null
  val literals9 = ()

  //   ___                       _
  //  / _ \ _ __   ___ _ __ __ _| |_ ___  _ __ ___
  // | | | | '_ \ / _ \ '__/ _` | __/ _ \| '__/ __|
  // | |_| | |_) |  __/ | | (_| | || (_) | |  \__ \
  //  \___/| .__/ \___|_|  \__,_|\__\___/|_|  |___/
  //       |_|

  val operators1 = (1 + 2) * (3 + 4)
  val operators2 = "Hello" + "world!"
  val operators3 = true && !false

  val operators4 = 123 + 456
  val operators5 = 123 + 456L
  val operators6 = 123 + "456"

  //   ____                _                   _                         _ _
  //  / ___|___  _ __  ___| |_ _ __ _   _  ___| |_ ___  _ __    ___ __ _| | |___
  // | |   / _ \| '_ \/ __| __| '__| | | |/ __| __/ _ \| '__|  / __/ _` | | / __|
  // | |__| (_) | | | \__ \ |_| |  | |_| | (__| || (_) | |    | (_| (_| | | \__ \
  //  \____\___/|_| |_|___/\__|_|   \__,_|\___|\__\___/|_|     \___\__,_|_|_|___/

  import java.util.Date

  val constructors1 = new Date()
  val constructors2 = new String("copy this string")

  val constructors3 = List.apply(1, 2, 3)
  val constructors4 = Vector.apply(1, 2, 3)

  //  __  __      _   _               _             _ _
  // |  \/  | ___| |_| |__   ___   __| |   ___ __ _| | |___
  // | |\/| |/ _ \ __| '_ \ / _ \ / _` |  / __/ _` | | / __|
  // | |  | |  __/ |_| | | | (_) | (_| | | (_| (_| | | \__ \
  // |_|  |_|\___|\__|_| |_|\___/ \__,_|  \___\__,_|_|_|___/

  import scala.io.StdIn

  val methodCalls1 = "Hello world!".take(5)
  val methodCalls2 = "Hello world!".length
  val methodCalls3 = "Hello world!".toUpperCase

  def methodCalls4 = StdIn.readLine
  def methodCalls5 = math.random
  def methodCalls6() = println("Hello world!")

  val methodCalls7 = List.apply(1, 2, 3).head
  val methodCalls8 = List.apply(1, 2, 3).tail

  val methodCalls9 = 123.toString
  val methodCalls10 = "123".toInt

  //  ___        __ _                                   _                               _
  // |_ _|_ __  / _(_)_  __   ___  _ __   ___ _ __ __ _| |_ ___  _ __   ___ _   _ _ __ | |_ __ ___  __
  //  | || '_ \| |_| \ \/ /  / _ \| '_ \ / _ \ '__/ _` | __/ _ \| '__| / __| | | | '_ \| __/ _` \ \/ /
  //  | || | | |  _| |>  <  | (_) | |_) |  __/ | | (_| | || (_) | |    \__ \ |_| | | | | || (_| |>  <
  // |___|_| |_|_| |_/_/\_\  \___/| .__/ \___|_|  \__,_|\__\___/|_|    |___/\__, |_| |_|\__\__,_/_/\_\
  //                              |_|                                       |___/

  val infixOperators1 = 1 + 2
  val infixOperators2 = 1.+(2)
  val infixOperators3 = "Hello world".take(5)
  val infixOperators4 = "Hello world" take 5

  // val infixOperators5 = a b c d e

  //   ____                _ _ _   _                   _
  //  / ___|___  _ __   __| (_) |_(_) ___  _ __   __ _| |___
  // | |   / _ \| '_ \ / _` | | __| |/ _ \| '_ \ / _` | / __|
  // | |__| (_) | | | | (_| | | |_| | (_) | | | | (_| | \__ \
  //  \____\___/|_| |_|\__,_|_|\__|_|\___/|_| |_|\__,_|_|___/

  val conditionals1 = if(math.random < 0.5) "Alien" else "Predator"
  val conditionals2 = if(math.random < 0.5) "Alien" else 2001

  //  ____  _            _
  // | __ )| | ___   ___| | _____
  // |  _ \| |/ _ \ / __| |/ / __|
  // | |_) | | (_) | (__|   <\__ \
  // |____/|_|\___/ \___|_|\_\___/

  // val blocks1 = {
  //   println("Calculating the answer...")
  //   6 * 7
  // }

  //  ____  _        _               _       _                        _       _   _
  // / ___|| |_ _ __(_)_ __   __ _  (_)_ __ | |_ ___ _ __ _ __   ___ | | __ _| |_(_) ___  _ __
  // \___ \| __| '__| | '_ \ / _` | | | '_ \| __/ _ \ '__| '_ \ / _ \| |/ _` | __| |/ _ \| '_ \
  //  ___) | |_| |  | | | | | (_| | | | | | | ||  __/ |  | |_) | (_) | | (_| | |_| | (_) | | | |
  // |____/ \__|_|  |_|_| |_|\__, | |_|_| |_|\__\___|_|  | .__/ \___/|_|\__,_|\__|_|\___/|_| |_|
  //                         |___/                       |_|

  val interpolation1 = s"The value of the first expression was $literals1"
  val interpolation2 = s"The sum of the first two expressions was ${literals1 + literals2}"
  val interpolation3 = s"A string with a literal $$ in it."

  //   ___  _   _                                                   _
  //  / _ \| |_| |__   ___ _ __    _____  ___ __  _ __ ___  ___ ___(_) ___  _ __  ___
  // | | | | __| '_ \ / _ \ '__|  / _ \ \/ / '_ \| '__/ _ \/ __/ __| |/ _ \| '_ \/ __|
  // | |_| | |_| | | |  __/ |    |  __/>  <| |_) | | |  __/\__ \__ \ | (_) | | | \__ \
  //  \___/ \__|_| |_|\___|_|     \___/_/\_\ .__/|_|  \___||___/___/_|\___/|_| |_|___/
  //                                       |_|

  // There are other types of expressions that we haven't talked about yet.
  // Stay tuned for more on these!

  //  - for comprehensions
  //  - try/catch expressions
  //  - pattern matching

  //  ____                                             _               _
  // / ___|  ___  _ __ ___   ___   _ __  _   _ _______| | ___ _ __ ___| |
  // \___ \ / _ \| '_ ` _ \ / _ \ | '_ \| | | |_  /_  / |/ _ \ '__/ __| |
  //  ___) | (_) | | | | | |  __/ | |_) | |_| |/ / / /| |  __/ |  \__ \_|
  // |____/ \___/|_| |_| |_|\___| | .__/ \__,_/___/___|_|\___|_|  |___(_)
  //                              |_|

  // What are the types and values of the following?

  val puzzler1 = "Hello world!".toUpperCase.reverse
  def puzzler2() = println("Hello world!".toUpperCase.reverse.toLowerCase.reverse)

  val puzzler3 = "Hello " + "world".take(2)
  val puzzler4 = "Hello " + "world" take 2

  def puzzler5 = "3".toInt
  def puzzler6 = "cake".toInt

  def puzzler7 = if(math.random < 0.5) "Hello" else null
  def puzzler8 = if(math.random < 0.5) "Hello" else throw new Exception("Aaargh!")

  //  ____        __ _       _ _   _
  // |  _ \  ___ / _(_)_ __ (_) |_(_) ___  _ __  ___
  // | | | |/ _ \ |_| | '_ \| | __| |/ _ \| '_ \/ __|
  // | |_| |  __/  _| | | | | | |_| | (_) | | | \__ \
  // |____/ \___|_| |_|_| |_|_|\__|_|\___/|_| |_|___/

  val definitions1 = "A value"
  def definitions2 = "A method"

  def definitions3: String = "Another value"
  def definitions4: String = "Another method"

  def definitions5(a: Int, b: Int) =
    a + b

  def definitions6(a: Int, b: Int): Int =
    a + b

  // val definitions7 = {
  //   println("Calculating the answer...")
  //   6 * 7
  // }

  // def definitions8 = {
  //   println("Calculating the answer...")
  //   6 * 7
  // }

  //  ____                                                _
  // / ___|  ___  _ __ ___   ___    _____  _____ _ __ ___(_)___  ___  ___
  // \___ \ / _ \| '_ ` _ \ / _ \  / _ \ \/ / _ \ '__/ __| / __|/ _ \/ __|
  //  ___) | (_) | | | | | |  __/ |  __/>  <  __/ | | (__| \__ \  __/\__ \
  // |____/ \___/|_| |_| |_|\___|  \___/_/\_\___|_|  \___|_|___/\___||___/

  // TODO: Implement methods as follows:

  // TODO: A method called "palindrome" that:
  //  - accepts a parameter of type String;
  //  - returns true if the parameter is a palindrome, or false if it is not.
  //
  // HINT: We saw earlier how to reverse a String.

  // TODO: A method called "greet" that:
  //  - accepts a parameter of type String representing somebody's name;
  //  - greets the person with a friendly message;
  //
  // QUESTION: Does your method obey substitution?

  // TODO: A method called "factorial" that:
  //  - accepts a parameter of type Int;
  //  - returns the factorial of the number.
  //
  // HINT: The factorial of N is 1 * 2 * 3 * ... * N

  // TODO: A method called "longestTail" that:
  //  - accepts two parameters, each of which is a list of integers;
  //  - returns the tail of the longest list.
  //
  // QUESTION: Is your method totally defined for all possible inputs?
}

object Main extends App {
  import Expr._

  println("Use the console to play with the expressions in this part. For example:")
  println()
  println("    bash$ ./sbt.sh console")
  println()
  println("    scala> import expr.Expr._")
  println("    import expr.Expr._")
  println()
  println("    scala> literals1")
  println("    literals1: Int = 123")
  println()

  // Helpers for the exercises. Uncomment these once you get here:

  // println(s"""palindrome("taco")                     == ${palindrome("taco")}""")
  // println(s"""greet("Earthlings")                    == ${greet("Earthlings")}""")
  // println(s"""factorial(10)                          == ${factorial(10)}""")
  // println(s"""longestTail(List(1, 2), List(3, 4, 5)) == ${longestTail(List(1, 2), List(3, 4, 5))}""")
}
