package generic.mylist

import org.scalatest._

class MyListSpec extends FlatSpec with Matchers {
  val ints    = MyPair(1, MyPair(3, MyPair(5, MyNil)))
  val strings = MyPair("foo", MyPair("bar", MyPair("baz", MyNil)))

  "intList.exists" should "work as expected" in {
    ints.exists(_ > 0) should equal(true)
    ints.exists(_ < 0) should equal(false)
    ints.exists(_ % 2 == 0) should equal(false)
    ints.exists(_ % 2 == 1) should equal(true)
  }

  "intList.filter" should "work as expected" in {
    ints.filter(_ > 0) should equal(ints)
    ints.filter(_ < 0) should equal(MyNil)
    ints.filter(_ > 3) should equal(MyPair(5, MyNil))
  }

  "intList.find" should "work as expected" in {
    ints.find(_ > 0) should equal(MySome(1))
    ints.find(_ < 0) should equal(MyNone)
    ints.find(_ > 3) should equal(MySome(5))
  }
}
