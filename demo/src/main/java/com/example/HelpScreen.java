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
        title.setBounds(140, 40, 400, 50);

        // Instructions Label   

        JLabel instructionsTag = new JLabel("Instructions:");
        JTextArea instructions = new JTextArea();
        instructions.setText("Welcome to Western GIS. Select the desired building that you want to visit in the map selection panel. You can browse the default point of interests that are set by our system or you can create your own new point of interests. You can filter the types of point of interests with and see the categories that you desire. To read more about a POI, you can click on them. You can favorite POIs that you like the most. If you are an admin, you can edit POIs. To create your own POIs, simply click where you want the POI to be located on the map and enter all necessary information.");
        instructions.setWrapStyleWord(true);
        instructions.setLineWrap(true);
        instructions.setEditable(false);
        instructionsTag.setForeground(Color.black);
        instructionsTag.setBackground(Color.decode(panelBackground1));
        instructionsTag.setFont(new Font("Balsamiq", Font.BOLD, 20));
        instructionsTag.setBounds(40, 110, 300, 50);
        instructions.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        instructions.setBounds(40, 150, 500, 300);
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
        this.setSize(600,600);
        this.getContentPane().setBackground(Color.decode(panelBackground1));
        this.add(title);
        this.add(instructionsTag);
        this.add(instructions);
        this.add(returnButton);
        this.setVisible(true);
    }
}
