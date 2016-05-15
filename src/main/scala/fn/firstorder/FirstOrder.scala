package fn.firstorder

object FirstOrder {
  val sumSquares: (Int, Int) => Int =
    (x: Int, y: Int) =>
      x*x + y*y

  val longer: (String, String) => String =
    (x: String, y: String) =>
      if(x.length > y.length) x else y

  val factorial: Int => Int =
    (n: Int) =>
      if(n == 0 || n == 1) {
        1
      } else {
        n * factorial(n - 1)
      }
}

object Main extends App {
  import FirstOrder._

  println(s"""sumSquares(3, 4) == ${sumSquares(3, 4)}""")
  println(s"""longer("fooo", "bar") == ${longer("fooo", "bar")}""")
  println(s"""factorial(5) == ${factorial(5)}""")
}
