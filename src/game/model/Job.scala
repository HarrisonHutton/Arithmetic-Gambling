package game.model

import game.model.expressions.Expression

class Job(name: String, val price: Double, jobs: List[Expression]) {

  var purchased: Boolean = false

  val expressions: List[Expression] = jobs

}
