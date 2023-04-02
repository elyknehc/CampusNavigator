package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel{
    private JButton enterButton;
    private JTextField passwordField;
    private String password;
    public static boolean pressed = false;
    
    LoginPanel() {
        // create JPanel for left panel and set properties
        setBounds(0, 0, 333, 523);
        setLayout(null);
        System.out.println(pressed);

        // LEFT PANEL
        // create JLabels for password prompt and set properties
        JLabel passwordLabel1 = new JLabel("Enter a password for admin access,");
        passwordLabel1.setBounds(70, 200, 400, 50);
        passwordLabel1.setFont(new Font("Balsamiq", Font.PLAIN,20));
        JLabel passwordLabel2 = new JLabel("or leave blank for general access:");
        passwordLabel2.setBounds(70, 230, 400, 50);
        passwordLabel2.setFont(new Font("Balsamiq", Font.PLAIN, 20));

        // create JTextField for password input and set properties
        passwordField = new JTextField();
        passwordField.setBounds(75, 265, 200, 25);

        // create JButton for entering password and set properties
        enterButton = new JButton("Enter");
        enterButton.setBounds(75, 280, 200, 25);
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==enterButton) {
                    password = passwordField.getText();
                    if (password.equals("adminPassword")){
                        System.out.println("Correct password");
                        Main.currUser.setAdmin(true);
                        pressed = true;
                    } else {
                        Main.currUser.setAdmin(false);
                        pressed = true;
                    }
                }
                System.out.println(password); //Filler
                System.out.println(pressed);
            }
        });

        // create JLabel for title
        JLabel titleLabel = new JLabel("Western University GIS");
        titleLabel.setBounds(50, 20, 340, 60);
        titleLabel.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        // add components to left panel
        add(passwordLabel1);
        add(passwordLabel2);
        add(passwordField);
        add(enterButton);
        add(titleLabel);
    }

}
