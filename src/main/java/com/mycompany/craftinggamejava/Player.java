/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.craftinggamejava;

/**
 *
 * @author wasiqrai
 */
public class Player {
    private String name;
    private String characterClass;
    private int level;
    private int experiencePoints;
    private Inventory inventory;

    public Player() {
        this.name = "";
        this.characterClass = "";
        this.level = 1;
        this.experiencePoints = 0;
        this.inventory = Game.inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public Inventory getInventory() {
        return inventory;
    }

    // Method to handle crafting and gain experience points
    public void craftItemAndGainExperience(CraftedItem craftedItem, int experiencePointsGained) {
        // Check if the player has enough resources to craft the item
        if (inventory.hasEnoughResourcesForCrafting(craftedItem)) {
            // Craft the item
            inventory.craftItem(craftedItem);
            // Gain experience points
            gainExperiencePoints(experiencePointsGained);
            // Display the crafting success message
            System.out.println("You crafted " + craftedItem.getName() + " and gained " + experiencePointsGained + " experience points!");
        } else {
            System.out.println("You don't have enough resources to craft " + craftedItem.getName() + ".");
        }
    }

    // Method to handle gaining experience points and leveling up
    private void gainExperiencePoints(int points) {
        experiencePoints += points;
        // Check if the player has reached the level-up threshold
        int levelUpThreshold = calculateLevelUpThreshold();
        if (experiencePoints >= levelUpThreshold) {
            levelUp();
        }
    }

    // Method to calculate the experience points required to level up
    private int calculateLevelUpThreshold() {
        // Customize the leveling system here (e.g., level * 100)
        return level * 100;
    }

    // Method to handle leveling up and unlocking new crafting recipes
    private void levelUp() {
        level++;
        // Customize the unlocking of crafting recipes here
        System.out.println("Congratulations! You reached level " + level + " and unlocked new crafting recipes!");
    }

    // ... (other methods if needed)
}

