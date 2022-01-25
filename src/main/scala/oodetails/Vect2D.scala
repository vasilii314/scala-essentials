package oodetails

class Vect2D(
            val x: Double,
            val y: Double
            ) {

  def +(v: Vect2D): Vect2D = new Vect2D(x + v.x, y + v.y)

  def -(v:Vect2D): Vect2D = new Vect2D(x - v.x, y - v.y)

  def scale(c: Double): Vect2D = new Vect2D(c * x, x * y)

  def magnitude: Double = math.sqrt(x * x + y * y)
}

object Vect2D {
  def main(args: Array[String]): Unit = {
    val v1 = new Vect2D(1, 2)
    val v2 = new Vect2D(2, 2)
    val v3 = v1 + v2
    println(v3.magnitude)
  }
}