package part2

import org.scalatest._

class Exercise7CounterSpec extends FlatSpec with Matchers {
  val counter1 = new Counter(123)
  val counter2 = new Counter(321)

  "constructor" should "create a counter with the correct value" in {
    counter1.value should equal(123)
    counter2.value should equal(321)
  }

  "increment" should "copy the counter and increment the value by 1" in {
    val counter3 = counter1.increment
    val counter4 = counter2.increment
    counter1.value should equal(123)
    counter2.value should equal(321)
    counter3.value should equal(124)
    counter4.value should equal(322)
  }

  "equals method" should "compare counters by value" in {
    (counter1 == counter1) should equal(true)
    (counter1 == counter1.increment) should equal(false)
    (counter1.increment == new Counter(124)) should equal(true)
    (counter1.increment == counter1.increment) should equal(true)
  }

  "toString method" should "pretty print a counter" in {
    counter1.toString should equal("Counter(123)")
    counter2.toString should equal("Counter(321)")
    counter1.increment.toString should equal("Counter(124)")
  }
}
