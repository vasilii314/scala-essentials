package polymorphism

import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

trait HasColor {

  val color: Color

  def draw(gc: GraphicsContext): Unit = {
    gc.fill = color
  }

}
