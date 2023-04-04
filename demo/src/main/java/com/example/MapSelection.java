package com.example;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
/**
 * This class is responsible for allowing a user to select which map they want to be displayed.
 * @author Kyle Chen, Andy Hwang
 */
public class MapSelection extends JPanel {

    //Initialize variables for buttons
    final String MIDDLESEX = "MC";
    final String HEALTHSCIENCE = "HSB";
    final String UCOLLEGE = "UC";

    final JButton middlesexButton;
    final JButton hsbButton;
    final JButton ucButton;
 
    /**
     * Creates a new map selection panel
     */
    MapSelection() {

        this.setLayout(null);

        //Adding buttons
        middlesexButton = new JButton("Middlesex College");
        middlesexButton.setBounds(100, 300, 200, 50);
        middlesexButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked (MouseEvent e) {
                User.setCurBuilding(MIDDLESEX);
                setButtonColors();
            }
        });

        hsbButton = new JButton("Health Sciences Building");
        hsbButton.setBounds(300, 300, 200, 50);
        hsbButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked (MouseEvent e) {
                User.setCurBuilding(HEALTHSCIENCE);
                setButtonColors();
            }
        });

        ucButton = new JButton("University College");
        ucButton.setBounds(500, 300, 200, 50);
        ucButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked (MouseEvent e) {
                User.setCurBuilding(UCOLLEGE);
                setButtonColors();
            }
        });

        this.add(middlesexButton);
        this.add(hsbButton);
        this.add(ucButton);
    }

    /**
     * Change button colors on click
     */
    private void setButtonColors() {

        //Selects buttons and changes colors based on user  selection
        if (User.getCurBuilding().equals(MIDDLESEX)) {
            middlesexButton.setBackground(Color.BLACK);
            middlesexButton.setForeground(Color.WHITE);
            hsbButton.setBackground(null);
            hsbButton.setForeground(Color.BLACK);
            ucButton.setBackground(null);
            ucButton.setForeground(Color.BLACK);
        } else if (User.getCurBuilding().equals(HEALTHSCIENCE)) {
            middlesexButton.setBackground(null);
            middlesexButton.setForeground(Color.BLACK);
            hsbButton.setBackground(Color.BLACK);
            hsbButton.setForeground(Color.WHITE);
            ucButton.setBackground(null);
            ucButton.setForeground(Color.BLACK);
        } else {
            middlesexButton.setBackground(null);
            middlesexButton.setForeground(Color.BLACK);
            hsbButton.setBackground(null);
            hsbButton.setForeground(Color.BLACK);
            ucButton.setBackground(Color.BLACK);
            ucButton.setForeground(Color.WHITE);
        }

    }
}