class Boss(name: String = "The Swamp Witch",
           healthPoints: Int = 1250,
           isEnemyDead: Boolean = false )
    : Enemy(name, healthPoints, isEnemyDead) {

    override val maxHealthPoints: Int = healthPoints

    var bossAttackOne: Int = 35
    var bossAttackTwo: Int = 70
    var bossAttackThree: Int = 105
    var bossAttackFour: Int = 75
    var bossAttackFive: Int = 0
    var bossAttackSix: Int = 0

    var allBossSkills: MutableMap<String, Int> = mutableMapOf(
        "Drowning" to bossAttackOne,
        "Mind Flay" to bossAttackTwo,
        "Sticky Webbing" to bossAttackThree,
        "Reign of Chaos" to bossAttackFour,
        "Swamp Plague" to bossAttackFive,
        "Summon Minion" to bossAttackSix
    )

    var allBossSkillList: MutableList<String> = mutableListOf(
        "Drowning",
        "Mind Flay",
        "Sticky Webbing",
        "Reign of Chaos",
        "",
        ""
    )

    override fun attackHero(opponent: MutableList<Hero>) {
    if (!isEnemyDead) {
        println("'${this.name}'s turn!")
        println()

        val attack = allBossSkillList.random()
        val attackIndex: Int = allBossSkillList.indexOf(attack)
        if (attackIndex in 0..2) {
            val attackedHero = opponent.random()
            val attackDamage = allBossSkills.values.elementAt(allBossSkills.keys.indexOf(attack))
            val damageDone = attackDamage - attackedHero.armor
            if (damageDone > 0) {
            println("'${attackedHero.name}' has been attacked with ${allBossSkills.keys.elementAt(attackIndex)}!")
            println("'${attackedHero.name}' receive $damageDone damage!")
            attackedHero.playerGetsDamage(lostHealth = damageDone,opponent)
            } else {
                println("'${attackedHero.name}' has been attacked with ${allBossSkills.keys.elementAt(attackIndex)}!")
                println("'${attackedHero.name}' receive 0 damage!")
                attackedHero.playerGetsDamage(lostHealth = 0,opponent)
            }
        } else if (attackIndex == 3) {
            for (i in opponent) {
                val damageDone = allBossSkills.values.elementAt(allBossSkills.keys.indexOf(attack)) - i.armor
                println("'${i.name}' has been attacked with ${allBossSkills.keys.elementAt(attackIndex)}!")
                println("'${i.name}' receive $damageDone damage!")
                i.playerGetsDamage(lostHealth = damageDone,opponent)
            }
        }

    }

    }





}