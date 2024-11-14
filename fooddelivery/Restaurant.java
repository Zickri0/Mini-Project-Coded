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

public class Restaurant {
    private String name; // Name of the restaurant
    private ArrayList<String> menuItems; // List to store the menu items of the restaurant
    private String imagePath; // Field to store the image path for the restaurant's logo

    // Constructor to initialize restaurant with name, image path, and an empty menu list
    public Restaurant(String name, String imagePath) {
        this.name = name; // Set the name of the restaurant
        this.imagePath = imagePath; // Set the image path for the restaurant's logo
        this.menuItems = new ArrayList<>(); // Initialize the menu items list
    }

    // Method to add a menu item to the restaurant's menu
    public void addMenuItem(String item) {
        menuItems.add(item); // Add the item to the menu list
    }

    // Getter method to return the restaurant's name
    public String getName() {
        return name; // Return the name of the restaurant
    }

    // Getter method to return the list of menu items
    public ArrayList<String> getMenuItems() {
        return menuItems; // Return the list of menu items
    }

    // Getter method to return the path to the restaurant's logo image
    public String getImagePath() {
        return imagePath; // Return the image path
    }
}


