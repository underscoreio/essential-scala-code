package drawing

import java.awt.geom.{Ellipse2D, Rectangle2D}
import java.awt.{Color, Graphics, Graphics2D}
import javax.swing.{JFrame, JPanel}

abstract class Canvas {
  def setColor(r: Double, g: Double, b: Double): Unit
  def fillCircle(x: Double, y: Double, r: Double): Unit
  def fillRect(x: Double, y: Double, w: Double, h: Double): Unit
}

object Canvas {
  def show(width: Int, height: Int, draw: Canvas => Unit): Unit = {
    val frame = new JFrame("Drawing")
    val panel = new CanvasPanel(draw)
    frame.setContentPane(panel)
    frame.setSize(width, height)
    frame.setVisible(true)
  }

  private class Graphics2DCanvas(graphics: Graphics2D) extends Canvas {
    override def setColor(r: Double, g: Double, b: Double): Unit = {
      graphics.setPaint(new Color((r * 255).toInt, (g * 255).toInt, (b * 255).toInt))
    }

    override def fillCircle(x: Double, y: Double, r: Double): Unit = {
      graphics.fill(new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r))
    }

    override def fillRect(x: Double, y: Double, w: Double, h: Double): Unit = {
      graphics.fill(new Rectangle2D.Double(x - w/2, y - h/2, w, h))
    }
  }

  private class CanvasPanel(draw: Canvas => Unit) extends JPanel {
    override def paintComponent(g: Graphics): Unit = {
      val canvas = new Graphics2DCanvas(g.asInstanceOf[Graphics2D])
      val size = getSize()
      g.setColor(Color.black)
      g.fillRect(0, 0, size.getWidth.toInt, size.getHeight.toInt)
      g.setColor(Color.white)
      draw(canvas)
    }
  }
}
