package typeclass.json

import org.scalatest._

class JsonSpec extends FlatSpec with Matchers {
  import JsonImplicits._

  val alice  = Person("Alice", Email("alice@example.com"))
  val bob    = Person("Bob", Email("bob@example.com"))
  val people = List(alice, bob)

  "JsonWriter" should "write a String" in {
    "Hello".toJson should equal(JsString("Hello"))
  }

  it should "write an Int" in {
    123.toJson should equal(JsNumber(123.0))
  }

  it should "write an Email" in {
    alice.email.toJson should equal(JsString(alice.email.address))
  }

  it should "write a Person" in {
    bob.toJson should equal(JsObject(Seq(
      "name"  -> JsString(bob.name),
      "email" -> JsString(bob.email.address)
    )))
  }

  it should "write a List[Person]" in {
    people.toJson should equal(JsArray(Seq(alice.toJson, bob.toJson)))
  }
}