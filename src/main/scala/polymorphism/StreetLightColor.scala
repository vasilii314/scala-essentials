package polymorphism

object StreetLightColor extends Enumeration {
  val Red, Green, Yellow = Value
}

class StreetLight(private var _color: StreetLightColor.Value) {
  def color: StreetLightColor.Value = _color

  def cycle: Unit = _color match {
    case StreetLightColor.Red => _color = StreetLightColor.Green
    case StreetLightColor.Green => _color = StreetLightColor.Yellow
    case StreetLightColor.Yellow => _color = StreetLightColor.Red
  }
}