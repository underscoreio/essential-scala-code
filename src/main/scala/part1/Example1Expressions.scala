package part1

object Example1Expressions {
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
  val operators2 = 1 + 2 * 3 + 4

  val operators3 = "Hello" + "world!"
  val operators4 = true && !false

  val operators5 = 123 + 456
  val operators6 = 123 + 456L
  val operators7 = 123 + "456"

  val operators8 = "a" == "a"
  val operators9 = "a" != "a"

  //  __  __      _   _               _             _ _
  // |  \/  | ___| |_| |__   ___   __| |   ___ __ _| | |___
  // | |\/| |/ _ \ __| '_ \ / _ \ / _` |  / __/ _` | | / __|
  // | |  | |  __/ |_| | | | (_) | (_| | | (_| (_| | | \__ \
  // |_|  |_|\___|\__|_| |_|\___/ \__,_|  \___\__,_|_|_|___/

  import scala.io.StdIn

  val methodCalls1 = "Hello world!".take(5)
  val methodCalls2 = "Hello world!".length
  val methodCalls3 = "Hello world!".toUpperCase

  def methodCalls4() = StdIn.readLine
  def methodCalls5() = math.random
  def methodCalls6() = println("Hello world!")

  val methodCalls7 = Math.random
  val methodCalls8 = List.apply(1, 2, 3)

  val methodCalls9  = methodCalls8.head
  val methodCalls10 = methodCalls8.tail
  val methodCalls11 = methodCalls8.apply(2)

  val methodCalls12 = 123.toString
  val methodCalls13 = "123".toInt

  //  ___        __ _                        _
  // |_ _|_ __  / _(_)_  __  ___ _   _ _ __ | |_ __ ___  __
  //  | || '_ \| |_| \ \/ / / __| | | | '_ \| __/ _` \ \/ /
  //  | || | | |  _| |>  <  \__ \ |_| | | | | || (_| |>  <
  // |___|_| |_|_| |_/_/\_\ |___/\__, |_| |_|\__\__,_/_/\_\
  //                             |___/

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

  val conditionals1 = if(Math.random < 0.5) "Alien" else "Predator"
  val conditionals2 = if(Math.random < 0.5) "Alien" else 2001

  //  ____  _            _
  // | __ )| | ___   ___| | _____
  // |  _ \| |/ _ \ / __| |/ / __|
  // | |_) | | (_) | (__|   <\__ \
  // |____/|_|\___/ \___|_|\_\___/

  def blocks1() = {
    println("Calculating the answer...")
    6 * 7
  }

  val blocks2 = {
    val a = 1
    val b = 2
    a + b
  }

  //  ____  _        _               _       _                        _       _   _
  // / ___|| |_ _ __(_)_ __   __ _  (_)_ __ | |_ ___ _ __ _ __   ___ | | __ _| |_(_) ___  _ __
  // \___ \| __| '__| | '_ \ / _` | | | '_ \| __/ _ \ '__| '_ \ / _ \| |/ _` | __| |/ _ \| '_ \
  //  ___) | |_| |  | | | | | (_| | | | | | | ||  __/ |  | |_) | (_) | | (_| | |_| | (_) | | | |
  // |____/ \__|_|  |_|_| |_|\__, | |_|_| |_|\__\___|_|  | .__/ \___/|_|\__,_|\__|_|\___/|_| |_|
  //                         |___/                       |_|

  val interpolation1 =
    s"The value of the first expression was $literals1"

  val interpolation2 =
    s"The sum of the first two expressions was ${literals1 + literals2}"

  val interpolation3 =
    s"A string with a literal $$ in it."

  //   ___  _   _                                                   _
  //  / _ \| |_| |__   ___ _ __    _____  ___ __  _ __ ___  ___ ___(_) ___  _ __  ___
  // | | | | __| '_ \ / _ \ '__|  / _ \ \/ / '_ \| '__/ _ \/ __/ __| |/ _ \| '_ \/ __|
  // | |_| | |_| | | |  __/ |    |  __/>  <| |_) | | |  __/\__ \__ \ | (_) | | | \__ \
  //  \___/ \__|_| |_|\___|_|     \___/_/\_\ .__/|_|  \___||___/___/_|\___/|_| |_|___/
  //                                       |_|

  def other1 = ???

  //  - for comprehensions
  //  - try/catch expressions
  //  - pattern matching

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

  //  ____                                             _               _
  // / ___|  ___  _ __ ___   ___   _ __  _   _ _______| | ___ _ __ ___| |
  // \___ \ / _ \| '_ ` _ \ / _ \ | '_ \| | | |_  /_  / |/ _ \ '__/ __| |
  //  ___) | (_) | | | | | |  __/ | |_) | |_| |/ / / /| |  __/ |  \__ \_|
  // |____/ \___/|_| |_| |_|\___| | .__/ \__,_/___/___|_|\___|_|  |___(_)
  //                              |_|

  val puzzler1 = "Hello world!".toUpperCase.reverse
  def puzzler2() = println("Hello world!".toUpperCase.reverse.toLowerCase.reverse)

  val puzzler3 = "Hello " + "world".take(2)
  val puzzler4 = "Hello " + "world" take 2

  def puzzler5 = "3".toInt
  def puzzler6 = "cake".toInt

  def puzzler7 = if(math.random < 0.5) "Hello" else null
  def puzzler8 = if(math.random < 0.5) "Hello" else throw new Exception("Aaargh!")
}
