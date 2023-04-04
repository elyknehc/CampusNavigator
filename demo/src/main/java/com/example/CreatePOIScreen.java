package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents a POI creation screen when the user wants to create a new POI, it asks them to enter fields for a new POI being created.
 * @author Kyle Chen
 */
public class CreatePOIScreen extends JFrame {
    
    //Declare constants
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField roomNumberField;
    private JTextField idField;
    private JCheckBox favoriteCheckBox;
    private JTextField floorField;
    private JComboBox<String> categoryComboBox;
    private boolean invalid = false;
    private JLabel unfinished;
    private POI currentPOI;

    /**
     * This function creates a new POI screen
     * @param x: X coordinate
     * @param y: y coordinate
     * @param currPOI: currentPOI of user
     */
    public CreatePOIScreen(int x, int y, POI curPOI) {
        
        setTitle("CreatePOIScreen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));
        setSize(400, 350);

        final int coordinateX = x;
        final int coordinateY = y;
        currentPOI = curPOI;


        //Add labels and buttons to the POI screen
        JLabel nameLabel = new JLabel("Name of POI: ");
        add(nameLabel);
        nameField = new JTextField();
        nameField.setSize(50, 20);
        add(nameField);

        JLabel categoryLabel = new JLabel("Category: ");
        String[] categories = {"washrooms", "classrooms", "stairwells", "genLabs", "sports", "entryExits", "elevators", "restaurants", "computerLabs", "collabRooms"};
        categoryComboBox = new JComboBox<>(categories);
        add(categoryLabel);
        add(categoryComboBox);


        JLabel descriptionLabel = new JLabel("Description: ");
        add(descriptionLabel);
        descriptionField = new JTextField();
        add(descriptionField);


        //Building options
        String[] buildings = {"MC", "HSB", "UC"};

        JLabel roomNumberLabel = new JLabel("Room Number: ");
        add(roomNumberLabel);
        roomNumberField = new JTextField();
        add(roomNumberField);

        JLabel favoriteLabel = new JLabel("Favorite: ");
        add(favoriteLabel);
        favoriteCheckBox = new JCheckBox();
        add(favoriteCheckBox);

        //If the information is not completely filled
        unfinished = new JLabel("Invalid Response");
        unfinished.setForeground(Color.RED);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {

                // Save the information here
            try{
                String poiName = nameField.getText();
                String poiDescription = descriptionField.getText();
                String poiBuilding = User.getCurBuilding();
                int poiRoomNumber = Integer.parseInt(roomNumberField.getText());
                int poiFloor = User.getCurFloor();
                String poiCategory = (String) categoryComboBox.getSelectedItem();
                boolean poiFavorite = favoriteCheckBox.isSelected();
            
                    if (poiName.length() == 0 || poiDescription.length() == 0
                            || poiDescription.length() == 0) {
                        invalid = true;
                        add(unfinished);
                        repaint();
                        return;
                }
                //Set the POI info that the user entering
                POI changeCurrentPOI = User.getCurPoi();
                changeCurrentPOI.setName(poiName);
                changeCurrentPOI.setBuilding(poiBuilding);
                changeCurrentPOI.setDescription(poiDescription);
                changeCurrentPOI.setRoomNum(poiRoomNumber);
                changeCurrentPOI.setFloor(poiFloor);
                changeCurrentPOI.setIsFavourite(poiFavorite);
                changeCurrentPOI.setCategory(poiCategory);
                
                User.setCurPoi(null);
                mapExplorePanel.updateFavouritePOI();
				mapExplorePanel.updateUserPOI();
                MapScrollPanel.repaintMapPOI();
                User.setCreating(false);
            
                dispose(); // Close the frame
            }
                catch (Exception exp) {
                    invalid = true;
                    add(unfinished);
                    revalidate();
                    repaint();

            }
            }

        });
        add(submitButton);
        
        //Cancelling a POI and removing it from the screen
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                User.removeFromAllPOI(currentPOI);
                User.setCurPoi(null);
                MapScrollPanel.repaintMapPOI();
                User.setCreating(false);
                dispose(); // Close the frame
            }
        });
        add(cancelButton);
        setVisible(true);
        setResizable(false);
    }
}