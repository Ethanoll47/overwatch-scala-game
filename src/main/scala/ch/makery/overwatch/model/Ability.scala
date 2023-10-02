package ch.makery.overwatch.model

abstract class Ability {
  val name: String
  val cost: Double

  //Minus Hero's Stamina after using an ability
  def minusStamina(caster: Hero): Unit = {
    caster.stamina -= cost
    if (caster.stamina < 0) {
      caster.stamina = 0
    }
  }
}

//Attack ability
trait Attack {
  def attack(damage: Double, target: Hero): Unit = {
    //If target's agility is less than 50, they receive damage
    if (target.agility < 50) {
      target.health -= damage
      if (target.health < 0) {
        target.health = 0
      }
    }
    //If target's agility is more than 50, they receive 0 damage
    else {
      target.agility = 0
    }
  }
}

//Heal Ability
trait Heal {
  //Heal caster's health
  def heal(amount: Double, caster: Hero): Unit = {
    caster.health += amount
    if (caster.health > caster.maxHealth) {
      caster.health = caster.maxHealth
    }
  }
}

//Agility Ability
trait Agility {
  //Add hero's agility
  def addAgility(amount: Double, caster: Hero): Unit ={
    caster.agility += amount
  }
}

//Reinhardt's Abilities
class RocketHammer(val caster: Hero, val target: Hero, agilityBonus: Double) extends Ability with Attack with Agility {
  val name = RocketHammer.name
  val cost = RocketHammer.cost
  var damage = RocketHammer.damage
  val agility = agilityBonus
}

class FireStrike(val caster: Hero, val target: Hero, agilityBonus: Double) extends Ability with Attack with Agility {
  val name = FireStrike.name
  val cost = FireStrike.cost
  var damage = FireStrike.damage
  val agility = agilityBonus
}

class BarrierField(val caster: Hero) extends Ability with Agility {
  val name = BarrierField.name
  val cost = BarrierField.cost
  var agility = BarrierField.agility
}

class Earthshatter(val caster: Hero, val target: Hero, agilityBonus: Double) extends Ability with Attack with Agility {
  val name = Earthshatter.name
  val cost = Earthshatter.cost
  var damage = Earthshatter.damage
  val agility = Earthshatter.agility + agilityBonus
}


object RocketHammer {
  val name = "Rocket Hammer"
  val cost = 0.0
  var damage = 5.0

  def apply(caster: Hero, target: Hero, agilityBonus: Double): Unit = {
    val a = new RocketHammer(caster, target, agilityBonus)
    a.minusStamina(caster)
    a.attack(a.damage, target)
    a.addAgility(a.agility, caster)
  }
}

object FireStrike {
  val name = "Fire Strike"
  val cost = 10.0
  var damage = 15.0

  def apply(caster: Hero, target: Hero, agilityBonus: Double): Unit = {
    val a = new FireStrike(caster, target, agilityBonus)
    a.minusStamina(caster)
    a.attack(a.damage, target)
    a.addAgility(a.agility, caster)
  }
}

object BarrierField {
  val name = "Barrier Field"
  val cost = 20.0
  var agility = 50.0

  def apply(caster: Hero): Unit = {
    val a = new BarrierField(caster)
    a.minusStamina(caster)
    a.addAgility(a.agility, caster)
  }
}

object Earthshatter {
  val name = "Earthshatter"
  val cost = 30.0
  var damage = 25.0
  var agility = 15.0

  def apply(caster: Hero, target: Hero, agilityBonus: Double): Unit = {
    val a = new Earthshatter(caster, target, agilityBonus)
    a.minusStamina(caster)
    a.attack(a.damage, target)
    a.addAgility(a.agility, caster)
  }
}

//Soldier 76's Abilities
class AssaultRifle(val caster: Hero, val target: Hero, damageBonus: Double) extends Ability with Attack {
  val name = AssaultRifle.name
  val cost = AssaultRifle.cost
  var damage = AssaultRifle.damage * damageBonus
}

class HelixRockets(val caster: Hero, val target: Hero, damageBonus: Double) extends Ability with Attack {
  val name = HelixRockets.name
  val cost = HelixRockets.cost
  var damage = HelixRockets.damage * damageBonus
}

