import ANSI.red
import ANSI.reset

class Minion(isEnemyDead: Boolean = false) : Enemy(name = "Ciórdan", healthPoints = 625, isEnemyDead) {

    override val maxHealthPoints: Int = healthPoints

    var minionAttackOne: IntRange = (15..30)
    var minionAttackTwo: IntRange = (25..50)
    var minionAttackThree: IntRange = (35..70)
    var minionAttackFour: IntRange = (45..90)

    var allMinionSkills: MutableMap<String, IntRange> = mutableMapOf(
        "Wind Fury" to minionAttackOne,
        "Wrath of Nature" to minionAttackTwo,
        "Thorny Vine" to minionAttackThree,
        "Broken Earth" to minionAttackFour
    )

    val listOfAllMinionAttacks: MutableList<String> = mutableListOf(
        "Wind Fury",
        "Wrath of Nature",
        "Thorny Vine",
        "Broken Earth"
    )


    override fun attackHero(opponent: MutableList<Hero>) {
        if (boss.isMinionSummoned) {
            println("'${this.name}'´s turn!")
            println()

            val attackedHero = opponent.random()
            val attack = listOfAllMinionAttacks.random()
            val attackIndex: Int = listOfAllMinionAttacks.indexOf(attack)
            val damageDone = allMinionSkills.values.elementAt(allMinionSkills.keys.indexOf(attack)).random()
            println("'${attackedHero.name}' has been attacked with '${allMinionSkills.keys.elementAt(attackIndex)}!")
            println("'${attackedHero.name}' receive $damageDone damage!")
            attackedHero.playerGetsDamage(lostHealth = damageDone)
            if (attackedHero.isCharDead) {
                opponent.remove(attackedHero)
            }
        }


    }
}