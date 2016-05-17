package stdlib.film

import org.scalatest._

class FilmSpec extends FlatSpec with Matchers {
  import TestData._
  import TestMethods._

  "directorsWithBackCatalogOfSize" should "produce the right result" in {
    pending
    // directorsWithBackCatalogOfSize(1) should contain theSameElementsAs(List(eastwood, mcTiernan, nolan))
    // directorsWithBackCatalogOfSize(4) should contain theSameElementsAs(List(eastwood, mcTiernan))
    // directorsWithBackCatalogOfSize(5) should contain theSameElementsAs(List(eastwood))
  }

  "directorsBornBefore" should "produce the right result" in {
    pending
    // directorsBornBefore(1930) should contain theSameElementsAs(Nil)
    // directorsBornBefore(1931) should contain theSameElementsAs(List(eastwood))
    // directorsBornBefore(1951) should contain theSameElementsAs(List(eastwood))
    // directorsBornBefore(1952) should contain theSameElementsAs(List(eastwood, mcTiernan))
  }

  "directorsBornBeforeWithBackCatalogOfSize" should "produce the right result" in {
    pending
    // directorsBornBeforeWithBackCatalogOfSize(1931, 5) should contain theSameElementsAs(List(eastwood))
    // directorsBornBeforeWithBackCatalogOfSize(1931, 6) should contain theSameElementsAs(Nil)
    // directorsBornBeforeWithBackCatalogOfSize(1930, 5) should contain theSameElementsAs(Nil)
  }

  "directorsSortedByAge" should "produce the right result" in {
    pending
    // directorsSortedByAge(true) should equal(List(eastwood, mcTiernan, nolan, someGuy))
    // directorsSortedByAge(false) should equal(List(eastwood, mcTiernan, nolan, someGuy).reverse)
  }

  "namesOfFilmsByNolan" should "produce the right result" in {
    pending
    // namesOfFilmsByNolan should contain theSameElementsAs(nolan.films.map(_.name))
  }

  "namesOfAllFilmsByAllDirectors" should "produce the right result" in {
    pending
    // val actual   = namesOfAllFilmsByAllDirectors
    // val expected = for {
    //   d <- directors
    //   f <- d.films
    // } yield f.name
    // actual should contain theSameElementsAs(expected)
  }

  "earliestFilmsByAllDirectors" should "produce the right result" in {
    pending
    // val actual   = earliestFilmsByAllDirectors
    // val expected = for {
    //   d <- directors
    //   f  = d.films.sortBy(_.yearOfRelease).headOption
    // } yield (d -> f)
    // actual should contain theSameElementsAs(expected)
  }

  "allFilmsSortedByImdb" should "produce the right result" in {
    pending
    // val actual   = allFilmsSortedByImdb
    // val expected = directors.flatMap(_.films).sortBy(f => -f.imdbRating)
    // actual should equal(expected)
  }

  "averageImdbRating" should "produce the right result" in {
    pending
    // val actual   = averageImdbRating
    // val expected = {
    //   val films = directors.flatMap(_.films)
    //   films.map(_.imdbRating).sum / films.length
    // }
    // actual should equal(expected)
  }

  "tonightOnlyMessages" should "produce the right result" in {
    pending
    // val actual   = tonightOnlyMessages
    // val expected = for {
    //   d <- directors
    //   f <- d.films
    // } yield s"Tonight! ${f.name} by ${d.name}!"
    // actual should equal(expected)
  }

  "earliestFilmByAnyDirector" should "produce the right result" in {
    pending
    // earliestFilmByAnyDirector should equal(Some(highPlainsDrifter))
  }
}