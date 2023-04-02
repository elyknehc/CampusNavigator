package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener {
    private JButton loginButton, changeButton, backButton;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JPanel loginPanel, changePanel;
    
    public AdminLogin() {
        // Set the properties of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Login");
        setSize(1000, 500);
        getContentPane().setBackground(Color.WHITE);

        // Create the login panel and add the login button and password field to it
        loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        passwordLabel = new JLabel("Password:");
        loginPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        passwordField = new JPasswordField(20);
        loginPanel.add(passwordField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginPanel.add(loginButton, gbc);
        add(loginPanel, BorderLayout.CENTER);

        // Create the change panel and add the change button and back button to it
        changePanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        changeButton = new JButton("Change Metadata of POI");
        changeButton.addActionListener(this);
        changePanel.add(changeButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        backButton = new JButton("Go Back");
        backButton.addActionListener(this);
        changePanel.add(backButton, gbc);
        changePanel.setVisible(false);
        add(changePanel, BorderLayout.SOUTH);

        // Set the JFrame to be visible
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String password = new String(passwordField.getPassword());
            if (password.equals("jword123")) {
                loginPanel.setVisible(false);
                changePanel.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == changeButton) {
            // Code to change the metadata of POI
            // ...
            JOptionPane.showMessageDialog(null, "Metadata changed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == backButton) {
            passwordField.setText("");
            changePanel.setVisible(false);
            loginPanel.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AdminLogin();
    }
}
