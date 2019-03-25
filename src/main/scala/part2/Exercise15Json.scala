package part2

// ----------------------------------------------

// Step 1. Implement an ADT `JsValue` to represent unstructured JSON data

sealed abstract class JsValue

// Include subtypes for each of the main types of JSON

// ----------------------------------------------

// Step 2. Implement a `stringify` method on the companion object for `JsValue`

object JsValue {
  def stringify(json: JsValue): String = {
    ???
  }
}

// ----------------------------------------------

object Exercise15Json {
  // val json1: JsValue =
  //   JsString("hello")

  // val json2: JsValue =
  //   JsArray(List(
  //     JsNumber(1),
  //     JsNumber(2),
  //     JsNumber(3),
  //   ))

  // val json3: JsValue =
  //   JsNull

  // val json4: JsValue =
  //   JsObject(List(
  //     ("foo", json1),
  //     ("bar", json2),
  //     ("baz", json3),
  //   ))

  def main(args: Array[String]): Unit = {
    println("stringify")
    // println(JsValue.stringify(json1))
    // println(JsValue.stringify(json2))
    // println(JsValue.stringify(json3))
    // println(JsValue.stringify(json4))
  }
}
