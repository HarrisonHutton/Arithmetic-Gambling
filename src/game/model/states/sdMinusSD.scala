package game.model.states

import game.model.{Behavior, Game, Job}

class sdMinusSD(game: Game) extends Behavior(game) {

  val reward = 6.0

  override def chooseExpression(): Unit = {
    val job: Job = game.jobs(2)
    game.displayedExpression = job.expressions(getRandomNum(job.expressions))
  }

  override def submitPressed(): Unit = {
    if (game.displayedExpression.evaluate == game.currentNum) {
      println("correct answer!")
      game.currency += reward
      game.currentNum = 0
      new sdMinusSD(game)
    }
  }

}
