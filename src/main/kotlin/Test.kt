fun main() {

    // !!!Only for testing Stuff!!!

    var enemy1 = Minion()
    var enemy2 = Minion("Undead Dude")
    var sorc1 = Enchantress("Bezauberndes Mädel")
    var hunt1 = Ranger("Jägermeister")

    var enemyList: MutableList<Enemy> = mutableListOf(enemy1, enemy2)

    repeat(5) {
        //sorc1.attackEnemy(enemyList)
        //enemy1.attackHero(sorc1)
        hunt1.attackEnemy(enemyList)
        //enemy2.attackHero(sorc1)
    }


}
