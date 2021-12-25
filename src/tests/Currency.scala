package tests

import game.model.Game
import org.scalatest._

class Currency extends FunSuite{

  test("Testing rewards") {

    val newGame: Game = new Game()

    assert(newGame.currency == 0.0, "currency isn't starting at 0")

    newGame.currencyEarned(50.0)

    assert(newGame.currency == 50.0, "currency didn't update to 50.0")

  }

}
