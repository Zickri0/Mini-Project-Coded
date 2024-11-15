/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fooddelivery;

/**
 *
 * @author Hasif
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.*;

public class FoodDelivery {
    private JFrame frame;
    private SubMenu subMenu;
    private Calculator calculator;
    private Display display;
    private AddressPayment addressPayment;
    private ArrayList<Restaurant> restaurants;

    public FoodDelivery() {
    // Set Look and Feel for the entire application
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        // Set the default background and foreground for Swing components
        UIManager.put("Panel.background", new Color(240, 233, 204)); // #FOE9CC - light yellowish background
        UIManager.put("Label.foreground", new Color(0, 167, 167)); // #00A7A7 - teal text
        UIManager.put("Button.background", new Color(240, 233, 204)); // Light yellowish background for buttons
        UIManager.put("Button.foreground", new Color(0, 167, 167)); // Teal text for buttons
        UIManager.put("OptionPane.background", new Color(240, 233, 204)); // Light yellowish background for JOptionPane
        UIManager.put("OptionPane.foreground", new Color(0, 167, 167)); // Teal text for JOptionPane
        UIManager.put("OptionPane.messageForeground", new Color(0, 167, 167)); // Teal text for message in JOptionPane
        UIManager.put("OptionPane.buttonBackground", new Color(240, 233, 204)); // Light yellowish background for buttons in JOptionPane
        UIManager.put("OptionPane.buttonForeground", new Color(0, 167, 167)); // Teal text for buttons in JOptionPane
    } catch (Exception e) {
        e.printStackTrace();
    }

    calculator = new Calculator();
    display = new Display();
    addressPayment = new AddressPayment();
    restaurants = new ArrayList<>();
    initializeRestaurants();

    frame = new JFrame("Food Delivery System");
    frame.setSize(385, 350); // Size to resemble a mobile phone
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    ImageIcon icon = new ImageIcon("fd.png");
    frame.setIconImage(icon.getImage());

    // Set the background color of the frame to light yellowish (FOE9CC)
    frame.getContentPane().setBackground(new Color(240, 233, 204)); // #FOE9CC - light yellowish background

    // Welcome message displayed in the frame
    ImageIcon imageIcon = new ImageIcon("fd.png");

    // Create a JLabel with both text and image
    JLabel welcomeLabel = new JLabel("Welcome To Food Delivery", imageIcon, SwingConstants.CENTER);
    welcomeLabel.setFont(new Font("Forte", Font.BOLD, 21)); // Bold font for header
    welcomeLabel.setForeground(new Color(0, 167, 167)); // #00A7A7 - teal text
    welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    frame.add(welcomeLabel, BorderLayout.NORTH);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    buttonPanel.setBackground(new Color(240, 233, 204)); // #FOE9CC - light yellowish background
    buttonPanel.setLayout(null); // Absolute layout

    // Set button dimensions and font
    Dimension buttonSize = new Dimension(250, 50); // Adjust the width and height
    Font buttonFont = new Font("MV Boli", Font.BOLD, 18); // Increase font size

    // Configure Select Restaurant button
    JButton selectRestaurantButton = new JButton("Select Restaurant");
    selectRestaurantButton.setFont(buttonFont);
    selectRestaurantButton.setSize(buttonSize);
    selectRestaurantButton.setLocation(50, 20); // Fixed location
    buttonPanel.add(selectRestaurantButton);

    // Configure Finalize Order button
    JButton finalizeButton = new JButton("Finalize Order");
    finalizeButton.setFont(buttonFont);
    finalizeButton.setSize(buttonSize);
    finalizeButton.setLocation(50, 80); // Fixed location
    buttonPanel.add(finalizeButton);

    // Configure Exit button
    JButton exitButton = new JButton("Exit");
    exitButton.setFont(buttonFont);
    exitButton.setSize(buttonSize);
    exitButton.setLocation(50, 140); // Fixed location
    buttonPanel.add(exitButton);

    frame.add(buttonPanel, BorderLayout.CENTER);

    selectRestaurantButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectRestaurant();
        }
    });

    finalizeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (calculator.getSelectedItems().isEmpty()) {
                String message = "<html><body style='font-family: MS Gothic; font-weight: bold; font-size: 10px;'>"
                        + "No items selected! Please add items before finalizing."
                        + "</body></html>";
                JOptionPane.showMessageDialog(frame, message);
            } else {
                enterAddressAndPayment();
            }
        }
    });

    exitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            exitSystem();
        }
    });

    frame.setVisible(true);
}

    
    private void initializeRestaurants() {
    // Updated to include more menu items

    // Italian Bistro
    Restaurant italianRestaurant = new Restaurant("Italian Bistro", "itali.png");
    italianRestaurant.addMenuItem("Pizza - RM15.00");
    italianRestaurant.addMenuItem("Pasta - RM10.00");
    italianRestaurant.addMenuItem("Lasagna - RM18.00");
    italianRestaurant.addMenuItem("Tiramisu - RM8.00");  // New item
    italianRestaurant.addMenuItem("Garlic Bread - RM5.00");  // New item
    italianRestaurant.addMenuItem("Fettuccine Alfredo - RM17.00");  // New item
    italianRestaurant.addMenuItem("Minestrone Soup - RM7.00");  // New item
    italianRestaurant.addMenuItem("Bruschetta - RM6.00");  // New item

    // Burger Joint
    Restaurant burgerJoint = new Restaurant("Burger Joint", "burger.png");
    burgerJoint.addMenuItem("Burger - RM6.00");
    burgerJoint.addMenuItem("Fries - RM4.00");
    burgerJoint.addMenuItem("Milkshake - RM5.00");
    burgerJoint.addMenuItem("Onion Rings - RM4.00");  // New item
    burgerJoint.addMenuItem("Chicken Nuggets - RM6.00");  // New item
    burgerJoint.addMenuItem("Veggie Burger - RM7.00");  // New item
    burgerJoint.addMenuItem("Cheese Fries - RM5.00");  // New item
    burgerJoint.addMenuItem("Chicken Wings - RM8.00");  // New item

    // Salad Bar
    Restaurant saladBar = new Restaurant("Salad Bar", "vegan.png");
    saladBar.addMenuItem("Caesar Salad - RM9.00");
    saladBar.addMenuItem("Greek Salad - RM8.00");
    saladBar.addMenuItem("Fruit Salad - RM6.00");
    saladBar.addMenuItem("Quinoa Salad - RM12.00");  // New item
    saladBar.addMenuItem("Avocado Salad - RM10.00");  // New item
    saladBar.addMenuItem("Cobb Salad - RM14.00");  // New item
    saladBar.addMenuItem("Lentil Salad - RM9.00");  // New item
    saladBar.addMenuItem("Tabbouleh - RM8.00");  // New item

    // Sushi Place
    Restaurant sushiPlace = new Restaurant("Sushi Place", "sushi.png");
    sushiPlace.addMenuItem("Sushi Rolls - RM15.00");
    sushiPlace.addMenuItem("Sashimi - RM18.00");
    sushiPlace.addMenuItem("Miso Soup - RM5.00");
    sushiPlace.addMenuItem("Tempura - RM20.00");  // New item
    sushiPlace.addMenuItem("Tuna Tartare - RM22.00");  // New item
    sushiPlace.addMenuItem("California Rolls - RM12.00");  // New item
    sushiPlace.addMenuItem("Dragon Rolls - RM18.00");  // New item
    sushiPlace.addMenuItem("Ebi (Shrimp) Sushi - RM10.00");  // New item

    // Chinese Takeaway
    Restaurant chineseTakeaway = new Restaurant("Chinese Takeaway", "chinese.png");
    chineseTakeaway.addMenuItem("Fried Rice - RM8.00");
    chineseTakeaway.addMenuItem("Spring Rolls - RM6.00");
    chineseTakeaway.addMenuItem("Kung Pao Chicken - RM16.00");  // New item
    chineseTakeaway.addMenuItem("Dim Sum - RM12.00");  // New item
    chineseTakeaway.addMenuItem("Beef with Broccoli - RM15.00");  // New item
    chineseTakeaway.addMenuItem("Hot and Sour Soup - RM7.00");  // New item
    chineseTakeaway.addMenuItem("Peking Duck - RM25.00");  // New item

    // Mexican Fiesta
    Restaurant mexicanFiesta = new Restaurant("Mexican Fiesta", "mexican.png");
    mexicanFiesta.addMenuItem("Tacos - RM9.00");
    mexicanFiesta.addMenuItem("Burritos - RM12.00");
    mexicanFiesta.addMenuItem("Quesadillas - RM10.00");
    mexicanFiesta.addMenuItem("Churros - RM7.00");  // New item
    mexicanFiesta.addMenuItem("Guacamole & Chips - RM5.00");  // New item
    mexicanFiesta.addMenuItem("Enchiladas - RM14.00");  // New item
    mexicanFiesta.addMenuItem("Nachos - RM8.00");  // New item
    mexicanFiesta.addMenuItem("Tamales - RM10.00");  // New item

    // Indian Spice
    Restaurant indianSpice = new Restaurant("Indian Spice", "indian.png");
    indianSpice.addMenuItem("Butter Chicken - RM16.00");
    indianSpice.addMenuItem("Naan Bread - RM4.00");
    indianSpice.addMenuItem("Samosas - RM5.00");
    indianSpice.addMenuItem("Chicken Tikka Masala - RM18.00");  // New item
    indianSpice.addMenuItem("Lassi - RM6.00");  // New item
    indianSpice.addMenuItem("Aloo Gobi - RM12.00");  // New item
    indianSpice.addMenuItem("Palak Paneer - RM15.00");  // New item
    indianSpice.addMenuItem("Mutton Rogan Josh - RM20.00");  // New item

    // Add all restaurants to the list
    restaurants.add(italianRestaurant);
    restaurants.add(burgerJoint);
    restaurants.add(saladBar);
    restaurants.add(sushiPlace);
    restaurants.add(chineseTakeaway);
    restaurants.add(mexicanFiesta);
    restaurants.add(indianSpice);
}
    private void selectRestaurant() {
    String[] restaurantNames = restaurants.stream().map(Restaurant::getName).toArray(String[]::new);

    // Load your custom icon for the dialog
    ImageIcon customIcon = new ImageIcon("fd.png"); // Replace with your image path

    // HTML formatted message for the font
    String message = "<html><body style='font-family:MS Gothic;font-size:8px;'><b>Select a restaurant:</b></body></html>";


    // Show input dialog with custom font
    String selectedRestaurant = (String) JOptionPane.showInputDialog(
            frame,
            message,
            "Restaurant Selection",
            JOptionPane.QUESTION_MESSAGE,
            customIcon,
            restaurantNames,
            restaurantNames[0]
    );

    if (selectedRestaurant != null) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(selectedRestaurant)) {
                // Show restaurant logo in dialog with custom font
                ImageIcon restaurantLogo = new ImageIcon(restaurant.getImagePath());
                String selectedMessage = "<html><body style='font-family:MS Gothic;font-size:12px;'><b>You selected: " + restaurant.getName() + "</body></html>";
                JOptionPane.showMessageDialog(frame, selectedMessage, "Restaurant Selected", JOptionPane.INFORMATION_MESSAGE, restaurantLogo);
                subMenu = new SubMenu(calculator, this, restaurant);
                subMenu.displayMenu();
                break;
            }
        }
    }
}


    private void enterAddressAndPayment() {
        // Create a new JFrame for the Finalize Order screen
        JFrame finalizeFrame = new JFrame("Finalize Your Order");
        finalizeFrame.setSize(400, 450); // Increased size for the Finalize Order screen
        finalizeFrame.setLayout(null);
        finalizeFrame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("fd.png"); // Ensure the path is correct
        finalizeFrame.setIconImage(icon.getImage());

    // Label to display selected items
    JLabel selectedItemsLabel = new JLabel("Selected Items:");
    selectedItemsLabel.setFont(new Font("MS Gothic", Font.BOLD, 12));
    selectedItemsLabel.setBounds(20, 20, 360, 30);
    finalizeFrame.add(selectedItemsLabel);

    // Preview of selected items
    StringBuilder previewMessage = new StringBuilder("<html>");
    ArrayList<String> selectedItems = calculator.getSelectedItems();
    if (selectedItems.isEmpty()) {
        previewMessage.append("No items selected.");
    } else {
        for (String item : selectedItems) {
            previewMessage.append(item).append("<br>");
        }
    }
    previewMessage.append("</html>");
    JLabel previewLabel = new JLabel(previewMessage.toString());
    previewLabel.setBounds(20, 50, 360, 100);
    finalizeFrame.add(previewLabel);

    // Calculate total cost
    double totalCost = calculator.calculateTotal();
    String formattedTotalCost = String.format("%.2f", totalCost);

    // Label to display total cost
    JLabel totalCostLabel = new JLabel("Total Cost: RM " + formattedTotalCost);
    totalCostLabel.setFont(new Font("MS Gothic", Font.BOLD, 12));
    totalCostLabel.setBounds(20, 185, 360, 25);
    finalizeFrame.add(totalCostLabel);

    // Address input field
    JLabel addressLabel = new JLabel("Enter Address:");
    addressLabel.setFont(new Font("MS Gothic", Font.BOLD, 12));
    addressLabel.setBounds(20, 230, 100, 25);
    finalizeFrame.add(addressLabel);

    JTextField addressField = new JTextField();
    addressField.setBounds(130, 230, 200, 25);
    finalizeFrame.add(addressField);
    
    JLabel phoneLabel = new JLabel("Phone Number:");
    phoneLabel.setFont(new Font("MS Gothic", Font.BOLD, 12));
    phoneLabel.setBounds(20, 260, 100, 25);
    finalizeFrame.add(phoneLabel);

    JTextField phoneField = new JTextField();
    phoneField.setBounds(130, 260, 200, 25);
    finalizeFrame.add(phoneField);

    // Payment method selection
    JLabel paymentLabel = new JLabel("Payment Method:");
    paymentLabel.setFont(new Font("MS Gothic", Font.BOLD, 12));
    paymentLabel.setBounds(20, 290, 200, 25);
    finalizeFrame.add(paymentLabel);

    JComboBox<String> paymentComboBox = new JComboBox<>(new String[]{"Credit Card", "Debit Card", "Cash", "TnG"});
    paymentComboBox.setBounds(130, 290, 200, 25);
    finalizeFrame.add(paymentComboBox);

    // Button to finalize the order
    JButton finalizeButton = new JButton("Finalize Order");
    finalizeButton.setFont(new Font("MV Boli", Font.BOLD, 14));
    finalizeButton.setBounds(20, 350, 150, 40);
    finalizeFrame.add(finalizeButton);

    // Button to go back to the main menu
    JButton backButton = new JButton("Back to Menu");
    backButton.setFont(new Font("MV Boli", Font.BOLD, 14));
    backButton.setBounds(180, 350, 150, 40);
    finalizeFrame.add(backButton);

    // Action listener for Finalizing the order
    // Add KeyListener to restrict input to numbers only
phoneField.addKeyListener(new KeyAdapter() {
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume(); // Ignore non-digit input
        }
    }
});

finalizeButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Validate the address, phone number, and payment method
        String address = addressField.getText().trim();
        String phoneNumber = phoneField.getText().trim(); // Retrieve phone number input
        String paymentMethod = (String) paymentComboBox.getSelectedItem();

        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(finalizeFrame, "Address is required to finalize the order.");
            return; // Exit if no address is entered
        }
        
        if (phoneNumber.length() != 10) {
                    JOptionPane.showMessageDialog(finalizeFrame, "Phone number must be 10 digits.");
                    return; // Exit if phone number is not 10 digits
        }
        
        if (phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(finalizeFrame, "Phone number is required to finalize the order.");
            return; // Exit if no phone number is entered
        }
        
        if (paymentMethod == null || paymentMethod.isEmpty()) {
            JOptionPane.showMessageDialog(finalizeFrame, "Please select a payment method.");
            return; // Exit if no payment method is selected
        }

        // Display the order summary
StringBuilder orderSummary = new StringBuilder("<html><body style='font-family:MS Gothic;font-size:10px;'>Order Summary:<br><br>");
for (String item : selectedItems) {
    orderSummary.append(item).append("<br>");
}
orderSummary.append("<br>Address: ").append(address);
orderSummary.append("<br>Phone Number: ").append(phoneNumber); // Add phone number to summary
orderSummary.append("<br>Payment Method: ").append(paymentMethod);
orderSummary.append("<br>Total Cost: RM").append(formattedTotalCost);
orderSummary.append("</body></html>");

// Show the order summary with custom font
ImageIcon customIcon = new ImageIcon("fd.png"); // Replace with your image path
JOptionPane.showMessageDialog(finalizeFrame, orderSummary.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE, customIcon);

calculator.clearItems(); // Clear the items after finalizing the order
finalizeFrame.dispose(); // Close the finalize order frame
frame.setVisible(true); // Show the main menu again
    }
});
    // Action listener for going back to the main menu
    backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            finalizeFrame.dispose(); // Close the finalize order frame
            frame.setVisible(true); // Show the main menu again
        }
    });

    // Hide the main menu
    frame.setVisible(false);

    // Show the finalize order frame
    finalizeFrame.setVisible(true);
}

private void exitSystem() {
    try {
        // Custom icon for the confirmation dialog
        ImageIcon customIcon = new ImageIcon("fd.png"); // Replace with your image path if needed

        // HTML formatted message for the font and size
        String message = "<html><body style='font-family:MS Gothic;font-size:10px;'><b>Are you sure you want to exit?</body></html>";

        // Show confirmation dialog with custom font
        int confirm = JOptionPane.showConfirmDialog(frame, message, "Confirm Exit",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, customIcon);

        // If the user clicked "Yes", dispose of the frame and close the application
        if (confirm == JOptionPane.YES_OPTION) {
            frame.dispose(); // Close the application without showing "Thank you" message
            System.exit(0); // Ensure the application exits properly
        }
        // No action is needed if the user clicked "No"
    } catch (Exception e) {
        String errorMessage = "<html><body style='font-family:MS Gothic;font-size:10px;'><b>An error occurred while exiting: " + e.getMessage() + "</body></html>";
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public static void main(String[] args) {
        new FoodDelivery();
    }
}
