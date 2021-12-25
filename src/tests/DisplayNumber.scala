package tests

import game.model.Game
import org.scalatest._

class DisplayNumber extends FunSuite {

  test("Testing Display Numbers") {

    val newGame: Game = new Game()

    assert(newGame.displayNumber() == 0, "Not starting with 0")

    newGame.numberPressed(9)

    assert(newGame.displayNumber() == 9, "Display number did not update to 9")

  }

}
