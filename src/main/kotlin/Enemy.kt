/**
 * motherclass of all enemy´s
 * @constructor name, healthPoints, isEnemyDead
 **/
open class Enemy(var name: String, var healthPoints: Int, var isEnemyDead: Boolean) {

    open val maxHealthPoints: Int = healthPoints

    /**
     * function for attacking a hero
     * @param opponent a mutable list of heroes with the datatype Hero
     * @param enemy a mutable list of enemy´s with the datatype Enemy
     * @see Enemy
     * @see Hero
     **/
    open fun attackHero(opponent: MutableList<Hero>, enemy: MutableList<Enemy>) {
        println("Placeholder")
    }

    /**
     * damage calculation function relating to enemy´s
     * also checks if an enemy died
     * @param lostHealth comes from calculation in the 'attackHero' function
     * @see attackHero
     **/
    fun enemyGetsDamage(lostHealth: Int) {
        healthPoints -= lostHealth
        if (healthPoints <= 0) {
            isEnemyDead = true
            println()
            println("YOU KILLED '${this.name}'!")
            println()
        } else {
            println("'${this.name}' has ${this.healthPoints}/${this.maxHealthPoints} HP left!")
            println()
        }
    }

}