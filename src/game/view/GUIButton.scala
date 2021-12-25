package game.view

import javafx.event.{ActionEvent, EventHandler}
import scalafx.scene.control.Button

class GUIButton(display: String, action: EventHandler[ActionEvent], xScale: Double = 1.0, yScale: Double = 1.0) extends Button {
  val buttonSize: Int = 5
  minWidth = buttonSize * xScale
  minHeight = buttonSize * yScale
  onAction = action
  text = display
  style = "-fx-font: 26 ariel;"
}
