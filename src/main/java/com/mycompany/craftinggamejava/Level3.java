package com.mycompany.craftinggamejava;

import java.util.Scanner;

public class Level3 {

    Player player = Game.player;

    CraftedItem tableItem;
     CraftedItem chairItem;
     CraftedItem floorItem;
     CraftedItem roofItem;
     CraftedItem almirahItem;
     CraftedItem wallsItem;
     CraftedItem windowsItem;

     int  points = 0;

    private int numTables;
    private int numChairs;
    private int numAlmirahs;
    private int numFloors;
    private int numRoofs;
    private int numWindows;
    private int numWalls;
    private boolean isHouseBuilt;
    Scanner scanner = new Scanner(System.in);

    public Level3() {
        this.scanner = new Scanner(System.in);
        this.isHouseBuilt = false;

        initializeResourcesAndItems();
        showMainMenu();
    }

    private void initializeResourcesAndItems() {
        // Initialize the number of crafted items obtained from Level 2

        if(!Game.loads){
            this.tableItem = Level2.tableItem;
            this.chairItem   = Level2.chairItem;
            this.floorItem = Level2.floorItem;
            this.roofItem   = Level2.roofItem;
            this.almirahItem = Level2.almirahItem;
            this.wallsItem   = Level2.wallsItem;
            this.windowsItem   = Level2.windowsItem;
            }else{
            this.tableItem = player.getInventory().getCraftedItemByName("Table");
            this.chairItem   = player.getInventory().getCraftedItemByName("Chair");
            this.floorItem = player.getInventory().getCraftedItemByName("Floor");
            this.roofItem   = player.getInventory().getCraftedItemByName("Roof");
            this.windowsItem = player.getInventory().getCraftedItemByName("Windows");
            this.wallsItem   = player.getInventory().getCraftedItemByName("Walls");
            this.almirahItem = player.getInventory().getCraftedItemByName("Almirah");
            }

        numTables = player.getInventory().getCraftedItemQuantity("Table");
        numChairs = player.getInventory().getCraftedItemQuantity("Chair");
        numAlmirahs = player.getInventory().getCraftedItemQuantity("Almirah");
        numFloors = player.getInventory().getCraftedItemQuantity("Floor");
        numRoofs = player.getInventory().getCraftedItemQuantity("Roof");
        numWindows = player.getInventory().getCraftedItemQuantity("Windows");
        numWalls = player.getInventory().getCraftedItemQuantity("Walls");
    }

