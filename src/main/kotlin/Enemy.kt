open class Enemy(var name: String, var healthPoints: Int, var isEnemyDead: Boolean) {

   open val maxHealthPoints: Int = healthPoints

    open fun attackHero(opponent: Hero) {
        println("Placeholder")
    }

    fun enemyGetsDamage (lostHealth: Int) {
        healthPoints -= lostHealth
        if (healthPoints <= 0) {
            isEnemyDead = true
            println("YOU KILLED '${this.name}'!")
        } else {
            println("'${this.name}' has ${this.healthPoints}/${this.maxHealthPoints} HP left!")
        }
        println()
    }

}