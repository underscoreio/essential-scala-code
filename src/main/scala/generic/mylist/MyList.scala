package generic.mylist

sealed trait MyOption[+A]

final case class MySome[A](value: A) extends MyOption[A]

case object MyNone extends MyOption[Nothing]

sealed trait MyList[+A] {
  def exists(func: A => Boolean): Boolean =
    this match {
      case MyPair(h, t) =>
        func(h) || t.exists(func)

      case MyNil => false
    }

  def filter(func: A => Boolean): MyList[A] =
    this match {
      case MyPair(h, t) =>
        if(func(h)) MyPair(h, t.filter(func)) else t.filter(func)

      case MyNil => MyNil
    }

  def find(func: A => Boolean): MyOption[A] =
    this match {
      case MyPair(h, t) =>
        if(func(h)) MySome(h) else t.find(func)

      case MyNil => MyNone
    }
}

final case class MyPair[A](head: A, tail: MyList[A]) extends MyList[A]

case object MyNil extends MyList[Nothing]

object Main extends App {
  val ints    = MyPair(1, MyPair(3, MyPair(5, MyNil)))
  val strings = MyPair("foo", MyPair("bar", MyPair("baz", MyNil)))

  println(s"""ints.exists(_ > 1)          == ${ints.exists(_ > 1)}""")
  println(s"""ints.filter(_ > 1)          == ${ints.filter(_ > 1)}""")
  println(s"""ints.find(_ > 1)            == ${ints.find(_ > 1)}""")

  println(s"""strings.exists(_(0) == 'b') == ${strings.exists(_(0) == 'b')}""")
  println(s"""strings.filter(_(0) == 'b') == ${strings.filter(_(0) == 'b')}""")
  println(s"""strings.find(_(0) == 'b')   == ${strings.find(_(0) == 'b')}""")
}
