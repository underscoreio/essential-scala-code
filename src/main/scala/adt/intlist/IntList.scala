package adt.intlist


sealed trait IntList {
  def exists(func: Int => Boolean): Boolean =
    ???

  def filter(func: Int => Boolean): IntList =
    ???

  // def find(func: Int => Boolean): ??? =
  //   ???
}

final case class IntPair(head: Int, tail: IntList)
  extends IntList

case object IntNil extends IntList

object Main extends App {
  val ints = IntPair(1, IntPair(3, IntPair(5, IntNil)))

  println(s"""ints.exists(_ > 0)      == ${ints.exists(_ > 0)}""")
  println(s"""ints.exists(_ < 0)      == ${ints.exists(_ < 0)}""")
  println(s"""ints.exists(_ % 2 == 0) == ${ints.exists(_ % 2 == 0)}""")
  println(s"""ints.exists(_ % 2 == 1) == ${ints.exists(_ % 2 == 1)}""")
}
