package game.controller

import game.model.Game
import javafx.event.EventHandler
import javafx.scene.input.KeyEvent

class KeyBoardInputs(game: Game) extends EventHandler[KeyEvent] {

//  val ZERO: String
//  val ONE: String
//  val TWO: String
//  val THREE: String
//  val FOUR: String
//  val FIVE: String
//  val SIX: String
//  val SEVEN: String
//  val EIGHT: String
//  val NINE: String

  override def handle(event: KeyEvent): Unit = {
    val keyCode: String = event.getText
    println(keyCode)

    keyCode match {
      case "0" => game.numberPressed(0)
      case "1" => game.numberPressed(1)
      case "2" => game.numberPressed(2)
      case "3" => game.numberPressed(3)
      case "4" => game.numberPressed(4)
      case "5" => game.numberPressed(5)
      case "6" => game.numberPressed(6)
      case "7" => game.numberPressed(7)
      case "8" => game.numberPressed(8)
      case "9" => game.numberPressed(9)

      case _ => println("Invalid key pressed")
//      case _ => println("Not getting KEY_TYPED")
    }
  }

}

//class PlayerInputs(game: Game) extends KeyBoardInputs(game) {
//  override val ZERO: String = "0"
//  override val ONE: String = "1'"
//  override val TWO: String = "2"
//  override val THREE: String = "3"
//  override val FOUR: String = "4"
//  override val FIVE: String = "5"
//  override val SIX: String = "6"
//  override val SEVEN: String = "7"
//  override val EIGHT: String = "8"
//  override val NINE: String = "9"
//}
