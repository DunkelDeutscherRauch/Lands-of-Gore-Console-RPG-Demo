class Ranger(
    isCharDead: Boolean = false
) : Hero(name = "Nathanos", healthPoints = 375, armor = 25, isCharDead) {

    override val maxHealthPoints: Int = healthPoints

    private var attackOne: IntRange = (15..30)
    private var attackTwo: IntRange = (35..70)
    private var attackThree: IntRange = (15..30)
    private var attackFour: IntRange = (25..50)


    var allCharSkills: MutableMap<String, IntRange> = mutableMapOf(
        "Axe Strike" to attackOne,
        "Aimed Shot" to attackTwo,
        "Multishot" to attackThree,
        "Rain of Arrows" to attackFour,
    )

    override fun attackEnemy(opponent: MutableList<Enemy>, hero: MutableList<Hero>, inventory: MutableList<Potion>) {
        var check = true
        while (check) {

            println("It´s your turn '${this.name}'! What do you want to do?")
            println()
            println("To attack with '${allCharSkills.keys.elementAt(0)}'       --> Type in 1")
            println("To attack with '${allCharSkills.keys.elementAt(1)}'       --> Type in 2")
            println("To attack with '${allCharSkills.keys.elementAt(2)}'        --> Type in 3")
            println("To attack with '${allCharSkills.keys.elementAt(3)}'   --> Type in 4")
            println("To use         'Inventory'        --> Type in 5")
            println()

            print("Input: ")
            val attack: Int
            try {
                attack = readln().toInt()
            } catch (e: Exception) {
                println("\nWrong input! Try again!\n")
                continue
            }
            if ((attack >= 1) && (attack <= 2)) {
                println("\nWhich enemy do you want to attack?\n")
                for (i in opponent) {
                    println("Type ${opponent.indexOf(i) + 1} for ${i.name}")
                }
                println()
                print("Input: ")
                val chooseEnemy: Int
                try {
                    chooseEnemy = readln().toInt()
                } catch (e: Exception) {
                    println("\nWrong input! Try again!\n")
                    continue
                }
                println()
                val choosenEnemy = opponent.elementAt(chooseEnemy - 1)
                val damageDone: Int = allCharSkills.values.elementAt(attack - 1).random()
                println(
                    "You attack '${choosenEnemy.name}' with " +
                            "'${allCharSkills.keys.elementAt(attack - 1)}'!"
                )
                println("'${choosenEnemy.name}' receive $damageDone damage!")
                choosenEnemy.enemyGetsDamage(lostHealth = damageDone)
                if (choosenEnemy.isEnemyDead) {
                    opponent.remove(choosenEnemy)
                }
                check = false
            } else if (attack == 3) {
                println("\nWhich enemy do you want to attack?\n")
                for (i in opponent) {
                    println("Type ${opponent.indexOf(i) + 1} for ${i.name}")
                }
                println()
                print("Input: ")
                val chooseEnemy: Int
                try {
                    chooseEnemy = readln().toInt()
                } catch (e: Exception) {
                    println("\nWrong input! Try again!\n")
                    continue
                }
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
                println(
                    "You hit your enemy with three arrows. So your enemy " +
                            "receive a total damage of $damageDoneFinal!"
                )
                choosenEnemy.enemyGetsDamage(lostHealth = damageDoneFinal)
                if (choosenEnemy.isEnemyDead) {
                    opponent.remove(choosenEnemy)
                }
                check = false
            } else if (attack == 4) {
                println()
                for (i in opponent) {
                    val damageDone: Int = allCharSkills.values.elementAt(attack - 1).random()
                    println("${i.name} receive $damageDone damage!")
                    i.enemyGetsDamage(lostHealth = damageDone)
                }
                val iterator = enemyList.iterator()
                for (i in iterator) {
                    if (i.isEnemyDead) {
                        iterator.remove()
                    }
                }
                check = false
            } else if (attack == 5) {
                println("\nWhich potion do you want to use?\n")
                if (inventory.isNotEmpty()) {
                    for (i in inventory) {
                        println("Type ${inventory.indexOf(i) + 1} for ${i.name} - ${i.description}")
                    }
                    println()
                    print("Input: ")
                    val choosePotion: Int
                    try {
                        choosePotion = readln().toInt()
                    } catch (e: Exception) {
                        println("\nWrong input! Try again!\n")
                        continue
                    }
                    println()
                    val choosenPotion = inventory.elementAt(choosePotion - 1)
                    choosenPotion.usePotion(this)
                    inventory.remove(choosenPotion)
                    check = false
                } else {
                    println("The inventory is empty! Choose another skill!\n")
                }
            } else {
                println("\nWrong input! Try again!\n")

            }
        }

    }

}
