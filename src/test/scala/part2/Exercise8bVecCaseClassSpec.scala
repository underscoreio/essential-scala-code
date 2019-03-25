package part2

import org.scalatest._

class Exercise8bVecCaseClassSpec extends FlatSpec with Matchers {
  val vec1 = VecB(3, 4)
  val vec2 = VecB(5, 12)

  "accessors" should "return fields from the Vec" in {
    vec1.x should equal(3)
    vec1.y should equal(4)
    vec2.x should equal(5)
    vec2.y should equal(12)
  }

  "copy constructor" should "create new Vecs" in {
    vec1.copy(x = 100) should equal(VecB(100, 4))
    vec2.copy(y = 100) should equal(VecB(5, 100))
  }

  "equals method" should "compare on contents, not on reference equality" in {
    (vec1 == vec1.copy()) should equal(true)
    (vec2 eq vec1.copy()) should equal(false)
  }

  "companion object apply method" should "create a Vec" in {
    val vec3 = VecB(1, 2)
    vec3.x should equal(1)
    vec3.y should equal(2)
  }

  "companion object unapply method" should "allow destructuring with pattern matching" in {
    vec1 match {
      case VecB(x0, y0) =>
        x0 should equal(3)
        y0 should equal(4)
    }
  }
}
