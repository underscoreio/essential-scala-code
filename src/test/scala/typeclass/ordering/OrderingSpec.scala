package typeclass.ordering

import org.scalatest._

class OrderingSpec extends FlatSpec with Matchers {
  import OrderingImplicits._

  val email1 = Email("z@example.com")
  val email2 = Email("y@example.com")
  val email3 = Email("x@example.com")
  val emails = List(email1, email2, email3)

  val person1 = Person("Alice",   email1)
  val person2 = Person("Charlie", email2)
  val person3 = Person("Bob",     email3)
  val people = List(person1, person2, person3)

  "emailOrdering" should "sort emails" in {
    val actual   = emails.sorted(emailOrdering)
    val expected = List(email3, email2, email1)
    actual should equal(expected)
  }

  it should "be the default sort order for emails" in {
    val actual   = emails.sorted
    val expected = List(email3, email2, email1)
    actual should equal(expected)
  }

  "personOrdering" should "sort people" in {
    val actual   = people.sorted(personOrdering)
    val expected = List(person1, person3, person2)
    actual should equal(expected)
  }

  it should "be the default sort order for people" in {
    val actual   = people.sorted
    val expected = List(person1, person3, person2)
    actual should equal(expected)
  }

  "personOrderingByEmail" should "sort people by email" in {
    val actual   = people.sorted(personOrderingByEmail)
    val expected = List(person3, person2, person1)
    actual should equal(expected)
  }

}