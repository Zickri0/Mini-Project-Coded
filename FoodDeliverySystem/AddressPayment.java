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

public class AddressPayment {
    private String address;
    private String paymentMethod;

    public void inputAddress() {
        address = JOptionPane.showInputDialog("Enter your delivery address:");
    }

    public void selectPaymentMethod() {
        // List of payment method options
        String[] options = {"Credit Card", "Cash", "Debit Card", "TnG"};
        paymentMethod = (String) JOptionPane.showInputDialog(null, "Select Payment Method:", "Payment Method",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    public String getAddress() {
        return address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}


