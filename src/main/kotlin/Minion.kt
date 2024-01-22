class Minion(isEnemyDead: Boolean = false)
    : Enemy(name = "Ciórdan", healthPoints = 250, isEnemyDead) {

    override val maxHealthPoints: Int = healthPoints



    override fun attackHero(opponent: MutableList<Hero>) {
        println("Placeholder")

    }



}