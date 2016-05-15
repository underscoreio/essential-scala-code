package adt.shape

final case class Color(r: Double, g: Double, b: Double) {
  def lightness: Double =
    (r + g + b) / 3.0

  def lighterThan(c: Color): Boolean =
    lightness > c.lightness
}

sealed trait Shape {
  def color: Color
}

object Shape {
  def area(s: Shape): Double =
    s match {
      case Circle(r, _)  => r * r * math.Pi
      case Rect(w, h, _) => w * h
    }
}

final case class Circle(r: Double, color: Color)
  extends Shape

final case class Rect(w: Double, h: Double, color: Color)
  extends Shape

object Main extends App {
  val shape1 = Circle(10, Color(1, 0, 0))
  val shape2 = Rect(3, 5, Color(0, 1, 0))

  println(shape1 + " " + Shape.area(shape1))
  println(shape2 + " " + Shape.area(shape2))
}
