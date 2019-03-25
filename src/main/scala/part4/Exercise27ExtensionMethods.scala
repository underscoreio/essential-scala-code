package part4

import part2._

object Syntax {
  // Implement an extension method on List[Int]:
  // - `toIntList` converts the data to an IntList

  // Implement an extension method on Int:
  // - `times(func)` runs `func` N times, passing in each integer from 0 upwards
  //   (see below for an example)

  // Implement an extension method on any data type A:
  // - `toJson` converts the data to a JsValue
}

object Exercise27ExtensionMethods {
  import Syntax._

  def main(args: Array[String]): Unit = {
    println("toIntList")
    // println(List(1, 2, 3).toIntList)
    // println(List.empty[Int].toIntList)

    println("times")
    // 5.times(i => println(i * 10))
    // 3.times(i => println(i + "!"))

    println("toJson")
    // println(Person("Dave", Email("dave@example.com")).toJson)
    // println(List(
    //   Person("Alice", Email("alice@example.com")),
    //   Person("Bob", Email("bob@example.com")),
    // ).toJson)
  }
}
