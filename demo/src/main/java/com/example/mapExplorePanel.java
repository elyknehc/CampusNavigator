package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;

public class mapExplorePanel extends JPanel {
   JTextField searchBar;
   JCheckBox washrooms, classrooms, genLabs, stairwells, entryExits, elevators, userCreatedPOIs, favourites;
   
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
      classrooms = new JCheckBox("Classrooms");
      genLabs = new JCheckBox("GenLabs");
      stairwells = new JCheckBox("Stairwells");
      entryExits = new JCheckBox("Entry/Exits");
      elevators = new JCheckBox("Elevators");
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

    
      washrooms.setBounds(100, 100, 200, 20);
      classrooms.setBounds(100, 120, 200, 20);
      genLabs.setBounds(100, 140, 200, 20);
      stairwells.setBounds(100, 160, 200, 20);
      entryExits.setBounds(100, 180, 200, 20);
      elevators.setBounds(100, 200, 200, 20);
      userCreatedPOIs.setBounds(100, 220, 200, 20);
      favourites.setBounds(100, 240, 200, 20);
      
      // create dropdown menu for floors and set properties
      String[] floors = {"Floor 1", "Floor 2", "Floor 3"};
      String[] builtin = {"1","2","3","4","5", "6", "7", "8", "9", "10"};
      String[] users = {"1","2","3","4","5", "6", "7", "8", "9", "10"};
      JComboBox<String> floorDropdown = new JComboBox<>(floors);
      JList<String> builtinPOIDrop = new JList<>(builtin);
      JLabel BuiltInList = new JLabel("Built-In POI's");
      JScrollPane scrollPane = new JScrollPane(builtinPOIDrop);
      // create JButton for adding POIs and set properties
      JButton addPOIButton = new JButton("Add POI");
      JList<String> usersList = new JList<>(users);
      JLabel usersListTitle = new JLabel("User POI");
      JScrollPane userScroll = new JScrollPane(usersList);

      BuiltInList.setBounds(100, 280, 200, 20);
      scrollPane.setBounds(100, 300, 200, 60);
      usersListTitle.setBounds(100, 360, 200, 20);
      userScroll.setBounds(100, 380, 200, 60);
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
      add(floorDropdown);
      add(BuiltInList);
      add(scrollPane);
      add(usersListTitle);
      add(userScroll);
      add(addPOIButton);
      add(title);
   }

   private void sendFilterValues() {
        ArrayList<String> temp = new ArrayList<String>();
        boolean[] filterValues = { washrooms.isSelected(), classrooms.isSelected(), genLabs.isSelected(),
                stairwells.isSelected(), entryExits.isSelected(), elevators.isSelected(), userCreatedPOIs.isSelected(),
                favourites.isSelected() };
        if (washrooms.isSelected()) {
            temp.add("washroom");
        }
        if (classrooms.isSelected()) {
            temp.add("classrooms");
        }
        if (genLabs.isSelected()) {
            temp.add("genLabs");
        }
        if (stairwells.isSelected()) {
            temp.add("stairwells");
        }
        if (entryExits.isSelected()) {
            temp.add("entryExits");
        }
        if (elevators.isSelected()) {
            temp.add("elevators");
        }
        if (userCreatedPOIs.isSelected()) {
            temp.add("userCreatedPOIs");
        }
        if (favourites.isSelected()) {
            temp.add("favourites");
        }
        User.addFilters(temp);
    }
}
