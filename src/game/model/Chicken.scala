package game.model

class Chicken() {

  // Percent chance to win a fight
  var strength: Double = 0.55
  var formattedStrength: String = "%1.2f".format(strength)

  def updateFormattedStrength(): Unit = {
    formattedStrength = "%1.2f".format(strength)
  }

  def win(): Unit = {
    strength += 0.01
    updateFormattedStrength()
  }

  def lose(): Unit = {
    strength = 0.55
    updateFormattedStrength()
  }

}
