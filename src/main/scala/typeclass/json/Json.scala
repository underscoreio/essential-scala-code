package typeclass.json

final case class Email(address: String)
final case class Person(name: String, email: Email)

sealed trait JsValue
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
  implicit class JsonOps[A](value: A) {
    def toJson(implicit writer: JsonWriter[A]): JsValue =
      writer.write(value)
  }

  implicit val intWriter: JsonWriter[Int] =
    new JsonWriter[Int] {
      def write(num: Int): JsValue =
        JsNumber(num)
    }

  implicit val stringWriter: JsonWriter[String] =
    new JsonWriter[String] {
      def write(str: String): JsValue =
        JsString(str)
    }

  implicit def listWriter[A](implicit writer: JsonWriter[A]): JsonWriter[List[A]] =
    new JsonWriter[List[A]] {
      def write(list: List[A]): JsValue =
        JsArray(list.map(_.toJson))
    }

  implicit val emailWriter: JsonWriter[Email] =
    new JsonWriter[Email] {
      def write(email: Email): JsValue =
        email.address.toJson
    }

  implicit val personWriter: JsonWriter[Person] =
    new JsonWriter[Person] {
      def write(person: Person): JsValue =
        JsObject(Seq(
          "name"  -> person.name.toJson,
          "email" -> person.email.toJson
        ))
    }
}

object Main extends App {
  import JsonImplicits._

  val email1 = Email("alice@cool.com")
  val email2 = Email("charlie@excellent.com")
  val email3 = Email("bob@awesome.com")

  val person1 = Person("Alice",   Email("alice@cool.com"))
  val person2 = Person("Charlie", Email("charlie@excellent.com"))
  val person3 = Person("Bob",     Email("bob@awesome.com"))

  val emails = List(email1, email2, email3)
  val people = List(person1, person2, person3)

  println(s"""email1.toJson == ${email1.toJson}""")
  println(s"""email2.toJson == ${email2.toJson}""")
  println(s"""email3.toJson == ${email3.toJson}""")

  println(s"""person1.toJson == ${person1.toJson}""")
  println(s"""person2.toJson == ${person2.toJson}""")
  println(s"""person3.toJson == ${person3.toJson}""")

  println(s"""emails.toJson == ${emails.toJson}""")
  println(s"""people.toJson == ${people.toJson}""")
}