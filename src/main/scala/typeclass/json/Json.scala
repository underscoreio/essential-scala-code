package typeclass.json

import scala.util.Try

// Library code ---------------------------------

sealed trait JsValue {
  def stringify: String =
    this match {
      case JsArray(values)  => values.map(_.stringify).mkString("[", ",", "]")
      case JsObject(fields) => fields.map(stringifyField).mkString("{", ",", "}")
      case JsNumber(value)  => value.toString
      case JsString(value)  => escapeString(value)
      case JsBoolean(value) => value.toString
      case JsNull           => "null"
    }

  private def stringifyField(field: (String, JsValue)): String =
    field match {
      case (name, value) =>
        escapeString(name) + ":" + value.stringify
    }

  private def escapeString(str: String): String =
    "\"" + str.replaceAll("\"", "\\\\\"") + "\""
}

case object JsNull extends JsValue
final case class JsString(value: String) extends JsValue
final case class JsNumber(value: Double) extends JsValue
final case class JsBoolean(value: Boolean) extends JsValue
final case class JsArray(values: Seq[JsValue]) extends JsValue
final case class JsObject(values: Seq[(String, JsValue)]) extends JsValue

trait JsonWriter[A] {
  def write(value: A): JsValue
}

object JsonImplicits {
  def jsonify[A](value: A)(implicit writer: JsonWriter[A]): JsValue =
    writer.write(value)

  implicit val intWriter: JsonWriter[Int] =
    new JsonWriter[Int] {
      def write(value: Int): JsValue =
        JsNumber(value)
    }

  implicit val stringWriter: JsonWriter[String] =
    new JsonWriter[String] {
      def write(value: String): JsValue =
        JsString(value)
    }

  implicit def listWriter[A](implicit writer: JsonWriter[A]): JsonWriter[List[A]] =
    ???
}

// Application code -----------------------------

final case class Email(address: String)

object Email {
  import JsonImplicits._

  implicit val writer: JsonWriter[Email] =
    ???
}

final case class Person(name: String, email: Email)

object Person {
  import JsonImplicits._

  implicit val writer: JsonWriter[Person] =
    ???
}

object Main extends App {
  import JsonImplicits._

  val alice  = Person("Alice", Email("alice@example.com"))
  val bob    = Person("Bob", Email("bob@example.com"))
  val people = List(alice, bob)

  println(s"""jsonify(people).stringify == ${jsonify(people).stringify}""")
}
