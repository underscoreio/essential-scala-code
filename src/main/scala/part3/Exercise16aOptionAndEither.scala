package part3

import films.{Director, Film}

object Exercise16aOptionAndEither {
  def directorWithLastName(directors: List[Director], lastName: String): Option[Director] = {
    ???
  }

  def directorWithLastNameOrFailure(directors: List[Director], lastName: String): Either[String, Director] = {
    ???
  }

  def yearOfBirthOfDirectorWithLastName(directors: List[Director], lastName: String): Option[Int] = {
    ???
  }

  def yearOfBirthOfDirectorWithLastNameOrFailure(directors: List[Director], lastName: String): Either[String, Int] = {
    ???
  }

  def filmsByDirectorWithLastName(directors: List[Director], lastName: String): List[Film] = {
    ???
  }

  def earliestFilmByDirectorWithLastName(directors: List[Director], lastName: String): Option[Film] = {
    ???
  }

  def earliestFilmByDirectorWithLastNameOrFailure(directors: List[Director], lastName: String): Either[String, Film] = {
    ???
  }

  def namesOfFilmsByDirectorWithLastName(directors: List[Director], lastName: String): List[String] = {
    ???
  }

  def nameOfEarliestFilmByDirectorWithLastName(directors: List[Director], lastName: String): Option[String] = {
    ???
  }

  def nameOfEarliestFilmByDirectorWithLastNameOrFailure(directors: List[Director], lastName: String): Either[String, String] = {
    ???
  }

  def main(args: Array[String]): Unit = {
    import films.TestData._

    println("directorWithLastName")
    // println(directorWithLastName(directors, "Nolan"))
    // println(directorWithLastName(directors, "Guy"))
    // println(directorWithLastName(directors, "DROP TABLE *;"))

    println("directorWithLastNameOrFailure")
    // println(directorWithLastNameOrFailure(directors, "Nolan"))
    // println(directorWithLastNameOrFailure(directors, "Guy"))
    // println(directorWithLastNameOrFailure(directors, "DROP TABLE *;"))

    println("yearOfBirthOfDirectorWithLastName")
    // println(yearOfBirthOfDirectorWithLastName(directors, "Nolan"))
    // println(yearOfBirthOfDirectorWithLastName(directors, "Guy"))
    // println(yearOfBirthOfDirectorWithLastName(directors, "DROP TABLE *;"))

    println("yearOfBirthOfDirectorWithLastNameOrFailure")
    // println(yearOfBirthOfDirectorWithLastNameOrFailure(directors, "Nolan"))
    // println(yearOfBirthOfDirectorWithLastNameOrFailure(directors, "Guy"))
    // println(yearOfBirthOfDirectorWithLastNameOrFailure(directors, "DROP TABLE *;"))

    println("filmsByDirectorWithLastName")
    // println(filmsByDirectorWithLastName(directors, "Nolan"))
    // println(filmsByDirectorWithLastName(directors, "Guy"))
    // println(filmsByDirectorWithLastName(directors, "DROP TABLE *;"))

    println("earliestFilmByDirectorWithLastName")
    // println(earliestFilmByDirectorWithLastName(directors, "Nolan"))
    // println(earliestFilmByDirectorWithLastName(directors, "Guy"))
    // println(earliestFilmByDirectorWithLastName(directors, "DROP TABLE *;"))

    println("earliestFilmByDirectorWithLastNameOrFailure")
    // println(earliestFilmByDirectorWithLastNameOrFailure(directors, "Nolan"))
    // println(earliestFilmByDirectorWithLastNameOrFailure(directors, "Guy"))
    // println(earliestFilmByDirectorWithLastNameOrFailure(directors, "DROP TABLE *;"))

    println("namesOfFilmsByDirectorWithLastName")
    // println(namesOfFilmsByDirectorWithLastName(directors, "Nolan"))
    // println(namesOfFilmsByDirectorWithLastName(directors, "Guy"))
    // println(namesOfFilmsByDirectorWithLastName(directors, "DROP TABLE *;"))

    println("nameOfEarliestFilmByDirectorWithLastName")
    // println(nameOfEarliestFilmByDirectorWithLastName(directors, "Nolan"))
    // println(nameOfEarliestFilmByDirectorWithLastName(directors, "Guy"))
    // println(nameOfEarliestFilmByDirectorWithLastName(directors, "DROP TABLE *;"))

    println("nameOfEarliestFilmByDirectorWithLastNameOrFailure")
    // println(nameOfEarliestFilmByDirectorWithLastNameOrFailure(directors, "Nolan"))
    // println(nameOfEarliestFilmByDirectorWithLastNameOrFailure(directors, "Guy"))
    // println(nameOfEarliestFilmByDirectorWithLastNameOrFailure(directors, "DROP TABLE *;"))
  }
}
