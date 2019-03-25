package part4

import org.scalatest._

class Exercise25OrderingSpec extends FlatSpec with Matchers {
  val email1 = Email("z@example.com")
  val email2 = Email("y@example.com")
  val email3 = Email("x@example.com")
  val emails = List(email1, email2, email3)

  val person1 = Person("Alice",   email1)
  val person2 = Person("Charlie", email2)
  val person3 = Person("Bob",     email3)
  val people = List(person1, person2, person3)

  "Email.ordering" should "sort emails" in {
    val actual   = emails.sorted(Email.ordering)
    val expected = List(email3, email2, email1)
    actual should equal(expected)
  }

  it should "be the default sort order for emails" in {
    val actual   = emails.sorted
    val expected = List(email3, email2, email1)
    actual should equal(expected)
  }

  "Person.ordering" should "sort people" in {
    val actual   = people.sorted(Person.ordering)
    val expected = List(person1, person3, person2)
    actual should equal(expected)
  }

  it should "be the default sort order for people" in {
    val actual   = people.sorted
    val expected = List(person1, person3, person2)
    actual should equal(expected)
  }

  "Person.ordringByEmail" should "sort people by email" in {
    val actual   = people.sorted(Person.orderingByEmail)
    val expected = List(person3, person2, person1)
    actual should equal(expected)
  }
}