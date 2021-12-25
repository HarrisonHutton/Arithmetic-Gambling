package game.model.states

import game.model.{Behavior, Game, Job}

class sdPlusDD(game: Game) extends Behavior(game) {

  val reward = 4.0

  override def chooseExpression(): Unit = {
    val job: Job = game.jobs(1)
    game.displayedExpression = job.expressions(getRandomNum(job.expressions))
  }

  override def submitPressed(): Unit = {
    if (game.displayedExpression.evaluate == game.currentNum) {
      println("correct answer!")
      game.currency += reward
      game.currentNum = 0
      new sdPlusDD(game)
    }
  }

}
