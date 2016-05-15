package generic.mylist

sealed trait MyOption[+A] {
  def map[B](func: A => B): MyOption[B] =
    this match {
      case MySome(value) => MySome(func(value))
      case MyNone        => MyNone
    }

  def flatMap[B](func: A => MyOption[B]): MyOption[B] =
    this match {
      case MySome(value) => func(value)
      case MyNone        => MyNone
    }
}

final case class MySome[A](value: A) extends MyOption[A]

case object MyNone extends MyOption[Nothing]

sealed trait MyList[+A] {
  def exists(func: A => Boolean): Boolean =
    this match {
      case MyPair(head, tail) =>
        func(head) || tail.exists(func)

      case MyNil => false
    }

  def filter(func: A => Boolean): MyList[A] =
    this match {
      case MyPair(head, tail) =>
        if(func(head)) {
          MyPair(head, tail.filter(func))
        } else {
          tail.filter(func)
        }

      case MyNil => MyNil
    }

  def find(func: A => Boolean): MyOption[A] =
    this match {
      case MyPair(hear, tail) =>
        if(func(hear)) {
          MySome(hear)
        } else {
          tail.find(func)
        }

      case MyNil => MyNone
    }

  def append[B >: A](that: MyList[B]): MyList[B] =
    this match {
      case MyPair(hear, tail) =>
        MyPair(hear, tail append that)

      case MyNil => that

    }

  def map[B](func: A => B): MyList[B] =
    this match {
      case MyPair(hear, tail) =>
        MyPair(func(hear), tail.map(func))

      case MyNil => MyNil

    }

  def flatMap[B](func: A => MyList[B]): MyList[B] =
    this match {
      case MyPair(head, tail) =>
        func(head) append tail.flatMap(func)

      case MyNil => MyNil

    }

  def foldLeft[B](memo: B)(func: (B, A) => B): B =
    this match {
      case MyPair(head, tail) =>
        tail.foldLeft(func(memo, head))(func)

      case MyNil => memo
    }

  def foldRight[B](memo: B)(func: (A, B) => B): B =
    this match {
      case MyPair(head, tail) =>
        func(head, tail.foldRight(memo)(func))

      case MyNil => memo
    }
}

final case class MyPair[A](head: A, tail: MyList[A]) extends MyList[A]

case object MyNil extends MyList[Nothing]

object Main extends App {
  val ints    = MyPair(1, MyPair(3, MyPair(5, MyNil)))
  val strings = MyPair("foo", MyPair("bar", MyPair("baz", MyNil)))

  println(s"""ints.exists(_ > 1)            == ${ints.exists(_ > 1)}""")
  println(s"""ints.filter(_ > 1)            == ${ints.filter(_ > 1)}""")
  println(s"""ints.find(_ > 1)              == ${ints.find(_ > 1)}""")

  println(s"""strings.exists(_(0) == 'b')   == ${strings.exists(_(0) == 'b')}""")
  println(s"""strings.filter(_(0) == 'b')   == ${strings.filter(_(0) == 'b')}""")
  println(s"""strings.find(_(0) == 'b')     == ${strings.find(_(0) == 'b')}""")

  def add(ints: MyList[Int], num: Int): MyList[Int] =
    ints.map(_ + num)

  println(s"""add(ints, 1))                 == ${add(ints, 1)}""")
  println(s"""strings.map(_ + "!"))         == ${ints.map(_ + "!")}""")

  println(s"""ints.flatMap(x => MyPair(x, MyPair(x * 10, MyNil)))     == ${ints.flatMap(x => MyPair(x, MyPair(x * 10, MyNil)))}""")
  println(s"""strings.flatMap(x => MyPair(x, MyPair(x + "!", MyNil))) == ${strings.flatMap(x => MyPair(x, MyPair(x + "!", MyNil)))}""")

  println(s"""ints.foldLeft(0)(_ + _))      == ${ints.foldLeft(0)(_ + _)}""")
  println(s"""ints.foldRight(0)(_ + _))     == ${ints.foldRight(0)(_ + _)}""")

  println(s"""strings.foldLeft("")(_ + _))  == ${strings.foldLeft("")(_ + _)}""")
  println(s"""strings.foldRight("")(_ + _)) == ${strings.foldRight("")(_ + _)}""")
}
