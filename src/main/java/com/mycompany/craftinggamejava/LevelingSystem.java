
package com.mycompany.craftinggamejava;
import com.mycompany.craftinggamejava.Level1;
/**
 *
 * @author wasiqrai
 */
public class LevelingSystem {
    private int level;
    LevelStories story = new LevelStories();


    public LevelingSystem() {
        // Default constructor
    }

    // Setter method to set the player's level
    public void setLevel(int level) {
        this.level = level;
    }

    // Getter method to get the player's current level
    public int getLevel() {
        return level;
    }

    public void showMainMenu() {
        switch (level) {
            case 1:
                Level1 level1 = new Level1(); // Create an instance of Level1 class
                story.level1Story();
                level1.showMainMenu(); // Call the showMainMenu() method of Level1 class
                break;
            case 2:
                Level2 level2 = new Level2(); // Create an instance of Level2 class
                story.level2Story();
                level2.showMainMenu(); // Call the showMainMenu() method of Level2 class
                break;
            case 3:
                Level3 level3 = new Level3(); // Create an instance of Level3 class
                story.level3Story();
                level3.showMainMenu(); // Call the showMainMenu() method of Level3 class
                break;
            default:
                System.out.println("Invalid level. Unable to show main menu.");
                break;
        }
    }
}

