package part2

enum IntList:
  case Pair(head: Int, tail: IntList)
  case Nil

  def contains(num: Int): Boolean =
    this match
      case Pair(h, t) => num == h || t.contains(num)
      case Nil => false


  def addToEach(num: Int): IntList =
    this match
      case Pair(h, t) => Pair(h + num, t.addToEach(num))
      case Nil => Nil

  def total: Int =
    this match
      case Pair(h, t) => h + t.total
      case Nil => 0

  // Harder
  def append(that: IntList): IntList =
    this match
      case Pair(head, tail) => Pair(head, tail.append(that))
      case Nil => that

  // Harder
  def evensOnly: IntList =
    this match
      case Pair(h, t) => if h % 2 == 0 then Pair(h, t.evensOnly) else t.evensOnly
      case Nil => Nil

object Exercise11IntList:
  val numbers = IntList.Pair(1, IntList.Pair(2, IntList.Pair(3, IntList.Nil)))

  def main(): Unit =
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
