package part4

import scala.math.Ordering

final case class Email(address: String)

object Email {
  implicit val ordering: Ordering[Email] =
    Ordering.fromLessThan((x, y) => x.address < y.address)
}

final case class Person(name: String, email: Email)

object Person {
  implicit val ordering: Ordering[Person] =
    Ordering.fromLessThan((x, y) => x.name < y.name)

  val orderingByEmail: Ordering[Person] =
    Ordering.by(p => p.email)
}

object Exercise25Ordering {
  val email1 = Email("alice@cool.com")
  val email2 = Email("charlie@excellent.com")
  val email3 = Email("bob@awesome.com")
  val emails = List(email1, email2, email3)

  val person1 = Person("Alice",   Email("alice@cool.com"))
  val person2 = Person("Charlie", Email("charlie@excellent.com"))
  val person3 = Person("Bob",     Email("bob@awesome.com"))
  val people = List(person1, person2, person3)

  def main(args: Array[String]): Unit = {
    println("ordering.compare")
    println(Email.ordering.compare(email1, email2))
    println(Person.ordering.compare(person1, person2))

    println("sorting")
    println(emails.sorted)
    println(people.sorted)

    println("non-standard orders")
    println(emails.sorted(Email.ordering.reverse))
    println(people.sorted(Person.orderingByEmail))
  }
}
