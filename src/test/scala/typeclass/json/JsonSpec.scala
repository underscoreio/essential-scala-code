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

  it should "write a List[Int]" in {
    pending
    // List(1, 2, jsonify(3)) should equal(JsArray(Seq(JsNumber(1), JsNumber(2), JsNumber(3))))
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

  "JsonReader" should "read a String" in {
    pending
    // JsString("Hello").as[String] should equal(Some("Hello"))
  }

  it should "fail appropriately on a malformed String" in {
    pending
    // JsNumber(123.0).as[String] should equal(None)
  }

  it should "read an Int" in {
    pending
    // JsNumber(123.0).as[Int] should equal(Some(123))
  }

  it should "fail appropriately on a malformed Int" in {
    pending
    // JsString("Hello").as[Int] should equal(None)
  }

  it should "read a List[Int]" in {
    pending
    // JsArray(Seq(JsNumber(1), JsNumber(2), JsNumber(3))).as[List[Int]] should equal(Some(List(1, 2, 3)))
  }

  it should "read an empty List[Int]" in {
    pending
    // JsArray(Seq()).as[List[Int]] should equal(Some(Nil))
  }

  it should "fail appropriately on a malformed List[Int]" in {
    pending
    // JsArray(Seq(JsString("Hello"))).as[List[Int]] should equal(None)
  }

  it should "read an Email" in {
    pending
    // JsString(alice.email.address).as[Email] should equal(Some(alice.email))
  }

  it should "fail appropriately on a malformed Email" in {
    pending
    // JsArray(Seq(jsonify(alice.email))).as[Email] should equal(None)
  }

  it should "read a Person" in {
    pending
    // JsObject(Seq(
    //   "name"  -> JsString(bob.name),
    //   "email" -> JsString(bob.email.address)
    // )).as[Person] should equal(Some(bob))
  }

  it should "fail appropriately on a malformed Person" in {
    pending
    // JsObject(Seq("name" -> JsString("Charlie"))).as[Person] should equal(None)
    // JsObject(Seq("email" -> JsString("charlie@example.com"))).as[Person] should equal(None)
  }

  it should "read a List[Person]" in {
    pending
    // jsonify(people).as[List[Person]] should equal(Some(people))
  }

  it should "fail appropriately on a malformed List[Person]" in {
    pending
    // JsArray(Seq(jsonify(alice), jsonify(bob), JsString("Hello"))).as[List[Person]] should equal(None)
  }
}