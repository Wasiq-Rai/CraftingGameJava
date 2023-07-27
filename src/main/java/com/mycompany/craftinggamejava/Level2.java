package com.mycompany.craftinggamejava;

import java.util.Scanner;

public class Level2 {
    Game game = new Game();
    LevelStories story = new LevelStories();
    Scanner scanner = new Scanner(System.in);
    private Player player = Game.player;
    private Resource woodResource;
    private Resource stoneResource;
    private Resource glassResource ;
    private Resource  cementResource;
    private Resource paintResource ;
     public static CraftedItem tableItem;
     public static CraftedItem chairItem;
     public static CraftedItem floorItem;
     public static CraftedItem roofItem;
     public static CraftedItem almirahItem;
     public static CraftedItem wallsItem;
     public static CraftedItem windowsItem;
    public boolean hasCraftedTable;
    public boolean hasCraftedChair;
    public boolean hasCraftedAlmirah;
    public boolean hasCraftedFloor;
    public boolean hasCraftedRoof;
    public int windowsCrafted;
    public int wallsCemented;
    public int wallsPainted;


    public Level2(){
        

        this.scanner = new Scanner(System.in);
        this.hasCraftedTable = false;
        this.hasCraftedChair = false;
        this.hasCraftedAlmirah = false;
        this.hasCraftedFloor = false;
        this.hasCraftedRoof = false;
        this.windowsCrafted = 0;
        this.wallsCemented = 0;
        this.wallsPainted = 0;

        // Initialize resources
        if(!Game.loads){
        this.woodResource = Level1.woodResource;
        this.stoneResource   = Level1.stoneResource;
        }else{
        this.woodResource = player.getInventory().getResourceByName("Wood");
        this.stoneResource   = player.getInventory().getResourceByName("Stone");
        }
        
        this.glassResource = new Resource("Glass", 0);
        this.cementResource = new Resource("Cement", 0);
        this.paintResource = new Resource("Paint", 0);

        // Initialize crafted items
        this.tableItem = new CraftedItem("Table", 0);
        this.chairItem = new CraftedItem("Chair", 0);
        this.floorItem = new CraftedItem("Floor", 0);
        this.roofItem = new CraftedItem("Roof", 0);
        this.almirahItem = new CraftedItem("Almirah", 0);
        this.wallsItem = new CraftedItem("Walls", 0);
        this.windowsItem = new CraftedItem("Windows", 0);
    }
    public void showMainMenu() {
         Messages.message("        Level 2: Crafting Furniture!");
         System.out.println("------------------------------------------------");
         System.out.println("Instructions:");
         System.out.println("1. Craft 20 Woods from the forest");
         System.out.println("2. Craft 50 Stones from a mountain");
         System.out.println("3. Craft 10 Glasses from an aluminum shop");
         System.out.println("4. Craft 15 Cement from a factory");
         System.out.println("5. Craft 5 Paints from a store");
         System.out.println("6. Craft 1 Table, 2 Chairs, and 1 Almirah");
         System.out.println("7. Craft the floor using 25 Stones");
         System.out.println("8. Craft the roof using 25 Stones");
         System.out.println("9. Craft 5 Windows using 2 Glasses each");
         System.out.println("10. Use Cement on 5 Walls (3 Cement each)");
         System.out.println("11. Paint 5 Walls (1 Paint each)");
         System.out.println("------------------------------------------------");

        while (!levelCompleted()) {
             Messages.message("--------- Level 2 "+" Points: "+player.getExperiencePoints()+" ---------");
             System.out.println("1. Gather Resources");
             System.out.println("2. Craft Items");
             System.out.println("3. View Inventory");
             System.out.println("4. Save Game");
             System.out.println("5. Exit");
             Messages.message("Enter your choice (1-5):");

            int choice = getPlayerChoice();
            switch (choice) {
                case 1:
                    gatherResources();
                    break;
                case 2:
                    craftItems();
                    break;
                case 3:
                    player.getInventory().displayInventory();
                    break;
                case 4:
                    System.out.println("Enter your name again: ");
                    String playerName = scanner.nextLine();

                    SaveGame.saveGame(playerName, Game.level.getLevel(), player.getExperiencePoints(),player.getInventory().getResources(),player.getInventory().getCraftedItems() );
                    // Implement save game functionality
                    break;
                case 5:
                    // Implement exit game functionality
                    break;
                default:
                     System.out.println("Invalid choice. Please try again.");
            }
        }

        player.setLevel(3);
        Game.level.setLevel(3);

         Messages.message("Congratulations! You have completed Level 2!");
        Game.level.showMainMenu();
    }
    private boolean levelCompleted() {
        return hasCraftedTable && hasCraftedChair && hasCraftedAlmirah &&
               hasCraftedFloor && hasCraftedRoof &&
               windowsCrafted >= 5 && wallsCemented >= 5 && wallsPainted >= 5;

        
    }

