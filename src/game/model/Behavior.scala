package game.model

import game.model.expressions.Expression

import scala.util.Random

abstract class Behavior(game: Game) {

  def submitPressed(): Unit

  def getRandomNum(list: List[Expression]): Int = {
    Random.nextInt(list.length)
  }

  def chooseExpression(): Unit

}
