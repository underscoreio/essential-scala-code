package part2

import org.scalatest._

class Exercise11IntListSpec extends FlatSpec with Matchers {
  // def pair(h: Int, t: IntList): IntPair =
  //   IntPair(h, t)

  // val nil: IntList =
  //   IntNil()

  // val numbers1: IntList =
  //   pair(1, pair(2, pair(3, nil)))

  // val numbers2: IntList =
  //   pair(4, pair(5, pair(6, nil)))

  "contains" should "return true and false appropriately" in {
    pending
    // numbers1.contains(1) should equal(true)
    // numbers1.contains(5) should equal(false)
    // numbers2.contains(5) should equal(true)
    // numbers2.contains(1) should equal(false)
    // nil.contains(1) should equal(false)
  }

  "addToEach" should "increment every element in the list" in {
    pending
    // numbers1.addToEach(1) should equal(pair(2, pair(3, pair(4, nil))))
    // numbers2.addToEach(3) should equal(pair(7, pair(8, pair(9, nil))))
    // nil.addToEach(10) should equal(nil)
  }

  "total" should "total all elements" in {
    pending
    // numbers1.total should equal(1 + 2 + 3)
    // numbers2.total should equal(4 + 5 + 6)
    // nil.total should equal(0)
  }

  "append" should "append lists" in {
    pending
    // nil.append(nil) should equal(nil)
    // nil.append(numbers2) should equal(numbers2)
    // numbers1.append(nil) should equal(numbers1)
    // numbers1.append(numbers2) should equal(pair(1, pair(2, pair(3, pair(4, pair(5, pair(6, nil)))))))
  }

  "evensOnly" should "filter the list" in {
    pending
    // numbers1.evensOnly should equal(pair(2, nil))
    // numbers2.evensOnly should equal(pair(4, pair(6, nil)))
    // numbers1.append(numbers2).evensOnly should equal(pair(2, pair(4, pair(6, nil))))
    // nil.evensOnly should equal(nil)
  }
}
