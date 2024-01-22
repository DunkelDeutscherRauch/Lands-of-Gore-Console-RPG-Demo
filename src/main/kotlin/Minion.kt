class Minion(name: String = "Undead Druid",
             healthPoints: Int = 250,
             isEnemyDead: Boolean = false )
    : Enemy(name, healthPoints, isEnemyDead) {

    override val maxHealthPoints: Int = healthPoints

    override fun attackHero(opponent: MutableList<Hero>) {

    }



}