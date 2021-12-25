package game.model

import game.model.expressions.{Add, Divide, Expression, Multiply, Subtract}
import game.model.states.{ddBySD, ddMinusSD, sdBySD, sdMinusSD, sdPlusDD, sdPlusSD, sdTimesDD, sdTimesSD}

class Game() {

  var currency: Double = 0.0
  var currentNum: Int = 0
  var displayedExpression: Expression = _

  var currentJob: Job = sdPlusSD

  var chicken: Chicken = new Chicken()
  var chickenOwned: Boolean = false

  var hasBetYet: Boolean = false

  var recentCashWon: Double = 0.0

  var state: Behavior = new sdPlusSD(this)

  val list1: List[Add] = List(
    new Add(5,7),
    new Add(3,4),
    new Add(8,9),
    new Add(1,6),
    new Add(2,9),
    new Add(9,9),
    new Add(7,4),
    new Add(3,2),
    new Add(8,8),
    new Add(1,9),
    new Add(4,8),
    new Add(7,6),
    new Add(5,4),
    new Add(6,5)
  )

  val list2: List[Add] = List(
    new Add(7, 68),
    new Add(5, 39),
    new Add(2, 77),
    new Add(9, 99),
    new Add(8, 43),
    new Add(63,5),
    new Add(49,9),
    new Add(80,7),
    new Add(3,79),
    new Add(57,4),
    new Add(6,31),
    new Add(97,4)
  )

  val list3: List[Subtract] = List(
    new Subtract(9,8),
    new Subtract(7,5),
    new Subtract(3, 3),
    new Subtract(6, 2),
    new Subtract(8, 4),
    new Subtract(7,4),
    new Subtract(3,8),
    new Subtract(5,8),
    new Subtract(1,7),
    new Subtract(2,8),
    new Subtract(6,7),
    new Subtract(7,6),
    new Subtract(5,2),
    new Subtract(4,4)
  )

  val list4: List[Subtract] = List(
    new Subtract(67,4),
    new Subtract(54,7),
    new Subtract(33,1),
    new Subtract(79,2),
    new Subtract(50,4),
    new Subtract(60,7),
    new Subtract(30,9),
    new Subtract(99,96),
    new Subtract(49,6),
    new Subtract(9,77),
    new Subtract(11,4),
    new Subtract(3,49)
  )

  val list5: List[Multiply] = List(
    new Multiply(5,6),
    new Multiply(2,7),
    new Multiply(9,3),
    new Multiply(7,7),
    new Multiply(6,5),
    new Multiply(8,8),
    new Multiply(9,2),
    new Multiply(5,4),
    new Multiply(3,5),
    new Multiply(7,4),
    new Multiply(7,9),
    new Multiply(6,2),
    new Multiply(8,9),
    new Multiply(4,6)
  )

  val list6: List[Multiply] = List(
    new Multiply(4,43),
    new Multiply(6,66),
    new Multiply(9,22),
    new Multiply(3,21),
    new Multiply(50,6),
    new Multiply(73,3),
    new Multiply(92,4),
    new Multiply(5,13),
    new Multiply(17,7),
    new Multiply(83,2),
    new Multiply(64,3)
  )

  val list7: List[Divide] = List(
    new Divide(6,3),
    new Divide(7,1),
    new Divide(9,3),
    new Divide(8,4),
    new Divide(8,2),
    new Divide(6,2),
    new Divide(5,1),
    new Divide(2,2)
  )

  val list8: List[Divide] = List(
    new Divide(54,2),
    new Divide(50,5),
    new Divide(54,6),
    new Divide(33,11),
    new Divide(22,2),
    new Divide(99,9),
    new Divide(36,6),
    new Divide(36,2),
    new Divide(44,11),
    new Divide(88,4),
    new Divide(54,9),
    new Divide(74,2)
  )

  //Add
  val sdPlusSD: Job = new Job("SD + SD", 0, list1)
  val sdPlusDD: Job = new Job("SD + DD", 20, list2)
  //Subtract
  val sdMinusSD: Job = new Job("SD - SD", 20, list3)
  val ddMinusSD: Job = new Job("DD - SD", 40, list4)
  //Multiply
  val sdTimesSD: Job = new Job("SD * SD", 40, list5)
  val sdTimesDD: Job = new Job("SD * DD", 60, list6)
  //Divide
  val sdBySD: Job = new Job("SD / SD", 60, list7)
  val ddBySD: Job = new Job("DD / SD", 80, list8)

  //Player starts off with sdPLusSD purchased
  sdPlusSD.purchased = true

  var jobs: List[Job] = List(
    sdPlusSD,
    sdPlusDD,
    sdMinusSD,
    ddMinusSD,
    sdTimesSD,
    sdTimesDD,
    sdBySD,
    ddBySD
  )

  def displayCurrency(): Double = {
    currency
  }

  def displayNumber(): Int = {
    currentNum
  }

  def numberPressed(number: Int): Unit = {
    if (currentNum.toString == "0"){
      currentNum = number
    }
    else {
      currentNum = (currentNum.toString + number.toString).toInt
    }
    println(number)
  }

  def clearPressed(): Unit = {
    println("clear pressed")
    currentNum = 0
  }

  def pmPressed(): Unit = {
    currentNum *= -1
  }

  def submitPressed(): Unit = {
    this.state.submitPressed()
    chooseExpression()
  }

