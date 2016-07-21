package fn.higherorder

sealed trait IntOption

final case class IntSome(value: Int) extends IntOption

case object IntNone extends IntOption

sealed trait IntList {
  def exists(func: Int => Boolean): Boolean =
    this match {
      case IntPair(head, tail) =>
        func(head) || tail.exists(func)

      case IntNil => false
    }

  def filter(func: Int => Boolean): IntList =
    this match {
      case IntPair(head, tail) =>
        if(func(head)) {
          IntPair(head, tail.filter(func))
        } else {
          tail.filter(func)
        }

      case IntNil => IntNil
    }

  def find(func: Int => Boolean): IntOption =
    this match {
      case IntPair(head, tail) =>
        if(func(head)) {
          IntSome(head)
        } else {
          tail.find(func)
        }

      case IntNil => IntNone
    }
}

final case class IntPair(head: Int, tail: IntList)
  extends IntList

case object IntNil extends IntList

object Main extends App {
  val ints = IntPair(1, IntPair(3, IntPair(5, IntNil)))

  println(ints + """.exists(_ > 0)      == """ + ints.exists(_ > 0))
  println(ints + """.exists(_ < 0)      == """ + ints.exists(_ < 0))
  println(ints + """.exists(_ % 2 == 0) == """ + ints.exists(_ % 2 == 0))
  println(ints + """.exists(_ % 2 == 1) == """ + ints.exists(_ % 2 == 1))
}
