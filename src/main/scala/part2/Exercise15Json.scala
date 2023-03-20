package part2

enum JsValue:
  case JsNull
  case JsBoolean(value: Boolean)
  case JsNumber(value: Double)
  case JsString(value: String)
  case JsArray(items: List[JsValue])
  case JsObject(fields: List[(String, JsValue)])

object JsValue:
  import JsValue._

  def stringify(json: JsValue): String =
    json match
      case JsNull => "null"
      case JsBoolean(value) => value.toString
      case JsNumber(value) => value.toString
      case JsString(value) => escape(value)
      case JsArray(items) => items.map(stringify).mkString("[", ",", "]")
      case JsObject(fields) =>
        fields
          .map {
            case (key, value) =>
              s"${escape(key)}:${stringify(value)}"
          }
          .mkString("{", ",", "}")


  private def escape(str: String): String =
    "\"" + str.replaceAll("\"", "\\\\\"") + "\""

object Exercise15Json:
  import JsValue._

  val json1: JsValue =
    JsString("hello")

  val json2: JsValue =
    JsArray(List(
      JsNumber(1),
      JsNumber(2),
      JsNumber(3),
    ))

  val json3: JsValue =
    JsNull

  val json4: JsValue =
    JsObject(List(
      ("foo", json1),
      ("bar", json2),
      ("baz", json3),
    ))

  def main(): Unit =
    println("json1")
    println(JsValue.stringify(json1))

    println("json2")
    println(JsValue.stringify(json2))

    println("json3")
    println(JsValue.stringify(json3))

    println("json4")
    println(JsValue.stringify(json4))
