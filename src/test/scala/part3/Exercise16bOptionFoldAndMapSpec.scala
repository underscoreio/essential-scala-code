package part3

import films.Director
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Exercise16bOptionFoldAndMapSpec extends AnyFlatSpec with Matchers {
  import Exercise16bOptionFoldAndMap._
  import films.TestData._

  "directorWithLastName" should "do the right thing" in {
    pending
    // directorWithLastName(directors, "Nolan") should equal(Some(nolan))
    // directorWithLastName(directors, "Some Guy") should equal(Some(someGuy))
    // directorWithLastName(directors, "DROP TABLE *;") should equal(None)
  }

  "directorWithLastNameOrFailure" should "do the right thing" in {
    pending
    // directorWithLastNameOrFailure(directors, "Nolan") should equal(Right(nolan))
    // directorWithLastNameOrFailure(directors, "Some Guy") should equal(Right(someGuy))
    // directorWithLastNameOrFailure(directors, "DROP TABLE *;") shouldBe a[Left[_, _]]
  }

  "yearOfBirthOfDirectorWithLastName" should "do the right thing" in {
    pending
    // yearOfBirthOfDirectorWithLastName(directors, "Nolan") should equal(Some(nolan.yearOfBirth))
    // yearOfBirthOfDirectorWithLastName(directors, "Some Guy") should equal(Some(someGuy.yearOfBirth))
    // yearOfBirthOfDirectorWithLastName(directors, "DROP TABLE *;") should equal(None)
  }

  "yearOfBirthOfDirectorWithLastNameOrFailure" should "do the right thing" in {
    pending
    // yearOfBirthOfDirectorWithLastNameOrFailure(directors, "Nolan") should equal(Right(nolan.yearOfBirth))
    // yearOfBirthOfDirectorWithLastNameOrFailure(directors, "Some Guy") should equal(Right(someGuy.yearOfBirth))
    // yearOfBirthOfDirectorWithLastNameOrFailure(directors, "DROP TABLE *;") shouldBe a[Left[_, _]]
  }

  "namesOfFilmsByDirectorWithLastName" should "do the right thing" in {
    pending
    // namesOfFilmsByDirectorWithLastName(directors, "Nolan") should equal(nolan.films.map(f => f.name))
    // namesOfFilmsByDirectorWithLastName(directors, "Some Guy") should equal(Nil)
    // namesOfFilmsByDirectorWithLastName(directors, "DROP TABLE *;") should equal(Nil)
  }
}
