package typeclass.json

import scala.util.Try

// Library code ---------------------------------

sealed trait JsValue {
  def \ (name: String): Option[JsValue] = this match {
    case JsObject(fields) =>
      fields
        .find { case (n, v) => n == name }
        .map  { case (n, v) => v }

    case _ => None
  }

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

object JsonWriter {
  import JsonImplicits._

  def apply[A](func: A => JsValue): JsonWriter[A] =
    new JsonWriter[A] {
      def write(value: A): JsValue =
        func(value)
    }
}

trait JsonReader[A] {
  def read(value: JsValue): Option[A]
}

object JsonReader {
  import JsonImplicits._

  def apply[A](func: JsValue => Option[A]): JsonReader[A] =
    new JsonReader[A] {
      def read(value: JsValue): Option[A] =
        func(value)
    }
}

object JsonImplicits {
  implicit class JsonOps[A](value: A) {
    def toJson(implicit writer: JsonWriter[A]): JsValue =
      writer.write(value)
  }

  implicit class JsValueOps(value: JsValue) {
    def as[A](implicit reader: JsonReader[A]): Option[A] =
      reader.read(value)

    def fieldAs[A](name: String)(implicit reader: JsonReader[A]): Option[A] =
      (value \ name).flatMap(_.as[A])
  }

  implicit val intReader: JsonReader[Int] =
    JsonReader[Int] {
      case JsNumber(value) => Try(value.toInt).toOption
      case _               => None
    }

  implicit val intWriter: JsonWriter[Int] =
    JsonWriter[Int](num => JsNumber(num))

  implicit val stringReader: JsonReader[String] =
    JsonReader[String] {
      case JsString(value) => Some(value)
      case _               => None
    }

  implicit val stringWriter: JsonWriter[String] =
    JsonWriter[String](str => JsString(str))

  implicit def listReader[A](implicit reader: JsonReader[A]): JsonReader[List[A]] =
    JsonReader[List[A]] {
      case JsArray(values) =>
        val results = values.map(_.as[A])
        if(results.exists(_.isEmpty)) None else Some(results.flatten.toList)

      case _ => None
    }

  implicit def listWriter[A](implicit writer: JsonWriter[A]): JsonWriter[List[A]] =
    JsonWriter[List[A]](list => JsArray(list.map(_.toJson)))
}

// Application code -----------------------------

final case class Email(address: String)

object Email {
  import JsonImplicits._

  implicit val reader: JsonReader[Email] =
    JsonReader[Email](_.as[String].map(Email.apply))

  implicit val writer: JsonWriter[Email] =
    JsonWriter[Email](_.address.toJson)
}

final case class Person(name: String, email: Email)

object Person {
  import JsonImplicits._

  implicit val reader: JsonReader[Person] =
    JsonReader[Person] { json =>
      for {
        name  <- json.fieldAs[String]("name")
        email <- json.fieldAs[Email]("email")
      } yield Person(name, email)
    }

  implicit val writer: JsonWriter[Person] =
    JsonWriter[Person] { person =>
      JsObject(Seq(
        "name"  -> person.name.toJson,
        "email" -> person.email.toJson
      ))
    }
}

object Main extends App {
  import JsonImplicits._

  val alice  = Person("Alice", Email("alice@example.com"))
  val bob    = Person("Bob", Email("bob@example.com"))
  val people = List(alice, bob)

  println(s"""people.toJson.stringify == ${people.toJson.stringify}""")
  println(s"""people.toJson.as[List[Person]] == ${people.toJson.as[List[Person]]}""")
}