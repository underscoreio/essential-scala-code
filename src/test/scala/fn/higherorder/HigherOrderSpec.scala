package fn.higherorder

import org.scalatest._

class HigherOrderSpec extends FlatSpec with Matchers {
  val ints = IntPair(1, IntPair(3, IntPair(5, IntNil)))

  "intList.exists" should "work as expected" in {
    ints.exists(_ > 0) should equal(true)
    ints.exists(_ < 0) should equal(false)
    ints.exists(_ % 2 == 0) should equal(false)
    ints.exists(_ % 2 == 1) should equal(true)
  }
}
