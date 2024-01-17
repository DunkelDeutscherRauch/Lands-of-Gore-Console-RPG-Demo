class Boss(name: String = "The Swamp Witch",
           healthPoints: Int = 1250,
           isEnemyDead: Boolean = false )
    : Enemy(name, healthPoints, isEnemyDead) {

    override val maxHealthPoints: Int = healthPoints






}