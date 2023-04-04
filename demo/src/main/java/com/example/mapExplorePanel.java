package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;

/**
 * This class represents a panel for uses to choose which properties they want to view on a map
 * @author Group 51
 */
public class mapExplorePanel extends JPanel {
   JTextField searchBar;
   JCheckBox washrooms, classrooms, genLabs, stairwells, entryExits, elevators, userCreatedPOIs, favourites, restaurants, computerLabs, collabRooms;
   
   public mapExplorePanel() {
      // create JPanel for left panel and set properties
      setLayout(null);

      // create JTextField for search bar and set properties
      JLabel title = new JLabel("Map Explore Panel");
      title.setBounds(75, 5, 340, 60);
      title.setFont(new Font("Balsamiq", Font.PLAIN, 32));
      searchBar = new JTextField("Search");
      searchBar.setBounds(100, 50, 200, 25);
      // Function to setup default text to dissappear or reappear
      searchBar.addFocusListener(new FocusListener() {
         public void focusGained(FocusEvent e) {
             searchBar.setText("");
         }
         public void focusLost(FocusEvent e) {
             if (searchBar.getText().isEmpty()) {
                 searchBar.setText("Search");
             }
         }
     });
      
      // create search button and set properties
      JButton searchButton = new JButton();
      searchButton.setBounds(303, 50, 22, 22);
      ImageIcon search = new ImageIcon("./images/searchButton.jpg");
      Image searchImage = search.getImage().getScaledInstance(searchButton.getWidth(), searchButton.getHeight(), Image.SCALE_SMOOTH);
        search = new ImageIcon(searchImage);
      searchButton.setIcon(search);
      // Function to return text from the searchbar
      searchButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String searchText = searchBar.getText();
            System.out.println("Search text: " + searchText);
        }
    });

      // create JLabel for POI Layers subheading and set properties
      JLabel poiLabel = new JLabel("POI Layers");
      poiLabel.setFont(new Font("Arial", Font.BOLD, 16));
      poiLabel.setBounds(100, 75, 200, 25);

      // create checkboxes for POI Layers and set properties
      washrooms = new JCheckBox("Washrooms");
      washrooms.setSelected(true);
      washrooms.setEnabled(false);
      classrooms = new JCheckBox("Classrooms");
      genLabs = new JCheckBox("GenLabs");
      stairwells = new JCheckBox("Stairwells");
      entryExits = new JCheckBox("Entry/Exits");
      elevators = new JCheckBox("Elevators");
      restaurants = new JCheckBox("Restaurants");
      computerLabs = new JCheckBox("Computer Labs");
      collabRooms = new JCheckBox("Collaboration Rooms");
      elevators.setEnabled(false);
     elevators.setSelected(true);
      userCreatedPOIs = new JCheckBox("User-created POIs");
      favourites = new JCheckBox("Favourites");

      ActionListener CheckBoxListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sendFilterValues();
        }
    };

      washrooms.addActionListener(CheckBoxListener);
      classrooms.addActionListener(CheckBoxListener);
      genLabs.addActionListener(CheckBoxListener);
      stairwells.addActionListener(CheckBoxListener);
      entryExits.addActionListener(CheckBoxListener);
      elevators.addActionListener(CheckBoxListener);
      userCreatedPOIs.addActionListener(CheckBoxListener);
      favourites.addActionListener(CheckBoxListener);
      restaurants.addActionListener(CheckBoxListener);
      computerLabs.addActionListener(CheckBoxListener);
      collabRooms.addActionListener(CheckBoxListener);


    
      washrooms.setBounds(100, 100, 200, 20);
      classrooms.setBounds(100, 120, 200, 20);
      genLabs.setBounds(100, 140, 200, 20);
      stairwells.setBounds(100, 160, 200, 20);
      entryExits.setBounds(100, 180, 200, 20);
      elevators.setBounds(100, 200, 200, 20);
      userCreatedPOIs.setBounds(100, 220, 200, 20);
      favourites.setBounds(100, 240, 200, 20);
      restaurants.setBounds(100, 260, 200, 20);
      computerLabs.setBounds(100, 280, 200, 20);
      collabRooms.setBounds(100, 300, 200, 20);

      
      // create dropdown menu for floors and set properties
      JButton addPOIButton = new JButton("Add POI");

      addPOIButton.setBounds(100, 460, 200, 20);

      // add components to left panel
      add(searchBar);
      add(searchButton);
      add(poiLabel);
      add(washrooms);
      add(classrooms);
      add(genLabs);
      add(stairwells);
      add(entryExits);
      add(elevators);
      add(userCreatedPOIs);
      add(favourites);
      add(addPOIButton);
      add(title);
      add(computerLabs);
      add(collabRooms);
      add(restaurants);
   }

   private void sendFilterValues() {
        ArrayList<String> tempAdd = new ArrayList<String>();
        ArrayList<String> tempRem = new ArrayList<String>();
        if (washrooms.isSelected()) {
            tempAdd.add("washrooms");
        }
        else {
            tempRem.add("washrooms");
        }
        if (classrooms.isSelected()) {
            tempAdd.add("classrooms");
        }
        else {
            tempRem.add("classrooms");
        }
        if (genLabs.isSelected()) {
            tempAdd.add("genLabs");
        }
        else {
            tempRem.add("genLabs");
        }
        if (stairwells.isSelected()) {
            tempAdd.add("stairwells");
        }
        else {
            tempRem.add("stairwells");
        }
        if (entryExits.isSelected()) {
            tempAdd.add("entryExits");
        }
        else {
            tempRem.add("entryExits");
        }
        if (elevators.isSelected()) {
            tempAdd.add("elevators");
        }
        else {
            tempRem.add("elevators");
        }
        if (restaurants.isSelected()) {
            tempAdd.add("restaurants");
        }
        else {
            tempRem.add("restaurants");
        }
        if (computerLabs.isSelected()) {
            tempAdd.add("computerLabs");
        }
        else {
            tempRem.add("computerLabs");
        }
        if (collabRooms.isSelected()) {
            tempAdd.add("collabRooms");
        }
        else {
            tempRem.add("collabRooms");
        }
        if (userCreatedPOIs.isSelected()) {
            tempAdd.add("userCreatedPOIs");
        }
        else {
            tempRem.add("userCreatedPOIs");
        }
        if (favourites.isSelected()) {
            tempAdd.add("favourites");
        }
        else {
            tempRem.add("favourites");
        }
        User.addFilters(tempAdd);
        User.removeFilters(tempRem);
    }
}
