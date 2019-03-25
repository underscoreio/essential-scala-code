package part3

import films.{Director, Film}
import org.scalatest._

class Exercise16aOptionAndEitherSpec extends FlatSpec with Matchers {
  import Exercise16aOptionAndEither._
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

  "filmsByDirectorWithLastName" should "do the right thing" in {
    pending
    // filmsByDirectorWithLastName(directors, "Nolan") should equal(nolan.films)
    // filmsByDirectorWithLastName(directors, "Some Guy") should equal(Nil)
    // filmsByDirectorWithLastName(directors, "DROP TABLE *;") should equal(Nil)
  }

  "earliestFilmByDirectorWithLastName" should "do the right thing" in {
    pending
    // earliestFilmByDirectorWithLastName(directors, "Nolan") should equal(Some(memento))
    // earliestFilmByDirectorWithLastName(directors, "Some Guy") should equal(None)
    // earliestFilmByDirectorWithLastName(directors, "DROP TABLE *;") should equal(None)
  }

  "earliestFilmByDirectorWithLastNameOrFailure" should "do the right thing" in {
    pending
    // earliestFilmByDirectorWithLastNameOrFailure(directors, "Nolan") should equal(Right(memento))
    // earliestFilmByDirectorWithLastNameOrFailure(directors, "Some Guy") shouldBe a[Left[_, _]]
    // earliestFilmByDirectorWithLastNameOrFailure(directors, "DROP TABLE *;") shouldBe a[Left[_, _]]
  }

  "namesOfFilmsByDirectorWithLastName" should "do the right thing" in {
    pending
    // namesOfFilmsByDirectorWithLastName(directors, "Nolan") should equal(nolan.films.map(f => f.name))
    // namesOfFilmsByDirectorWithLastName(directors, "Some Guy") should equal(Nil)
    // namesOfFilmsByDirectorWithLastName(directors, "DROP TABLE *;") should equal(Nil)
  }

  "nameOfEarliestFilmByDirectorWithLastName" should "do the right thing" in {
    pending
    // nameOfEarliestFilmByDirectorWithLastName(directors, "Nolan") should equal(Some(memento.name))
    // nameOfEarliestFilmByDirectorWithLastName(directors, "Some Guy") should equal(None)
    // nameOfEarliestFilmByDirectorWithLastName(directors, "DROP TABLE *;") should equal(None)
  }

  "nameOfEarliestFilmByDirectorWithLastNameOrFailure" should "do the right thing" in {
    pending
    // nameOfEarliestFilmByDirectorWithLastNameOrFailure(directors, "Nolan") should equal(Right(memento.name))
    // nameOfEarliestFilmByDirectorWithLastNameOrFailure(directors, "Some Guy") shouldBe a[Left[_, _]]
    // nameOfEarliestFilmByDirectorWithLastNameOrFailure(directors, "DROP TABLE *;") shouldBe a[Left[_, _]]
  }
}
