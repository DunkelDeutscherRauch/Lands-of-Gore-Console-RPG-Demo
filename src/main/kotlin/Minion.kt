/**
 * daughter of class Enemy
 * @see Enemy
 **/
class Minion(isEnemyDead: Boolean = false) : Enemy(name = "Ciórdan", healthPoints = 625, isEnemyDead) {

    override val maxHealthPoints: Int = healthPoints

    private var minionAttackOne: IntRange = (15..30)
    private var minionAttackTwo: IntRange = (25..50)
    private var minionAttackThree: IntRange = (35..70)
    private var minionAttackFour: IntRange = (45..90)

    private var allMinionSkills: MutableMap<String, IntRange> = mutableMapOf(
        "Wind Fury" to minionAttackOne,
        "Wrath of Nature" to minionAttackTwo,
        "Unholy Thorny Vine" to minionAttackThree,
        "Broken Earth" to minionAttackFour
    )

    private val listOfAllMinionAttacks: MutableList<String> = mutableListOf(
        "Wind Fury",
        "Wrath of Nature",
        "Unholy Thorny Vine",
        "Broken Earth"
    )

    override fun attackHero(opponent: MutableList<Hero>, enemy: MutableList<Enemy>) {
        if (!isEnemyDead && boss.isMinionSummoned) {
            println("'${this.name}'´s turn!")
            println()

            val attackedHero = opponent.random()
            val attack = listOfAllMinionAttacks.random()
            val attackIndex: Int = listOfAllMinionAttacks.indexOf(attack)
            val damageDone = allMinionSkills.values.elementAt(allMinionSkills.keys.indexOf(attack)).random()
            println("'${attackedHero.name}' has been attacked with '${allMinionSkills.keys.elementAt(attackIndex)}'!")
            println("'${attackedHero.name}' receive $damageDone damage!")
            attackedHero.playerGetsDamage(lostHealth = damageDone)
            if (attackedHero.isCharDead) {
                opponent.remove(attackedHero)
            }
        }


    }
}