package part2

// ----------------------------------------------

// Step 1. Implement MyList[A] below

sealed abstract class MyList[A]

// Step 2. Implement the following methods
// using methods from IntList as templates:

// - exists(func)
//   Does the list contain a particular value?
//   Use `contains` as a template

// - map(func)
//   Applies `func` to each item, returning a list of the results
//   Use `addToEach` as a template

// Harder methods:

// - filter(predicate)
//   Applies `predicate` to each item to get a boolean result
//   Return a new list, but only include items for which `predicate` returns true
//   Use `evensOnly` as a template

// - reduce(accum, func)
//   Start with `accum`. Use `func` to combine it with the head of the list.
//   Then use the result as the `accum` to reduce the tail of the list.
//   Use `total` as a template

// - append(list)
//   Append two lists

// ----------------------------------------------

object Exercise14GenericList {
  // val numbers: MyList[Int] =
  //   MyPair(1, MyPair(3, MyPair(5, MyNil())))

  // val strings: MyList[String] =
  //   MyPair("foo", MyPair("bar", MyPair("baz", MyNil())))

  // val shapes: MyList[Shape] =
  //   MyPair(
  //     Circle(20, Color(1, 1, 0)),
  //     MyPair(
  //       Circle(10, Color(1, 1, 0)),
  //       MyPair(
  //         Rect(30, 20, Color(1, 0, 1)),
  //         MyNil())))

  println("exists")
  // println(numbers.exists(n => n > 1))
  // println(strings.exists(s => s.startsWith("b")))
  // println(shapes.exists(s => s.area > 100))

  println("map")
  // println(numbers.map(n => n + 1))
  // println(strings.map(s => s + "!"))
  // println(shapes.map(s => s.toString))

  println("reduce")
  // println(numbers.reduce(0, (a, b) => a + b))
  // println(strings.reduce("", (a, b) => a + b))

  println("append")
  // println(numbers.append(numbers))
  // println(strings.append(strings))
  // println(shapes.append(shapes))

  println("filter")
  // println(numbers.filter(n => n > 1))
  // println(strings.filter(s => s.startsWith("b")))
  // println(shapes.filter(s => s.area > 50))
}
