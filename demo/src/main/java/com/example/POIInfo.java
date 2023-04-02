package com.example;
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
/**
 * This class is responsible for showing information aout the current POI
 * @author 
 */

public class POIInfo extends JFrame {
	// Create a new frame and pass in a new POI object through it
    POIInfo(POI current) {
		// Create the labels and get information from current 
		JLabel title = new JLabel(current.getName());
		title.setBounds(50, 20, 340, 60);
		JLabel poiName = new JLabel("Name: Example");
		poiName.setBounds(50, 70, 340, 60);
		JLabel building = new JLabel("Building:");
		building.setBounds(50, 120, 340, 60);
		JLabel type = new JLabel("Type: Example");
		type.setBounds(50, 170, 170, 60);
		JLabel description = new JLabel("Description: Example");
		description.setBounds(50, 220, 340, 60);
		JLabel floor = new JLabel("Floor: Example");
		floor.setBounds(50, 270, 340, 60);
		JLabel favourite = new JLabel("Favourite: ");
		favourite.setBounds(50, 320, 200, 60);
		JToggleButton favouriteToggle = new JToggleButton("Favourite");
		favouriteToggle.setBounds(175, 337, 100, 30);

		// Set the font for each label
        type.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        description.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        building.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        poiName.setFont(new Font("Balsamiq", Font.BOLD, 32));
        title.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		floor.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		favourite.setFont(new Font("Balsamiq", Font.PLAIN, 20));

		// 
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("POI Information Screen");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(600,600);
        this.getContentPane().setBackground(Color.white);
		this.add(title);
		this.add(poiName);
		this.add(building);
		this.add(type);
		this.add(description);
		this.add(floor);
		this.add(favourite);
		this.add(favouriteToggle);
		this.setVisible(true);
    }
}