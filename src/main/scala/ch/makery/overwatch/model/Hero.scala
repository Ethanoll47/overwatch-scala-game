package ch.makery.overwatch.model

import scalafx.scene.image.Image

abstract class Hero {
  val name: String
  var health: Double
  var agility: Double = 0
  val maxStamina: Double = 100
  var stamina: Double = maxStamina
  val abilitiesName: Array[String]
  val abilitiesCost: Array[Double]
  val abilitiesEffect: Array[Double]
  val maxHealth: Double
  val image : Image

  //Add stamina to a hero
  def addStamina(amount: Double): Unit = {
    stamina += amount
    if (stamina > maxStamina) {
      stamina = maxStamina
    }
  }

  //Use an ability
  def useAbility(index: Int, target: Hero): Unit = {
    index match {
      case 1 =>
        //Ability 1
        ability1(target)
      case 2 =>
        //Ability 2
        ability2(target)
      case 3 =>
        //Ability 3
        ability3()
      case 4 =>
        //Ability 4
        ability4(target)
    }
  }

  //Ability 1 Function
  def ability1(target: Hero): Unit = {
  }

  //Ability 2 Function
  def ability2(target: Hero): Unit = {
  }

  //Ability 3 Function
  def ability3(): Unit = {
  }

  //Ability 4 Function
  def ability4(target: Hero): Unit = {
  }

}

//Tank Role Passive Ability
trait Tank {
  val agilityBonus: Double = 20
}

//Damage Role Passive Ability
trait Damage {
  val damageBonus: Double = 1.1
}

//Support Role Passive Ability
trait Support {
  val healBonus: Double = 10
}

class Reinhardt extends Hero with Tank {
  val name = Reinhardt.name
  var health = Reinhardt.baseHealth
  val abilitiesName = Reinhardt.abilitiesName
  val abilitiesCost = Reinhardt.abilitiesCost
  val abilitiesEffect = Reinhardt.abilitiesEffect
  val maxHealth = Reinhardt.baseHealth
  val image = Reinhardt.image

  override def ability1(target: Hero): Unit = {
    super.ability1(target)
    RocketHammer(this, target, agilityBonus)
  }

  override def ability2(target: Hero): Unit = {
    super.ability2(target)
    FireStrike(this, target, agilityBonus)
  }

  override def ability3(): Unit = {
    super.ability3()
    BarrierField(this)
  }

  override def ability4(target: Hero): Unit = {
    super.ability4(target)
    Earthshatter(this, target, agilityBonus)
  }
}

object Reinhardt {
  val name = "Reinhardt"
  val baseHealth = 100
  val abilitiesName = Array(RocketHammer.name, FireStrike.name, BarrierField.name, Earthshatter.name)
  val abilitiesCost = Array(RocketHammer.cost, FireStrike.cost, BarrierField.cost, Earthshatter.cost)
  val abilitiesEffect = Array(RocketHammer.damage, FireStrike.damage, BarrierField.agility, Earthshatter.damage, Earthshatter.agility)
  val image = new Image("/images/reinhardt.png")
}

class Soldier76 extends Hero with Damage {
  val name = Soldier76.name
  var health = Soldier76.baseHealth
  val abilitiesName = Soldier76.abilitiesName
  val abilitiesCost = Soldier76.abilitiesCost
  val abilitiesEffect = Soldier76.abilitiesEffect
  val maxHealth = Soldier76.baseHealth
  val image = Soldier76.image

  override def ability1(target: Hero): Unit = {
    super.ability1(target)
    AssaultRifle(this, target, damageBonus)
  }

  override def ability2(target: Hero): Unit = {
    super.ability2(target)
    HelixRockets(this, target, damageBonus)
  }

  override def ability3(): Unit = {
    super.ability3()
    BioticField(this)
  }

  override def ability4(target: Hero): Unit = {
    super.ability4(target)
    TacticalVisor(this, target, damageBonus)
  }
}

object Soldier76 {
  val name = "Soldier 76"
  val baseHealth = 100
  val abilitiesName = Array(AssaultRifle.name, HelixRockets.name, BioticField.name, TacticalVisor.name)
  val abilitiesCost = Array(AssaultRifle.cost, HelixRockets.cost, BioticField.cost, TacticalVisor.cost)
  val abilitiesEffect = Array(AssaultRifle.damage, HelixRockets.damage, BioticField.health, TacticalVisor.damage)
  val image = new Image("/images/soldier76.png")
}

class Moira extends Hero with Support {
  val name = Moira.name
  var health = Moira.baseHealth
  val abilitiesName = Moira.abilitiesName
  val abilitiesCost = Moira.abilitiesCost
  val abilitiesEffect = Moira.abilitiesEffect
  val maxHealth = Moira.baseHealth
  val image = Moira.image

  override def ability1(target: Hero): Unit = {
    super.ability1(target)
    BioticGrasp(this, target, healBonus)
  }

  override def ability2(target: Hero): Unit = {
    super.ability2(target)
    BioticOrb(this, target, healBonus)
  }

  override def ability3(): Unit = {
    super.ability3()
    Fade(this, healBonus)
  }

  override def ability4(target: Hero): Unit = {
    super.ability4(target)
    Coalescence(this, target, healBonus)
  }
}

object Moira {
  val name = "Moira"
  val baseHealth = 100
  val abilitiesName = Array(BioticGrasp.name, BioticOrb.name, Fade.name, Coalescence.name)
  val abilitiesCost = Array(BioticGrasp.cost, BioticOrb.cost, Fade.cost, Coalescence.cost)
  val abilitiesEffect = Array(BioticGrasp.damage, BioticOrb.damage, Fade.health, Coalescence.damage, Coalescence.health)
  val image = new Image("/images/moira.png")
}




