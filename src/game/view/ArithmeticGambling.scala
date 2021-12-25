package game.view

import game.controller.{BuyChickenAction, ClearAction, CockFightAction, NumberAction, PMAction, SubmitAction, cheatAction, ddBySDAction, ddMinusSDAction, sdBySDAction, sdMinusSDAction, sdPlusDDAction, sdPlusSDAction, sdTimesDDAction, sdTimesSDAction}
import scalafx.application.JFXApp
import javafx.scene.input.{KeyEvent, MouseEvent}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.layout.GridPane
import game.model.Game

object ArithmeticGambling extends JFXApp{

  val game = new Game()

  var answerField: TextField = new TextField {
    editable = false
    style = "-fx-font: 26 ariel;"
    text.value = game.displayNumber().toString
  }

  var expressionField: TextField = new TextField {
    editable = false
    style = "-fx-font: 26 ariel;"
    text.value = game.displayExpression().toString
  }

  var currencyField: TextField = new TextField {
    editable = false
    style = "-fx-font: 26 ariel"
    text.value = "Currency: " + game.displayCurrency().toString
  }

  var cockField: TextField = new TextField {
    editable = false
    style = "-fx-font: 26 ariel"
    text.value = game.cockDetails()
  }

  var resultsField: TextField = new TextField {
    editable = false
    style = "-fx-font: 26 ariel"
    text.value = game.results()
  }

  stage = new PrimaryStage {
    title = "Arithmetic Gambling"
    scene = new Scene() {
      content = List(
        new GridPane {
          hgap = 0.0
          vgap = 0.0

          add(expressionField, 0, 0, 2, 1)
          add(answerField, 0, 1, 1, 1)
          add(currencyField, 4, 0, 1, 1)
          add(new GUIButton("Submit!", new SubmitAction(game)), 1, 1, 1, 1)

          add(new GUIButton("7", new NumberAction(game, 7)), 0, 2)
          add(new GUIButton("8", new NumberAction(game, 8)), 1, 2)
          add(new GUIButton("9", new NumberAction(game, 9)), 2, 2)
          add(new GUIButton("4", new NumberAction(game, 4)), 0, 3)
          add(new GUIButton("5", new NumberAction(game, 5)), 1, 3)
          add(new GUIButton("6", new NumberAction(game, 6)), 2, 3)
          add(new GUIButton("1", new NumberAction(game, 1)), 0, 4)
          add(new GUIButton("2", new NumberAction(game, 2)), 1, 4)
          add(new GUIButton("3", new NumberAction(game, 3)), 2, 4)
          add(new GUIButton("0", new NumberAction(game, 0)), 0, 5)

          add(new GUIButton("c", new ClearAction(game)), 1, 5)
          add(new GUIButton("+/-", new PMAction(game)), 2, 5)

          add(cockField, 0, 7, 2, 1)
          add(resultsField, 0, 8, 2, 1)
          add(new GUIButton("Buy Chicken: 50", new BuyChickenAction(game)), 0, 9)
          add(new GUIButton("Cock Fight 50", new CockFightAction(game, 50)), 0, 10)
          add(new GUIButton("Cock Fight 100", new CockFightAction(game, 100)), 1, 10)
          add(new GUIButton("Cock Fight 200", new CockFightAction(game, 200)), 2, 10)

          add(new GUIButton("SD + SD", new sdPlusSDAction(game)), 4, 2)
          add(new GUIButton("SD + DD", new sdPlusDDAction(game)), 5, 2)
          add(new GUIButton("SD - SD", new sdMinusSDAction(game)), 4, 3)
          add(new GUIButton("DD - SD", new ddMinusSDAction(game)), 5, 3)
          add(new GUIButton("SD * SD", new sdTimesSDAction(game)), 4, 4)
          add(new GUIButton("SD * DD", new sdTimesDDAction(game)), 5, 4)
          add(new GUIButton("SD / SD", new sdBySDAction(game)), 4, 5)
          add(new GUIButton("DD / SD", new ddBySDAction(game)), 5, 5)

          add(new GUIButton("Dev $1000", new cheatAction(game)), 4, 7)
        }
      )
    }

    addEventFilter(MouseEvent.MOUSE_CLICKED, (event: MouseEvent) => {
      answerField.text.value = game.displayNumber().toString
      expressionField.text.value = game.displayedExpression.toString
      currencyField.text.value = "Currency: " + game.displayCurrency().toString
      cockField.text.value = game.cockDetails()
      resultsField.text.value = game.results()
      Math.max(5,6)
    })
  }

}
