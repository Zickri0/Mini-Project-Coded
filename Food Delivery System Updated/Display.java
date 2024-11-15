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

public class Display {
    public void showAddressAndPayment(String address, String paymentMethod) {
        // Show a message dialog with the address and payment method
        JOptionPane.showMessageDialog(null, "Address: " + address + "\nPayment Method: " + paymentMethod);
    }

     public void showTotalCost(double totalCost) {
        // Show a message dialog with the total cost
        JOptionPane.showMessageDialog(null, "Total Cost: $" + totalCost);
    }
}
