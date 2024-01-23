var sorc = Enchantress()
var hunt = Ranger()
var war = Swordmaster()
var boss = Boss()

var enemyList: MutableList<Enemy> = mutableListOf(boss)
var heroList: MutableList<Hero> = mutableListOf(war, hunt, sorc)
var inventory: MutableList<Potion> = mutableListOf(
    Potion("Elixir", 50),
    Potion("Elixir", 50),
    Potion("Elixir", 50),
    Potion("Elixir", 50),
    Potion("Elixir", 50)
)

fun main() {

   // intro()
    fightloop()
    //outro()
}


