package typeclass.times

import org.scalatest._

class TimesSpec extends FlatSpec with Matchers {
  import TimesImplicits._

  "times" should "accumulate a List[Int]" in {
    5.times(_ * 10) should equal(List(10, 20, 30, 40, 50))
  }

  it should "accumulate a List[String]" in {
    3.times(_ + "!") should equal(List("1!", "2!", "3!"))
  }
}
