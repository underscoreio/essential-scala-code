package part3

import films.{Director, Film}

object Exercise22Sorting {
  def filmsSortedByImdb(films: List[Film]): List[Film] = {
    ???
  }

  def filmsByDirectorSortedByImdb(director: Director): List[Film] = {
    ???
  }

  def filmsByAllDirectorsSortedByImdb(directors: List[Director]): List[Film] = {
    ???
  }

  def filmsByAllDirectorsSortedByDirectorNameThenImdb(directors: List[Director]): List[Film] = {
    ???
  }

  def averageImdbRating(films: List[Film]): Double = {
    ???
  }

  def averageImdbRatingAcrossDirectors(directors: List[Director]): Double = {
    ???
  }

  def main(args:Array[String]): Unit = {
    import films.TestData._

    println("filmsSortedByImdb")
    // println(filmsSortedByImdb(mcTiernan.films))
    // println(filmsSortedByImdb(eastwood.films))

    println("filmsByDirectorSortedByImdb")
    // println(filmsByDirectorSortedByImdb(mcTiernan))
    // println(filmsByDirectorSortedByImdb(eastwood))

    println("filmsByAllDirectorsSortedByImdb")
    // println(filmsByAllDirectorsSortedByImdb(List(nolan, mcTiernan)))

    println("filmsByAllDirectorsSortedByDirectorNameThenImdb")
    // println(filmsByAllDirectorsSortedByDirectorNameThenImdb(List(nolan, mcTiernan)))

    println("averageImdbRating")
    // println(averageImdbRating(nolan.films))
    // println(averageImdbRating(someGuy.films))

    println("averageImdbRatingAcrossDirectors")
    // println(averageImdbRatingAcrossDirectors(directors))
  }
}
