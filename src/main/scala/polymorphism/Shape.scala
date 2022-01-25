package polymorphism

import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

abstract class Shape {
  def area: Double

  def perimeter: Double

}

object Shape {
  def main(args: Array[String]): Unit = {
    val rect = new Rectangle(3, 4, Color.Black)
    val circle = new Circle(3, Color.Black)
    val square = new Square(5, Color.Black)
    val square2 = new MutableSquare(5, Color.Black)
    square2.width = 99
    printShapeData(rect)
    printShapeData(circle)
    printShapeData(square)
  }

  def printShapeData(s: Shape): Unit = {
    println(s"Area = ${s.area}")
    println(s"Perimeter = ${s.perimeter}")
  }
}
