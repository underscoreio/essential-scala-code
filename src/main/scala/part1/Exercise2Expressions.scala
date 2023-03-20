package part1

object Exercise2Expressions:
  def greet(name: String): Unit =
    println(s"Hello $name!")

  def greeting(name: String): String =
    s"Hello $name!"

  // Hint - You can reverse a string with `string.reverse`
  def palindrome(str: String): Boolean =
    str == str.reverse

  def factorial(n: Int): Int =
    if n == 0 || n == 1 then 1 else n * factorial(n - 1)

  @main def main(): Unit =
    println("greet")
    println(greet("Earthlings"))

    println("palindrome")
    println(palindrome("taco"))

    println("factorial")
    println(factorial(10))
