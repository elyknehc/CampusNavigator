package com.example;
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
/**
 * This class is responsible for showing information aout the current POI and offering admins to chance to edit them
 * @author Kevin
 */

public class POIInfo extends JFrame {
	// Create a new frame and pass in a new POI object through it
    POIInfo(POI current) {
		// Create the labels and get information from current 
		JLabel title = new JLabel("Point of Interest Information");
		title.setBounds(75, 20, 340, 60);
		JLabel poiName = new JLabel("Name: Example");
		poiName.setBounds(75, 70, 340, 60);
		JLabel building = new JLabel("Building:");
		building.setBounds(75, 120, 340, 60);
		JLabel type = new JLabel("Type: Example");
		type.setBounds(75, 170, 170, 60);
		JLabel description = new JLabel("Description: Example");
		description.setBounds(75, 220, 340, 60);
		JLabel floor = new JLabel("Floor: Example");
		floor.setBounds(75, 270, 340, 60);
		JLabel favourite = new JLabel("Favourite: ");
		favourite.setBounds(75, 320, 100, 60);
		JToggleButton favouriteToggle = new JToggleButton("Favourite");
		favouriteToggle.setBounds(190, 340, 100, 30);
		JLabel adminEdit = new JLabel("Admin Edit");
		adminEdit.setBounds(75, 390, 150, 30);
		JButton edit = new JButton("Edit");
		edit.setBounds(190, 392, 100, 30);


		// Set the font for each label
        type.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        description.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        building.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        poiName.setFont(new Font("Balsamiq", Font.BOLD, 32));
        title.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		floor.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		favourite.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		adminEdit.setFont(new Font("Balsamiq", Font.PLAIN, 20));

		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("POI Information Screen");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(500,500);
        this.getContentPane().setBackground(Color.white);
		this.add(title);
		this.add(poiName);
		this.add(building);
		this.add(type);
		this.add(description);
		this.add(floor);
		this.add(favourite);
		this.add(favouriteToggle);
		this.add(adminEdit);
		this.add(edit);
		this.setVisible(true);
    }
}