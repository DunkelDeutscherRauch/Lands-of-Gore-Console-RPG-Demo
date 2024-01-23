class Swordmaster(
    isCharDead: Boolean = false
) : Hero(name = "Anduin", healthPoints = 500, armor = 50, isCharDead) {

    override val maxHealthPoints: Int = healthPoints

    private var attackOne: IntRange = (25..50)
    private var attackTwo: IntRange = (35..70)
    private var attackThree: IntRange = (0..0)
    private var attackFour: IntRange = (60..120)


    var allCharSkills: MutableMap<String, IntRange> = mutableMapOf(
        "Pommel Strike" to attackOne,
        "Sword Strike" to attackTwo,
        "Scream of Armored Soul" to attackThree,
        "Rage" to attackFour,
    )

    override fun attackEnemy(opponent: MutableList<Enemy>, hero: MutableList<Hero>, inventory: MutableList<Potion>) {
        var check = true
        while (check) {
            if (!isCharDead) {
                println("It´s your turn '${this.name}'! What do you want to do?")
                println()
                println("To attack with '${allCharSkills.keys.elementAt(0)}'            --> Type in 1")
                println("To attack with '${allCharSkills.keys.elementAt(1)}'             --> Type in 2")
                println("To attack with '${allCharSkills.keys.elementAt(2)}'   --> Type in 3")
                println("To attack with '${allCharSkills.keys.elementAt(3)}'                     --> Type in 4")
                println("To use         'Inventory'                --> Type in 5")
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
                    if (choosenEnemy.isEnemyDead) {
                        opponent.remove(choosenEnemy)
                    }
                    check = false
                } else if (attack == 3) {
                    println()
                    println("'${this.name}' screams loudly: \"WOOOOAAAAAAHHHH!!!\"")
                    for (i in hero) {
                        i.armor += 25
                        println("${i.name}`s armor increases by 25!")
                        println("${i.name} has now ${i.armor}!")
                    }
                    println()
                } else if (attack == 4) {
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
                    if (choosenEnemy.isEnemyDead) {
                        opponent.remove(choosenEnemy)
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
                        val choosenPotion: Potion
                        try {
                            choosePotion = readln().toInt()
                            choosenPotion = inventory.elementAt(choosePotion - 1)
                        } catch (e: Exception) {
                            println("\nWrong input! Try again!\n")
                            continue
                        }
                        println()
                        choosenPotion.usePotion(this)
                        inventory.remove(choosenPotion)
                        check = false
                    } else {
                        println("The inventory is empty! Choose another skill!\n")
                    }
                } else {
                    println("\nWrong input! Try again!")
                }
            }
        }
    }
}

