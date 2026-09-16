package com.mycompany.practical_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Practical 8: A: Construct a simple calculator using Java Swing with minimum functionality.
 */
public class Practical8A extends JFrame implements ActionListener {

    private JTextField displayField;
    private double num1 = 0;
    private double num2 = 0;
    private char operator = '\0';
    private boolean startNewNumber = true;

    public Practical8A() {
        // Configure Frame
        setTitle("Practical 8A: Simple Calculator");
        setSize(360, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Display TextField
        displayField = new JTextField("0");
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Arial", Font.BOLD, 28));
        displayField.setBackground(Color.WHITE);
        displayField.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(displayField, BorderLayout.NORTH);

        // Buttons Panel (4x4 Grid)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 22));
            button.setFocusPainted(false);

            // Styling buttons
            if (label.equals("=")) {
                button.setBackground(new Color(66, 133, 244));
                button.setForeground(Color.WHITE);
            } else if (label.equals("C")) {
                button.setBackground(new Color(234, 67, 53));
                button.setForeground(Color.WHITE);
            } else if (label.matches("[+\\-*/]")) {
                button.setBackground(new Color(241, 243, 244));
                button.setForeground(new Color(32, 33, 36));
            } else {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
            }

            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            // Digit button clicked
            if (startNewNumber || displayField.getText().equals("0") || displayField.getText().equals("Error")) {
                displayField.setText(command);
                startNewNumber = false;
            } else {
                displayField.setText(displayField.getText() + command);
            }
        } else if (command.equals("C")) {
            // Clear button clicked
            num1 = 0;
            num2 = 0;
            operator = '\0';
            startNewNumber = true;
            displayField.setText("0");
        } else if (command.equals("=")) {
            // Equal button clicked
            if (operator != '\0' && !startNewNumber) {
                try {
                    num2 = Double.parseDouble(displayField.getText());
                    double result = calculate(num1, num2, operator);

                    if (Double.isInfinite(result) || Double.isNaN(result)) {
                        displayField.setText("Error");
                    } else {
                        // Display whole numbers without trailing .0
                        if (result == (long) result) {
                            displayField.setText(String.valueOf((long) result));
                        } else {
                            displayField.setText(String.valueOf(result));
                        }
                    }
                } catch (Exception ex) {
                    displayField.setText("Error");
                }
                operator = '\0';
                startNewNumber = true;
            }
        } else {
            // Operator (+, -, *, /) clicked
            try {
                if (operator != '\0' && !startNewNumber) {
                    // Chain calculations if user clicks e.g. 5 + 3 + ...
                    num2 = Double.parseDouble(displayField.getText());
                    num1 = calculate(num1, num2, operator);
                    if (num1 == (long) num1) {
                        displayField.setText(String.valueOf((long) num1));
                    } else {
                        displayField.setText(String.valueOf(num1));
                    }
                } else {
                    num1 = Double.parseDouble(displayField.getText());
                }
                operator = command.charAt(0);
                startNewNumber = true;
            } catch (Exception ex) {
                displayField.setText("Error");
                startNewNumber = true;
            }
        }
    }

    private double calculate(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) {
                    return Double.NaN;
                }
                return a / b;
            default: return b;
        }
    }

    public static void main(String[] args) {
        // Set Look and Feel to System Default for native look
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> {
            new Practical8A().setVisible(true);
        });
    }
}
