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
                totalCost += 15.00;  // Pizza price
            } else if (item.contains("Pasta")) {
                totalCost += 10.00;  // Pasta price
            } else if (item.contains("Lasagna")) {
                totalCost += 18.00;  // Lasagna price
            } else if (item.contains("Tiramisu")) {
                totalCost += 8.00;  // Tiramisu price
            } else if (item.contains("Garlic Bread")) {
                totalCost += 5.00;  // Garlic Bread price
            } else if (item.contains("Fettuccine Alfredo")) {
                totalCost += 17.00;  // Fettuccine Alfredo price
            } else if (item.contains("Minestrone Soup")) {
                totalCost += 7.00;  // Minestrone Soup price
            } else if (item.contains("Bruschetta")) {
                totalCost += 6.00;  // Bruschetta price
            } else if (item.contains("Burger")) {
                totalCost += 6.00;  // Burger price
            } else if (item.contains("Fries")) {
                totalCost += 4.00;  // Fries price
            } else if (item.contains("Milkshake")) {
                totalCost += 5.00;  // Milkshake price
            } else if (item.contains("Onion Rings")) {
                totalCost += 4.00;  // Onion Rings price
            } else if (item.contains("Chicken Nuggets")) {
                totalCost += 6.00;  // Chicken Nuggets price
            } else if (item.contains("Veggie Burger")) {
                totalCost += 7.00;  // Veggie Burger price
            } else if (item.contains("Cheese Fries")) {
                totalCost += 5.00;  // Cheese Fries price
            } else if (item.contains("Chicken Wings")) {
                totalCost += 8.00;  // Chicken Wings price
            } else if (item.contains("Caesar Salad")) {
                totalCost += 9.00;  // Caesar Salad price
            } else if (item.contains("Greek Salad")) {
                totalCost += 8.00;  // Greek Salad price
            } else if (item.contains("Fruit Salad")) {
                totalCost += 6.00;  // Fruit Salad price
            } else if (item.contains("Quinoa Salad")) {
                totalCost += 12.00;  // Quinoa Salad price
            } else if (item.contains("Avocado Salad")) {
                totalCost += 10.00;  // Avocado Salad price
            } else if (item.contains("Cobb Salad")) {
                totalCost += 14.00;  // Cobb Salad price
            } else if (item.contains("Lentil Salad")) {
                totalCost += 9.00;  // Lentil Salad price
            } else if (item.contains("Tabbouleh")) {
                totalCost += 8.00;  // Tabbouleh price
            } else if (item.contains("Sushi Rolls")) {
                totalCost += 15.00;  // Sushi Rolls price
            } else if (item.contains("Sashimi")) {
                totalCost += 18.00;  // Sashimi price
            } else if (item.contains("Miso Soup")) {
                totalCost += 5.00;  // Miso Soup price
            } else if (item.contains("Tempura")) {
                totalCost += 20.00;  // Tempura price
            } else if (item.contains("Tuna Tartare")) {
                totalCost += 22.00;  // Tuna Tartare price
            } else if (item.contains("California Rolls")) {
                totalCost += 12.00;  // California Rolls price
            } else if (item.contains("Dragon Rolls")) {
                totalCost += 18.00;  // Dragon Rolls price
            } else if (item.contains("Ebi (Shrimp) Sushi")) {
                totalCost += 10.00;  // Ebi Sushi price
            } else if (item.contains("Sweet and Sour Chicken")) {
                totalCost += 14.00;  // Sweet and Sour Chicken price
            } else if (item.contains("Fried Rice")) {
                totalCost += 8.00;  // Fried Rice price
            } else if (item.contains("Spring Rolls")) {
                totalCost += 6.00;  // Spring Rolls price
            } else if (item.contains("Kung Pao Chicken")) {
                totalCost += 16.00;  // Kung Pao Chicken price
            } else if (item.contains("Dim Sum")) {
                totalCost += 12.00;  // Dim Sum price
            } else if (item.contains("Beef with Broccoli")) {
                totalCost += 15.00;  // Beef with Broccoli price
            } else if (item.contains("Hot and Sour Soup")) {
                totalCost += 7.00;  // Hot and Sour Soup price
            } else if (item.contains("Peking Duck")) {
                totalCost += 25.00;  // Peking Duck price
            } else if (item.contains("Tacos")) {
                totalCost += 9.00;  // Tacos price
            } else if (item.contains("Burritos")) {
                totalCost += 12.00;  // Burritos price
            } else if (item.contains("Quesadillas")) {
                totalCost += 10.00;  // Quesadillas price
            } else if (item.contains("Churros")) {
                totalCost += 7.00;  // Churros price
            } else if (item.contains("Guacamole & Chips")) {
                totalCost += 5.00;  // Guacamole & Chips price
            } else if (item.contains("Enchiladas")) {
                totalCost += 14.00;  // Enchiladas price
            } else if (item.contains("Nachos")) {
                totalCost += 8.00;  // Nachos price
            } else if (item.contains("Tamales")) {
                totalCost += 10.00;  // Tamales price
            } else if (item.contains("Butter Chicken")) {
                totalCost += 16.00;  // Butter Chicken price
            } else if (item.contains("Naan Bread")) {
                totalCost += 4.00;  // Naan Bread price
            } else if (item.contains("Samosas")) {
                totalCost += 5.00;  // Samosas price
            } else if (item.contains("Chicken Tikka Masala")) {
                totalCost += 18.00;  // Chicken Tikka Masala price
            } else if (item.contains("Lassi")) {
                totalCost += 6.00;  // Lassi price
            } else if (item.contains("Aloo Gobi")) {
                totalCost += 12.00;  // Aloo Gobi price
            } else if (item.contains("Palak Paneer")) {
                totalCost += 15.00;  // Palak Paneer price
            } else if (item.contains("Mutton Rogan Josh")) {
                totalCost += 20.00;  // Mutton Rogan Josh price
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
