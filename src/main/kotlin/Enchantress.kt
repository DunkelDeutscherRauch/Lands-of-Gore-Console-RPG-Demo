class Enchantress(
    name: String = "",
    healthPoints: Int = 250,
    manaPoints: Int = 100,
    armor: Int = 0,
    isCharDead: Boolean = false
) : Hero(name, healthPoints, armor, isCharDead) {

    override val maxHealthPoints: Int = healthPoints

    var attackOne: IntRange = (1..10)
    var attackTwo: IntRange = (50..100)
    var attackThree: IntRange = (75..150)
    var attackFour: IntRange = (50..100)
    var attackFive: IntRange = (750..750)


    var allCharSkills: MutableMap<String, IntRange> = mutableMapOf(
        "Oak Stuff" to attackOne,
        "Arcane Missiles" to attackTwo,
        "Firebold" to attackThree,
        "Drop of Essence" to attackFour,
        "Vanishing Sea of Fire" to attackFive,

        )

    override fun attackEnemy(opponent: MutableList<Enemy>, hero: MutableList<Hero>, inventory: MutableList<Potion>) {
        var check = true
        while (check) {
            if (!isCharDead) {
                println("It´s your turn '${this.name}'! What do you want to do?")
                println()
                println("To attack with '${allCharSkills.keys.elementAt(0)}'               --> Type in 1")
                println("To attack with '${allCharSkills.keys.elementAt(1)}'         --> Type in 2")
                println("To attack with '${allCharSkills.keys.elementAt(2)}'                --> Type in 3")
                println("To attack with '${allCharSkills.keys.elementAt(3)}'         --> Type in 4")
                println("To attack with '${allCharSkills.keys.elementAt(4)}'   --> Type in 5")
                println("To use         'Inventory'               --> Type in 6")
                println()

                print("Input: ")
                val attack: Int = readln().toInt()

                if ((attack >= 1) && (attack <= 3)) {
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
                    val healAmount: Int = damageDone
                    println(
                        "You attack '${choosenEnemy.name}' with " +
                                "'${allCharSkills.keys.elementAt(attack - 1)}'!"
                    )
                    println("'${choosenEnemy.name}' receive $damageDone damage!")
                    val newHealthPoints: Int = healthPoints + healAmount
                    if (newHealthPoints >= maxHealthPoints) {
                        healthPoints = maxHealthPoints
                        println(
                            "'${this.name}' receives healing equal to " +
                                    "${(maxHealthPoints - newHealthPoints) + healAmount} HP!"
                        )
                    } else {
                        healthPoints += healAmount
                        println("'${this.name}' receives healing equal to $healAmount HP!")
                    }
                    println("'${this.name}' currently has $healthPoints/$maxHealthPoints HP!")
                    choosenEnemy.enemyGetsDamage(lostHealth = damageDone)
                    check = false
                } else if (attack == 5) {
                    println(
                        "\n'${this.name}' begins to whisper: \"From the ashes of the past. " +
                                "Fire rises at it´s last.\""
                    )
                    Thread.sleep(2500)
                    println("'${this.name}' eyes turn from blue to red...")
                    Thread.sleep(1750)
                    println("\"Flames are dancing in my heart. Ripping my Soul apart.\"")
                    Thread.sleep(2500)
                    println("'${this.name}' begin to levitate...")
                    Thread.sleep(1750)
                    println("\"I am burning deep inside. Ignite the light in an endless night.\"")
                    Thread.sleep(2500)
                    println("Flames surround '${this.name}'´s body...")
                    Thread.sleep(1750)
                    println("\"Feel the pain, feel the desire.\"")
                    Thread.sleep(2500)
                    println("\"ALL EVIL SHALL BURN IN A VANISHING SEA OF FIRE!\"\n")
                    Thread.sleep(2500)
                    for (i in opponent) {
                        val damageDone: Int = allCharSkills.values.elementAt(attack - 1).random()
                        println("${i.name} receive $damageDone damage!")
                        i.enemyGetsDamage(lostHealth = damageDone)
                    }
                    println()
                    check = false
                } else if (attack == 6) {
                    println("\nWhich potion do you want to use?\n")
                    if (inventory.isNotEmpty()) {
                        for (i in inventory) {
                            println("Type ${inventory.indexOf(i) + 1} for ${i.name} - ${i.description}")
                        }
                        println()
                        print("Input: ")
                        val choosePotion: Int = readln().toInt()
                        println()
                        val choosenPotion = inventory.elementAt(choosePotion - 1)
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

