class Swordmaster(name: String = "",
                  healthPoints: Int = 500,
                  armor: Int = 125,
                  isCharDead: Boolean = false)
    : Hero(name, healthPoints, armor, isCharDead) {

        override val maxHealthPoints: Int = healthPoints

    var attackOne: IntRange = (0..0)
    var attackTwo: IntRange = (0..0)
    var attackThree: IntRange = (0..0)
    var attackFour: IntRange = (0..0)
    var healingItem: IntRange = (0..0)

    var allCharSkills: MutableMap<String, IntRange> = mutableMapOf(
        "Pommel Strike" to attackOne,
        "Sword Strike" to attackTwo,
        "Scream of armored Soul" to attackThree,
        "Rage" to attackFour,
        "Elixir" to healingItem
    )

    override fun attackEnemy(opponent: MutableList<Enemy>) {
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
        }
    }




}