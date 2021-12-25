package game.model.states

import game.model.expressions.{Add, Expression}
import game.model.{Behavior, Game, Job}

import scala.util.Random

class sdPlusSD(game: Game) extends Behavior(game) {

  val reward = 2.0

  override def chooseExpression(): Unit = {
    val job: Job = game.jobs(0)
    game.displayedExpression = job.expressions(getRandomNum(job.expressions))
  }

  override def submitPressed(): Unit = {
    if (game.displayedExpression.evaluate == game.currentNum) {
      println("correct answer!")
      game.currency += reward
      game.currentNum = 0
      new sdPlusSD(game)
    }
    else {
      game.currentNum = 0
    }
  }

}
