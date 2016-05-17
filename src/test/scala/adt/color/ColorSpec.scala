package adt.color

import org.scalatest._

class ColorSpec extends FlatSpec with Matchers {
  "lightness" should "return the average of r, g, and b" in {
    pending
    // val color = Color(.1, .2, .3)
    // color.lightness should equal((color.r + color.g + color.b) / 3)
  }

  "lighterThan" should "identify that white is lighter than black" in {
    pending
    // val color1 = Color(1, 1, 1)
    // val color2 = Color(0, 0, 0)
    // (color1 lighterThan color2) should equal(true)
    // (color2 lighterThan color1) should equal(false)
  }

  it should "return false when both colors are the same" in {
    pending
    // val color = Color(.5, .5, .5)
    // (color lighterThan color) should equal(false)
  }

  "mostlyRed" should "classify primary colors correctly" in {
    pending
    // import Main.mostlyRed
    // mostlyRed(Color(1, 0, 0)) should equal(true)
    // mostlyRed(Color(0, 1, 0)) should equal(false)
    // mostlyRed(Color(0, 0, 1)) should equal(false)
  }
}
