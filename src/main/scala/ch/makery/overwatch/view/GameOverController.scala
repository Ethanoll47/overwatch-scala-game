package ch.makery.overwatch.view

import ch.makery.overwatch.MainApp
import MainApp.game
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import scalafx.scene.control.Label

@sfxml
class GameOverController(private val gameOverLabel: Label) {
  gameOverLabel.text = game.winner

  def handleReturnHome(action: ActionEvent) = {
    MainApp.showHome()
  }
}