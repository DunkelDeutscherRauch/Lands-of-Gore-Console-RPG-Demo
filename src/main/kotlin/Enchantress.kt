class Enchantress(name: String = "",
                  healthPoints: Int = 250,
                  armor: Int,
                  isCharDead: Boolean)
    : Hero(name, healthPoints, armor, isCharDead) {

    var attackOne: IntRange = (0..0)
    var defenseSpell: Int = 0
    var attackTwo: IntRange = (0..0)
    var attackThree: IntRange = (0..0)
    var attackFour: Int = 0
    var healingItem: Int = 0


}