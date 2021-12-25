package game.model.states

import game.model.{Behavior, Game, Job}

class ddBySD(game: Game) extends Behavior(game) {

  val reward = 16.0

  override def chooseExpression(): Unit = {
    val job: Job = game.jobs(7)
    game.displayedExpression = job.expressions(getRandomNum(job.expressions))
  }

  override def submitPressed(): Unit = {
    if (game.displayedExpression.evaluate == game.currentNum) {
      println("correct answer!")
      game.currency += reward
      game.currentNum = 0
      new ddBySD(game)
    }
  }

}
