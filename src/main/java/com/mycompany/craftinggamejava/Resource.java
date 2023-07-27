
package com.mycompany.craftinggamejava;

/**
 *
 * @author wasiqrai
 */
public class Resource {
    private String name;
    private int quantity;

    public Resource(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Additional methods to manage resources

    public void addQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        }
    }

    public void removeQuantity(int amount) {
        if (amount > 0 && amount <= quantity) {
            this.quantity -= amount;
        } else {
            System.out.println("Invalid quantity to remove.");
        }
    }

    // Method to check if the resource is available in the required quantity
    public boolean hasEnoughQuantity(int requiredQuantity) {
        return requiredQuantity <= quantity;
    }
}
