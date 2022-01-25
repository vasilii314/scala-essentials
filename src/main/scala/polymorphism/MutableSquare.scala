package polymorphism

import scalafx.scene.paint.Color

class MutableSquare(private var _length: Double, c: Color) extends MutableRectangle(_length, _length, c) {
  override def width_=(w: Double): Unit = {
    this.width = w
    this.height = w
  }
}
