package counter

class Counter(value: Int) {
  def inc: Counter =
    new Counter(value + 1)

  def get: Int =
    value

  override def toString: String =
    s"Counter($value)"
}

object Main extends App {
  val counter1 = new Counter(41)
  val counter2 = counter1.inc
  val theAnswer = counter2.get
  println(counter1)
  println(counter2)
}
