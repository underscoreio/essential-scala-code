package part4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import part2._

class Exercise26JsonWriterSpec extends AnyFlatSpec with Matchers {
  val alice = Person("Alice", Email("alice@example.com"))
  val bob = Person("Bob", Email("bob@example.com"))
  val people = List(alice, bob)

  "JsonWriter.write" should "write a String" in {
    JsonWriter.write("Hello") should equal(JsString("Hello"))
  }

  it should "write an Int" in {
    JsonWriter.write(123) should equal(JsNumber(123.0))
  }

  it should "write an Email" in {
    JsonWriter.write(alice.email) should equal(JsString(alice.email.address))
  }

  it should "write a Person" in {
    JsonWriter.write(bob) should equal(
      JsObject(
        List(
          "name" -> JsString(bob.name),
          "email" -> JsString(bob.email.address)
        )
      )
    )
  }

  it should "write a List[Person]" in {
    JsonWriter.write(people) should equal(
      JsArray(
        List(
          JsonWriter.write(alice),
          JsonWriter.write(bob)
        )
      )
    )
  }
}
