package part4

import part2._

object Syntax {
  implicit class JsonOps[A](value: A) {
    def toJson(implicit writer: JsonWriter[A]): JsValue =
      writer.write(value)
  }

  implicit class IntListOps(list: List[Int]) {
    def toIntList: IntList = {
      list match {
        case Nil          => IntNil()
        case head :: tail => IntPair(head, tail.toIntList)
      }
    }
  }

  implicit class TimesOps(num: Int) {
    def times(func: Int => Unit): Unit =
      (1 to num).foreach(func)
  }
}

object Exercise27ExtensionMethods {
  import Syntax._

  def main(args: Array[String]): Unit = {
    println("toJson")
    println(Person("Dave", Email("dave@example.com")).toJson)

    println("toIntList")
    println(List(1, 2, 3).toIntList)
    println(List.empty[Int].toIntList)

    println("times")
    5.times(i => println(i * 10))
    3.times(i => println(i + "!"))
  }
}
