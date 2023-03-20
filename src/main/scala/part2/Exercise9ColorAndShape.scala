package part2

case class Color(r: Double, g: Double, b: Double)

object Color {
  val black = Color(0, 0, 0)
  val yellow = Color(1, 1, 0)
  val magenta = Color(1, 0, 1)
}

sealed abstract class Shape {
  def color: Color
  def area: Double
  def perimeter: Double
}

final case class Circle(radius: Double, color: Color) extends Shape {
  override def area: Double = {
    math.Pi * radius * radius
  }

  override def perimeter: Double = {
    2 * math.Pi * radius
  }

}

final case class Rect(width: Double, height: Double, color: Color) extends Shape {
  override def area: Double = {
    width * height
  }

  override def perimeter: Double = {
    width * 2 + height * 2
  }
}

object Exercise9ColorAndShape {
  def main(): Unit = {
    println("color")
    println(Color.yellow)
    println(Color.magenta)

    println("circle")
    val circle = Circle(30, Color.yellow)
    println(circle)
    println(circle.area)
    println(circle.perimeter)

    println("rect")
    val rect = Rect(50, 30, Color.magenta)
    println(rect)
    println(rect.area)
    println(rect.perimeter)
  }
}
