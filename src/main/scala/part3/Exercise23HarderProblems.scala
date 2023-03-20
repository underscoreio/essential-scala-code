package part3

import films.{Director, Film}

object Exercise23HarderProblems:
  def earliestFilmsByAllDirectors(directors: List[Director]): List[(Director, Option[Film])] =
    directors.map(d => d -> d.films.sortBy(_.yearOfRelease).headOption)

  def earliestFilmsByAllDirectorsAsMap(directors: List[Director]): Map[Director, Option[Film]] =
    directors.map(d => d -> d.films.sortBy(_.yearOfRelease).headOption).toMap

  def averageImdbRatingAcrossDirectors(directors: List[Director]): Double =
    val films = directors.flatMap(d => d.films)
    films.foldLeft(0.0)((total, film) => total + film.imdbRating) / films.length

  def earliestFilmByAnyDirector(directors: List[Director]): Option[Film] =
    directors
      .flatMap(_.films)
      .sortBy(f => f.yearOfRelease)
      .headOption

  def earliestFilmByOldestDirector(directors: List[Director]): Option[Film] =
    directors
      .sortBy(d => d.yearOfBirth)
      .headOption
      .flatMap { d =>
        d.films
          .sortBy(f => f.yearOfRelease)
          .headOption
      }

  def filmsByAllDirectorsSortedByDirectorNameAndImdb(directors: List[Director], asc: Boolean): List[Film] =
    val compareDirectors: (Director, Director) => Boolean =
      if asc then
        (a, b) => a.name < b.name
      else
        (a, b) => a.name > b.name

    val compareFilms: (Film, Film) => Boolean =
      if asc then
        (a, b) => a.imdbRating > b.imdbRating
      else
        (a, b) => a.imdbRating < b.imdbRating

    directors
      .sortWith(compareDirectors)
      .map(d => d.copy(films = d.films.sortWith(compareFilms)))
      .flatMap(d => d.films)

  def main(): Unit =
    import films.TestData._

    println("earliestFilmsByAllDirectors")
    earliestFilmsByAllDirectors(directors).foreach {
      case (key, value) =>
        println(s"$key -> $value")
    }

    println("earliestFilmsByAllDirectorsAsMap")
    earliestFilmsByAllDirectorsAsMap(directors).foreach {
      case (key, value) =>
        println(s"$key -> $value")
    }

    println("averageImdbRatingAcrossDirectors")
    println(averageImdbRatingAcrossDirectors(directors))

    println("earliestFilmByAnyDirector")
    println(earliestFilmByAnyDirector(directors))

    println("earliestFilmByOldestDirector")
    println(earliestFilmByOldestDirector(directors))

    println("filmsByAllDirectorsSortedByDirectorNameAndImdb asc")
    filmsByAllDirectorsSortedByDirectorNameAndImdb(directors, true).foreach(println)

    println("filmsByAllDirectorsSortedByDirectorNameAndImdb asc")
    filmsByAllDirectorsSortedByDirectorNameAndImdb(directors, false).foreach(println)
