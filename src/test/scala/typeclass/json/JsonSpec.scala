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

  it should "write a List[Int]" in {
    List(1, 2, 3).toJson should equal(JsArray(Seq(JsNumber(1), JsNumber(2), JsNumber(3))))
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

  "JsonReader" should "read a String" in {
    JsString("Hello").as[String] should equal(Some("Hello"))
  }

  it should "fail appropriately on a malformed String" in {
    JsNumber(123.0).as[String] should equal(None)
  }

  it should "read an Int" in {
    JsNumber(123.0).as[Int] should equal(Some(123))
  }

  it should "fail appropriately on a malformed Int" in {
    JsString("Hello").as[Int] should equal(None)
  }

  it should "read a List[Int]" in {
    JsArray(Seq(JsNumber(1), JsNumber(2), JsNumber(3))).as[List[Int]] should equal(Some(List(1, 2, 3)))
  }

  it should "read an empty List[Int]" in {
    JsArray(Seq()).as[List[Int]] should equal(Some(Nil))
  }

  it should "fail appropriately on a malformed List[Int]" in {
    JsArray(Seq(JsString("Hello"))).as[List[Int]] should equal(None)
  }

  it should "read an Email" in {
    JsString(alice.email.address).as[Email] should equal(Some(alice.email))
  }

  it should "fail appropriately on a malformed Email" in {
    JsArray(Seq(alice.email.toJson)).as[Email] should equal(None)
  }

  it should "read a Person" in {
    JsObject(Seq(
      "name"  -> JsString(bob.name),
      "email" -> JsString(bob.email.address)
    )).as[Person] should equal(Some(bob))
  }

  it should "fail appropriately on a malformed Person" in {
    JsObject(Seq("name" -> JsString("Charlie"))).as[Person] should equal(None)
    JsObject(Seq("email" -> JsString("charlie@example.com"))).as[Person] should equal(None)
  }

  it should "read a List[Person]" in {
    people.toJson.as[List[Person]] should equal(Some(people))
  }

  it should "fail appropriately on a malformed List[Person]" in {
    JsArray(Seq(alice.toJson, bob.toJson, JsString("Hello"))).as[List[Person]] should equal(None)
  }
}