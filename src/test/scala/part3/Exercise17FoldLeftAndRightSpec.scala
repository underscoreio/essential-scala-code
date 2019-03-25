package part3

import org.scalatest._

class Exercise17FoldLeftAndRightSpec extends FlatSpec with Matchers {
  import Exercise17FoldLeftAndRight._
  import films.TestData._

  "totalImdbRating" should "do the right thing" in {
    pending
    // totalImdbRating(List(memento, outlawJoseyWales, thomasCrownAffair)) should equal(memento.imdbRating + outlawJoseyWales.imdbRating + thomasCrownAffair.imdbRating)
    // totalImdbRating(Nil) should equal(0.0)
  }

  "averageImdbRating" should "do the right thing" in {
    pending
    // averageImdbRating(List(memento, outlawJoseyWales, thomasCrownAffair)) should equal((memento.imdbRating + outlawJoseyWales.imdbRating + thomasCrownAffair.imdbRating) / 3.0)
    // averageImdbRating(Nil).isNaN should equal(true)
  }

  "reverseUsingFold" should "do the right thing" in {
    pending
    // reverseUsingFold(List(1, 2, 3)) should equal(List(3, 2, 1))
    // reverseUsingFold(Nil) should equal(Nil)
  }

  "filterUsingFold" should "do the right thing" in {
    pending
    // filterUsingFold(List(1, 2, 3, 4, 5), (n: Int) => n % 2 == 0) should equal(List(2, 4))
    // filterUsingFold(Nil, (n: Int) => n % 2 == 0) should equal(Nil)
  }
}
