package hust.soict.dsai.lab01;

import javax.swing.*;

public class CalculatorDialog {
    public static void main(String[] args) {
        String strnum1, strnum2;
        String strNotification1 = "The sum of: ";
        String strNotification2 = "The difference of: ";
        String strNotification3 = "The product of: ";
        String strNotification4 = "The quotient of: ";

        double sum = 0;
        double difference = 0;
        double product = 0;
        double quotient = 0;

        // Input first number
        strnum1 = JOptionPane.showInputDialog(null, "Please input your first number: ",
                "Input First Number",
                JOptionPane.INFORMATION_MESSAGE);
        strNotification1 += strnum1 + " and ";

        // Input second number
        strnum2 = JOptionPane.showInputDialog(null, "Please input your second number: ",
                "Input Second Number",
                JOptionPane.INFORMATION_MESSAGE);
        strNotification1 += strnum2;

        // Parse input to double
        double num1 = Double.parseDouble(strnum1);
        double num2 = Double.parseDouble(strnum2);

        // Perform calculations
        sum = num1 + num2;
        difference = num1 - num2;
        product = num1 * num2;

        // Handle division by zero
        if (num2 != 0) {
            quotient = num1 / num2;
            strNotification4 += num1 + " and " + num2 + " is: " + quotient;
        } else {
            strNotification4 += num1 + " and " + num2 + " cannot be calculated (division by zero).";
        }

        // Display results
        JOptionPane.showMessageDialog(null,
                strNotification1 + " is: " + sum + "\n" +
                        strNotification2 + num1 + " and " + num2 + " is: " + difference + "\n" +
                        strNotification3 + num1 + " and " + num2 + " is: " + product + "\n" +
                        strNotification4,
                "Calculation Results",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
