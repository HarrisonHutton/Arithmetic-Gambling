package game.controller

import game.model.{Game, Job}
import javafx.event.{ActionEvent, EventHandler}

class SubmitAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.submitPressed()
}

class NumberAction(game: Game, number: Int) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.numberPressed(number)
}

class ClearAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.clearPressed()
}

class PMAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.pmPressed()
}

class BuyChickenAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.buyChicken()
}

class CockFightAction(game: Game, number: Int) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.cockFight(number)
}

class sdPlusSDAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.sdPlusSDPressed()
}

class sdPlusDDAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.sdPlusDDPressed()
}

class sdMinusSDAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.sdMinusSDPressed()
}

class ddMinusSDAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.ddMinusSDPressed()
}

class sdTimesSDAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.sdTimesSDPressed()
}

class sdTimesDDAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.sdTimesDDPressed()
}

class sdBySDAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.sdBySDPressed()
}

class ddBySDAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.ddBySDPressed()
}

class cheatAction(game: Game) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = game.cheatGive1000()
}


//class BuyChickenAction(game: Game) extends EventHandler[ActionEvent] {
//  override def handle(event: ActionEvent): Unit = game.buyChickenPressed()
//}
//
//class BuyPromotion(game: Game) extends EventHandler[ActionEvent] {
//  override def handle(event: ActionEvent): Unit = game.buyPromotion(job: Job)
//}
