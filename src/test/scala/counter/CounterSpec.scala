package counter

import org.scalatest._

class CounterSpec extends FlatSpec with Matchers {
  val counter = new Counter(123)

  "constructor" should "create a counter with the correct value" in {
    counter.get should be(123)
  }

  "inc method" should "create a counter with a value that is one higher" in {
    counter.inc.get should be(124)
    counter.inc.inc.get should be(125)
    counter.inc.inc.inc.get should be(126)
  }

  "toString method" should "return a nicely formatted String" in {
    counter.toString should be("Counter(123)")
    counter.inc.toString should be("Counter(124)")
  }
}
