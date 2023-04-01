
package com.example;
import javax.swing.*;
import java.awt.*;

public class CreatePOIScreen extends JFrame {
    private JTextField nameField;
    private JTextField categoryField;
    private JTextField descriptionField;
    private JTextField idField;
    private JCheckBox favoriteCheckBox;
    private JTextField floorField;

    public CreatePOIScreen() {
        setTitle("CreatePOIScreen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));
        setSize(400, 250);

        JLabel nameLabel = new JLabel("Name of POI: ");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);

        JLabel categoryLabel = new JLabel("Category: ");
        add(categoryLabel);
        categoryField = new JTextField();
        add(categoryField);

        JLabel descriptionLabel = new JLabel("Description: ");
        add(descriptionLabel);
        descriptionField = new JTextField();
        add(descriptionField);

        JLabel idLabel = new JLabel("POI ID: ");
        add(idLabel);
        idField = new JTextField();
        add(idField);

        JLabel favoriteLabel = new JLabel("Favorite: ");
        add(favoriteLabel);
        favoriteCheckBox = new JCheckBox();
        add(favoriteCheckBox);

        JLabel floorLabel = new JLabel("Floor Number: ");
        add(floorLabel);
        floorField = new JTextField();
        add(floorField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(event -> {
            // Save the information here
            String poiName = nameLabel.getText();
            String poiCategory = categoryLabel.getText();
            String poiDescription = descriptionLabel.getText();
            int poiID = Integer.parseInt(idLabel.getText());
            String poiFloor = floorLabel.getText();


            POI newPOI = new POI(poiName, poiDescription, poiCategory, poiID);
            User.userPOIList.add(newPOI);
        
            dispose(); // Close the frame
        });
        add(submitButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(event -> {
            User.setCancel(true);
            dispose(); // Close the frame
        });
        add(cancelButton);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CreatePOIScreen();
    }
}
