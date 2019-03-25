package part1

import org.scalatest._

class Exercise6FilmsSpec extends FlatSpec with Matchers {
  import films.TestData._
  import Exercise6Films._

  "nameOfFilm" should "work as expected" in {
    nameOfFilm(memento) should equal(memento.name)
    nameOfFilm(darkKnight) should equal(darkKnight.name)
  }

  "filmsByDirector" should "work as expected" in {
    filmsByDirector(nolan) should contain theSameElementsAs nolan.films
    filmsByDirector(eastwood) should contain theSameElementsAs eastwood.films
  }

  "directorsWithBackCatalogOfSize" should "work as expected" in {
    directorsWithBackCatalogOfSize(directors, 1) should contain theSameElementsAs List(eastwood, mcTiernan, nolan)
    directorsWithBackCatalogOfSize(directors, 4) should contain theSameElementsAs List(eastwood, mcTiernan)
    directorsWithBackCatalogOfSize(directors, 5) should contain theSameElementsAs List(eastwood)
    directorsWithBackCatalogOfSize(Nil, 1) should contain theSameElementsAs Nil
  }

  "directorsBornBefore" should "work as expected" in {
    directorsBornBefore(directors, 1930) should contain theSameElementsAs Nil
    directorsBornBefore(directors, 1931) should contain theSameElementsAs List(eastwood)
    directorsBornBefore(directors, 1951) should contain theSameElementsAs List(eastwood)
    directorsBornBefore(directors, 1952) should contain theSameElementsAs List(eastwood, mcTiernan)
    directorsBornBefore(Nil, 2000) should contain theSameElementsAs Nil
  }

  "directorsBornBeforeWithBackCatalogOfSize" should "work as expected" in {
    directorsBornBeforeWithBackCatalogOfSize(directors, 1931, 5) should contain theSameElementsAs List(eastwood)
    directorsBornBeforeWithBackCatalogOfSize(directors, 1931, 6) should contain theSameElementsAs Nil
    directorsBornBeforeWithBackCatalogOfSize(directors, 1930, 5) should contain theSameElementsAs Nil
    directorsBornBeforeWithBackCatalogOfSize(Nil, 2000, 1) should contain theSameElementsAs Nil
  }

  "namesOfFilms" should "work as expected" in {
    namesOfFilms(List(memento, darkKnight)) should contain theSameElementsAs List(memento.name, darkKnight.name)
    namesOfFilms(Nil) should equal(Nil)
  }

  "namesOfFilmsByDirector" should "work as expected" in {
    namesOfFilmsByDirector(nolan) should contain theSameElementsAs nolan.films.map(_.name)
    namesOfFilmsByDirector(eastwood) should contain theSameElementsAs eastwood.films.map(_.name)
    namesOfFilmsByDirector(someGuy) should equal(Nil)
  }

  "namesOfFilmsByDirectorScoringAtLeast" should "work as expected" in {
    namesOfFilmsByDirectorScoringAtLeast(nolan, 8.8) should contain theSameElementsAs List(darkKnight.name, inception.name)
    namesOfFilmsByDirectorScoringAtLeast(nolan, 8.9) should contain theSameElementsAs List(darkKnight.name)
    namesOfFilmsByDirectorScoringAtLeast(someGuy, 0.0) should equal(Nil)
  }
}
