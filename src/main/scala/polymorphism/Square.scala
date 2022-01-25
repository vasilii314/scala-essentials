package polymorphism

import scalafx.scene.paint.Color

class Square(private val length: Double, c: Color) extends Rectangle(length, length, c)
