package part3

import films.{Director, Film}

object Exercise23HarderProblems {
  def earliestFilmsByAllDirectors(directors: List[Director]): List[(Director, Option[Film])] = {
    ???
  }

  def earliestFilmsByAllDirectorsAsMap(directors: List[Director]): Map[Director, Option[Film]] = {
    ???
  }

  def averageImdbRatingAcrossDirectors(directors: List[Director]): Double = {
    ???
  }

  def earliestFilmByAnyDirector(directors: List[Director]): Option[Film] = {
    ???
  }

  def earliestFilmByOldestDirector(directors: List[Director]): Option[Film] = {
    ???
  }

  def filmsByAllDirectorsSortedByDirectorNameAndImdb(directors: List[Director], asc: Boolean): List[Film] = {
    ???
  }

  def main(args: Array[String]): Unit = {
    import films.TestData._

    println("earliestFilmsByAllDirectors")
    // earliestFilmsByAllDirectors(directors).foreach {
    //   case (key, value) =>
    //     println(key + " -> " + value)
    // }

    println("earliestFilmsByAllDirectorsAsMap")
    // earliestFilmsByAllDirectorsAsMap(directors).foreach {
    //   case (key, value) =>
    //     println(key + " -> " + value)
    // }

    println("averageImdbRatingAcrossDirectors")
    // println(averageImdbRatingAcrossDirectors(directors))

    println("earliestFilmByAnyDirector")
    // println(earliestFilmByAnyDirector(directors))

    println("earliestFilmByOldestDirector")
    // println(earliestFilmByOldestDirector(directors))

    println("filmsByAllDirectorsSortedByDirectorNameAndImdb asc")
    // filmsByAllDirectorsSortedByDirectorNameAndImdb(directors, true).foreach(println)

    println("filmsByAllDirectorsSortedByDirectorNameAndImdb asc")
    // filmsByAllDirectorsSortedByDirectorNameAndImdb(directors, false).foreach(println)
  }
}
