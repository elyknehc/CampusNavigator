package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Group 51
 * Login panel represents a user logging into admin select
 */
public class LoginPanel extends JPanel{
    //Declare constants
    private JLabel IncorrectPassword;
    private JLabel CorrectPassword;
    private JButton enterButton;
    private JTextField passwordField;
    private String password;

    LoginPanel() {
        /**
         * Constructor for creating a login panel
         */
        String background = "#a37cf0";
        setLayout(null);

        // create JLabels for password prompt and set properties
        JLabel passwordLabel1 = new JLabel("Enter Admin Password");
        passwordLabel1.setFont(new Font("Balsamiq", Font.PLAIN, 20));

        // create JTextField for password input and set properties
        passwordField = new JTextField();

        // create JLabel for title
        JLabel titleLabel = new JLabel("Welcome Back");
        titleLabel.setFont(new Font("Balsamiq", Font.PLAIN, 40));

        IncorrectPassword = new JLabel("Incorrect Password");
        IncorrectPassword.setFont(new Font("Balsamiq", Font.BOLD, 20));
        IncorrectPassword.setForeground(Color.RED);

        CorrectPassword = new JLabel("Correct Password");
        CorrectPassword.setFont(new Font("Balsamiq", Font.BOLD, 20));
        CorrectPassword.setForeground(Color.GREEN);

        // create JButton for entering password and set properties
        enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == enterButton) {
                    password = passwordField.getText();
                    if (password.equals("adminPassword")) {
                        add(CorrectPassword);
                        remove(IncorrectPassword);
                        repaint();
                        User.setAdmin(true);
                    } else {
                        add(IncorrectPassword);
                        addIncorrect();
                        repaint();
                    }
                }
            }
        });

        titleLabel.setBounds(85, 220, 300, 40);
        passwordLabel1.setBounds(100, 280, 300, 20);
        passwordField.setBounds(100, 300, 200, 25);
        enterButton.setBounds(100, 340, 200, 20);
        IncorrectPassword.setBounds(90, 380, 600, 50);
        CorrectPassword.setBounds(90, 380, 600, 50);



        // add components to left panel
        add(passwordLabel1);
        add(passwordField);
        add(enterButton);
        add(titleLabel);
        setBackground(Color.decode(background));

    }

    private void addIncorrect() {
        add(IncorrectPassword);
        revalidate();
        repaint();
    }

}
