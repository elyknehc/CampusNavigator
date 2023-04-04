package com.example;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * This class is responsible for showing information aout the current POI and offering admins to chance to edit them
 * @authors Kevin Chau
 */

public class POIInfo extends JFrame {
	// Create a new frame and pass in a new POI object through it
    POIInfo(POI current) {

		final POI curr = current;

		// Create the labels and fill in information about current POI
		JLabel title = new JLabel("Point of Interest Information");
		title.setBounds(70, 20, 400, 60);
		JLabel poiName = new JLabel("Name: " + curr.getName());
		poiName.setBounds(70, 70, 400, 60);
		JLabel building = new JLabel("Building: " + curr.getBuilding());
		building.setBounds(70, 120, 400, 60);
		JLabel type = new JLabel("Type: " + curr.getDescription());
		type.setBounds(70, 170, 400, 60);
		JLabel description = new JLabel("Description: " + curr.getDescription());
		description.setBounds(70, 220, 400, 60);
		JLabel floor = new JLabel("Floor: " + curr.getFloor());
		floor.setBounds(70, 270, 400, 60);
		JLabel favourite = new JLabel("Favourite: " + curr.getIsFavourite());
		favourite.setBounds(70, 320, 200, 60);
		JToggleButton favouriteToggle = new JToggleButton("Favourite");
		favouriteToggle.setBounds(220, 340, 100, 30);
		JLabel adminEdit = new JLabel("Admin Edit");
		adminEdit.setBounds(70, 390, 150, 30);
		JButton edit = new JButton("Edit");
		edit.setBounds(220, 392, 100, 30);

		// For the admin side if they are an admin
		if (User.getAdmin() == false) {
			adminEdit.setVisible(false);
			edit.setVisible(false);
		}

		// Lets
		favouriteToggle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				curr.setIsFavourite(true);
			}
		});

		// Set the font for each label
		title.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        type.setFont(new Font("Balsamiq", Font.PLAIN, 10));
        description.setFont(new Font("Balsamiq", Font.PLAIN, 10));
        building.setFont(new Font("Balsamiq", Font.PLAIN, 10));
        poiName.setFont(new Font("Balsamiq", Font.BOLD, 20));
		floor.setFont(new Font("Balsamiq", Font.PLAIN, 10));
		favourite.setFont(new Font("Balsamiq", Font.PLAIN, 10));
		adminEdit.setFont(new Font("Balsamiq", Font.PLAIN, 10));

		//Add properties to the frame
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