package typeclass.json

import org.scalatest._

class JsonSpec extends FlatSpec with Matchers {
  import JsonImplicits._

  val alice  = Person("Alice", Email("alice@example.com"))
  val bob    = Person("Bob", Email("bob@example.com"))
  val people = List(alice, bob)

  "JsonWriter" should "write a String" in {
    pending
    // jsonify("Hello") should equal(JsString("Hello"))
  }

  it should "write an Int" in {
    pending
    // jsonify(123) should equal(JsNumber(123.0))
  }

  it should "write an Email" in {
    pending
    // jsonify(alice.email) should equal(JsString(alice.email.address))
  }

  it should "write a Person" in {
    pending
    // jsonify(bob) should equal(JsObject(Seq(
    //   "name"  -> JsString(bob.name),
    //   "email" -> JsString(bob.email.address)
    // )))
  }

  it should "write a List[Person]" in {
    pending
    // jsonify(people) should equal(JsArray(Seq(jsonify(alice), jsonify(bob))))
  }
}