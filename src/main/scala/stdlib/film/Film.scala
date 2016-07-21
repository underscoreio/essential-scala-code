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
    directors.filter(_.films.length >= numberOfFilms)

  def directorsBornBefore(year: Int): Seq[Director] =
    directors.filter(_.yearOfBirth < year)

  def directorsBornBeforeWithBackCatalogOfSize(year: Int, numberOfFilms: Int): Seq[Director] =
    directors
     .filter(_.yearOfBirth < year)
     .filter(_.films.length >= numberOfFilms)

  def directorsSortedByAge(ascending: Boolean = true): Seq[Director] =
    directors.sortWith { (a, b) =>
      if(ascending) {
        a.yearOfBirth < b.yearOfBirth
      } else {
        a.yearOfBirth > b.yearOfBirth
      }
    }

  def namesOfFilmsByNolan: Seq[String] =
    directors
      .find(_.lastName == "Nolan")
      .map(_.films.map(_.name))
      .getOrElse(Seq.empty)

  def namesOfAllFilmsByAllDirectors: Seq[String] =
    directors
      .flatMap(_.films.map(film => film.name))

  def earliestFilmsByAllDirectors: Map[Director, Option[Film]] =
    for {
      (director, films) <- directors.map(d => d -> d.films).toMap
      earliest           = films
                             .sortWith((a, b) => a.yearOfRelease < b.yearOfRelease)
                             .headOption
    } yield (director -> earliest)


  def allFilmsSortedByImdb: Seq[Film] =
    directors
      .flatMap(_.films)
      .sortWith((a, b) => a.imdbRating > b.imdbRating)

  def averageImdbRating: Double = {
    val films = directors.flatMap(_.films)
    films.foldLeft(0.0)(_ + _.imdbRating) / films.length
  }

  def tonightOnlyMessages: Seq[String] =
    for {
      director <- directors
      film     <- director.films
    } yield s"Tonight! ${film.name} by ${director.name}!"

  def earliestFilmByAnyDirector: Option[Film] =
    directors
      .flatMap(_.films)
      .sortWith((a, b) => a.yearOfRelease < b.yearOfRelease)
      .headOption
}

object Main extends App {
  import TestData.directors
  import TestMethods._

  println("""directorsWithBackCatalogOfSize(3)                 == """ + directorsWithBackCatalogOfSize(3))
  println("""directorsBornBefore(1970)                         == """ + directorsBornBefore(1970))
  println("""directorsBornBeforeWithBackCatalogOfSize(1970, 5) == """ + directorsBornBeforeWithBackCatalogOfSize(1970, 5))
  println("""namesOfFilmsByNolan                               == """ + namesOfFilmsByNolan)
  println("""namesOfAllFilmsByAllDirectors                     == """ + namesOfAllFilmsByAllDirectors)
  println("""averageImdbRating                                 == """ + averageImdbRating)
  println("""directorsSortedByAge(false)                       == """ + directorsSortedByAge(false))
  println("""allFilmsSortedByImdb                              == """ + allFilmsSortedByImdb)
  println("""earliestFilmsByAllDirectors                       == """ + earliestFilmsByAllDirectors)
  println("""earliestFilmByAnyDirector                         == """ + earliestFilmByAnyDirector)
}
