package part2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Exercise9ColorAndShapeSpec extends AnyFlatSpec with Matchers {
  // val shape1: Shape = Circle(10, Color(1, 1, 0))
  // val shape2: Shape = Rect(3, 5, Color(1, 0, 1))

  "area" should "calculate the area of a shape" in {
    pending
    // shape1.area should equal(math.Pi * 10 * 10)
    // shape2.area should equal(3 * 5)
  }

  "perimeter" should "calculate the perimeter of a shape" in {
    pending
    // shape1.perimeter should equal(2 * math.Pi * 10)
    // shape2.perimeter should equal(3 * 2 + 5 * 2)
  }

  "every shape" should "have a color" in {
    pending
    // shape1.color should equal(Color(1, 1, 0))
    // shape2.color should equal(Color(1, 0, 1))
  }
}
