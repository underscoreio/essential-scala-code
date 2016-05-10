package intro

import org.scalatest._

class HelloWorldSpec extends FlatSpec with Matchers {
  "greeting message" should "be nice and friendly" in {
    HelloWorld.message should equal("Hello world!")
  }
}