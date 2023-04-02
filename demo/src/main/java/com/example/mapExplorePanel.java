package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class mapExplorePanel extends JPanel {
   JTextField searchBar;
   JCheckBox washrooms, classrooms, genLabs, stairwells, entryExits, elevators, userCreatedPOIs, favourites;
   
   public mapExplorePanel() {
      // create JPanel for left panel and set properties
      setLayout(null);

      // create JTextField for search bar and set properties
      JLabel title = new JLabel("Map Explore Panel");
      title.setBounds(100, 10, 340, 60);
      title.setFont(new Font("Balsamiq", Font.PLAIN, 20));
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
      washrooms.setBounds(100, 90, 200, 25);
      washrooms.setSelected(true);
      washrooms.setEnabled(false);
      classrooms = new JCheckBox("Classrooms");
      classrooms.setBounds(100, 105, 200, 25);
      genLabs = new JCheckBox("GenLabs");
      genLabs.setBounds(100, 120, 200, 25);
      stairwells = new JCheckBox("Stairwells");
      stairwells.setBounds(100, 135, 200, 25);
      entryExits = new JCheckBox("Entry/Exits");
      entryExits.setBounds(100, 150, 200, 25);
      elevators = new JCheckBox("Elevators");
      elevators.setBounds(100, 175, 200, 25);
      elevators.setSelected(true);
      elevators.setEnabled(false);
      
      userCreatedPOIs = new JCheckBox("User-created POIs");
      userCreatedPOIs.setBounds(100, 190, 200, 25);
      
      favourites = new JCheckBox("Favourites");
      favourites.setBounds(100, 205, 200, 25);

      // create dropdown menu for floors and set properties
      String[] floors = {"Floor 1", "Floor 2", "Floor 3"};
      String[] builtin = {"1","2","3","4","5", "6", "7", "8", "9", "10"};
      String[] users = {"1","2","3","4","5", "6", "7", "8", "9", "10"};
      JComboBox<String> floorDropdown = new JComboBox<>(floors);
      floorDropdown.setBounds(100, 250, 200, 25);
      JList<String> builtinPOIDrop = new JList<>(builtin);
      JLabel BuiltInList = new JLabel("Built-In POI's");
      BuiltInList.setBounds(100, 280, 100, 20);
      JScrollPane scrollPane = new JScrollPane(builtinPOIDrop);
      scrollPane.setBounds(100, 300, 200, 75);
      // create JButton for adding POIs and set properties
      JButton addPOIButton = new JButton("Add POI");
      addPOIButton.setBounds(100, 480, 200, 25);
      JList<String> usersList = new JList<>(users);
      JLabel usersListTitle = new JLabel("User POI");
      usersListTitle.setBounds(100, 380, 100, 20);
      JScrollPane userScroll = new JScrollPane(usersList);
      userScroll.setBounds(100, 400, 200, 75);


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

    private boolean[] getFilterValeus() {
        boolean[] filterValues = {washrooms.isSelected(), classrooms.isSelected(), genLabs.isSelected(), stairwells.isSelected(), entryExits.isSelected(), elevators.isSelected(), userCreatedPOIs.isSelected(), favourites.isSelected()};
        return filterValues;
    }
}