    private int getPlayerChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }
    private void gatherResources() {
         Messages.message("        --- Gather Resources ---");
         System.out.println("==>>> You find some resources in the game world.");
         System.out.println("1. Gather Wood");
         System.out.println("2. Gather Stone");
         System.out.println("3. Gather Glass");
         System.out.println("4. Gather Cement");
         System.out.println("5. Gather Paint");
         System.out.println("6. Back to Main Menu");
    
        int choice = getPlayerChoice();
        switch (choice) {
            case 1:
                gatherWood();
                break;
            case 2:
                gatherStone();
                break;
            case 3:
                gatherGlass();
                break;
            case 4:
                gatherCement();
                break;
            case 5:
                gatherPaint();
                break;
            case 6:
                // Return to the main menu
                break;
            default:
                 System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private void gatherWood() {
        player.getInventory().addResource(woodResource);
        woodResource = player.getInventory().getResourceByName("Wood");
        int requiredWood = 20;
        int gatheredWood = woodResource.getQuantity();
        if (gatheredWood < requiredWood) {
            woodResource.setQuantity(gatheredWood + 4);
             Messages.message("You gathered 4 piece of Wood. (" + (gatheredWood + 1) + "/" + requiredWood + ")");
        } else {
             Messages.message("You have already gathered enough Wood from the forest.");
        }
    }
    
    private void gatherStone() {
        player.getInventory().addResource(stoneResource);
        stoneResource = player.getInventory().getResourceByName("Stone");
        int requiredStone = 50;
        int gatheredStone = stoneResource.getQuantity();
        if (gatheredStone < requiredStone) {
            stoneResource.setQuantity(gatheredStone + 5);
             Messages.message("You gathered 5 piece of Stone. (" + (gatheredStone + 1) + "/" + requiredStone + ")");
        } else {
             Messages.message("You have already gathered enough Stone from the mountain.");
        }
    }
    
    private void gatherGlass() {
            player.getInventory().addResource(glassResource);
        
        glassResource = player.getInventory().getResourceByName("Glass");
        
        int requiredGlass = 10;
        int gatheredGlass = glassResource.getQuantity();
        if (gatheredGlass < requiredGlass) {
            glassResource.setQuantity(gatheredGlass + 1);
            Messages.message("You gathered 1 piece of Glass. (" + (gatheredGlass + 1) + "/" + requiredGlass + ")");
        } else {
            Messages.message("You have already gathered enough Glass from the aluminum shop.");
        }
    }
    
    private void gatherCement() {
            player.getInventory().addResource(cementResource);
        
        cementResource = player.getInventory().getResourceByName("Cement");
        
        int requiredCement = 15;
        int gatheredCement = cementResource.getQuantity();
        if (gatheredCement < requiredCement) {
            cementResource.setQuantity(gatheredCement + 1);
            Messages.message("You gathered 1 piece of Cement. (" + (gatheredCement + 1) + "/" + requiredCement + ")");
        } else {
            Messages.message("You have already gathered enough Cement from the factory.");
        }
    }
    
    private void gatherPaint() {
            player.getInventory().addResource(paintResource);
        
        paintResource = player.getInventory().getResourceByName("Paint");
        
        int requiredPaint = 5;
        int gatheredPaint = paintResource.getQuantity();
        if (gatheredPaint < requiredPaint) {
            paintResource.setQuantity(gatheredPaint + 1);
            Messages.message("You gathered 1 piece of Paint. (" + (gatheredPaint + 1) + "/" + requiredPaint + ")");
        } else {
            Messages.message("You have already gathered enough Paint from the store.");
        }
    }
    private void craftItems() {
         Messages.message("        --- Craft Items ---");
         System.out.println("1. Craft Table");
         System.out.println("2. Craft Chair");
         System.out.println("3. Craft Almirah");
         System.out.println("4. Craft Floor");
         System.out.println("5. Craft Roof");
         System.out.println("6. Craft Windows");
         System.out.println("7. Craft Walls");
         System.out.println("8. Back to Main Menu");
    
        int choice = getPlayerChoice();
        switch (choice) {
            case 1:
                craftTable();
                break;
            case 2:
                craftChair();
                break;
            case 3:
                craftAlmirah();
                break;
            case 4:
                craftFloor();
                break;
            case 5:
                craftRoof();
                break;
            case 6:
                craftWindows();
                break;
            case 7:
                craftWalls();
                break;
            case 8:
                // Return to the main menu
                break;
            default:
                 System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private void craftTable() {
        player.getInventory().addCraftedItem(tableItem);
        
        tableItem = player.getInventory().getCraftedItemByName("Table");
        int requiredWood = 6;
        int gatheredWood = player.getInventory().getResourceQuantity("Wood");
        if (gatheredWood >= requiredWood && tableItem.getQuantity() <1 ) {
            tableItem.addQuantity(1);
            woodResource.setQuantity(woodResource.getQuantity()-requiredWood);
            Messages.message("You crafted 1 Table.");
        } else if (tableItem.getQuantity() >= 1) {
                hasCraftedTable=true;
            Messages.message("You have already crafted a Table.");
        } else {
             System.out.println("===>>> You don't have enough Wood to craft a Table.");
        }
    }
    private void craftChair() {
             player.getInventory().addCraftedItem(chairItem);
        
         chairItem = player.getInventory().getCraftedItemByName("Chair");
        int requiredWood = 2;
        int gatheredWood = player.getInventory().getResourceQuantity("Wood");
        if (gatheredWood >= requiredWood && chairItem.getQuantity() < 2) {

            chairItem.addQuantity(1);
            woodResource.setQuantity(woodResource.getQuantity()-requiredWood);
           Messages.message("You crafted 1 Chair.");
        } else if (chairItem.getQuantity() >= 2) {
            hasCraftedChair = true;
             Messages.message("You have already crafted 2 Chairs.");
        } else {
             System.out.println("===>>> You don't have enough Wood to craft a Chair.");
        }
    }
    
    private void craftAlmirah() {
             player.getInventory().addCraftedItem(almirahItem);
        
        almirahItem = player.getInventory().getCraftedItemByName("Almirah");
        int requiredWood = 10;
        int gatheredWood = player.getInventory().getResourceQuantity("Wood");
        if (gatheredWood >= requiredWood && almirahItem.getQuantity() < 1) {
            almirahItem.addQuantity(1);
            woodResource.setQuantity(woodResource.getQuantity()-requiredWood);
             Messages.message("You crafted 1 Almirah.");
        } else if (almirahItem.getQuantity() >= 1) {
            hasCraftedAlmirah = true;
            Messages.message("You have already crafted an Almirah.");
        } else {
             System.out.println("===>>> You don't have enough Wood to craft an Almirah.");
        }
    }
    
    private void craftFloor() {
             player.getInventory().addCraftedItem(floorItem);
        
        stoneResource = player.getInventory().getResourceByName("Stone");
        int requiredStone = 25;
        int gatheredStone = player.getInventory().getResourceQuantity("Stone");
        if (gatheredStone >= requiredStone) {
            // Deduct the required stones from the player's inventory
            stoneResource.setQuantity(gatheredStone - requiredStone);
            floorItem.addQuantity(1);
            hasCraftedFloor = true;
             Messages.message("You crafted the Floor.");
        } else {
             System.out.println("===>>> You don't have enough Stone to craft the Floor.");
        }
    }
    
    private void craftRoof() {
             player.getInventory().addCraftedItem(roofItem);
        
         stoneResource = player.getInventory().getResourceByName("Stone");
        int requiredStone = 25;
        int gatheredStone = player.getInventory().getResourceQuantity("Stone");
        if (gatheredStone >= requiredStone) {
            // Deduct the required stones from the player's inventory
            stoneResource.setQuantity(gatheredStone - requiredStone);
            roofItem.setQuantity(1);
            hasCraftedRoof = true;
            Messages.message("You crafted the Roof.");
        } else {
             System.out.println("===>>> You don't have enough Stone to craft the Roof.");
        }
    }
    
    private void craftWindows() {
             player.getInventory().addCraftedItem(windowsItem);
        
         windowsItem = player.getInventory().getCraftedItemByName("Windows");
        int requiredGlass = 2;
        int gatheredGlass = player.getInventory().getResourceQuantity("Glass");
        if (gatheredGlass >= requiredGlass && windowsItem.getQuantity() < 5) {
            windowsItem.addQuantity(1);
            glassResource.setQuantity(glassResource.getQuantity()-requiredGlass);
            Messages.message("You crafted 1 set of Windows.");
        } else if (windowsItem.getQuantity() >= 5) {
            windowsCrafted = 1;
            Messages.message("You have already crafted 5 sets of Windows.");
        } else {
             System.out.println("===>>> You don't have enough Glass to craft Windows.");
        }
    }
    
    private void craftWalls() {
             player.getInventory().addCraftedItem(wallsItem);
         wallsItem = player.getInventory().getCraftedItemByName("Walls");
         cementResource = player.getInventory().getResourceByName("Cement");
         paintResource = player.getInventory().getResourceByName("Paint");
        int requiredCement = 3;
        int requiredPaint = 1;
        int gatheredCement = player.getInventory().getResourceQuantity("Cement");
        int gatheredPaint = player.getInventory().getResourceQuantity("Paint");
        if (gatheredCement >= requiredCement  && gatheredPaint >= requiredPaint  && wallsItem.getQuantity() < 5) {
            // Deduct the required resources from the player's inventory
            cementResource.setQuantity(gatheredCement - requiredCement );
            paintResource.setQuantity(gatheredPaint - requiredPaint );
            wallsItem.addQuantity(1);
            Messages.message("You crafted 1 set of Walls.");
        } else if (wallsItem.getQuantity() >= 5) {
            wallsCemented=1;
            wallsPainted =1;
            Messages.message("You have already crafted 5 sets of Walls.");
        } else {
             System.out.println("You don't have enough Cement or Paint to craft Walls.");
    }
    }
    
    
    
    
    
}
