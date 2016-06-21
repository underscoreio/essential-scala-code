package stdlib.film

final case class Director(
  firstName: String,
  lastName: String,
  yearOfBirth: Int,
  films: Seq[Film]
) {
  def name: String =
    s"$firstName $lastName"
}

final case class Film(
  name: String,
  yearOfRelease: Int,
  imdbRating: Double
)

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
    Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))

  val mcTiernan = new Director("John", "McTiernan", 1951,
    Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))

  val nolan = new Director("Christopher", "Nolan", 1970,
    Seq(memento, darkKnight, inception))

  val someGuy = new Director("Just", "Some Guy", 1990,
    Seq())

  val directors = Seq(someGuy, mcTiernan, nolan, eastwood)
}

object TestMethods {
  import TestData.directors

  def directorsWithBackCatalogOfSize(numberOfFilms: Int): Seq[Director] =
    ???

  def directorsBornBefore(year: Int): Seq[Director] =
    ???

  def directorsBornBeforeWithBackCatalogOfSize(year: Int, numberOfFilms: Int): Seq[Director] =
    ???

  def namesOfFilmsByNolan: Seq[String] =
    ???

  def namesOfAllFilmsByAllDirectors: Seq[String] =
    ???

  def averageImdbRating: Double =
    ???

  def directorsSortedByAge(ascending: Boolean = true): Seq[Director] =
    ???

  def allFilmsSortedByImdb: Seq[Film] =
    ???

  def earliestFilmByAnyDirector: Option[Film] =
    ???

  def earliestFilmsByAllDirectors: Map[Director, Option[Film]] =
    ???
}

object Main extends App {
  import TestData.directors
  import TestMethods._

  // println(s"""directorsWithBackCatalogOfSize(3) == ${directorsWithBackCatalogOfSize(3)}""")
  // println(s"""directorsBornBefore(1970) == ${directorsBornBefore(1970)}""")
  // println(s"""directorsBornBeforeWithBackCatalogOfSize(1970, 5) == ${directorsBornBeforeWithBackCatalogOfSize(1970, 5)}""")
  // println(s"""namesOfFilmsByNolan == ${namesOfFilmsByNolan}""")
  // println(s"""namesOfAllFilmsByAllDirectors == ${namesOfAllFilmsByAllDirectors}""")
  // println(s"""averageImdbRating == ${averageImdbRating}""")
  // println(s"""directorsSortedByAge(false) == ${directorsSortedByAge(false)}""")
  // println(s"""allFilmsSortedByImdb == ${allFilmsSortedByImdb}""")
  // println(s"""earliestFilmsByAllDirectors == ${earliestFilmsByAllDirectors}""")
  // println(s"""earliestFilmByAnyDirector == ${earliestFilmByAnyDirector}""")
}
