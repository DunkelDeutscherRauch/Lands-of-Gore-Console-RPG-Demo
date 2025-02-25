/**
 * independent class for creating potions
 * @constructor name, amount, description
 **/
class Potion(val name: String, amount: Int, var description: String = "Heals $amount HP") {

    private var amountOfPotion: Int = amount

    /**
     * function for using a potion, calculates the healing amount
     * is used in the 'attackEnemy' function
     * @param hero equals the choosen hero
     **/
    fun usePotion(hero: Hero) {
        println("'${hero.name}' uses an '${this.name}'!")
        val healAmount: Int = this.amountOfPotion
        val newHealthPoints: Int = hero.healthPoints + healAmount
        if (newHealthPoints >= hero.maxHealthPoints) {
            hero.healthPoints = hero.maxHealthPoints

            println(
                "'${this.name}' receives healing equal to " +
                        "${(hero.maxHealthPoints - newHealthPoints) + healAmount} HP!"
            )
        } else {
            hero.healthPoints += healAmount
            println("'${hero.name}' receives healing equal to $healAmount HP!")
        }
        println("'${hero.name}' currently has ${hero.healthPoints}/${hero.maxHealthPoints} HP!\n")
    }

}