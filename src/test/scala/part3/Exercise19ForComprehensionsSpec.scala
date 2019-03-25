package part3

import org.scalatest._

class Exercise19ForComprehensionsSpec extends FlatSpec with Matchers {
  import Exercise19ForComprehensions._
  import films.TestData._

  "filmsByDirector" should "do the right thing" in {
    filmsByDirector(nolan) should contain theSameElementsAs List(memento, darkKnight, inception)
    filmsByDirector(someGuy) should equal(Nil)
  }

  "namesOfFilmsByDirector" should "do the right thing" in {
    namesOfFilmsByDirector(nolan) should contain theSameElementsAs List(memento.name, darkKnight.name, inception.name)
    namesOfFilmsByDirector(someGuy) should equal(Nil)
  }

  "filmsByAllDirectors" should "do the right thing" in {
    filmsByAllDirectors(List(nolan, mcTiernan)) should contain theSameElementsAs (nolan.films ++ mcTiernan.films)
    filmsByAllDirectors(List(eastwood, someGuy)) should contain theSameElementsAs eastwood.films
  }

  "namesOfFilmsByAllDirectors" should "do the right thing" in {
    namesOfFilmsByAllDirectors(List(nolan, mcTiernan)) should contain theSameElementsAs (nolan.films ++ mcTiernan.films).map(f => f.name)
    namesOfFilmsByAllDirectors(List(eastwood, someGuy)) should contain theSameElementsAs eastwood.films.map(f => f.name)
  }

  "tonightOnlyMessages" should "do the right thing" in {
    tonightOnlyMessages(List(nolan, mcTiernan)) should contain theSameElementsAs List(
      "Tonight only! Memento by Christopher Nolan!",
      "Tonight only! Dark Knight by Christopher Nolan!",
      "Tonight only! Inception by Christopher Nolan!",
      "Tonight only! Predator by John McTiernan!",
      "Tonight only! Die Hard by John McTiernan!",
      "Tonight only! The Hunt for Red October by John McTiernan!",
      "Tonight only! The Thomas Crown Affair by John McTiernan!",
    )
  }
}
