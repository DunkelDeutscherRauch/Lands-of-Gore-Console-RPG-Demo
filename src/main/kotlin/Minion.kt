class Minion(isEnemyDead: Boolean = false)
    : Enemy(name = "Ciórdan", healthPoints = 250, isEnemyDead) {

    override val maxHealthPoints: Int = healthPoints

    var minionAttackOne: IntRange = (15..30)
    var minionAttackTwo: IntRange = (25..50)
    var minionAttackThree: IntRange = (35..70)
    var minionAttackFour: IntRange = (45..90)

    var allMinionSkills: MutableMap<String, IntRange> = mutableMapOf(
        "" to minionAttackOne,
        "" to minionAttackTwo,
        "" to minionAttackThree,
        "" to minionAttackFour
    )



    override fun attackHero(opponent: MutableList<Hero>) {
        println("Placeholder")

    }



}