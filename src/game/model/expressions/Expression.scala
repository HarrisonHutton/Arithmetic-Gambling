package game.model.expressions

abstract class Expression(lhs: Int, rhs: Int) {

  def evaluate: Int

}
