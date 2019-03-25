package part3

import films.Director
import org.scalatest._

class Exercise16bOptionFoldAndMapSpec extends FlatSpec with Matchers {
  import Exercise16bOptionFoldAndMap._
  import films.TestData._

  "directorWithLastName" should "do the right thing" in {
    directorWithLastName(directors, "Nolan") should equal(Some(nolan))
    directorWithLastName(directors, "Some Guy") should equal(Some(someGuy))
    directorWithLastName(directors, "DROP TABLE *;") should equal(None)
  }

  "directorWithLastNameOrFailure" should "do the right thing" in {
    directorWithLastNameOrFailure(directors, "Nolan") should equal(Right(nolan))
    directorWithLastNameOrFailure(directors, "Some Guy") should equal(Right(someGuy))
    directorWithLastNameOrFailure(directors, "DROP TABLE *;") shouldBe a[Left[_, _]]
  }

  "yearOfBirthOfDirectorWithLastName" should "do the right thing" in {
    yearOfBirthOfDirectorWithLastName(directors, "Nolan") should equal(Some(nolan.yearOfBirth))
    yearOfBirthOfDirectorWithLastName(directors, "Some Guy") should equal(Some(someGuy.yearOfBirth))
    yearOfBirthOfDirectorWithLastName(directors, "DROP TABLE *;") should equal(None)
  }

  "yearOfBirthOfDirectorWithLastNameOrFailure" should "do the right thing" in {
    yearOfBirthOfDirectorWithLastNameOrFailure(directors, "Nolan") should equal(Right(nolan.yearOfBirth))
    yearOfBirthOfDirectorWithLastNameOrFailure(directors, "Some Guy") should equal(Right(someGuy.yearOfBirth))
    yearOfBirthOfDirectorWithLastNameOrFailure(directors, "DROP TABLE *;") shouldBe a[Left[_, _]]
  }

  "namesOfFilmsByDirectorWithLastName" should "do the right thing" in {
    namesOfFilmsByDirectorWithLastName(directors, "Nolan") should equal(nolan.films.map(f => f.name))
    namesOfFilmsByDirectorWithLastName(directors, "Some Guy") should equal(Nil)
    namesOfFilmsByDirectorWithLastName(directors, "DROP TABLE *;") should equal(Nil)
  }
}
