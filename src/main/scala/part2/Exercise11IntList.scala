package part2

sealed abstract class IntList {
  def contains(num: Int): Boolean =
    this match {
      case IntPair(h, t) =>
        num == h || t.contains(num)

      case IntNil() =>
        false
    }

  def addToEach(num: Int): IntList =
    this match {
      case IntPair(h, t) =>
        IntPair(h + num, t.addToEach(num))

      case IntNil() =>
        IntNil()
    }

  def total: Int =
    this match {
      case IntPair(h, t) =>
        h + t.total

      case IntNil() =>
        0
    }

  // Harder
  def append(that: IntList): IntList =
    this match {
      case IntPair(head, tail) =>
        IntPair(head, tail.append(that))

      case IntNil() =>
        that
    }

  // Harder
  def evensOnly: IntList =
    this match {
      case IntPair(h, t) =>
        if(h % 2 == 0) {
          IntPair(h, t.evensOnly)
        } else {
          t.evensOnly
        }

      case IntNil() =>
        IntNil()
    }
}

final case class IntPair(head: Int, tail: IntList) extends IntList
final case class IntNil() extends IntList

object Exercise11IntList {
  val numbers = IntPair(1, IntPair(2, IntPair(3, IntNil())))

  def main(args: Array[String]): Unit = {
    println("contains")
    println(numbers.contains(1))
    println(numbers.contains(5))

    println("addToEach")
    println(numbers.addToEach(1))
    println(numbers.addToEach(5))

    println("total")
    println(numbers.total)

    println("append")
    println(numbers.append(numbers))

    println("evensOnly")
    println(numbers.evensOnly)
  }
}