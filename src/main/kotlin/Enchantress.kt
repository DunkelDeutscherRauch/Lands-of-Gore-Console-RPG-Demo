class Enchantress(
    name: String = "",
    healthPoints: Int = 250,
    manaPoints: Int = 100,
    armor: Int = 0,
    isCharDead: Boolean = false
) : Hero(name, healthPoints, armor, isCharDead) {

    var attackOne: IntRange = (1..10)
    var attackTwo: IntRange = (50..100)
    var attackThree: IntRange = (75..150)
    var attackFour: IntRange = (250..500)
    var defenseSpell: IntRange = (0..0)
    var healingItem: IntRange = (0..0)

    var allCharSkills: MutableMap<String, IntRange> = mutableMapOf(
        "Oak Stuff" to attackOne,
        "Arcane Missiles" to attackTwo,
        "Firebold" to attackThree,
        "Vanishing Sea of Fire" to attackFour,
        "Arcane Barrier" to defenseSpell,
        "Elixir" to healingItem
    )

    override fun attackEnemy(opponent: MutableList<Enemy>) {
        var check = true
        while (check) {
            if (!isCharDead) {
                println("It´s your turn '${this.name}'! What do you want to do?")
                println()
                println("To attack with '${allCharSkills.keys.elementAt(0)}'               --> Type in 1")
                println("To attack with '${allCharSkills.keys.elementAt(1)}'         --> Type in 2")
                println("To attack with '${allCharSkills.keys.elementAt(2)}'                --> Type in 3")
                println("To attack with '${allCharSkills.keys.elementAt(3)}'   --> Type in 4")
                println("To affect      '${allCharSkills.keys.elementAt(4)}'          --> Type in 5")
                println("To use         '${allCharSkills.keys.elementAt(5)}'                  --> Type in 6")
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
                } else if ((attack >= 4) && (attack <= 6)) {
                    println("\nThis skill has no effect yet, please try another one!")
                    check = false
                } else {
                    println("\nWrong input! Try again!")
                }
            }
        }

    }

}