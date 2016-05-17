package adt.json

import org.scalatest._

class JsonSpec extends FlatSpec with Matchers {
  def json1 = ??? // "hello"
  def json2 = ??? // [1,2,3]
  def json3 = ??? // null
  def json4 = ??? // {"foo":json1, "bar":json2, "baz":json3}

  "stringify" should "handle the examples" in {
    pending
    // json1.stringify should equal(""" "hello" """.trim)
    // json2.stringify should equal(""" [1.0,2.0,3.0] """.trim)
    // json3.stringify should equal(""" null """.trim)
    // json4.stringify should equal(""" {"foo":"hello","bar":[1.0,2.0,3.0],"baz":null} """.trim)
  }

  it should "escape string literals" in {
    pending
    // val actual =
    //   JsString(""" Hello "world"! """.trim).stringify

    // val expected =
    //   """ "Hello \"world\"!" """.trim

    // actual should equal(expected)
  }

  it should "escape object field names" in {
    pending
    // val actual =
    //   JsObjectPair(
    //     JsField(
    //       """ "name" """.trim,
    //       JsString(""" "value" """.trim)
    //     ),
    //     JsObjectNil
    //   ).stringify

    // val expected =
    //   """ {"\"name\"":"\"value\""} """.trim

    // actual should equal(expected)
  }
}
