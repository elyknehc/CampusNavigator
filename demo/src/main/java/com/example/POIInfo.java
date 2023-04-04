package com.example;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class is responsible for showing information aout the current POI and offering admins to chance to edit them
 * @authors Kevin Chau
 */

public class POIInfo extends JFrame {
	private POI currentPOI;
	// Create a new frame and pass in a new POI object through it
	POIInfo(POI current) {

		final POI curr = current;
		// Create the labels and fill in information about current POI
		final JLabel title = new JLabel("Point of Interest Information");
		title.setBounds(70, 20, 400, 60);
		final JLabel poiName = new JLabel("Name: " + curr.getName());
		poiName.setBounds(70, 70, 400, 60);
		final JLabel building = new JLabel("Building: " + curr.getBuilding());
		building.setBounds(70, 120, 400, 60);
		final JLabel category = new JLabel("category: " + curr.getCategory());
		category.setBounds(70, 170, 400, 60);
		final JTextArea description = new JTextArea("Description: " + curr.getDescription());
		description.setLineWrap(true);
		description.setEditable(false);
		description.setBounds(70, 220, 400, 60);
		final JLabel floor = new JLabel("Floor: " + curr.getFloor());
		floor.setBounds(70, 270, 400, 60);
		final JLabel favourite = new JLabel("Favourite: " + curr.getIsFavourite());
		favourite.setBounds(70, 320, 200, 60);
		final JLabel adminEdit = new JLabel("Admin Edit");
		adminEdit.setBounds(70, 390, 150, 30);
		final JButton edit = new JButton("Edit");
		edit.setBounds(220, 392, 100, 30);
		final JButton delete = new JButton("Delete");
		delete.setBounds(360, 392, 100, 30);

		// For the admin side if they are an admin
		if (!curr.getIsUser() && !User.getAdmin()) {
			adminEdit.setVisible(false);
			edit.setVisible(false);
			delete.setVisible(false);
		}

		// Set the font for each label
		title.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		description.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		building.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		poiName.setFont(new Font("Balsamiq", Font.BOLD, 20));
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create a new JFrame for editing the POI information
				final JFrame editFrame = new JFrame("Edit POI Information");
				editFrame.setSize(400, 400);
				
				// Create labels and text fields for editing each POI property
				JLabel nameLabel = new JLabel("Name:");
				final JTextField nameField = new JTextField(curr.getName());
				nameLabel.setBounds(20, 20, 80, 20);
				nameField.setBounds(100, 20, 200, 20);
		
				JLabel buildingLabel = new JLabel("Building:");
				final JTextField buildingField = new JTextField(curr.getBuilding());
				buildingLabel.setBounds(20, 60, 80, 20);
				buildingField.setBounds(100, 60, 200, 20);
		
				JLabel categoryLabel = new JLabel("Category:");
				String[] categories = {"washrooms", "classrooms", "genLabs", "entryExits", "elevators", "restaurants", "computerLabs", "collabRooms"};
				final JComboBox categoryComboBox = new JComboBox<>(categories);
				categoryLabel.setBounds(20, 100, 80, 20);
				categoryComboBox.setBounds(100, 100, 200, 20);
		
				JLabel descriptionLabel = new JLabel("Description:");
				final JTextField descriptionField = new JTextField(curr.getDescription());
				descriptionLabel.setBounds(20, 140, 80, 20);
				descriptionField.setBounds(100, 140, 200, 20);
		
				// Add labels and text fields to the frame
				editFrame.add(nameLabel);
				editFrame.add(nameField);
				editFrame.add(buildingLabel);
				editFrame.add(buildingField);
				editFrame.add(categoryLabel);
				editFrame.add(categoryComboBox);
				editFrame.add(descriptionLabel);
				editFrame.add(descriptionField);
		
				// Create a save button to save the edited information
				JButton saveButton = new JButton("Save");
				saveButton.setBounds(150, 250, 80, 30);
		
				saveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Save the edited information to the POI object
						curr.setName(nameField.getText());
						curr.setBuilding(buildingField.getText());
						curr.setCategory((String) categoryComboBox.getSelectedItem());
						curr.setDescription(descriptionField.getText());
	
						// Update the GUI labels with the edited information
						poiName.setText("Name: " + curr.getName());
						building.setText("Building: " + curr.getBuilding());
						category.setText("Category: " + curr.getCategory());
						description.setText("Description: " + curr.getDescription());
						floor.setText("Floor: " + curr.getFloor());
						
						User.addToAllPOI(curr);
						// Close the edit frame
						editFrame.dispose();
					}
				});
		
				// Add the save button to the frame
				editFrame.add(saveButton);
		
				// Set the layout and visibility of the edit frame
				editFrame.setLayout(null);
				editFrame.setVisible(true);
			}
		});

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User.deleteDefaultPOI(curr);
				setVisible(false);
		}
	});

		

		// Set the font for each label
		title.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        category.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        description.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        building.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        poiName.setFont(new Font("Balsamiq", Font.BOLD, 20));
		floor.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		favourite.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		adminEdit.setFont(new Font("Balsamiq", Font.PLAIN, 20));

		FrameListener listener = new FrameListener();

		//Add properties to the frame
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(listener);
		this.setTitle("POI Information Screen");
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(500, 500);
		this.getContentPane().setBackground(Color.white);
		this.add(title);
		this.add(poiName);
		this.add(building);
		this.add(category);
		this.add(description);
		this.add(floor);
		this.add(favourite);
		this.add(adminEdit);
		this.add(edit);
		this.add(delete);
		this.setVisible(true);
	}
	private class FrameListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			User.setCurPoi(null);
			MapScrollPanel.repaintMapPOI();
        }
    }

}