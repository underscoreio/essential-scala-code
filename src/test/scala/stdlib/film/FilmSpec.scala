package stdlib.film

import org.scalatest._

class FilmSpec extends FlatSpec with Matchers {
  import TestData._
  import TestMethods._

  "directorsWithBackCatalogOfSize" should "produce the right result" in {
    pending
    // directorsWithBackCatalogOfSize(directors, 1) should contain theSameElementsAs(List(eastwood, mcTiernan, nolan))
    // directorsWithBackCatalogOfSize(directors, 4) should contain theSameElementsAs(List(eastwood, mcTiernan))
    // directorsWithBackCatalogOfSize(directors, 5) should contain theSameElementsAs(List(eastwood))
  }

  "directorsBornBefore" should "produce the right result" in {
    pending
    // directorsBornBefore(directors, 1930) should contain theSameElementsAs(Nil)
    // directorsBornBefore(directors, 1931) should contain theSameElementsAs(List(eastwood))
    // directorsBornBefore(directors, 1951) should contain theSameElementsAs(List(eastwood))
    // directorsBornBefore(directors, 1952) should contain theSameElementsAs(List(eastwood, mcTiernan))
  }

  "directorsBornBeforeWithBackCatalogOfSize" should "produce the right result" in {
    pending
    // directorsBornBeforeWithBackCatalogOfSize(directors, 1931, 5) should contain theSameElementsAs(List(eastwood))
    // directorsBornBeforeWithBackCatalogOfSize(directors, 1931, 6) should contain theSameElementsAs(Nil)
    // directorsBornBeforeWithBackCatalogOfSize(directors, 1930, 5) should contain theSameElementsAs(Nil)
  }

  "namesOfAllFilms" should "produce the right result" in {
    pending
    // val actual   = namesOfAllFilms(directors)
    // val expected = List(
    //   "Memento",
    //   "Dark Knight",
    //   "Inception",
    //   "High Plains Drifter",
    //   "The Outlaw Josey Wales",
    //   "Unforgiven",
    //   "Gran Torino",
    //   "Invictus",
    //   "Predator",
    //   "Die Hard",
    //   "The Hunt for Red October",
    //   "The Thomas Crown Affair",
    // )
    // actual should contain theSameElementsAs(expected)
  }

  "findDirectorWithName" should "produce the right result" in {
    pending
    // findDirectorWithName(directors, "Nolan") should equal(Some(nolan))
    // findDirectorWithName(directors, "Dijkstra") should equal(None)
  }

  "namesOfFilmsByNolan" should "produce the right result" in {
    pending
    // val actual   = namesOfFilmsByNolan(directors)
    // val expected = List("Memento", "Dark Knight", "Inception")
    // actual should contain theSameElementsAs(expected)
  }

  "averageImdbRating" should "produce the right result" in {
    // pending
    // val actual   = averageImdbRating(directors)
    // val expected = 8.03
    // actual should equal(expected +- 0.1)
  }

  "directorsSortedByAge" should "produce the right result" in {
    pending
    // directorsSortedByAge(directors, true) should equal(List(eastwood, mcTiernan, nolan, someGuy))
    // directorsSortedByAge(directors, false) should equal(List(eastwood, mcTiernan, nolan, someGuy).reverse)
  }

  "allFilmsSortedByImdb" should "produce the right result" in {
    pending
    // val actual   = allFilmsSortedByImdb(directors)
    // val expected = List(
    //   darkKnight,
    //   inception,
    //   memento,
    //   unforgiven,
    //   dieHard,
    //   granTorino,
    //   predator,
    //   outlawJoseyWales,
    //   highPlainsDrifter,
    //   huntForRedOctober,
    //   invictus,
    //   thomasCrownAffair,
    // )
    // actual should equal(expected)
  }

  "earliestFilmByAnyDirector" should "produce the right result" in {
    pending
    // earliestFilmByAnyDirector(directors) should equal(Some(highPlainsDrifter))
  }

  "earliestFilmsByAllDirectors" should "produce the right result" in {
    pending
    // val actual   = earliestFilmsByAllDirectors(directors)
    // val expected = Map(
    //   eastwood  -> Some(highPlainsDrifter),
    //   mcTiernan -> Some(predator),
    //   nolan     -> Some(memento),
    //   someGuy   -> None
    // )
    // actual should equal(expected)
  }
}