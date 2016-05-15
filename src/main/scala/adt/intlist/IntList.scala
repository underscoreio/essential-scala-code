package adt.intlist

sealed trait IntList {
  def contains(num: Int): Boolean =
    this match {
      case IntPair(h, t) => num == h || t.contains(num)
      case IntNil()      => false
    }

  def add(num: Int): IntList =
    this match {
      case IntPair(h, t) => IntPair(h + num, t.add(num))
      case IntNil()      => IntNil()
    }

  def total: Int =
    this match {
      case IntPair(h, t) => h + t.total
      case IntNil()      => 0
    }
}

final case class IntPair(head: Int, tail: IntList)
  extends IntList

final case class IntNil()
  extends IntList

object Main extends App {
  val ints = IntPair(1, IntPair(2, IntPair(3, IntNil())))

  println(s"""$ints.contains(1) == ${ints.contains(1)}""")
  println(s"""$ints.contains(5) == ${ints.contains(5)}""")
  println(s"""$ints.add(1) == ${ints.add(1)}""")
  println(s"""$ints.add(5) == ${ints.add(5)}""")
  println(s"""$ints.total == ${ints.total}""")
}
