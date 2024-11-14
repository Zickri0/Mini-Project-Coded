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

            // Create the frame for the submenu
            frame = new JFrame("Select Food Item - " + restaurant.getName());
            frame.setSize(300, 200);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            ImageIcon icon = new ImageIcon("fd.png"); 
            frame.setIconImage(icon.getImage());

            // Label for selecting food item
            JLabel selectLabel = new JLabel("Select Food Item:");
            selectLabel.setBounds(20, 20, 120, 25);
            frame.add(selectLabel);

            // ComboBox to display food items from the selected restaurant's menu
            foodComboBox = new JComboBox<>(restaurant.getMenuItems().toArray(new String[0]));
            foodComboBox.setBounds(150, 20, 120, 25);
            frame.add(foodComboBox);

            // Button to add the selected item
            addButton = new JButton("Add Item");
            addButton.setBounds(20, 60, 120, 25);
            frame.add(addButton);

            // Button to remove the selected item
            removeButton = new JButton("Remove Item");
            removeButton.setBounds(150, 60, 120, 25);
            frame.add(removeButton);

            // Button to exit the submenu
            doneButton = new JButton("Done");
            doneButton.setBounds(90, 100, 120, 25);
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

        // This method adds the selected item to the order.
        private void addItem() {
            String selectedItem = (String) foodComboBox.getSelectedItem();
            calculator.addItem(selectedItem);  // Add item to the calculator
            JOptionPane.showMessageDialog(frame, "Item added to order! Current items: " + calculator.getSelectedItems());
        }

        // This method removes the selected item from the order.
        private void removeItem() {
            String selectedItem = (String) foodComboBox.getSelectedItem();
            // Attempt to remove the item from the selected items list
            if (calculator.getSelectedItems().remove(selectedItem)) {
                JOptionPane.showMessageDialog(frame, "Item removed from order! Current items: " + calculator.getSelectedItems());
            } else {
                JOptionPane.showMessageDialog(frame, "Item not found in order!");  // Show error if item not found
            }
        }
    }
