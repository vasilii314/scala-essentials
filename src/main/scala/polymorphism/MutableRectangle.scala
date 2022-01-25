package polymorphism

import scalafx.scene.paint.Color

class MutableRectangle(
                        protected var _width: Double,
                        protected var _height: Double,
                        val color: Color
                      ) extends Shape with HasColor {

  def width: Double = _width

  def height: Double = _height

  def width_= (w: Double): Unit = _width = w

  def height_= (h: Double): Unit = _height = h

  override def area: Double = width * height

  override def perimeter: Double = 2 * (width + height)
}
