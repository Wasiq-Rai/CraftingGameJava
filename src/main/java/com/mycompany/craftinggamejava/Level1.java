package com.mycompany.craftinggamejava;

import java.util.Scanner;


public class Level1 {
    Game game = new Game();
    Player player =  Game.player;
    Scanner scanner = new Scanner(System.in);
    public static Resource woodResource;
    public static Resource stoneResource;
    private CraftedItem axeItem;
    private CraftedItem pickaxeItem;

    public Level1(){
        woodResource = new Resource("Wood", 0);
        stoneResource = new Resource("Stone", 0);
        this.axeItem = new CraftedItem("Axe", 0);
        this.pickaxeItem = new CraftedItem("Pickaxe", 0);
        showMainMenu();
    }
     

   

    public void showMainMenu(){
        // Main game loop
        boolean isGameRunning = true;
         
            Messages.message("             Welcome to Crafting Game        ");
             
        do{
             if(player.getExperiencePoints() >= 200 && (woodResource.getQuantity()!=0 && stoneResource.getQuantity()!=0)){
                 Messages.message("Level 1 cleared !");
                player.setLevel(2);
                Game.level.setLevel(2);
                Game.level.showMainMenu();
                break;
            }
            else if (player.getExperiencePoints() >= 200 && (woodResource.getQuantity()==0 || stoneResource.getQuantity()==0)) {
                Messages.message("Gather some more resources for next level.");
            }


             // Clear the screen before displaying the menu
            // System.out.print("\033[H\033[2J");
            // System.out.flush();

            // Main menu display
            
             
            Messages.message("             Level 1       "+ " Points: "+player.getExperiencePoints());
             
            System.out.println("1. Gather Resources");
            System.out.println("2. Craft Items");
            System.out.println("3. View Inventory");
            System.out.println("4. Save Game");
            System.out.println("5. Exit");
             
            Messages.message("                Enter (1-5):            ");          
             
            

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a numeric value: ");
                scanner.next();
            }
            

            switch (scanner.nextInt()) {
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
                    SaveGame.saveGame(playerName, player.getLevel(), player.getExperiencePoints(),player.getInventory().getResources(),player.getInventory().getCraftedItems() );
                    break;
                case 5:
                    isGameRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (player.getExperiencePoints() < 200 || woodResource.getQuantity()==0 || stoneResource.getQuantity()==0) ;
         
         
        
    }

    void gatherResources() {
         
        Messages.message("            --- Gather Resources ---");
         
        
        
        System.out.println("You find some resources in the game world.");
        System.out.println("1. Gather Wood");
        System.out.println("2. Gather Stone");
        System.out.println("3. Back to Main Menu");
         
        Messages.message("            --- Enter your Choice (1-3) ---");
         

        int choice = getPlayerChoice();
        switch (choice) {
            case 1:
                gatherWood();
                break;
            case 2:
                gatherStone();
                break;
            case 3:
                // Return to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    private int getPlayerChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }
    private void gatherWood() {
        if (Game.loads && Game.woodFound)
            woodResource = player.getInventory().getResourceByName("Wood");

        

        // Simulate gathering wood and add it to the player's inventory
        woodResource.setQuantity(woodResource.getQuantity()+1);
        // woodResource.addQuantity(1);
        player.getInventory().addResource(woodResource);
        player.setExperiencePoints(player.getExperiencePoints()+20);
        Messages.message("You gathered 1 piece of Wood.");
    }

    private void gatherStone() {
        if (Game.loads && Game.stoneFound)
         stoneResource = player.getInventory().getResourceByName("Stone");

        // Simulate gathering stone and add it to the player's inventory
        stoneResource.addQuantity(1);
        player.setExperiencePoints(player.getExperiencePoints()+10);
        player.getInventory().addResource(stoneResource);
        Messages.message("You gathered 1 piece of Stone.");
    }
    void craftItems() {
         
        Messages.message("            --- Craft Items ---");
         
        System.out.println("1. Craft Axe");
        System.out.println("2. Craft Pickaxe");
        System.out.println("3. Back to Main Menu");
         
        Messages.message("            --- Enter your Choice (1-3) ---");
         

        int choice = getPlayerChoice();
        switch (choice) {
            case 1:
                craftAxe();
                break;
            case 2:
                craftPickaxe();
                break;
            case 3:
                // Return to the main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void craftAxe() {
        // Check if the player has enough resources to craft an Axe
        Resource woodResource = player.getInventory().getResourceByName("Wood");
        Resource stoneResource = player.getInventory().getResourceByName("Stone");
        if (Game.loads && Game.axeFound)
            axeItem = player.getInventory().getCraftedItemByName("Axe");

        
            
        int requiredWood = 1;
        int requiredStone = 1;

        if (woodResource != null && stoneResource != null) {
            if (player.getInventory().hasEnoughQuantity(woodResource, requiredWood) &&
                player.getInventory().hasEnoughQuantity(stoneResource, requiredStone)) {
                // Remove the required resources from the inventory
                woodResource.setQuantity(woodResource.getQuantity() - requiredWood);
                stoneResource.setQuantity(stoneResource.getQuantity() - requiredStone);
                axeItem.addQuantity(1);
                player.setExperiencePoints(player.getExperiencePoints()+100);

                // Craft the Axe
                player.getInventory().addCraftedItem(axeItem);
                 
                Messages.message("        You crafted 1 Axe.");
                Messages.message("=========== Points: "+  player.getExperiencePoints()   +"==============");

                 
                ;
            } else {
                 
                System.out.println("=>>>> You don't have enough resources to craft an Axe.");
                 
            }
        } else {
             
                System.out.println("=>>>>> Resource not found in the inventory.");
                 
            
        }
    }

    private void craftPickaxe() {
        // Check if the player has enough resources to craft a Pickaxe
        Resource woodResource = player.getInventory().getResourceByName("Wood");
        Resource stoneResource = player.getInventory().getResourceByName("Stone");
        int requiredWood = 2;
        int requiredStone = 3;

        if (woodResource != null && stoneResource != null) {
            if (player.getInventory().hasEnoughQuantity(woodResource, requiredWood) &&
                player.getInventory().hasEnoughQuantity(stoneResource, requiredStone)) {
                // Remove the required resources from the inventory
                woodResource.setQuantity(woodResource.getQuantity() - requiredWood);
                stoneResource.setQuantity(stoneResource.getQuantity() - requiredStone);
                pickaxeItem.addQuantity(1);
                player.setExperiencePoints(player.getExperiencePoints()+200);

                // Craft the Pickaxe
                player.getInventory().addCraftedItem(pickaxeItem);
                 
                Messages.message("        You crafted 1 PickAxe.");
                Messages.message("=========== Points: "+  player.getExperiencePoints()   +"==============");
                 
            } else {
                 
                System.out.println("=>>>>> You don't have enough resources to craft a PickAxe.");
                 
            }
        } else {
             
                System.out.println("=>>>>> Resource not found in the inventory.");
                 
        }
    }
    
}
