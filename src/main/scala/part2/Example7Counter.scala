package part2

class Counter(num: Int) {
  def increment: Counter =
    new Counter(num + 1)

  def value: Int =
    num

  override def equals(that: Any): Boolean =
    that match {
      case that: Counter =>
        this.value == that.value

      case _ =>
        false
    }

  override def toString: String =
    s"Counter($num)"
}

object Counter {
  val zero: Counter =
    new Counter(0)
}

object Example7Counter {
  def main(): Unit = {
    println("constructors")
    val counter1 = new Counter(10)
    val counter2 = new Counter(20)
    println(counter1.value)
    println(counter2.value)

    println("increment")
    val counter3 = new Counter(41)
    val counter4 = counter3.increment
    println(counter3.value)
    println(counter4.value)

    println("toString")
    println(counter1)
    println(counter4)

    println("equality")
    val counter5 = new Counter(100)
    val counter6 = new Counter(100)
    println(counter5 == counter6)

    println("companion object")
    println(Counter.zero.increment.increment.increment)
  }
}
