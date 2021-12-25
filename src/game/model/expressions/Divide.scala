package game.model.expressions

class Divide(lhs: Int, rhs: Int) extends Expression(lhs, rhs) {

  override def toString: String = {
    f"$lhs / $rhs"
  }

  override def evaluate(): Int = {
    lhs / rhs
  }

}
