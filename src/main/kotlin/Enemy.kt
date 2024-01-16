open class Enemy(var name: String, var healthPoints: Int, var isEnemyDead: Boolean = false) {

    open fun attackHero(opponent: Hero) {
        println("Placeholder")
    }

    fun enemyGetsDamage (lostHealth: Int) {
        healthPoints -= lostHealth
        if (healthPoints <= 0) {
            isEnemyDead = true
            println()
            println("YOU KILLED '${this.name}'!")
        } else {
            println("'${this.name}' has ${this.healthPoints} left!")
            println()
        }
    }

}