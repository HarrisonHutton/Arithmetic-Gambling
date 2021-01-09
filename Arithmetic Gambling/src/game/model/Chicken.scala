package game.model

class Chicken() {

  // Percent chance to win a fight
  var strength: Double = 0.55

  def win(): Unit = {
    strength += 0.01
  }

  def lose(): Unit = {
    strength = 0.55
  }

}
