package part3

import films.{Director, Film}

object Exercise22Sorting:
  def filmsSortedByImdb(films: List[Film]): List[Film] =
    films
      .sortBy(f => f.imdbRating)

  def filmsByDirectorSortedByImdb(director: Director): List[Film] =
    director.films
      .sortBy(f => f.imdbRating)

  def filmsByAllDirectorsSortedByImdb(directors: List[Director]): List[Film] =
    directors
      .flatMap(d => d.films)
      .sortBy(f => f.imdbRating)

  def filmsByAllDirectorsSortedByDirectorNameThenImdb(directors: List[Director]): List[Film] =
    directors
      .map(d => d.copy(films = d.films.sortBy(f => f.imdbRating)))
      .sortBy(f => f.name)
      .flatMap(d => d.films)

  def averageImdbRating(films: List[Film]): Double =
    films.foldLeft(0.0)(_ + _.imdbRating) / films.length

  def averageImdbRatingAcrossDirectors(directors: List[Director]): Double = {
    val films = directors.flatMap(d => d.films)
    films.foldLeft(0.0)(_ + _.imdbRating) / films.length
  }

  def main(args:Array[String]): Unit =
    import films.TestData._

    println("filmsSortedByImdb")
    println(filmsSortedByImdb(mcTiernan.films))
    println(filmsSortedByImdb(eastwood.films))

    println("filmsByDirectorSortedByImdb")
    println(filmsByDirectorSortedByImdb(mcTiernan))
    println(filmsByDirectorSortedByImdb(eastwood))

    println("filmsByAllDirectorsSortedByImdb")
    println(filmsByAllDirectorsSortedByImdb(List(nolan, mcTiernan)))

    println("filmsByAllDirectorsSortedByDirectorNameThenImdb")
    println(filmsByAllDirectorsSortedByDirectorNameThenImdb(List(nolan, mcTiernan)))

    println("averageImdbRating")
    println(averageImdbRating(nolan.films))
    println(averageImdbRating(someGuy.films))

    println("averageImdbRatingAcrossDirectors")
    println(averageImdbRatingAcrossDirectors(directors))