    public void showMainMenu() {
        // Main game loop
        boolean isGameRunning = true;

        do {
            Messages.message("===== Main Menu =====");
             System.out.println("1. Build House");
             System.out.println("2. View Inventory");
             System.out.println("3. Save Game");
             System.out.println("4. Exit");
             System.out.println("Enter (1-4):");

            int choice = getPlayerChoice();
            switch (choice) {
                case 1:
                    buildHouse();
                    break;
                case 2:
                    player.getInventory().displayInventory();
                    break;
                case 3:
                    SaveGame.saveGame(player.getName(), player.getLevel(), player.getExperiencePoints(), player.getInventory().getResources(), player.getInventory().getCraftedItems());
                    break;
                case 4:
                    isGameRunning = false;
                    break;
                default:
                     System.out.println("Invalid choice. Please try again.");
            }
        } while (isGameRunning);
    }
    private int getPlayerChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    private void buildHouse() {
        Messages.message("===== House Building =====");
        if (isHouseBuilt) {
            Messages.message("You have already built your dream house. Congratulations!");
            return;
        }

        // Check if the player has enough crafted items to build the house
        if (numTables >= 1 && numChairs >= 2 && numAlmirahs >= 1 && numFloors >= 1 && numRoofs >= 1 && numWindows >= 5 && numWalls >= 5) {
            Messages.message("Let's start building your house!");
             System.out.println("Your house requires:");
             System.out.println("1 Table");
             System.out.println("2 Chairs");
             System.out.println("1 Almirah");
             System.out.println("1 Floor");
             System.out.println("1 Roof");
             System.out.println("5 Windows");
             System.out.println("5 Walls");

            // Ask the player to start building the house step by step
            buildStepByStep();
            isHouseBuilt = true;
        } else {
            Messages.message("You don't have enough crafted items to build the house.");
        }
    }
    private void buildStepByStep() {
    Messages.message("=== Building Steps ===");
    Messages.message("Answer the following questions with yes or no:");
        
        // Step 1
        Messages.message("1- Did we make table with with iron?");
        if (!askUserToConfirm()) {
            numTables--;
            player.getInventory().getCraftedItemByName("Table").setQuantity(numTables);
            points++;
            Messages.message("Points: " +points+"/7");
        } else {

            System.out.println("Oops! The table was not made of Iron. We made it using woods.");
            Messages.message("Points: " +points+"/7");
        }

        // Step 2
        Messages.message("2- Is it okay to place the 2 Chairs above the Table");
        if (!askUserToConfirm()) {
            numChairs -= 4;
            player.getInventory().getCraftedItemByName("Chair").setQuantity(numChairs);
            points++;
            Messages.message("Points: " +points+"/7");
        } else {
            System.out.println("Oops! The chairs were not placed correctly. Make sure to place 2 chairs around the table.");
            Messages.message("Points: " +points+"/7");
        }

        // Step 3
        Messages.message("3- Should we place Almirah in the bedroom?");
        if (askUserToConfirm()) {
            numAlmirahs--;
            player.getInventory().getCraftedItemByName("Almirah").setQuantity(numAlmirahs);
            points++;
            Messages.message("Points: " +points+"/7");
        } else {
            System.out.println("Oops! The almirah was not installed correctly. Make sure to place it in the bedroom.");
            Messages.message("Points: " +points+"/7");
        }

        // Step 4
        Messages.message("4- Are you willing to lay the floor on the stairs only?");
        if (!askUserToConfirm()) {
            numFloors--;
            player.getInventory().getCraftedItemByName("Floor").setQuantity(numFloors);
            points++;
            Messages.message("Points: " +points+"/7");
        } else {
            System.out.println("Oops! The floor was not laid correctly. Make sure to lay it in the entire house.");
            Messages.message("Points: " +points+"/7");
        }

        // Step 5
        Messages.message("5- Roof should be on top of the house.");
        if (askUserToConfirm()) {
            numRoofs--;
            player.getInventory().getCraftedItemByName("Roof").setQuantity(numRoofs);
            points++;
            Messages.message("Points: " +points+"/7");
        } else {
            System.out.println("Oops! The roof was not set correctly. Make sure to set it on top of the house.");
            Messages.message("Points: " +points+"/7");
        }

        // Step 6
        Messages.message("6- Did we craft 50 windows for our house?");
        if (!askUserToConfirm()) {
            numWindows -= 5;
            player.getInventory().getCraftedItemByName("Windows").setQuantity(numWindows);
            points++;
            Messages.message("Points: " +points+"/7");
        } else {
            System.out.println("Oops! The windows were only 5.");
            Messages.message("Points: " +points+"/7");
        }

        // Step 7
        Messages.message("7- can we Use Cement to reinforce the 5 Walls.");
        if (askUserToConfirm()) {
            numWalls -= 5;
            player.getInventory().getCraftedItemByName("Walls").setQuantity(numWalls);
            points++;
            Messages.message("Points: " +points+"/7");
        } else {
            System.out.println("Oops! The walls were not reinforced correctly. Make sure to use cement on 5 walls.");
            Messages.message("Points: " +points+"/7");
        }

        Messages.message("Congratulations! You have successfully built your dream house.");
        Messages.message("Enjoy living in your cozy forest home!");
        player.setExperiencePoints(player.getExperiencePoints() + 500);
        System.out.println("=== Final Level Cleared! ===");
    }

    private boolean askUserToConfirm() {
        System.out.println("Answer? (yes/no)");
        String answer = scanner.nextLine().trim().toLowerCase();
        if(answer.equals("yes"))return true;
        else if(answer.equals("no"))return false;
        else askUserToConfirm();
        return true;
    }



}
