package adt.json

sealed trait JsValue {
  def stringify: String =
    JsValue.stringify(this)
}

final case class JsNumber(value: Double) extends JsValue
final case class JsString(value: String) extends JsValue
final case class JsBoolean(value: Boolean) extends JsValue
case object JsNull extends JsValue

sealed trait JsArray extends JsValue
final case class JsArrayPair(head: JsValue, tail: JsArray) extends JsArray
case object JsArrayNil extends JsArray

sealed trait JsObject extends JsValue
final case class JsObjectPair(head: JsField, tail: JsObject) extends JsObject
case object JsObjectNil extends JsObject

final case class JsField(name: String, value: JsValue)

object JsValue {
  def stringify(value: JsValue): String =
    value match {
      case arr: JsArray     => "[" + stringifyArrayValues(arr)  + "]"
      case obj: JsObject    => "{" + stringifyObjectFields(obj) + "}"
      case JsNumber(value)  => value.toString
      case JsString(value)  => escapeString(value)
      case JsBoolean(value) => value.toString
      case JsNull           => "null"
    }

  private def stringifyArrayValues(arr: JsArray): String =
    arr match {
      case JsArrayNil                    => ""
      case JsArrayPair(head, JsArrayNil) => stringify(head)
      case JsArrayPair(head, tail)       => stringify(head) + "," + stringifyArrayValues(tail)
    }

  private def stringifyObjectFields(obj: JsObject): String =
    obj match {
      case JsObjectNil                     => ""
      case JsObjectPair(head, JsObjectNil) => stringifyField(head)
      case JsObjectPair(head, tail)        => stringifyField(head) + "," + stringifyObjectFields(tail)
    }

  private def stringifyField(field: JsField): String =
    field match {
      case JsField(name, value) =>
        escapeString(name) + ":" + stringify(value)
    }

  private def escapeString(str: String): String =
    "\"" + str.replaceAll("\"", "\\\\\"") + "\""
}

object Main extends App {
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

  println(json1 + " ==> " + json1.stringify)
  println(json2 + " ==> " + json2.stringify)
  println(json3 + " ==> " + json3.stringify)
  println(json4 + " ==> " + json4.stringify)
}
