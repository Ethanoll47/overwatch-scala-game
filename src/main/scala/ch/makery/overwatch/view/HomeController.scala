package ch.makery.overwatch.view

import ch.makery.overwatch.MainApp
import ch.makery.overwatch.MainApp.game
import ch.makery.overwatch.model.Game
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent

@sfxml
class HomeController {

  def handlePlayButton(action: ActionEvent) = {
    game = new Game()
    MainApp.showHeroSelect()
  }

  def handleExitButton(action: ActionEvent) = {
    System.exit(0)
  }
}