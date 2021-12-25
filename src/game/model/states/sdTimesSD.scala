package game.model.states

import game.model.{Behavior, Game, Job}

class sdTimesSD(game: Game) extends Behavior(game) {

  val reward = 10.0

  override def chooseExpression(): Unit = {
    val job: Job = game.jobs(4)
    game.displayedExpression = job.expressions(getRandomNum(job.expressions))
  }

  override def submitPressed(): Unit = {
    if (game.displayedExpression.evaluate == game.currentNum) {
      println("correct answer!")
      game.currency += reward
      game.currentNum = 0
      new sdTimesSD(game)
    }
  }

}
