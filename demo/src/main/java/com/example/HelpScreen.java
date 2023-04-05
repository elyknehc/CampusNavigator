package com.example;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;   
import javax.swing.*;

/**
 * @author Group 51
 * This class represents a frame for the user that is popped up when the user clicks for help
 * It displays information for how the program works.
 */

public class HelpScreen extends JFrame{
    HelpScreen() {

        String panelBackground1 = "#a012ff";
        
        // Title Label
        JLabel title = new JLabel("Western GIS");
        title.setForeground(Color.black);
        title.setFont(new Font("Balsamiq", Font.BOLD, 55));
        title.setBounds(220, 40, 400, 50);

        // Instructions Label   

        JLabel instructionsTag = new JLabel("Instructions:");
        JTextArea instructions = new JTextArea();
        instructions.setText("Welcome to Western GIS! Follow these instructions to begin using our application.\n\nOpening a map: To view the floor plans of a building, you will be greeted with a screen to select a building, or you can click on the Map Select button. Click on the desired building, then click on the Map Explore Screen to view the floor plans of the desired building. To change floors, scroll down on the left panel and click on the desired floor.\n\nSwitching maps: Click on the Map Select button to return to the building selection page. From here, you can click on a new building. Then, click on the Map Explore Screen button to see your new map selection.\n\nLooking for POIs: Once you have a floor plan open, you can discover POIs in multiple ways. On the left panel, you can scroll through all of the POIs available on the map. By default, you can also see all of the POIs on the map graphically. If you want to filter for a specific category of POI, you can select the desired filters on the left, which will then only show the desired types of POIs on the map. This also represent she different layers of POIs that can be seen.\n\nSearching for POIs: On the Map Explore Screen, there is a search bar where you can search for specific POIs. After typing in the POI you are looking for, click on the enter button to see a list of POIs that match your search request. You can click on these POIs to jump to them and see a description.\n\nReading POI information: Once you have a map open, you can either click on the POI, which will create a pop-up window to show information regarding the room, description of POI, and type of POI. You can also click on a POI on the right, which will highlight the pin on the map, as well as open a new window with the POI's information.\n\nFavourite POI: To favourite a POI, click on a POI on the map. On the new window, there will be an option to toggle the POI as a favourite POI. Once you check it off, it will appear in the left panel of the original window. You can click on these POIs from any location and it will bring you back to the correct map.\n\nCreating a POI: To create a POI, scroll down to the bottom of the left panel and click on the Add POI button. From here, you can click anywhere on the map to select a location for your new POI. Enter all requested information into the window and click on Submit. The POI will appear on the screen, as well as show in a special list on the left panel called User Points of Interest.\n\nEditing/Deleting POIs: On the map explore screen, go to the list of user POIs on the left and click on any user POI. This will bring up a window with the POI information, which will show an additional option of editing/deleting the POI. To move the POI, click on the Move button, then click anywhere on the screen to select the new location. To edit the information, click on the Edit button and make the necessary changes to the information before clicking on Save. To delete the POI, click on the Delete button.\n\nViewing weather: The temperature and weather conditions will automatically appear in the top right corner once the application is opened.\n\nAdmin features: Admins have the ability to add in, edit, and remove any built-in POIs. To do so, click on the Admin Login button at the top, type in the password, and click on Enter. Then, you can return to any map and create a new POI using the Creating a POI instructions, as well as edit/delete POIs using the Editing/Deleting POIs instructions.");
        instructions.setWrapStyleWord(true);
        instructions.setLineWrap(true);
        instructions.setEditable(false);
        instructionsTag.setForeground(Color.black);
        instructionsTag.setBackground(Color.decode(panelBackground1));
        instructionsTag.setFont(new Font("Balsamiq", Font.BOLD, 20));
        instructionsTag.setBounds(40, 110, 300, 50);
        instructions.setFont(new Font("Balsamiq", Font.PLAIN, 10));
        instructions.setBounds(50, 150, 650, 600);
        // Return to App Button

        JButton returnButton = new JButton("Return to App");
        returnButton.setFont(new Font("Balsamiq", Font.BOLD, 18));
        returnButton.setBounds(200, 500, 200,50);
        returnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });

        // Framing
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Help Screen");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(800,800);
        this.getContentPane().setBackground(Color.decode(panelBackground1));
        this.add(title);
        this.add(instructionsTag);
        this.add(instructions);
        this.add(returnButton);
        this.setVisible(true);
    }
}
