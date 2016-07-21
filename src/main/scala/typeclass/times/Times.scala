package typeclass.times

object TimesImplicits {
  implicit class TimesOps(num: Int) {
    def times[A](func: Int => A): List[A] =
      (1 to num).map(func).toList
  }
}

object Main extends App {
  import TimesImplicits._

  println("""5.times(_ * 10)  == """ + 5.times(_ * 10))
  println("""3.times(_ + "!") == """ + 3.times(_ + "!"))
}