class BioticField(val caster: Hero) extends Ability with Heal {
  val name = BioticField.name
  val cost = BioticField.cost
  var health = BioticField.health
}

class TacticalVisor(val caster: Hero, val target: Hero, damageBonus: Double) extends Ability with Attack {
  val name = TacticalVisor.name
  val cost = TacticalVisor.cost
  var damage = TacticalVisor.damage * damageBonus
}


object AssaultRifle {
  val name = "Assault Rifle"
  val cost = 0.0
  var damage = 5.0

  def apply(caster: Hero, target: Hero, damageBonus: Double): Unit = {
    val a = new AssaultRifle(caster, target, damageBonus)
    a.minusStamina(caster)
    a.attack(a.damage, target)
  }
}

object HelixRockets {
  val name = "Helix Rockets"
  val cost = 10.0
  var damage = 15.0

  def apply(caster: Hero, target: Hero, damageBonus: Double): Unit = {
    val a = new HelixRockets(caster, target, damageBonus)
    a.minusStamina(caster)
    a.attack(a.damage, target)
  }
}

object BioticField {
  val name = "Biotic Field"
  val cost = 20.0
  var health = 25.0

  def apply(caster: Hero): Unit = {
    val a = new BioticField(caster)
    a.minusStamina(caster)
    a.heal(a.health, caster)
  }
}

object TacticalVisor {
  val name = "Tactical Visor"
  val cost = 30.0
  var damage = 40.0

  def apply(caster: Hero, target: Hero, damageBonus: Double): Unit = {
    val a = new TacticalVisor(caster, target, damageBonus)
    a.minusStamina(caster)
    a.attack(a.damage, target)
  }
}

//Moira's Abilities
class BioticGrasp(val caster: Hero, val target: Hero, healBonus: Double) extends Ability with Attack with Heal{
  val name = BioticGrasp.name
  val cost = BioticGrasp.cost
  var damage = BioticGrasp.damage
  var health = healBonus
}

class BioticOrb(val caster: Hero, val target: Hero, healBonus: Double) extends Ability with Attack with Heal{
  val name = BioticOrb.name
  val cost = BioticOrb.cost
  var damage = BioticOrb.damage
  var health = healBonus
}

class Fade(val caster: Hero, healBonus: Double) extends Ability with Heal {
  val name = Fade.name
  val cost = Fade.cost
  var health = Fade.health + healBonus
}

class Coalescence(val caster: Hero, val target: Hero, healBonus: Double) extends Ability with Attack with Heal{
  val name = Coalescence.name
  val cost = Coalescence.cost
  var damage = Coalescence.damage
  var health = Coalescence.health + healBonus
}


object BioticGrasp {
  val name = "Biotic Grasp"
  val cost = 0.0
  var damage = 5.0

  def apply(caster: Hero, target: Hero, healBonus: Double): Unit = {
    val a = new BioticGrasp(caster, target, healBonus)
    a.minusStamina(caster)
    a.attack(a.damage, target)
    a.heal(a.health, caster)
  }
}

object BioticOrb {
  val name = "Biotic Orb"
  val cost = 10.0
  var damage = 10.0

  def apply(caster: Hero, target: Hero, healBonus: Double): Unit = {
    val a = new BioticOrb(caster, target, healBonus)
    a.minusStamina(caster)
    a.attack(a.damage, target)
    a.heal(a.health, caster)
  }
}

object Fade {
  val name = "Fade"
  val cost = 20.0
  var health = 35.0

  def apply(caster: Hero, healBonus: Double): Unit = {
    val a = new Fade(caster, healBonus)
    a.minusStamina(caster)
    a.heal(a.health, caster)
  }
}

object Coalescence {
  val name = "Coalescence"
  val cost = 30.0
  var damage = 25.0
  var health = 15.0

  def apply(caster: Hero, target: Hero, healBonus: Double): Unit = {
    val a = new Coalescence(caster, target, healBonus)
    a.minusStamina(caster)
    a.attack(a.damage, target)
    a.heal(a.health, caster)
  }
}
