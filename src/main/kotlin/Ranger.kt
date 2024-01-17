class Ranger(
    name: String = "",
    healthPoints: Int = 375,
    armor: Int = 50,
    isCharDead: Boolean = false
) : Hero(name, healthPoints, armor, isCharDead) {

    override val maxHealthPoints: Int = healthPoints

    var attackOne: IntRange = (15..30)
    var attackTwo: IntRange = (35..70)
    var attackThree: IntRange = (15..30)
    var attackFour: IntRange = (25..50)
    var healingItem: IntRange = (50..50)

    var allCharSkills: MutableMap<String, IntRange> = mutableMapOf(
        "Axe Strike" to attackOne,
        "Aimed Shot" to attackTwo,
        "Multishot" to attackThree,
        "Rain of Arrows" to attackFour,
        "Elixir" to healingItem
    )

    override fun attackEnemy(opponent: MutableList<Enemy>) {
        var check = true
        while (check) {
            if (!isCharDead) {
                println("It´s your turn '${this.name}'! What do you want to do?")
                println()
                println("To attack with '${allCharSkills.keys.elementAt(0)}'       --> Type in 1")
                println("To attack with '${allCharSkills.keys.elementAt(1)}'       --> Type in 2")
                println("To attack with '${allCharSkills.keys.elementAt(2)}'        --> Type in 3")
                println("To attack with '${allCharSkills.keys.elementAt(3)}'   --> Type in 4")
                println("To use         '${allCharSkills.keys.elementAt(4)}'           --> Type in 5")
                println()

                print("Input: ")
                val attack: Int = readln().toInt()

                if ((attack >= 1) && (attack <= 2)) {
                    println("\nWhich enemy do you want to attack?\n")
                    for (i in opponent) {
                        println("Type ${opponent.indexOf(i) + 1} for ${i.name}")
                    }
                    println()
                    print("Input: ")
                    val chooseEnemy: Int = readln().toInt()
                    println()
                    val choosenEnemy = opponent.elementAt(chooseEnemy - 1)
                    val damageDone: Int = allCharSkills.values.elementAt(attack - 1).random()
                    println(
                        "You attack '${choosenEnemy.name}' with " +
                                "'${allCharSkills.keys.elementAt(attack - 1)}'!"
                    )
                    println("'${choosenEnemy.name}' receive $damageDone damage!")
                    choosenEnemy.enemyGetsDamage(lostHealth = damageDone)
                    check = false
                } else if (attack == 3) {
                    println("\nWhich enemy do you want to attack?\n")
                    for (i in opponent) {
                        println("Type ${opponent.indexOf(i) + 1} for ${i.name}")
                    }
                    println()
                    print("Input: ")
                    val chooseEnemy: Int = readln().toInt()
                    println()
                     val choosenEnemy = opponent.elementAt(chooseEnemy - 1)
                    val damageDoneSingle1: Int = allCharSkills.values.elementAt(attack - 1).random()
                    val damageDoneSingle2: Int = allCharSkills.values.elementAt(attack - 1).random()
                    val damageDoneSingle3: Int = allCharSkills.values.elementAt(attack - 1).random()
                    val damageDoneFinal: Int = damageDoneSingle1 + damageDoneSingle2 + damageDoneSingle3
                    println(
                        "You attack '${choosenEnemy.name}' with " +
                                "'${allCharSkills.keys.elementAt(attack - 1)}'!"
                    )
                    println("'${choosenEnemy.name}' receive $damageDoneSingle1 damage!")
                    println("'${choosenEnemy.name}' receive $damageDoneSingle2 damage!")
                    println("'${choosenEnemy.name}' receive $damageDoneSingle3 damage!")
                    println("You hit your enemy with three arrows. So your enemy " +
                            "receive a total damage of $damageDoneFinal!")
                    choosenEnemy.enemyGetsDamage(lostHealth = damageDoneFinal)
                    check = false
                } else if (attack == 4) {
                    println()
                    for (i in opponent) {
                        val damageDone: Int = allCharSkills.values.elementAt(attack - 1).random()
                        println("${i.name} receive $damageDone damage!")
                        i.enemyGetsDamage(lostHealth = damageDone)
                    }
                    check = false
                } else if (attack == 5) {
                    val healAmount: Int = allCharSkills.values.elementAt(attack - 1).random()
                    val newHealthPoints: Int = healthPoints + healAmount
                    if (newHealthPoints >= maxHealthPoints) {
                        healthPoints = maxHealthPoints
                        println("\n'${this.name}' uses an '${allCharSkills.keys.elementAt(attack - 1)}'!")
                        println("'${this.name}' recives healing equal to ${(maxHealthPoints- newHealthPoints) + healAmount} HP!")
                        println("'${this.name}' currently has $healthPoints/$maxHealthPoints HP!\n")
                    } else {
                        healthPoints += healAmount
                        println("\n'${this.name}' uses an '${allCharSkills.keys.elementAt(attack - 1)}'!")
                        println("'${this.name}' recives healing equal to $healAmount HP!")
                        println("'${this.name}' currently has $healthPoints/$maxHealthPoints HP!\n")
                    }
                    check = false
                } else {
                    println("\nWrong input! Try again!")
                }
            }

        }

    }
}