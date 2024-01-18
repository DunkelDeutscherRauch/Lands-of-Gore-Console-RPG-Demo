open class Hero(var name: String, var healthPoints: Int, var armor: Int = 0, var isCharDead: Boolean) {

    open val maxHealthPoints: Int = healthPoints

    open fun attackEnemy(opponent: MutableList<Enemy>, hero: MutableList<Hero>) {
        println("Placeholder")
    }


    fun playerGetsDamage (lostHealth: Int) {
        healthPoints -= lostHealth
        if (healthPoints <= 0) {
            isCharDead = true
            println()
            println("'${this.name}' IS DEAD!")
        } else {
            println("'${this.name}' has ${this.healthPoints/this.maxHealthPoints} HP left!")
            println()
        }
    }

}