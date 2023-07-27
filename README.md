# Crafting Game

Welcome to the Crafting Game! This is a text-based Java console game that challenges you to gather resources, craft items, and build your own house. The game is divided into three exciting levels, each with its own unique challenges and tasks. Are you ready to embark on a crafting adventure and become a master builder?

## Features

- Three levels of progressive difficulty
- Gather resources such as wood and stone
- Craft items like axes, pickaxes, and furniture
- Build your own house in the final level
- Save and load your game progress

## Usage

1. Run this project in VS Code or any Java IDE.
2. If playing for the first time, start a new game.
3. In Level 1, gather resources and craft items until you reach a score of 200 or more.
4. Progress to Level 2 where you will be given instructions to gather specific resources and craft required items.
5. Once all items are crafted, move on to Level 3.
6. In Level 3, use the items crafted in Level 2 to build your own house by answering questions and gaining points.
7. Save your game progress anytime using a name.
8. Load your saved game from any of the three provided text files (level1.txt, level2.txt, level3.txt).

Feel free to explore, create, and enjoy the world of crafting!

## File Structure

1. **CraftingGameJava**: Main project directory.
2. **src**: Contains the source code of the game.
   - **com.mycompany.craftinggamejava**: Package containing game classes.
   - **Game.java**: Main class that handles the game loop and interactions.
   - **Player.java**: Class representing the player with their inventory and level.
   - **Inventory.java**: Class handling player's resources and crafted items.
   - **Resource.java**: Class representing a resource with name and quantity.
   - **CraftedItem.java**: Class representing a crafted item with name and quantity.
   - **LevelingSystem.java**: Class handling the leveling system and progression.
   - **Level1.java**: Class implementing Level 1 gameplay and tasks.
   - **Level2.java**: Class implementing Level 2 gameplay and tasks.
   - **Level3.java**: Class implementing Level 3 gameplay and house building.
   - **LevelStories.java**: Class containing the storyline for each level.
   - **Save.java** : Class used to save the progress at any level.
3. **level1.txt, level2.txt, level3.txt**: Provided text files for loading saved games in each level.

Please let us know if you have any questions, need further assistance, or have any suggestions for improvement. Happy crafting!
