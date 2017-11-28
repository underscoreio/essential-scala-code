package fn.higherorder

import org.scalatest._

class HigherOrderSpec extends FlatSpec with Matchers {
  val ints = IntPair(1, IntPair(3, IntPair(5, IntNil())))

  "intList.exists" should "work as expected" in {
    pending
    // ints.exists(_ > 0) should equal(true)
    // ints.exists(_ < 0) should equal(false)
    // ints.exists(_ % 2 == 0) should equal(false)
    // ints.exists(_ % 2 == 1) should equal(true)
  }

  "intList.filter" should "work as expected" in {
    pending
    // ints.filter(_ > 0) should equal(ints)
    // ints.filter(_ < 0) should equal(IntNil)
    // ints.filter(_ > 3) should equal(IntPair(5, IntNil))
  }

  "intList.find" should "work as expected" in {
    pending
    // ints.find(_ > 0) should equal(IntSome(1))
    // ints.find(_ < 0) should equal(IntNone)
    // ints.find(_ > 3) should equal(IntSome(5))
  }
}
