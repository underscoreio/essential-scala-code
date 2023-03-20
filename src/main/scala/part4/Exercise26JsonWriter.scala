package part4

import part2.JsValue

trait JsonWriter[A]:
  def write(value: A): JsValue

object JsonWriter:
  import JsValue._

  def write[A](value: A)(implicit writer: JsonWriter[A]): JsValue =
    writer.write(value)

  implicit val intWriter: JsonWriter[Int] =
    new JsonWriter[Int]:
      def write(num: Int): JsValue =
        JsNumber(num)

  implicit val stringWriter: JsonWriter[String] =
    new JsonWriter[String]:
      def write(str: String): JsValue =
        JsString(str)

  implicit def listWriter[A](implicit writer: JsonWriter[A]): JsonWriter[List[A]] =
    new JsonWriter[List[A]]:
      def write(list: List[A]): JsValue =
        JsArray(list.map(writer.write))

  implicit def emailWriter: JsonWriter[Email] =
    new JsonWriter[Email]:
      override def write(email: Email): JsValue =
        JsString(email.address)

  implicit def personWriter: JsonWriter[Person] =
    new JsonWriter[Person]:
      override def write(person: Person): JsValue =
        JsObject(List(
          ("name", JsString(person.name)),
          ("email", JsString(person.email.address)),
        ))

object Exercise26JsonWriter:
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
