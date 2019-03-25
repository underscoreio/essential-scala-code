package part4

import part2._

// ----------------------------------------------

// Step 1. Implement a type class JsonWriter[A]

// Give it a method write() that:
// - accepts a parameter of type A
// - returns a JsValue

// ----------------------------------------------

// Step 2. In a companion object for JsonWriter implement:

// - an instance for Email
// - an instance for Person

// ----------------------------------------------

// Step 3. In a companion object for JsonWriter implement:

// - an instance for Lists (of any type of data)

// ----------------------------------------------

object Exercise26JsonWriter {
  // def write[A](value: A)(implicit writer: JsonWriter[A]): JsValue =
  //   writer.write(value)

  def main(args: Array[String]): Unit = {
    println("email")
    // write(Email("dave@example.com"))

    println("person")
    // write(Person("Alice", Email("alice@example.com")))
    // write(Person("Bob", Email("bob@example.com")))

    println("list of people")
    // write(List(
    //   Person("Alice", Email("alice@example.com")),
    //   Person("Bob", Email("bob@example.com")),
    // ))
  }
}
