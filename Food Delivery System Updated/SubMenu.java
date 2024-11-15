    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

    public class SubMenu {
        private Calculator calculator;  // The calculator to manage the selected items
        private JFrame frame;           // The frame for the submenu
        private JComboBox<String> foodComboBox;  // Combo box for displaying menu items
        private JButton addButton;      // Button to add an item to the order
        private JButton removeButton;   // Button to remove an item from the order
        private JButton doneButton;     // Button to exit the submenu
        private Restaurant restaurant;  // The selected restaurant for the submenu

        public SubMenu(Calculator calculator, FoodDelivery foodDelivery, Restaurant restaurant) {
            this.calculator = calculator;
            this.restaurant = restaurant;

            // Create the frame for the submenu with the updated size
            frame = new JFrame("Select Food Item - " + restaurant.getName());
            frame.setSize(385, 350); // Updated size to match main menu
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            ImageIcon icon = new ImageIcon("fd.png"); 
            frame.setIconImage(icon.getImage());

            // Label for selecting food item
            JLabel selectLabel = new JLabel("Select Food Item :");
            selectLabel.setFont(new Font("Roboto", Font.BOLD, 12));
            selectLabel.setBounds(20, 22, 120, 25);
            frame.add(selectLabel);

            // ComboBox to display food items from the selected restaurant's menu
            foodComboBox = new JComboBox<>(restaurant.getMenuItems().toArray(new String[0]));
            foodComboBox.setBounds(150, 20, 200, 30);
            frame.add(foodComboBox);

            // Common button size and font
            Dimension buttonSize = new Dimension(250, 50);
            Font buttonFont = new Font("MV Boli", Font.BOLD, 18);

            // Button to add the selected item
            addButton = new JButton("Add Item");
            addButton.setFont(buttonFont);
            addButton.setSize(buttonSize);
            addButton.setLocation(60, 80); // Adjusted location
            frame.add(addButton);

            // Button to remove the selected item
            removeButton = new JButton("Remove Item");
            removeButton.setFont(buttonFont);
            removeButton.setSize(buttonSize);
            removeButton.setLocation(60, 140); // Adjusted location
            frame.add(removeButton);

            // Button to exit the submenu
            doneButton = new JButton("Done");
            doneButton.setFont(buttonFont);
            doneButton.setSize(buttonSize);
            doneButton.setLocation(60, 200); // Adjusted location
            frame.add(doneButton);

            // Action listener for adding an item to the order
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addItem();  // Add item to order
                }
            });

            // Action listener for removing an item from the order
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeItem();  // Remove item from order
                }
            });

            // Action listener for exiting the submenu
            doneButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();  // Close the submenu frame
                }
            });
        }

        // This method displays the submenu to the user.
        public void displayMenu() {
    frame.setVisible(true);  // Show the submenu frame
}

private void addItem() {
    String selectedItem = (String) foodComboBox.getSelectedItem();
    calculator.addItem(selectedItem);  // Add item to the calculator

    // HTML formatted message for MS Gothic, bold, and size 10
    String message = "<html><body style='font-family:MS Gothic;font-size:10px;'><b>Item added to order! Current items: " 
                     + calculator.getSelectedItems() + "</b></body></html>";
    JOptionPane.showMessageDialog(frame, message);
}

private void removeItem() {
    String selectedItem = (String) foodComboBox.getSelectedItem();
    // Attempt to remove the item from the selected items list
    if (calculator.getSelectedItems().remove(selectedItem)) {
        // HTML formatted message for MS Gothic, bold, and size 10
        String message = "<html><body style='font-family:MS Gothic;font-size:10px;'><b>Item removed from order! Current items: " 
                         + calculator.getSelectedItems() + "</b></body></html>";
        JOptionPane.showMessageDialog(frame, message);
    } else {
        // HTML formatted message for MS Gothic, bold, and size 10
        String message = "<html><body style='font-family:MS Gothic;font-size:10px;'><b>Item not found in order!</b></body></html>";
        JOptionPane.showMessageDialog(frame, message);  // Show error if item not found
    }
}}