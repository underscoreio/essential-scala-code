package part3

import films.Director

object Exercise16bOptionFoldAndMap {
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

  def namesOfFilmsByDirectorWithLastName(directors: List[Director], lastName: String): List[String] = {
    ???
  }

  def main(args: List[String]): Unit = {
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

    println("namesOfFilmsByDirectorWithLastName")
    println(namesOfFilmsByDirectorWithLastName(directors, "Nolan"))
    println(namesOfFilmsByDirectorWithLastName(directors, "Guy"))
    println(namesOfFilmsByDirectorWithLastName(directors, "DROP TABLE *;"))
  }
}
