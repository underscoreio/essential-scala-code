package part3

import films.{Director, Film}

object Exercise16bOptionFoldAndMap {
  def directorWithLastName(directors: List[Director], lastName: String): Option[Director] = {
    directors
      .find(d => d.lastName == lastName)
  }

  def directorWithLastNameOrFailure(directors: List[Director], lastName: String): Either[String, Director] = {
    directors
      .find(d => d.lastName == lastName)
      .toRight(s"Director not found: $lastName")
  }

  def yearOfBirthOfDirectorWithLastName(directors: List[Director], lastName: String): Option[Int] = {
    directors
      .find(d => d.lastName == lastName)
      .map(d => d.yearOfBirth)
  }

  def yearOfBirthOfDirectorWithLastNameOrFailure(directors: List[Director], lastName: String): Either[String, Int] = {
    directors
      .find(d => d.lastName == lastName)
      .toRight(s"Director not found: $lastName")
      .map(d => d.yearOfBirth)
  }

  def namesOfFilmsByDirectorWithLastName(directors: List[Director], lastName: String): List[String] = {
    directors
      .find(d => d.lastName == lastName)
      .fold[List[String]](Nil)(d => d.films.map(f => f.name))
  }

  def main(args: List[String]): Unit = {
    import films.TestData._

    println("directorWithLastName")
    println(directorWithLastName(directors, "Nolan"))
    println(directorWithLastName(directors, "Guy"))
    println(directorWithLastName(directors, "DROP TABLE *;"))

    println("directorWithLastNameOrFailure")
    println(directorWithLastNameOrFailure(directors, "Nolan"))
    println(directorWithLastNameOrFailure(directors, "Guy"))
    println(directorWithLastNameOrFailure(directors, "DROP TABLE *;"))

    println("yearOfBirthOfDirectorWithLastName")
    println(yearOfBirthOfDirectorWithLastName(directors, "Nolan"))
    println(yearOfBirthOfDirectorWithLastName(directors, "Guy"))
    println(yearOfBirthOfDirectorWithLastName(directors, "DROP TABLE *;"))

    println("yearOfBirthOfDirectorWithLastNameOrFailure")
    println(yearOfBirthOfDirectorWithLastNameOrFailure(directors, "Nolan"))
    println(yearOfBirthOfDirectorWithLastNameOrFailure(directors, "Guy"))
    println(yearOfBirthOfDirectorWithLastNameOrFailure(directors, "DROP TABLE *;"))

    println("namesOfFilmsByDirectorWithLastName")
    println(namesOfFilmsByDirectorWithLastName(directors, "Nolan"))
    println(namesOfFilmsByDirectorWithLastName(directors, "Guy"))
    println(namesOfFilmsByDirectorWithLastName(directors, "DROP TABLE *;"))
  }
}
