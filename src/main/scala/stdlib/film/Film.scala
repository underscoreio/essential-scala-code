package stdlib.film

final case class Director(
  firstName: String,
  lastName: String,
  yearOfBirth: Int,
  films: List[Film]
) {
  def name: String =
    s"$firstName $lastName"
}

final case class Film(
  name: String,
  yearOfRelease: Int,
  imdbRating: Double
)

object TestMethods {
  def directorsWithBackCatalogOfSize(directors: List[Director], numberOfFilms: Int): List[Director] =
    ???

  def directorsBornBefore(directors: List[Director], year: Int): List[Director] =
    ???

  def directorsBornBeforeWithBackCatalogOfSize(directors: List[Director], year: Int, numberOfFilms: Int): List[Director] =
    ???

  def namesOfAllFilms(directors: List[Director]): List[String] =
    ???

  def findDirectorWithName(directors: List[Director], lastName: String): Option[Director] =
    ???

  def namesOfFilmsByNolan(directors: List[Director]): List[String] =
    ???

  def averageImdbRating(directors: List[Director]): Double =
    ???

  def directorsSortedByAge(directors: List[Director], ascending: Boolean = true): List[Director] =
    ???

  def allFilmsSortedByImdb(directors: List[Director]): List[Film] =
    ???

  def earliestFilmByAnyDirector(directors: List[Director]): Option[Film] =
    ???

  def earliestFilmsByAllDirectors(directors: List[Director]): Map[Director, Option[Film]] =
    ???
}

object TestData {
  val memento           = new Film("Memento", 2000, 8.5)
  val darkKnight        = new Film("Dark Knight", 2008, 9.0)
  val inception         = new Film("Inception", 2010, 8.8)

  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
  val outlawJoseyWales  = new Film("The Outlaw Josey Wales", 1976, 7.9)
  val unforgiven        = new Film("Unforgiven", 1992, 8.3)
  val granTorino        = new Film("Gran Torino", 2008, 8.2)
  val invictus          = new Film("Invictus", 2009, 7.4)

  val predator          = new Film("Predator", 1987, 7.9)
  val dieHard           = new Film("Die Hard", 1988, 8.3)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)

  val eastwood = new Director("Clint", "Eastwood", 1930,
    List(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))

  val mcTiernan = new Director("John", "McTiernan", 1951,
    List(predator, dieHard, huntForRedOctober, thomasCrownAffair))

  val nolan = new Director("Christopher", "Nolan", 1970,
    List(memento, darkKnight, inception))

  val someGuy = new Director("Just", "Some Guy", 1990,
    Nil)

  val directors = List(someGuy, mcTiernan, nolan, eastwood)

  val films = someGuy.films ++ mcTiernan.films ++ nolan.films ++ eastwood.films
}

object Main extends App {
  import TestData._
  import TestMethods._

  // println(s"""directorsWithBackCatalogOfSize           == ${directorsWithBackCatalogOfSize(directors, 3)}""")
  // println(s"""directorsBornBefore                      == ${directorsBornBefore(directors, 1970)}""")
  // println(s"""directorsBornBeforeWithBackCatalogOfSize == ${directorsBornBeforeWithBackCatalogOfSize(directors, 1970, 5)}""")
  // println(s"""namesOfAllFilms                          == ${namesOfAllFilms(directors)}""")
  // println(s"""findDirectorWithName                     == ${findDirectorWithName(directors, "Nolan")}""")
  // println(s"""namesOfFilmsByNolan                      == ${namesOfFilmsByNolan(directors)}""")
  // println(s"""averageImdbRating                        == ${averageImdbRating(directors)}""")
  // println(s"""directorsSortedByAge                     == ${directorsSortedByAge(directors, false)}""")
  // println(s"""allFilmsSortedByImdb                     == ${allFilmsSortedByImdb(directors)}""")
  // println(s"""earliestFilmByAnyDirector                == ${earliestFilmByAnyDirector(directors)}""")
  // println(s"""earliestFilmsByAllDirectors              == ${earliestFilmsByAllDirectors(directors)}""")
}
