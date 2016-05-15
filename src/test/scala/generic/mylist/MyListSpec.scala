package generic.mylist

import org.scalatest._

class MyListSpec extends FlatSpec with Matchers {
  val ints    = MyPair(1, MyPair(3, MyPair(5, MyNil)))
  val strings = MyPair("foo", MyPair("bar", MyPair("baz", MyNil)))

  "myList.exists" should "work as expected" in {
    ints.exists(_ > 0) should equal(true)
    ints.exists(_ < 0) should equal(false)
    ints.exists(_ % 2 == 0) should equal(false)
    ints.exists(_ % 2 == 1) should equal(true)
  }

  "myList.filter" should "work as expected" in {
    ints.filter(_ > 0) should equal(ints)
    ints.filter(_ < 0) should equal(MyNil)
    ints.filter(_ > 3) should equal(MyPair(5, MyNil))
  }

  "myList.find" should "work as expected" in {
    ints.find(_ > 0) should equal(MySome(1))
    ints.find(_ < 0) should equal(MyNone)
    ints.find(_ > 3) should equal(MySome(5))
  }

  "myList.map" should "work on integers" in {
    val actual   = ints.map(_ + 1)
    val expected = MyPair(2, MyPair(4, MyPair(6, MyNil)))
    actual should equal(expected)
  }

  it should "work on strings" in {
    val actual   = strings.map(_ + "!")
    val expected = MyPair("foo!", MyPair("bar!", MyPair("baz!", MyNil)))
    actual should equal(expected)
  }

  "myList.flatMap" should "work on integers" in {
    val actual   = ints.flatMap(x => MyPair(x, MyPair(x * 10, MyNil)))
    val expected = MyPair(1, MyPair(10, MyPair(3, MyPair(30, MyPair(5, MyPair(50, MyNil))))))
    actual should equal(expected)
  }

  it should "work on strings" in {
    val actual   = strings.flatMap(x => MyPair(x, MyPair(x + "!", MyNil)))
    val expected = MyPair("foo", MyPair("foo!", MyPair("bar", MyPair("bar!", MyPair("baz", MyPair("baz!", MyNil))))))
    actual should equal(expected)
  }

  "myList.foldLeft" should "accumulate from left to right" in {
    ints.foldLeft(10)(_ + _) should equal(19)
    strings.foldLeft("nil")(_ + _) should equal("nilfoobarbaz")
  }

  "myList.foldRight" should "accumulate from right to left" in {
    ints.foldLeft(10)(_ + _) should equal(19)
    strings.foldRight("nil")(_ + _) should equal("foobarbaznil")
  }

  "myOption.map" should "map over MySome" in {
    val actual   = MySome(41).map(_ + 1)
    val expected = MySome(42)
    actual should equal(expected)
  }

  it should "map over MyNone" in {
    val actual   = (MyNone : MyOption[Int]).map(_ + 1)
    val expected = MyNone
    actual should equal(expected)
  }

  "myOption.flatMap" should "flatMap over MySome" in {
    val actual = for {
      x <- MySome(10)
      y <- MySome(32)
    } yield x + y
    val expected = MySome(42)
    actual should equal(expected)
  }

  it should "flatMap over MyNone" in {
    val actual = for {
      x <- (MyNone : MyOption[Int])
      y <- MySome(32)
    } yield x + y
    val expected = MyNone
    actual should equal(expected)
  }
}
