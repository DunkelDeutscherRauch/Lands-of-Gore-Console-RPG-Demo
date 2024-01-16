class Minion(name: String = "Undead Druid",
             healthPoints: Int = 250,
             isEnemyDead: Boolean = false )
    : Enemy(name, healthPoints, isEnemyDead) {

    override fun attackHero(opponent: Hero) {
        println("${this.name} can not attack yet. So your enemy is harmless.\n")
    }



}