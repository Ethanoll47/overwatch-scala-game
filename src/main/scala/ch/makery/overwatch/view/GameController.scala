package ch.makery.overwatch.view

import ch.makery.overwatch.MainApp
import scalafx.animation.FadeTransition
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import scalafx.scene.control.{Button, Label, ProgressBar}
import scalafx.scene.image.ImageView
import scalafx.scene.text.Text
import scalafx.util.Duration
import MainApp.game

@sfxml
class GameController(private val player1HealthBar: ProgressBar,
                     private val player1HealthLabel: Label,
                     private val player1StaminaBar: ProgressBar,
                     private val player1StaminaLabel: Label,
                     private val player1HeroLabel: Label,
                     private val player1HeroImage: ImageView,
                     private val player1Ability1: Button,
                     private val player1Ability2: Button,
                     private val player1Ability3: Button,
                     private val player1Ability4: Button,
                     private val player2HealthBar: ProgressBar,
                     private val player2HealthLabel: Label,
                     private val player2StaminaBar: ProgressBar,
                     private val player2StaminaLabel: Label,
                     private val player2HeroLabel: Label,
                     private val player2HeroImage: ImageView,
                     private val player2Ability1: Button,
                     private val player2Ability2: Button,
                     private val player2Ability3: Button,
                     private val player2Ability4: Button,
                     private val consoleText: Text){

  //Initialize variables for player 1
  player1HeroLabel.setText(game.player1.name)
  player1Ability1.setText(game.player1.abilitiesName(0))
  player1Ability2.setText(game.player1.abilitiesName(1))
  player1Ability3.setText(game.player1.abilitiesName(2))
  player1Ability4.setText(game.player1.abilitiesName(3))
  player1HeroImage.image = game.player1.image

  //Initialize variables for player 2
  player2HeroLabel.setText(game.player2.name)
  player2Ability1.setText(game.player2.abilitiesName(0))
  player2Ability2.setText(game.player2.abilitiesName(1))
  player2Ability3.setText(game.player2.abilitiesName(2))
  player2Ability4.setText(game.player2.abilitiesName(3))
  player2HeroImage.image = game.player2.image

  //Initialize player stat when game start
  setPlayersStats

  //Disable player 2's buttons when game start
  setPlayer2Buttons(true)

  //Make console text fade out after 2.5 seconds
  def hideConsoleText: Unit = {
    val fadeOut: FadeTransition = new FadeTransition(Duration(2500), consoleText)
    fadeOut.setFromValue(1.0)
    fadeOut.setToValue(0.0)
    fadeOut.play()
  }

  //Check whether game ends
  def endGame: Unit ={
    if (game.player2.health == 0) {
      game.winner = "Player 1 Wins!"
      MainApp.showGameOver()
    }
    else if (game.player1.health == 0){
      game.winner = "Player 2 Wins!"
      MainApp.showGameOver()
    }
  }

  //Add Stamina for both players after they both used an ability
  def addStamina: Unit ={
    game.player1.addStamina(10)
    game.player2.addStamina(10)
    setPlayersStats
  }

  //Set stats for both players
  def setPlayersStats: Unit ={
    player1HealthBar.setProgress(game.player1.health/100)
    player1HealthLabel.setText(f"${game.player1.health}%.2f")
    player1StaminaBar.setProgress(game.player1.stamina/100)
    player1StaminaLabel.setText(f"${game.player1.stamina}%.2f")
    player2HealthBar.setProgress(game.player2.health/100)
    player2HealthLabel.setText(f"${game.player2.health}%.2f")
    player2StaminaBar.setProgress(game.player2.stamina/100)
    player2StaminaLabel.setText(f"${game.player2.stamina}%.2f")
  }

  //Disable all of player 1's buttons
  def setPlayer1Buttons(boolean: Boolean): Unit = {
    player1Ability1.disable = boolean
    player1Ability2.disable = boolean
    player1Ability3.disable = boolean
    player1Ability4.disable = boolean
  }

  //Disable all of player 2's buttons
  def setPlayer2Buttons(boolean: Boolean): Unit = {
    player2Ability1.disable = boolean
    player2Ability2.disable = boolean
    player2Ability3.disable = boolean
    player2Ability4.disable = boolean
  }

  //Check whether player 1 has enough stamina for each of his abilities
  def checkPlayer1AbilityRequirements: Unit ={
    for (x <- 1 to game.player1.abilitiesCost.length) {
      x match {
        case 1 => if (game.player1.stamina < game.player1.abilitiesCost(x - 1)) {
          player1Ability1.disable = true
        }
        case 2 => if (game.player1.stamina < game.player1.abilitiesCost(x - 1)) {
          player1Ability2.disable = true
        }
        case 3 => if (game.player1.stamina < game.player1.abilitiesCost(x - 1)) {
          player1Ability3.disable = true
        }
        case 4 => if (game.player1.stamina < game.player1.abilitiesCost(x - 1)) {
          player1Ability4.disable = true
        }
      }
    }
  }

  //Check whether player 2 has enough stamina for each of his abilities
  def checkPlayer2AbilityRequirements: Unit = {
    for (x <- 1 to game.player2.abilitiesCost.length) {
      x match {
        case 1 => if (game.player2.stamina < game.player2.abilitiesCost(x - 1)) {
          player2Ability1.disable = true
        }
        case 2 => if (game.player2.stamina < game.player2.abilitiesCost(x - 1)) {
          player2Ability2.disable = true
        }
        case 3 => if (game.player2.stamina < game.player2.abilitiesCost(x - 1)) {
          player2Ability3.disable = true
        }
        case 4 => if (game.player2.stamina < game.player2.abilitiesCost(x - 1)) {
          player2Ability4.disable = true
        }
      }
    }
  }

  //Functions to run when Player 1's turn ends
  def endPlayer1Turn: Unit ={
    endTurn
    setPlayer1Buttons(true)
    setPlayer2Buttons(false)
    checkPlayer2AbilityRequirements
  }
  //Functions to run when Player 2's turn ends
  def endPlayer2Turn: Unit = {
    endTurn
    setPlayer2Buttons(true)
    setPlayer1Buttons(false)
    addStamina
    checkPlayer1AbilityRequirements
  }

  //Functions to run when any player turn ends
  def endTurn: Unit ={
    hideConsoleText
    setPlayersStats
    endGame
  }

  //Functions to handle Player 1's Ability Buttons
  def player1handleAbility1(action: ActionEvent): Unit ={
    game.player1.useAbility(1, game.player2)
    consoleText.setText(s"${game.player1.name} used ${game.player1.abilitiesName(0)}!")
    endPlayer1Turn
  }

  def player1handleAbility2(action: ActionEvent): Unit = {
    game.player1.useAbility(2, game.player2)
    consoleText.setText(s"${game.player1.name} used ${game.player1.abilitiesName(1)}!")
    endPlayer1Turn
  }

  def player1handleAbility3(action: ActionEvent): Unit = {
    game.player1.useAbility(3, game.player2)
    consoleText.setText(s"${game.player1.name} used ${game.player1.abilitiesName(2)}!")
    endPlayer1Turn
  }

  def player1handleAbility4(action: ActionEvent): Unit = {
    game.player1.useAbility(4, game.player2)
    consoleText.setText(s"${game.player1.name} used ${game.player1.abilitiesName(3)}!")
    endPlayer1Turn
  }

  //Functions to handle Player 2's Ability Buttons
  def player2handleAbility1(action: ActionEvent): Unit = {
    game.player2.useAbility(1, game.player1)
    consoleText.setText(s"${game.player2.name} used ${game.player2.abilitiesName(0)}!")
    endPlayer2Turn
  }

  def player2handleAbility2(action: ActionEvent): Unit = {
    game.player2.useAbility(2, game.player1)
    consoleText.setText(s"${game.player2.name} used ${game.player2.abilitiesName(1)}!")
    endPlayer2Turn
  }

  def player2handleAbility3(action: ActionEvent): Unit = {
    game.player2.useAbility(3, game.player1)
    consoleText.setText(s"${game.player2.name} used ${game.player2.abilitiesName(2)}!")
    endPlayer2Turn
  }

  def player2handleAbility4(action: ActionEvent): Unit = {
    game.player2.useAbility(4, game.player1)
    consoleText.setText(s"${game.player2.name} used ${game.player2.abilitiesName(3)}!")
    endPlayer2Turn
  }

}