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
    private boolean invalid = false;
    private JLabel unfinished;
    private POI currentPOI;

    public CreatePOIScreen(int x, int y, POI curPOI) {
        setTitle("CreatePOIScreen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));
        setSize(400, 350);

        final int coordinateX = x;
        final int coordinateY = y;
        currentPOI = curPOI;

        JLabel nameLabel = new JLabel("Name of POI: ");
        add(nameLabel);
        nameField = new JTextField();
        nameField.setSize(50, 20);
        add(nameField);

        JLabel categoryLabel = new JLabel("Category: ");
        add(categoryLabel);
        categoryField = new JTextField();
        add(categoryField);

        JLabel descriptionLabel = new JLabel("Description: ");
        add(descriptionLabel);
        descriptionField = new JTextField();
        add(descriptionField);

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


        unfinished = new JLabel("Invalid Response");
        unfinished.setForeground(Color.RED);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // Save the information here
            try{
                String poiName = nameField.getText();
                String poiCategory = categoryField.getText();
                String poiDescription = descriptionField.getText();
                String poiBuilding = User.getCurBuilding();
                    int poiRoomNumber = Integer.parseInt(roomNumberField.getText());
                    int poiFloor = User.getCurFloor();
                // String labelID = idLabel.getText();
                // int poiID = Integer.parseInt(labelID);
                boolean poiFavorite = favoriteCheckBox.isSelected();
                
                    if (poiName.length() == 0 || poiCategory.length() == 0 || poiDescription.length() == 0
                            || poiDescription.length() == 0) {
                        invalid = true;
                        add(unfinished);
                        repaint();
                        return;
                }

                POI changeCurrentPOI = User.getCurPoi();
                changeCurrentPOI.setName(poiName);
                changeCurrentPOI.setCategory(poiCategory);
                changeCurrentPOI.setBuilding(poiBuilding);
                changeCurrentPOI.setDescription(poiDescription);
                changeCurrentPOI.setRoomNum(poiRoomNumber);
                changeCurrentPOI.setFloor(poiFloor);
                changeCurrentPOI.setIsFavourite(poiFavorite);
                
                User.setCurPoi(null);
                MapScrollPanel.repaintMapPOI();
            
                dispose(); // Close the frame
            }
                catch (Exception exp) {
                    System.out.println(exp);
                    invalid = true;
                    add(unfinished);
                    revalidate();
                    repaint();

            }
            }

        });
        add(submitButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                User.removeFromAllPOI(currentPOI);
                User.setCurPoi(null);
                dispose(); // Close the frame
            }
        });
        add(cancelButton);
        setVisible(true);
        setResizable(false);
    }
}
