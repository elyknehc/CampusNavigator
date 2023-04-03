package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePOIScreen extends JFrame {
    private JTextField nameField;
    private JTextField categoryField;
    private JTextField descriptionField;
    private JTextField roomNumberField;
    private JTextField idField;
    private JCheckBox favoriteCheckBox;
    private JTextField floorField;

    public CreatePOIScreen(int x, int y) {
        setTitle("CreatePOIScreen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));
        setSize(400, 250);

        final int coordinateX = x;
        final int coordinateY = y;

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

        String[] buildings = {"MC", "HSB", "UC"};
        final JComboBox<String> buildingsDropdown = new JComboBox<>(buildings);
        add(buildingsDropdown);

        JLabel roomNumberLabel = new JLabel("Room Number: ");
        add(roomNumberLabel);
        roomNumberField = new JTextField();
        add(roomNumberField);

        // JLabel idLabel = new JLabel("POI ID: ");
        // add(idLabel);
        // idField = new JTextField();
        // add(idField);

        JLabel favoriteLabel = new JLabel("Favorite: ");
        add(favoriteLabel);
        favoriteCheckBox = new JCheckBox();
        add(favoriteCheckBox);

        JLabel floorLabel = new JLabel("Floor Number: ");
        add(floorLabel);
        floorField = new JTextField();
        add(floorField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                            // Save the information here
            String poiName = nameField.getText();
            String poiCategory = categoryField.getText();
            String poiDescription = descriptionField.getText();
            String poiBuilding = buildingsDropdown.getSelectedItem().toString();
            int poiRoomNumber = Integer.parseInt(roomNumberField.getText());
            // String labelID = idLabel.getText();
            // int poiID = Integer.parseInt(labelID);
            int poiFloor = Integer.parseInt(floorField.getText());
            boolean poiFavorite = favoriteCheckBox.isSelected();

<<<<<<< HEAD
            User currentSessionData = new User();
            POI newPOI = new POI(poiName, poiDescription, poiCategory, poiBuilding, 1, coordinateX, coordinateY, poiRoomNumber, poiFloor, poiFavorite, !currentSessionData.getAdmin());
            User.addToAllPOI(newPOI);
=======
            POI changeCurrentPOI = User.getCurPoi();
            changeCurrentPOI.setName(poiName);
            changeCurrentPOI.setCategory(poiCategory);
            changeCurrentPOI.setBuilding(poiBuilding);
            changeCurrentPOI.setDescription(poiDescription);
            changeCurrentPOI.setRoomNum(poiRoomNumber);
            changeCurrentPOI.setFloor(poiFloor);
            changeCurrentPOI.setIsFavourite(poiFavorite);

            // POI newPOI = new POI(poiName, poiDescription, poiCategory, poiBuilding, 1, coordinateX, coordinateY, poiRoomNumber, poiFloor, poiFavorite, User.getAdmin());
            // User.addToAllPOI(newPOI);
>>>>>>> bb9d6fcfe4230bcad975e04d48e3ef806529b96d
        
            dispose(); // Close the frame
            }

        });
        add(submitButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            //User.setCancel(true);
            dispose(); // Close the frame
            }
        });
        add(cancelButton);
        setVisible(true);
    }
}
