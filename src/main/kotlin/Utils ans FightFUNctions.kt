import ANSI.*

fun fight(enemy: MutableList<Enemy>, hero: MutableList<Hero>, inventory: MutableList<Potion> ) {
    //war1.attackEnemy(enemyList, heroList, inventory)
    sorc1.attackEnemy(enemyList, heroList, inventory)
    hunt1.attackEnemy(enemyList,heroList, inventory)

    if (boss.healthPoints <= 625 && !boss.isMinionSummoned) {
        boss.summon(boss.minion, enemyList)
        println("\n'${boss.name}': \"You infantile mortals are getting on my nerves!\"")
        Thread.sleep(2500)
        println("'${boss.name}': \"Your Mistress is calling you, my beloved minion!\"")
        Thread.sleep(2500)
        println("'${boss.name}': \"${boss.minion.name}...RISE!\"")
        Thread.sleep(2500)
        println("'${boss.minion.name}: \"Your wish is my desire Mistress!\"")
        Thread.sleep(2500)
        println("'$${boss.minion.name}' appears on the battlefield!")
        println()
        Thread.sleep(1750)
    } else {
        boss.attackHero(heroList)
    }
    boss.minion.attackHero(heroList)
}

fun intro () {
    println()
    println("This is pre-Alpha footage an can contain bugs, errors, exceptions, useless code fragments and all the cool" +
            " and funny stuff, which will get on your nerves!")
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

    println(""" 
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
        """)

    Thread.sleep(5000)

    println()
    println("Ready? FIGHT!")
    println()

    Thread.sleep(2500)

}

fun outro () {

}