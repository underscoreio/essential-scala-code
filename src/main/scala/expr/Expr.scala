package expr

object Expr {
  def palindrome(str: String): String =
    str + str.reverse.substring(1)

  def greet(name: String): Unit =
    println(s"Hello $name!")

  def factorial(n: Int): Int =
    if(n == 0 || n == 1) 1 else n * factorial(n - 1)
}

object Main extends App {
  import Expr._

  println("""palindrome("taco") == ${palindrome("taco")}""")
  println("""greet("Earthlings") == ${greet("Earthlings")}""")
  println("""factorial(10) == ${factorial(10)}""")
}
