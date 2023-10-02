package ch.makery.overwatch.view

import ch.makery.overwatch.MainApp
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent

@sfxml
class RootLayoutController {

  def handleHomeButton(action: ActionEvent) = {
    MainApp.showHome()
  }

  def handleHeroesListButton(action: ActionEvent) = {
    MainApp.showHeroesListDialog()
  }

  def handleExitButton(action: ActionEvent) = {
    System.exit(0)
  }

}