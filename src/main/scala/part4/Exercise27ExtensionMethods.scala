package part4

import part2._

object Syntax:
  extension [A](value: A) def toJson(implicit writer: JsonWriter[A]): JsValue =
    writer.write(value)

  extension (list: List[Int]) def toIntList: IntList =
    list match
      case Nil          => IntList.Nil
      case head :: tail => IntList.Pair(head, tail.toIntList)

  extension (num: Int) def times(func: Int => Unit): Unit =
    1.to(num).foreach(func)

object Exercise27ExtensionMethods:
  import Syntax._

  def main(): Unit =
    println("toJson")
    println(Person("Dave", Email("dave@example.com")).toJson)

    println("toIntList")
    println(List(1, 2, 3).toIntList)
    println(List.empty[Int].toIntList)

    println("times")
    5.times(i => println(i * 10))
    3.times(i => println(i + "!"))
