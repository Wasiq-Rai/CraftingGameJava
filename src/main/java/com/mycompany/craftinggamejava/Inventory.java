
package com.mycompany.craftinggamejava;

/**
 *
 * @author wasiqrai
 */
import java.util.ArrayList;
import java.util.List;


public class Inventory {
    private List<Resource> resources;
    private List<CraftedItem> craftedItems;

    public Inventory() {
        this.resources = new ArrayList<>();
        this.craftedItems = new ArrayList<>();
    }

    // Methods to add, remove, and display resources and crafted items

    public void addResource(Resource resource) {
        boolean resourceExists = false;
        for (Resource existingResource : resources) {
            if (existingResource.getName().equalsIgnoreCase(resource.getName())) {
                // Resource already exists, increase its quantity
                // existingResource.setQuantity(existingResource.getQuantity() + resource.getQuantity());
                resourceExists = true;
                break;
            }
        }
       
    
        if (!resourceExists) {
            // Resource does not exist, add it to the ArrayList
            resources.add(resource);
            
        }
    }
    

    public void removeResource(Resource resource) {
        resources.remove(resource);
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void addCraftedItem(CraftedItem craftedItem) {
        boolean craftedItemExists = false;
        for (CraftedItem existingCraftedItem : craftedItems) {
            if (existingCraftedItem.getName().equalsIgnoreCase(craftedItem.getName())) {
                craftedItemExists = true;
                break;
            }
        }
    
        if (!craftedItemExists) {
            // Resource does not exist, add it to the ArrayList
            craftedItems.add(craftedItem);
        }
    }

    public void removeCraftedItem(CraftedItem craftedItem) {
        craftedItems.remove(craftedItem);
    }

    public List<CraftedItem> getCraftedItems() {
        return craftedItems;
    }
    public int getResourceQuantity(String resourceName) {
        for (Resource resource : resources) {
            if (resource.getName().equalsIgnoreCase(resourceName)) {
                return resource.getQuantity();
            }
        }
        return 0;
    }
    public int getCraftedItemQuantity(String craftedItemName) {
        for (CraftedItem craftedItem : craftedItems) {
            if (craftedItem.getName().equalsIgnoreCase(craftedItemName)) {
                return craftedItem.getQuantity();
            }
        }
        return 0;
    }

    public boolean hasEnoughQuantity(Resource resource, int requiredQuantity) {
        return resource.getQuantity() >= requiredQuantity;
    }

    public boolean hasEnoughResourcesForCrafting(CraftedItem craftedItem) {
        // Check if the player has enough resources to craft the item
        // Customize the check based on the required resources for each crafted item
        // For example, check if the player has enough wood and stone to craft an Axe
        int requiredWood = 1;
        int requiredStone = 1;
        return hasEnoughQuantity(getResourceByName("Wood"), requiredWood) &&
               hasEnoughQuantity(getResourceByName("Stone"), requiredStone);
    }
    public void craftItem(CraftedItem craftedItem) {
        // Custom logic to handle crafting the item based on required resources
        // For example, if the crafted item is an Axe, deduct the required wood and stone from the inventory
        int requiredWood = 1;
        int requiredStone = 1;
        Resource wood = getResourceByName("Wood");
        Resource stone = getResourceByName("Stone");

        if (hasEnoughQuantity(wood, requiredWood) && hasEnoughQuantity(stone, requiredStone)) {
            wood.setQuantity(wood.getQuantity() - requiredWood);
            stone.setQuantity(stone.getQuantity() - requiredStone);
            addCraftedItem(craftedItem);
        }
    }



    // Helper method to get a resource by name
    public Resource getResourceByName(String resourceName) {
        for (Resource resource : resources) {
            if (resource.getName().equalsIgnoreCase(resourceName)) {
                return resource;
            }
        }
        return null; // Return null if the resource is not found
    }
    public CraftedItem getCraftedItemByName(String craftedItemName) {
        for (CraftedItem craftedItem : craftedItems) {
            if (craftedItem.getName().equalsIgnoreCase(craftedItemName)) {
                return craftedItem;
            }
        }
        return null; // Return null if the resource is not found
    }
    public void displayInventory() {
    if (resources.isEmpty() && craftedItems.isEmpty()) {
        // If both resources and craftedItems are empty, 
        System.out.println("Your inventory is empty. Keep gathering and crafting to fill it up!");
        
    } else {
        // Otherwise, display the inventory as usual
        System.out.println("--- Inventory ---");
        System.out.println("Resources:");
        for (Resource resource : resources) {
            System.out.println(resource.getName() + " - Quantity: " + resource.getQuantity());
        }

        System.out.println("\nCrafted Items:");
        for (CraftedItem craftedItem : craftedItems) {
            System.out.println(craftedItem.getName() + " - Quantity: " + craftedItem.getQuantity());
        }
        System.out.println("-----------------");
    }
}

}
