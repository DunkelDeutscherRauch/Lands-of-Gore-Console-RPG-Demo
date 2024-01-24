/**
 * motherclass of all heroes
 * @constructor name, healthPoints, armor, isCharDead
 **/
open class Hero(var name: String, var healthPoints: Int, var armor: Int = 0, var isCharDead: Boolean) {

    open val maxHealthPoints: Int = healthPoints

    /**
     * function for attacking an enemy
     * @param opponent a mutable list of enemy´s with the datatype Enemy
     * @param hero a mutable list of heroes with the datatype Hero
     * @param inventory a mutable list of potions with the datatype Potion
     * @see Potion
     * @see Enemy
     * @see Hero
     **/
    open fun attackEnemy(opponent: MutableList<Enemy>, hero: MutableList<Hero>, inventory: MutableList<Potion>) {
        println("Placeholder")
    }

    /**
     * damage calculation function relating to heroes
     * also checks if a hero died
     * @param lostHealth comes from calculation in the 'attackEnemy' function
     * @see attackEnemy
     **/
    fun playerGetsDamage(lostHealth: Int) {
        this.healthPoints -= lostHealth
        if (healthPoints <= 0) {
            isCharDead = true
            println()
            println("'${this.name}' IS DEAD!")
            println()
        } else {
            println("'${this.name}' has ${this.healthPoints}/${this.maxHealthPoints} HP left!")
            println()
        }
    }

}