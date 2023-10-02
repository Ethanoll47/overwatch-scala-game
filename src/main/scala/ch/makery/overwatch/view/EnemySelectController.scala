package ch.makery.overwatch.view

import ch.makery.overwatch.MainApp
import ch.makery.overwatch.model.{Moira, Reinhardt, Soldier76}
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import scalafx.scene.control.Label
import MainApp.game
import scalafx.scene.image.ImageView

@sfxml
class EnemySelectController(private val reinhardtLabel: Label,
                            private val soldier76Label: Label,
                            private val moiraLabel: Label,
                            private val reinhardtImage: ImageView,
                            private val soldier76Image: ImageView,
                            private val moiraImage: ImageView) {

  //Initialize variables
  reinhardtLabel.text = Reinhardt.name
  soldier76Label.text = Soldier76.name
  moiraLabel.text = Moira.name
  reinhardtImage.image = Reinhardt.image
  soldier76Image.image = Soldier76.image
  moiraImage.image = Moira.image

  //Player choose tank role
  def handleTank(action: ActionEvent) = {
    game.player2= new Reinhardt()
    MainApp.showGame()
  }

  //Player choose damage role
  def handleDamage(action: ActionEvent) = {
    game.player2= new Soldier76()
    MainApp.showGame()
  }

  //Player choose support role
  def handleSupport(action: ActionEvent) = {
    game.player2 = new Moira()
    MainApp.showGame()
  }
}