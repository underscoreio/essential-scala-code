package part4

import org.scalatest._
import part2._

class Exercise27ExtensionMethodsSpec extends FlatSpec with Matchers {
  // import Syntax._

  "toIntList" should "create an IntList" in {
    pending
    // List(1, 2, 3).toIntList should equal(IntPair(1, IntPair(2, IntPair(3, IntNil()))))
  }

  "toJson" should "write json" in {
    pending
    // "Hello".toJson should equal(JsString("Hello"))
  }
}
