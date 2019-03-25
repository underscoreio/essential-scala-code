package part2

import drawing.Canvas

object Exercise10Draw {
  // def draw(canvas: Canvas, x: Double, y: Double, shape: Shape): Unit = {
  //   ???
  // }

  def main(args: Array[String]): Unit = {
    Canvas.show(500, 500, canvas => {
      // draw(canvas, 100, 100, Circle(40, Color(1, 1, 0)))
      // draw(canvas, 200, 200, Rect(80, 60, Color(1, 0 ,0)))
    })
  }
}
