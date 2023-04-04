package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is for the login panel and allowing users to become admin
 * @authors Kevin Chau 
 * @
 */

public class LoginPanel extends JPanel{
    private JButton enterButton;
    private JTextField passwordField;
    private String password;
    public static boolean pressed = false;
    
    LoginPanel() {
        String background = "#a37cf0";
        setLayout(null);

        // create JLabels for password prompt and set properties
        JLabel passwordLabel1 = new JLabel("Enter Admin Password");
        passwordLabel1.setFont(new Font("Balsamiq", Font.PLAIN,20));

        // create JTextField for password input and set properties
        passwordField = new JTextField();

                // create JLabel for title
                JLabel titleLabel = new JLabel("Welcome Back");
                titleLabel.setFont(new Font("Balsamiq", Font.PLAIN, 40));

        // create JButton for entering password and set properties
        enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==enterButton) {
                    password = passwordField.getText();
                    if (password.equals("adminPassword")){
                        System.out.println("Correct password");
                        User.setAdmin(true);
                        pressed = true;
                    } else {
                        User.setAdmin(false);
                        pressed = true;
                    }
                }
                System.out.println(password); //Filler
            }
        });

        titleLabel.setBounds(85, 220, 300, 40);
        passwordLabel1.setBounds(100, 280, 300, 20);
        passwordField.setBounds(100, 300, 200, 25);
        enterButton.setBounds(100,340, 200, 20);

        // add components to left panel
        add(passwordLabel1);
        add(passwordField);
        add(enterButton);
        add(titleLabel);
        setBackground(Color.decode(background));

    }

}
