package game.model.states

import game.model.{Behavior, Game, Job}

class ddMinusSD(game: Game) extends Behavior(game) {

  val reward = 8.0

  override def chooseExpression(): Unit = {
    val job: Job = game.jobs(3)
    game.displayedExpression = job.expressions(getRandomNum(job.expressions))
  }

  override def submitPressed(): Unit = {
    if (game.displayedExpression.evaluate == game.currentNum) {
      println("correct answer!")
      game.currency += reward
      game.currentNum = 0
      new ddMinusSD(game)
    }
  }

}
