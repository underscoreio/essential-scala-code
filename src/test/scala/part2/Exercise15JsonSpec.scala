package part2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Exercise15JsonSpec extends AnyFlatSpec with Matchers {
  // val json1: JsValue =
  //   JsString("hello")

  // You may have to change this definition
  // depending on how you structured JsArray:
  // val json2: JsValue =
  //   JsArray(List(
  //     JsNumber(1),
  //     JsNumber(2),
  //     JsNumber(3),
  //   ))

  // val json3: JsValue =
  //   JsNull

  // You may have to change this definition
  // depending on how you structured JsObject:
  // val json4: JsValue =
  //   JsObject(List(
  //     ("foo", json1),
  //     ("bar", json2),
  //     ("baz", json3),
  //   ))

  "stringify" should "handle the examples" in {
    pending
    // JsValue.stringify(json1) should equal(""""hello"""")
    // JsValue.stringify(json2) should equal("""[1.0,2.0,3.0]""")
    // JsValue.stringify(json3) should equal("""null""")
    // JsValue.stringify(json4) should equal("""{"foo":"hello","bar":[1.0,2.0,3.0],"baz":null}""")
  }

  // Harder: only do this if you have time:
  it should "escape string literals" in {
    pending
    // val actual: String =
    //   JsValue.stringify(JsString("""Hello "world"!"""))
    //
    // val expected: String =
    //   """"Hello \"world\"!""""
    //
    // actual should equal(expected)
  }

  // Harder: only do this if you have time:
  it should "escape object field names" in {
    pending
    // val actual: String =
    //   JsValue.stringify(JsObject(List(
    //     (""""name"""", JsString(""""value""""))
    //   )))
    //
    // val expected: String =
    //   """{"\"name\"":"\"value\""}"""
    //
    // actual should equal(expected)
  }
}
