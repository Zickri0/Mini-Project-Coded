/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fooddelivery;

/**
 *
 * @author Hasif
 */

import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> selectedItems;  // List to store the selected items
    private double totalCost;  // Total cost of selected items

    public Calculator() {
        selectedItems = new ArrayList<>();  // Initialize the list to hold selected items
        totalCost = 0.0;  // Initialize total cost to 0
    }

    public void addItem(String item) {
        try {
            if (item == null || item.trim().isEmpty()) {
                throw new IllegalArgumentException("Item cannot be null or empty.");
            }
            selectedItems.add(item);
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding item: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error adding item: " + e.getMessage());
        }
    }

    // Method to calculate the total cost based on selected items
    public double calculateTotal() {
        try {
            totalCost = 0.0;  // Reset total cost before recalculating
            for (String item : selectedItems) {
                // Add prices based on the selected items
                if (item.contains("Pizza")) {
                    totalCost += 15.00;  // Updated price for Pizza
                } else if (item.contains("Pasta")) {
                    totalCost += 10.00;  // Updated price for Pasta
                } else if (item.contains("Lasagna")) {
                    totalCost += 18.00;  // Updated price for Lasagna
                } else if (item.contains("Burger")) {
                    totalCost += 6.00;  // Updated price for Burger
                } else if (item.contains("Fries")) {
                    totalCost += 4.00;  // Updated price for Fries
                } else if (item.contains("Milkshake")) {
                    totalCost += 5.00;  // Updated price for Milkshake
                } else if (item.contains("Caesar Salad")) {
                    totalCost += 9.00;  // Updated price for Caesar Salad
                } else if (item.contains("Greek Salad")) {
                    totalCost += 8.00;  // Updated price for Greek Salad
                } else if (item.contains("Fruit Salad")) {
                    totalCost += 6.00;  // Updated price for Fruit Salad
                } else if (item.contains("Sushi Rolls")) {
                    totalCost += 15.00;  // Updated price for Sushi Rolls
                } else if (item.contains("Sashimi")) {
                    totalCost += 18.00;  // Updated price for Sashimi
                } else if (item.contains("Miso Soup")) {
                    totalCost += 5.00;  // Updated price for Miso Soup
                } else if (item.contains("Sweet and Sour Chicken")) {
                    totalCost += 14.00;  // Updated price for Sweet and Sour Chicken
                } else if (item.contains("Fried Rice")) {
                    totalCost += 8.00;  // Updated price for Fried Rice
                } else if (item.contains("Spring Rolls")) {
                    totalCost += 6.00;  // Updated price for Spring Rolls
                } else if (item.contains("Tacos")) {
                    totalCost += 9.00;  // Updated price for Tacos
                } else if (item.contains("Burritos")) {
                    totalCost += 12.00;  // Updated price for Burritos
                } else if (item.contains("Quesadillas")) {
                    totalCost += 10.00;  // Updated price for Quesadillas
                } else if (item.contains("Butter Chicken")) {
                    totalCost += 16.00;  // Updated price for Butter Chicken
                } else if (item.contains("Naan Bread")) {
                    totalCost += 4.00;  // Updated price for Naan Bread
                } else if (item.contains("Samosas")) {
                    totalCost += 5.00;  // Updated price for Samosas
                } else {
                    throw new IllegalArgumentException("Unknown item: " + item);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error calculating total cost: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error calculating total cost: " + e.getMessage());
        }
        return totalCost;  // Return the calculated total cost
    }

    // Get the list of selected items
    public ArrayList<String> getSelectedItems() {
        return selectedItems;
    }

    // Clear the selected items for a new order
    public void clearItems() {
        try {
            selectedItems.clear();
        } catch (Exception e) {
            System.err.println("Unexpected error clearing items: " + e.getMessage());
        }
    }
}
