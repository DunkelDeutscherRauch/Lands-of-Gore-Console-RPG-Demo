class Boss(name: String = "The Swamp Witch",
           healthPoints: Int = 1250,
           isEnemyDead: Boolean = false )
    : Enemy(name, healthPoints, isEnemyDead) {

    override val maxHealthPoints: Int = healthPoints

    var bossAttackOne: Int = 35
    var bossAttackTwo: Int = 70
    var bossAttackThree: Int = 105
    var bossAttackFour: Int = 0
    var bossAttackFive: Int = 75
    var bossAttackSix: Int = 0

    var allBossSkills: MutableMap<String, Int> = mutableMapOf(
        "Drowning" to bossAttackOne,
        "Mind Flay" to bossAttackTwo,
        "Sticky Webbing" to bossAttackThree,
        "Swamp Plague" to bossAttackFour,
        "Reign of Chaos" to bossAttackFive,
        "Summon Minion" to bossAttackSix
    )

    var allBossSkillList: MutableList<String> = mutableListOf(
        "Drowning",
        "Mind Flay",
        "Sticky Webbing",
        "",
        "",
        ""
    )

    override fun attackHero(opponent: Hero) {
    if (!isEnemyDead) {
        println("'${this.name}'s turn!")
        println()

        val attack = allBossSkillList.random()
        val attackIndex: Int = allBossSkillList.indexOf(attack)
        val damageDone = allBossSkills.values.elementAt(allBossSkills.keys.indexOf(attack))
        println("'${opponent.name}' has been attacked with ${allBossSkills.keys.elementAt(attackIndex)}!")
        println("'${opponent.name}' receive $damageDone damage!")
        opponent.playerGetsDamage(lostHealth = damageDone)

    }

    }





}