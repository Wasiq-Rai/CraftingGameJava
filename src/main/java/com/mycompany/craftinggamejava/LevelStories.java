package com.mycompany.craftinggamejava;

public class LevelStories {
    LevelStories(){

    }


    void level1Story(){
        Messages.message("Story:\n" + //
                "You, a young and aspiring adventurer, find yourself in a lush and mysterious forest filled with ancient trees and hidden treasures. Eager to prove your worth, you embark on a journey to explore the depths of the forest and uncover its secrets. The forest is said to be abundant with valuable resources like wood and stone, essential for crafting powerful tools.\n" + //
                "\n" + //
                "Tasks:\n" + //
                "\n" + //
                "    Explore the Forest: Your first task is to explore the forest and gather as much wood and stone as possible. Use your trusty hands to collect resources from fallen branches and rocks.\n" + //
                "\n" + //
                "    Crafting Basics: Next, learn the art of crafting! Use the wood and stone you gathered to craft a simple wooden axe and stone pickaxe. These tools will aid you in gathering resources more efficiently.\n" + //
                "\n" + //
                "    Harvest Resources: Now that you have your tools, start harvesting wood from the ancient trees and mine stone from the rocky terrain. Gather a substantial amount of both resources to proceed to the next task.");
    }

    void level2Story(){
         Messages.message("Welcome to Level 2 - Forest House Construction\n"+
         "Your objective is to build a cozy forest house surrounded by nature's beauty.\n"+
         "Gather 20 wood from the forest, 50 stones from the mountains,\n"+
         "10 glass from an aluminum shop, 15 cement from a factory,\n"+
         "and 5 paint from a store to begin your construction.");
    }


    void level3Story(){
        Messages.message("Welcome to Level 3 - Building the House"+
         "You have gathered all the required resources and crafted items."+
         "Now, it's time to build your dream house in the forest!"+
         "Let's start the construction process.");
    }
    
}
