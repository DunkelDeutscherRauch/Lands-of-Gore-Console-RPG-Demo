import kotlin.math.roundToInt

class Boss(isEnemyDead: Boolean = false) : Enemy(name = "Mistress of the Swamp", healthPoints = 1250, isEnemyDead) {

    override val maxHealthPoints: Int = healthPoints

    var minion = Minion()
    var isMinionSummoned = false
    var bossAttackOne: Int = 50
    var bossAttackTwo: Int = 75
    var bossAttackThree: Int = 100
    var bossAttackFour: Int = 75
    var bossAttackFive: Int = 0
    var raisedDamage: Int = 0


    var allBossSkills: MutableMap<String, Int> = mutableMapOf(
        "Drowning" to bossAttackOne,
        "Mind Flay" to bossAttackTwo,
        "Mind Blast" to bossAttackThree,
        "Reign of Chaos" to bossAttackFour,
        "Power of Unholy Decay" to bossAttackFive,
    )

    var allBossSkillList: MutableList<String> = mutableListOf(
        "Drowning",
        "Mind Flay",
        "Mind Blast",
        "Reign of Chaos",
        "Power of Unholy Decay",
    )

    override fun attackHero(opponent: MutableList<Hero>, enemy: MutableList<Enemy>) {
        if (!isEnemyDead) {
            println("'${this.name}'´s turn!")
            println()

            val attack = allBossSkillList.random()
            val attackIndex: Int = allBossSkillList.indexOf(attack)
            if (attackIndex in 0..2) {
                val attackedHero = opponent.random()
                val attackDamage = allBossSkills.values.elementAt(allBossSkills.keys.indexOf(attack))
                val damageDone = (attackDamage + raisedDamage) - attackedHero.armor
                if (damageDone > 0) {
                    println(
                        "'${attackedHero.name}' has been attacked with " +
                                "${allBossSkills.keys.elementAt(attackIndex)}!"
                    )
                    println("'${attackedHero.name}' receive $damageDone damage!")
                    attackedHero.playerGetsDamage(lostHealth = damageDone)
                } else {
                    println(
                        "'${attackedHero.name}' has been attacked with " +
                                "${allBossSkills.keys.elementAt(attackIndex)}!"
                    )
                    println("'${attackedHero.name}' receive 0 damage!")
                    attackedHero.playerGetsDamage(lostHealth = 0)
                }
                if (attackedHero.isCharDead) {
                    opponent.remove(attackedHero)
                }
            } else if (attackIndex == 3) {
                for (i in opponent) {
                    val attackDamage = allBossSkills.values.elementAt(allBossSkills.keys.indexOf(attack))
                    val damageDone = (attackDamage + raisedDamage) - i.armor
                    if (damageDone > 0) {
                        println("'${i.name}' has been attacked with ${allBossSkills.keys.elementAt(attackIndex)}!")
                        println("'${i.name}' receive $damageDone damage!")
                        i.playerGetsDamage(lostHealth = damageDone)
                    } else {
                        println("'${i.name}' has been attacked with ${allBossSkills.keys.elementAt(attackIndex)}!")
                        println("'${i.name}' receive 0 damage!")
                        i.playerGetsDamage(lostHealth = 0)
                    }
                }
                val iterator = heroList.iterator()
                for (i in iterator) {
                    if (i.isCharDead) {
                        iterator.remove()
                    }
                }
            } else if (attackIndex == 4) {
                println("'${this.name}' gain power and get´s stronger! But '${this.name}' also loose 50 HP!")
                raisedDamage += 25
                this.enemyGetsDamage(lostHealth = 50)
            }
            if (this.isEnemyDead) {
                enemy.remove(boss)
            }
        }
    }

    fun summon(minion: Minion, enemyList: MutableList<Enemy>) {
        enemyList.add(minion)
        this.isMinionSummoned = true
    }
}