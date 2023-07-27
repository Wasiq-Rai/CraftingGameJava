
package com.mycompany.craftinggamejava;

import java.util.List;
/**
 *
 * @author wasiqrai
 */
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Game {
    public static boolean loads = false;
    public static Player player ;
    public static Inventory inventory = new Inventory();
    public static LevelingSystem level = new LevelingSystem();
    
    
    
    private boolean isRunning;
    private Scanner scanner;

    public Game() {
        player= new Player();
        this.isRunning = true;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        Messages.message("Welcome to The IntelligentCraft Game!");
        while (isRunning) {
            // Show loading screen
           // showLoadingScreen();
            displayMainMenu();
            int choice = getPlayerChoice();
            processMainMenuChoice(choice);
        }
        scanner.close();
    }
    private static void showLoadingScreen() {
        System.out.print("Loading: ");
        for (int i = 0; i <= 100; i += 10) {
            try {
                Thread.sleep(300); // Simulate loading time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\033[1K"); // Clear current line
            System.out.print(i + "%");
            System.out.print("\r"); // Move cursor to the beginning of the line
        }
        Messages.message("\nLoading complete!");
    }

    private void displayMainMenu() {
        Messages.message("\n--- Main Menu ---");
        System.out.println("1. Start New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getPlayerChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    private void processMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                startNewGame();
                break;
            case 2:
                loadGame();
                break;
            case 3:
                exitGame();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void startNewGame() {
        // Implement code to start a new game
        Messages.message("Starting a new game...");
        // You can call methods related to character creation, resource collection, etc.
        createCharacter();
        displayPlayerDetails();
        level.setLevel(1);
        
        System.out.println("Press any key to go to Main Menu");
        String choice = scanner.next();
        level.showMainMenu();


        
    }
    
    private void exitGame() {
        isRunning = false;
        System.out.println("Exiting The IntelligentCraft Game. Goodbye!");
    }
    private void createCharacter() {
        Messages.message("--- Character Creation ---");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        player.setName(playerName);

        

        System.out.println("Character created!");
    }

    private void displayPlayerDetails() {
        Messages.message("--- Player Details ---");
        System.out.println("Name: " + player.getName());
        System.out.println("Class: " + player.getCharacterClass());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Experience Points: " + player.getExperiencePoints());
        System.out.print("Inventory: " );
        player.getInventory().displayInventory();
        // You can display other player details as needed.
    }
    


    public static  boolean woodFound = false;
    public static  boolean stoneFound = false;
    public static boolean axeFound =   false;
    public static boolean pickAxeFound = false; 


    private void loadGame() {
    
        
    loads = true;
    System.out.print("Enter your name: ");
    String playerName = scanner.nextLine();
    String fileName = playerName + ".txt";

    showLoadingScreen();

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        player.setName(playerName);
        // Read the player's level and points from the file
        String levelLine = reader.readLine();
        String pointsLine = reader.readLine();

        int playerLevel = 1; // Default level if not found in the file
        int playerPoints = 0; // Default points if not found in the file

        if (levelLine != null && levelLine.startsWith("Level,")) {
            playerLevel = Integer.parseInt(levelLine.substring(6));
        }

        if (pointsLine != null && pointsLine.startsWith("Points,")) {
            playerPoints = Integer.parseInt(pointsLine.substring(7));
        }

        // Update the player's level and points
        // Assuming you have a Player class with setLevel() and setPoints() methods
        player.setLevel(playerLevel);
        level.setLevel(playerLevel);
        player.setExperiencePoints(playerPoints);

        // Read the game data (resources and crafted items) from the file
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Resource,")) {
                String[] values = line.split(",");
                String resourceName = values[1];
                int resourceQuantity = Integer.parseInt(values[2]);

                if(resourceName.startsWith("W")){
                woodFound=true;

                }
                else if(resourceName.startsWith("S")){
                stoneFound=true;
                }
                player.getInventory().addResource(new Resource(resourceName,resourceQuantity));

            } else if (line.startsWith("CraftedItem,")) {
                String[] values = line.split(",");
                String craftedItemName = values[1];
                int craftedItemQuantity = Integer.parseInt(values[2]);
                if(craftedItemName.startsWith("A"))
                axeFound=true;
                else if(craftedItemName.startsWith("P"))
                pickAxeFound=true;

                // Update the game state with the restored crafted item information
                // Assuming you have a method to addCraftedItem() in the Player class
                player.getInventory().addCraftedItem(new CraftedItem(craftedItemName, craftedItemQuantity));
            }
        }

        System.out.println("Game loaded successfully.");
        level.showMainMenu();

    } catch (IOException e) {
        System.out.println("Failed to load game: " + e.getMessage());
    }
}

}
