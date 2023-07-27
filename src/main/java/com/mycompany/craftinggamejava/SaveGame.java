
package com.mycompany.craftinggamejava;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author wasiqrai
 */
public class SaveGame {
    public static void saveGame(String file, int playerLevel, int playerPoints, List<Resource> resources, List<CraftedItem> craftedItems) {
        String fName = file.toLowerCase().toString();
        String fileName = fName + ".txt";
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write the player's level and points to the file
            writer.write("Level," + playerLevel);
            writer.newLine();
            writer.write("Points," + playerPoints);
            writer.newLine();
    
            // Write the game data (resources and crafted items) to the file
            for (Resource resource : resources) {
                writer.write("Resource," + resource.getName() + "," + resource.getQuantity());
                writer.newLine();
            }
    
            for (CraftedItem craftedItem : craftedItems) {
                writer.write("CraftedItem," + craftedItem.getName() + "," + craftedItem.getQuantity());
                writer.newLine();
            }
    
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save game: " + e.getMessage());
        }
    }
}
