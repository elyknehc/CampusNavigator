
package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreatePOIScreen extends JFrame implements ActionListener {
    private JButton createButton, titleButton, xButton, yButton, saveButton, cancelButton;
    private JTextField titleField, xField, yField, infoField;
    private JLabel titleLabel, xLabel, yLabel, infoLabel;
    private JPanel createPanel, infoPanel;
    
    public CreatePOIScreen() {
        // Set the properties of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Create Point of Interest");
        setSize(500, 500);
        getContentPane().setBackground(Color.BLUE);

        // Create the create panel and add the create button to it
        createPanel = new JPanel();
        createButton = new JButton("Create Point of Interest");
        createButton.addActionListener(this);
        createPanel.add(createButton);
        add(createPanel, BorderLayout.NORTH);

        // Create the info panel and add the buttons and fields to it
        infoPanel = new JPanel(new GridLayout(5, 2));
        titleLabel = new JLabel("Title of Point of Interest:");
        titleField = new JTextField(20);
        xLabel = new JLabel("X location:");
        xField = new JTextField(5);
        yLabel = new JLabel("Y location:");
        yField = new JTextField(5);
        infoLabel = new JLabel("Information:");
        infoField = new JTextField(20);
        titleButton = new JButton("Enter Title");
        xButton = new JButton("Enter X");
        yButton = new JButton("Enter Y");
        saveButton = new JButton("Save Point of Interest");
        cancelButton = new JButton("Cancel");
        titleButton.addActionListener(this);
        xButton.addActionListener(this);
        yButton.addActionListener(this);
        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);
        infoPanel.add(titleLabel);
        infoPanel.add(titleField);
        infoPanel.add(xLabel);
        infoPanel.add(xField);
        infoPanel.add(yLabel);
        infoPanel.add(yField);
        infoPanel.add(infoLabel);
        infoPanel.add(infoField);
        infoPanel.add(cancelButton);
        infoPanel.add(saveButton);
        infoPanel.setVisible(false);
        add(infoPanel, BorderLayout.CENTER);

        // Set the JFrame to be visible
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            createPanel.setVisible(false);
            infoPanel.setVisible(true);
        } else if (e.getSource() == saveButton) {
            // Code to save all the information entered by the user
            String title = titleField.getText();
            int x = Integer.parseInt(xField.getText());
            int y = Integer.parseInt(yField.getText());
            String info = infoField.getText();
            
            // Code to save the point of interest with the above information
            // ...
            
            // Reset the input fields
            titleField.setText("");
            xField.setText("");
            yField.setText("");
            infoField.setText("");
            
            infoPanel.setVisible(false);
            createPanel.setVisible(true);
        } else if (e.getSource() == cancelButton) {
            infoPanel.setVisible(false);
            createPanel.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new CreatePOIScreen();
    }
}