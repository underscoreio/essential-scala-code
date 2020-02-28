package part3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Exercise22SortingSpec extends AnyFlatSpec with Matchers {
  import Exercise22Sorting._
  import films.TestData._

  "filmsSortedByImdb" should "do the right thing" in {
    filmsSortedByImdb(nolan.films) should equal(List(memento, inception, darkKnight))
    filmsSortedByImdb(eastwood.films) should equal(List(invictus, highPlainsDrifter, outlawJoseyWales, granTorino, unforgiven))
  }

  "filmsByDirectorSortedByImdb" should "do the right thing" in {
    filmsByDirectorSortedByImdb(nolan) should equal(List(memento, inception, darkKnight))
    filmsByDirectorSortedByImdb(eastwood) should equal(List(invictus, highPlainsDrifter, outlawJoseyWales, granTorino, unforgiven))
  }

  "filmsByAllDirectorsSortedByImdb" should "do the right thing" in {
    filmsByAllDirectorsSortedByImdb(List(nolan, mcTiernan)) should equal(List(
      thomasCrownAffair,
      huntForRedOctober,
      predator,
      dieHard,
      memento,
      inception,
      darkKnight,
    ))
  }

  "filmsByAllDirectorsSortedByDirectorNameThenImdb" should "do the right thing" in {
    filmsByAllDirectorsSortedByDirectorNameThenImdb(List(nolan, mcTiernan)) should equal(List(
      memento,
      inception,
      darkKnight,
      thomasCrownAffair,
      huntForRedOctober,
      predator,
      dieHard,
    ))
  }

  "averageImdbRating" should "do the right thing" in {
    averageImdbRating(nolan.films) should equal(8.766 +- 0.001)
    averageImdbRating(someGuy.films).isNaN should be(true)
  }

  "averageImdbRatingAcrossDirectors" should "do the right thing" in {
    averageImdbRatingAcrossDirectors(directors) should equal(8.033 +- 0.001)
  }
}
