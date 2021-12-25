package game.model.states

import game.model.{Behavior, Game, Job}

class sdBySD(game: Game) extends Behavior(game) {

  val reward = 14.0

  override def chooseExpression(): Unit = {
    val job: Job = game.jobs(6)
    game.displayedExpression = job.expressions(getRandomNum(job.expressions))
  }

  override def submitPressed(): Unit = {
    if (game.displayedExpression.evaluate == game.currentNum) {
      println("correct answer!")
      game.currency += reward
      game.currentNum = 0
      new sdBySD(game)
    }
  }

}
