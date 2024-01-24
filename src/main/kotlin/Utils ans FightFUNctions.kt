import ANSI.*

/**
 * includes the combat sequence
 * is looped in the 'fightloop' function
 * @param enemy a mutable list of enemy´s with the datatype Enemy
 * @param hero a mutable list of heroes with the datatype Hero
 * @param inventory a mutable list of potions with the datatype Potion
 * @see Hero
 * @see Enemy
 * @see Potion
 * @see fightloop
 **/
fun fight(enemy: MutableList<Enemy>,hero: MutableList<Hero>, inventory: MutableList<Potion>) {
    for (fighter in hero) {
        if (!boss.isEnemyDead || !boss.minion.isEnemyDead) {
            fighter.attackEnemy(enemyList, heroList, inventory)
        } else {
            break
        }
    }

    if (boss.healthPoints <= 625 && !boss.isMinionSummoned) {
        boss.summon(boss.minion, enemyList)
        println("'${boss.name}': \"You infantile mortals are getting on my nerves!\"")
        Thread.sleep(2500)
        println("'${boss.name}': \"Your Mistress is calling you, my beloved minion!\"")
        Thread.sleep(2500)
        println("'${boss.name}': \"${boss.minion.name}...RISE!\"")
        Thread.sleep(2500)
        println("'${boss.minion.name}': \"Your wish is my desire Mistress!\"")
        Thread.sleep(2500)
        println("'${boss.minion.name}' appears on the battlefield!")
        println()
        Thread.sleep(1750)
    } else {
        boss.attackHero(heroList, enemyList)
    }
    boss.minion.attackHero(heroList, enemyList)
}

/**
 * just contains the into
 **/
fun intro() {
    println()
    println(
        "This is pre-Alpha footage an can contain bugs, errors, exceptions, useless code fragments and all the cool" +
                " and funny stuff, which will get on your nerves!"
    )
    println()

    Thread.sleep(2500)

    println("Some functions may not do what they are intended to. Some tasks were solved differently!")
    println()

    Thread.sleep(2500)

    println("This is a classic text-RPG. Three heros, a swamp and a evil witch. You may wonder: \"Dude, what do i have to do?\"")
    println()

    Thread.sleep(2500)

    println("KILL THAT WITCH!!!")
    println()

    Thread.sleep(2500)

    println("Good luck player...")
    println()

    Thread.sleep(2500)

    println(
        """ 
        /^v^\           /^v^\
                                  
                /^v^\   
        $red                                                                                                                         
         _        _______  _        ______   _______    _______  _______    _______  _______  _______  _______ 
        ( \      (  ___  )( (    /|(  __  \ (  ____ \  (  ___  )(  ____ \  (  ____ \(  ___  )(  ____ )(  ____ \
        | (      | (   ) ||  \  ( || (  \  )| (    \/  | (   ) || (    \/  | (    \/| (   ) || (    )|| (    \/
        | |      | (___) ||   \ | || |   ) || (_____   | |   | || (__      | |      | |   | || (____)|| (__    
        | |      |  ___  || (\ \) || |   | |(_____  )  | |   | ||  __)     | | ____ | |   | ||     __)|  __)   
        | |      | (   ) || | \   || |   ) |      ) |  | |   | || (        | | \_  )| |   | || (\ (   | (      
        | (____/\| )   ( || )  \  || (__/  )/\____) |  | (___) || )        | (___) || (___) || ) \ \__| (____/|
        (_______/|/     \||/    )_)(______/ \_______)  (_______)|/         (_______)(_______)|/   \__/(_______| 
                                                                                                                $reset                                                                                   
                                                                                          /^v^\           /^v^\                                                                         
                                                                                                                  
                                                                                                  /^v^\                                                                                            
        """
    )

    println()

    Thread.sleep(5000)

}

/**
 * just contains the outro
 **/
fun outro() {

    Thread.sleep(2500)
    println()
    println("Thank you for playing! Hope you enjoyed it!")
    println()
    Thread.sleep(2500)

    println("Special thanks to:")
    println()
    Thread.sleep(1750)

    println("Juri Huhn -> for his ideas, support and for the cool for-loop with the iterator!")
    Thread.sleep(750)
    println("Jan Morgenweck -> for his support!")
    Thread.sleep(750)
    println("Kathleen Conrad -> for her support and for throwing me out of bed every day! ;P")
    Thread.sleep(750)
    println("The guys from the tutor team for their support!")
    Thread.sleep(750)
    println("All testers who tested my little program!")
    Thread.sleep(750)
    println("Bekir Kus -> as a source of inspiration!")
    println("https://github.com/M3taWolf/GoldenSyntax.RolePlayGame")
    println()
    Thread.sleep(2500)

    println("Forged with passion by: \"so nem Dude\"!")
    println()
    Thread.sleep(2500)

    println("\"It just works!\" - Todd Howard, Game Director and Executive Producer für Bethesda Game Studios")

}

/**
 * loops the 'fight' function and checks whether the heroes or the enemy´s won
 * @see fight
 **/
fun fightloop() {
    while (enemyList.isNotEmpty() && heroList.isNotEmpty()) {

        fight(enemyList, heroList, inventory)

        if (enemyList.isEmpty()) {
            println("Your heroes done it! The evil witch is dead!")
            println()
            Thread.sleep(2500)
            println("Game Over!")
        } else if (heroList.isEmpty()) {
            println("Evil has won...")
            println()
            Thread.sleep(2500)
            println("Game Over!")
        }

    }
}