package part2

// ----------------------------------------------

// Write a definition for IntList here!

// Implement the following methods on IntList:
// - def contains(num: Int): Boolean
//   Does the list contain `num`?
//
// - def addToEach(num: Int): IntList
//   Add `num` to every item in the list, returning a new list
//
// - def total: Int
//   Add up the items in the list and return the total
//
// - def append(that: IntList): IntList
//   Append two lists
//
// - def evensOnly: IntList
//   Return a new list comprising only the even numbers from this list

// ----------------------------------------------

object Exercise11IntList {
  // val numbers = IntPair(1, IntPair(2, IntPair(3, IntNil())))

  def main(args: Array[String]): Unit = {
    println("contains")
    // println(numbers.contains(1))
    // println(numbers.contains(5))

    println("addToEach")
    // println(numbers.addToEach(1))
    // println(numbers.addToEach(5))

    println("total")
    // println(numbers.total)

    println("append")
    // println(numbers.append(numbers))

    println("evensOnly")
    // println(numbers.evensOnly)
  }
}