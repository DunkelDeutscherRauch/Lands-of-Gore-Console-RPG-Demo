fun main() {

    var enemy1 = Minion()
    var enemy2 = Minion("Undead Dude")
    var sorc1 = Enchantress("Wilde Hilde")

    var enemyList: MutableList<Enemy> = mutableListOf(enemy1,enemy2)

    repeat(5) {
    sorc1.attackEnemy(enemyList)
    }


}
