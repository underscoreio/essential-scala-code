package part4

import org.scalatest._
import part2.{IntPair, IntNil, JsString}

class Exercise27ExtensionMethodsSpec extends FlatSpec with Matchers {
  import Syntax._

  "toJson" should "write json" in {
    "Hello".toJson should equal(JsString("Hello"))
  }

  "toIntList" should "create an IntList" in {
    List(1, 2, 3).toIntList should equal(IntPair(1, IntPair(2, IntPair(3, IntNil()))))
  }
}