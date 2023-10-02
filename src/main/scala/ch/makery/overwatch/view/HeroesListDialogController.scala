package ch.makery.overwatch.view

import ch.makery.overwatch.model.{Moira, Reinhardt, Soldier76}
import scalafxml.core.macros.sfxml
import scalafx.scene.control.Label
import scalafx.scene.text.Text
import scalafx.stage.Stage

@sfxml
class HeroesListDialogController(private val reinhardtNameLabel: Label,
                                 private val reinhardtAbility1Name: Text,
                                 private val reinhardtAbility1Effect: Text,
                                 private val reinhardtAbility1Cost: Text,
                                 private val reinhardtAbility2Name: Text,
                                 private val reinhardtAbility2Effect: Text,
                                 private val reinhardtAbility2Cost: Text,
                                 private val reinhardtAbility3Name: Text,
                                 private val reinhardtAbility3Effect: Text,
                                 private val reinhardtAbility3Cost: Text,
                                 private val reinhardtAbility4Name: Text,
                                 private val reinhardtAbility4Effect: Text,
                                 private val reinhardtAbility4Cost: Text,
                                 private val soldier76NameLabel: Label,
                                 private val soldier76Ability1Name: Text,
                                 private val soldier76Ability1Effect: Text,
                                 private val soldier76Ability1Cost: Text,
                                 private val soldier76Ability2Name: Text,
                                 private val soldier76Ability2Effect: Text,
                                 private val soldier76Ability2Cost: Text,
                                 private val soldier76Ability3Name: Text,
                                 private val soldier76Ability3Effect: Text,
                                 private val soldier76Ability3Cost: Text,
                                 private val soldier76Ability4Name: Text,
                                 private val soldier76Ability4Effect: Text,
                                 private val soldier76Ability4Cost: Text,
                                 private val moiraNameLabel: Label,
                                 private val moiraAbility1Name: Text,
                                 private val moiraAbility1Effect: Text,
                                 private val moiraAbility1Cost: Text,
                                 private val moiraAbility2Name: Text,
                                 private val moiraAbility2Effect: Text,
                                 private val moiraAbility2Cost: Text,
                                 private val moiraAbility3Name: Text,
                                 private val moiraAbility3Effect: Text,
                                 private val moiraAbility3Cost: Text,
                                 private val moiraAbility4Name: Text,
                                 private val moiraAbility4Effect: Text,
                                 private val moiraAbility4Cost: Text
                                ) {
  var dialogStage: Stage = null

  //Initialize variables
  reinhardtNameLabel.text = Reinhardt.name
  reinhardtAbility1Name.text = Reinhardt.abilitiesName(0)
  reinhardtAbility1Effect.text = s"Damage: ${Reinhardt.abilitiesEffect(0)}"
  reinhardtAbility1Cost.text = s"Cost: ${Reinhardt.abilitiesCost(0)}"
  reinhardtAbility2Name.text = Reinhardt.abilitiesName(1)
  reinhardtAbility2Effect.text = s"Damage: ${Reinhardt.abilitiesEffect(1)}"
  reinhardtAbility2Cost.text = s"Cost: ${Reinhardt.abilitiesCost(1)}"
  reinhardtAbility3Name.text = Reinhardt.abilitiesName(2)
  reinhardtAbility3Effect.text = s"Agility: ${Reinhardt.abilitiesEffect(2)}"
  reinhardtAbility3Cost.text = s"Cost: ${Reinhardt.abilitiesCost(2)}"
  reinhardtAbility4Name.text = Reinhardt.abilitiesName(3)
  reinhardtAbility4Effect.text = s"Damage: ${Reinhardt.abilitiesEffect(3)} Agility: ${Reinhardt.abilitiesEffect(4)} "
  reinhardtAbility4Cost.text = s"Cost: ${Reinhardt.abilitiesCost(3)}"

  soldier76NameLabel.text = Soldier76.name
  soldier76Ability1Name.text = Soldier76.abilitiesName(0)
  soldier76Ability1Effect.text = s"Damage: ${Soldier76.abilitiesEffect(0)}"
  soldier76Ability1Cost.text = s"Cost: ${Soldier76.abilitiesCost(0)}"
  soldier76Ability2Name.text = Soldier76.abilitiesName(1)
  soldier76Ability2Effect.text = s"Damage: ${Soldier76.abilitiesEffect(1)}"
  soldier76Ability2Cost.text = s"Cost: ${Soldier76.abilitiesCost(1)}"
  soldier76Ability3Name.text = Soldier76.abilitiesName(2)
  soldier76Ability3Effect.text = s"Heal: ${Soldier76.abilitiesEffect(2)}"
  soldier76Ability3Cost.text = s"Cost: ${Soldier76.abilitiesCost(2)}"
  soldier76Ability4Name.text = Soldier76.abilitiesName(3)
  soldier76Ability4Effect.text = s"Damage: ${Soldier76.abilitiesEffect(3)}"
  soldier76Ability4Cost.text = s"Cost: ${Soldier76.abilitiesCost(3)}"

  moiraNameLabel.text = Moira.name
  moiraAbility1Name.text = Moira.abilitiesName(0)
  moiraAbility1Effect.text = s"Damage: ${Moira.abilitiesEffect(0)}"
  moiraAbility1Cost.text = s"Cost: ${Moira.abilitiesCost(0)}"
  moiraAbility2Name.text = Moira.abilitiesName(1)
  moiraAbility2Effect.text = s"Damage: ${Moira.abilitiesEffect(1)}"
  moiraAbility2Cost.text = s"Cost: ${Moira.abilitiesCost(1)}"
  moiraAbility3Name.text = Moira.abilitiesName(2)
  moiraAbility3Effect.text = s"Heal: ${Moira.abilitiesEffect(2)}"
  moiraAbility3Cost.text = s"Cost: ${Moira.abilitiesCost(2)}"
  moiraAbility4Name.text = Moira.abilitiesName(3)
  moiraAbility4Effect.text = s"Damage: ${Moira.abilitiesEffect(3)} Heal: ${Moira.abilitiesEffect(4)} "
  moiraAbility4Cost.text = s"Cost: ${Moira.abilitiesCost(3)}"
}