  def displayExpression(): Expression = {
    this.state.chooseExpression()
    displayedExpression
  }

  def chooseExpression(): Unit = {
    this.state.chooseExpression()
  }


  def sdPlusSDPressed(): Unit = {
    if(sdPlusSD.purchased){
      currentJob = sdPlusSD
      state = new sdPlusSD(this)
      chooseExpression()
    }
    else if (currency >= sdPlusSD.price){
      currency -= sdPlusSD.price
      currentJob = sdPlusSD
      sdPlusSD.purchased = true
      state = new sdPlusSD(this)
      chooseExpression()
    }
    else {
      println("Insufficient Currency")
    }
  }

  def sdPlusDDPressed(): Unit = {
    if(sdPlusDD.purchased){
      currentJob = sdPlusDD
      state = new sdPlusDD(this)
      chooseExpression()

    }
    else if (currency >= sdPlusDD.price){
      currency -= sdPlusDD.price
      currentJob = sdPlusDD
      sdPlusDD.purchased = true
      state = new sdPlusDD(this)
      println("Purchased!")
      chooseExpression()
    }
    else {
      println("Insufficient Currency")
    }
  }

  def sdMinusSDPressed(): Unit = {
    if(sdMinusSD.purchased){
      currentJob = sdMinusSD
      state = new sdMinusSD(this)
      chooseExpression()
    }
    else if (currency >= sdMinusSD.price){
      currency -= sdMinusSD.price
      currentJob = sdMinusSD
      sdMinusSD.purchased = true
      state = new sdMinusSD(this)
      println("Purchased!")
      chooseExpression()
    }
    else {
      println("Insufficient Currency")
    }
  }

  def ddMinusSDPressed(): Unit = {
    if(ddMinusSD.purchased){
      currentJob = ddMinusSD
      state = new ddMinusSD(this)
      chooseExpression()
    }
    else if (currency >= ddMinusSD.price){
      currency -= ddMinusSD.price
      currentJob = ddMinusSD
      ddMinusSD.purchased = true
      state = new ddMinusSD(this)
      println("Purchased!")
      chooseExpression()
    }
    else {
      println("Insufficient Currency")
    }
  }

  def sdTimesSDPressed(): Unit = {
    if(sdTimesSD.purchased){
      currentJob = sdTimesSD
      state = new sdTimesSD(this)
      chooseExpression()
    }
    else if (currency >= sdTimesSD.price){
      currency -= sdTimesSD.price
      currentJob = sdTimesSD
      sdTimesSD.purchased = true
      state = new sdTimesSD(this)
      println("Purchased!")
      chooseExpression()
    }
    else {
      println("Insufficient Currency")
    }
  }

  def sdTimesDDPressed(): Unit = {
    if(sdTimesDD.purchased){
      currentJob = sdTimesDD
      state = new sdTimesDD(this)
      chooseExpression()
    }
    else if (currency >= sdTimesDD.price){
      currency -= sdTimesDD.price
      currentJob = sdTimesDD
      sdTimesDD.purchased = true
      state = new sdTimesDD(this)
      println("Purchased!")
      chooseExpression()
    }
    else {
      println("Insufficient Currency")
    }
  }

  def sdBySDPressed(): Unit = {
    if(sdBySD.purchased){
      currentJob = sdBySD
      state = new sdBySD(this)
      chooseExpression()
    }
    else if (currency >= sdBySD.price){
      currency -= sdBySD.price
      currentJob = sdBySD
      sdBySD.purchased = true
      state = new sdBySD(this)
      println("Purchased!")
      chooseExpression()
    }
    else {
      println("Insufficient Currency")
    }
  }

  def ddBySDPressed(): Unit = {
    if(ddBySD.purchased){
      currentJob = ddBySD
      state = new ddBySD(this)
      chooseExpression()
    }
    else if (currency >= ddBySD.price){
      currency -= ddBySD.price
      currentJob = ddBySD
      ddBySD.purchased = true
      state = new ddBySD(this)
      println("Purchased!")
      chooseExpression()
    }
    else {
      println("Insufficient Currency")
    }
  }

  def cheatGive1000(): Unit = {
    currency += 1000.0
  }

  def currencyEarned(reward: Double): Unit = {
    this.currency += reward
  }

  //Should only be able to buy chicken if the user doesn't already have one
  def buyChicken(): Unit = {
    if (!chickenOwned) {
      if (currency >= 50){
        currency -= 50
        chickenOwned = true
      }
      hasBetYet = false
    }
  }

  /**
   * @param number How much the user wants to bet
   */
  def cockFight(number: Int): Unit = {
    if(chickenOwned){
      hasBetYet = true
      currency -= number
      if (Math.random() <= chicken.strength){
        currency += 2 * number
        recentCashWon = number
        chicken.win()
      }
      else {
        chicken.lose()
        chickenOwned = false
        recentCashWon = 0.0
      }
    }
  }

  def cockDetails(): String = {
    if (chickenOwned){
      f"Cock Strength: ${chicken.formattedStrength}"
    }
    else{
      "No chicken owned"
    }
  }

  def results(): String = {
    if (!hasBetYet) {
      ""
    }
    else if (recentCashWon > 0.0){
      f"Your cock earned you $recentCashWon!"
    }
    else {
      "Your chicken died."
    }
  }

}
