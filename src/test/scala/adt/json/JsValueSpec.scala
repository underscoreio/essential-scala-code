package adt.json

import org.scalatest._

class JsValueSpec extends FlatSpec with Matchers {
  val json1: JsValue =
    JsString("hello")

  val json2: JsValue =
    JsArrayPair(
      JsNumber(1),
      JsArrayPair(
        JsNumber(2),
        JsArrayPair(
          JsNumber(3),
          JsArrayNil
        )
      )
    )

  val json3: JsValue =
    JsNull

  val json4: JsValue =
    JsObjectPair(
      JsField("foo", json1),
      JsObjectPair(
        JsField("bar", json2),
        JsObjectPair(
          JsField("baz", json3),
          JsObjectNil
        )
      )
    )

  "stringify" should "handle the examples" in {
    json1.stringify should equal(""" "hello" """.trim)
    json2.stringify should equal(""" [1.0,2.0,3.0] """.trim)
    json3.stringify should equal(""" null """.trim)
    json4.stringify should equal(""" {"foo":"hello","bar":[1.0,2.0,3.0],"baz":null} """.trim)
  }

  it should "escape string literals" in {
    val actual =
      JsString(""" Hello "world"! """.trim).stringify

    val expected =
      """ "Hello \"world\"!" """.trim

    actual should equal(expected)
  }

  it should "escape object field names" in {
    val actual =
      JsObjectPair(
        JsField(
          """ "name" """.trim,
          JsString(""" "value" """.trim)
        ),
        JsObjectNil
      ).stringify

    val expected =
      """ {"\"name\"":"\"value\""} """.trim

    actual should equal(expected)
  }
}
