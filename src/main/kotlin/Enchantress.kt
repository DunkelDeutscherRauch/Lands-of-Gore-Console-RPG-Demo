class Enchantress(name: String = "",
                  healthPoints: Int = 250,
                  manaPoints: Int = 100,
                  armor: Int = 0,
                  isCharDead: Boolean = false)
    : Hero(name, healthPoints, armor, isCharDead) {

    var attackOne: IntRange = (0..0)
    var attackTwo: IntRange = (0..0)
    var attackThree: IntRange = (0..0)
    var attackFour: IntRange = (0..0)
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

            val attack: Int = readln().toInt()

            if ((attack >= 1) && (attack <= 3))
            println("Which enemy do you want to attack?")

            var chooseEnemy: Int = readln().toInt()
            var choosenEnemy = opponent.elementAt(chooseEnemy - 1)
            val damageDone: Int = allCharSkills.values.elementAt(attack - 1).random()
            println("You have attackt '${choosenEnemy.name}' with '${allCharSkills.keys.elementAt(attack - 1)}'!")
            println("'${choosenEnemy.name}' received $damageDone damage!")
            choosenEnemy.enemyGetsDamage(lostHealth = damageDone)









        }

    }










    }