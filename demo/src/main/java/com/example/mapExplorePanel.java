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
   
   private JScrollPane exploreScroll;
   private JPanel container = new JPanel();


   public mapExplorePanel() {
      // create JPanel for left panel and set properties
      container.setLayout(null);
      container.setPreferredSize(new Dimension(446, 900));

      // create JTextField for search bar and set properties
      JLabel title = new JLabel("Map Explore Panel");
      title.setBounds(75, 5, 340, 60);
      title.setFont(new Font("Balsamiq", Font.PLAIN, 32));
      searchBar = new JTextField("Search");
      searchBar.setBounds(100, 75, 200, 25);
      
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
      searchButton.setBounds(303, 75, 22, 22);
      ImageIcon search = new ImageIcon("./images/searchButton.jpg");
      Image searchImage = search.getImage().getScaledInstance(searchButton.getWidth(), searchButton.getHeight(), Image.SCALE_SMOOTH);
        search = new ImageIcon(searchImage);
      searchButton.setIcon(search);

     // SEARCH BAR TEST
    final String[] items = new String[]{"aasd", "bfsadf", "casdf", "dfasdf", "asdfe", "asdf", "dfg"};
    final DefaultListModel<String> listModel = new DefaultListModel<String>();
      
      // Function to return text from the searchbar
      searchButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String searchText = searchBar.getText().toLowerCase();
            listModel.clear();
            for (int i = 0; i < items.length; i++) {
                if ((items[i].toLowerCase()).contains(searchText)) {
                    listModel.addElement(items[i]);
                }
                System.out.println(items[i]);
            }
        }
    });

    // SEARCH BAR TEST CONTINUED
    JList<String> resultList = new JList<String>(listModel);
     JScrollPane searchDisplay = new JScrollPane(resultList);
     searchDisplay.setBounds(100,100,200,175);
     container.add(searchDisplay);
     searchDisplay.setVisible(true);


      // create JLabel for POI Layers subheading and set properties
      JLabel poiLabel = new JLabel("POI Layers");
      poiLabel.setFont(new Font("Arial", Font.BOLD, 16));
      poiLabel.setBounds(100, 285, 200, 25);

      // create checkboxes for POI Layers and set properties
      washrooms = new JCheckBox("Washrooms");
      classrooms = new JCheckBox("Classrooms");
      genLabs = new JCheckBox("GenLabs");
      stairwells = new JCheckBox("Stairwells");
      entryExits = new JCheckBox("Entry/Exits");
      elevators = new JCheckBox("Elevators");
      userCreatedPOIs = new JCheckBox("User-created POIs");
      favourites = new JCheckBox("Favourites");
    
      washrooms.setBounds(100, 310, 200, 20);
      classrooms.setBounds(100, 330, 200, 20);
      genLabs.setBounds(100, 350, 200, 20);
      stairwells.setBounds(100, 370, 200, 20);
      entryExits.setBounds(100, 390, 200, 20);
      elevators.setBounds(100, 410, 200, 20);
      userCreatedPOIs.setBounds(100, 430, 200, 20);
      favourites.setBounds(100, 450, 200, 20);
      
      // create dropdown menu for floors and set properties
      String[] floors = {"Floor 1", "Floor 2", "Floor 3"};
      JComboBox<String> floorDropdown = new JComboBox<>(floors);
      JLabel floorTitle = new JLabel("Floors");
      
      String[] allCurrentPOI = {"1","2","3","4","5", "6", "7", "8", "9", "10"};
      JList<String> allCurrentPOIList = new JList<>(allCurrentPOI);
      JLabel allCurrentPOITitle = new JLabel("Current Points of Interest");
      JScrollPane allCurrentScroll = new JScrollPane(allCurrentPOIList);
      
      String[] favouritePOIs = {"1","2","3","4","5", "6", "7", "8", "9", "10"};
      JList<String> favouriteList = new JList<>(favouritePOIs);
      JLabel favouriteListTitle = new JLabel("Favourite Points of Interest");
      JScrollPane favouriteScroll = new JScrollPane(favouriteList);

      String[] users = {"1","2","3","4","5", "6", "7", "8", "9", "10"};
      JList<String> userList = new JList<>(users);
      JLabel userListTitle = new JLabel("User Points of Interest");
      JScrollPane userScroll = new JScrollPane(userList);
      

      // create JButton for adding POIs and set properties
      JButton addPOIButton = new JButton("Add POI");

      allCurrentPOITitle.setBounds(100, 480, 200, 20);
      allCurrentScroll.setBounds(100, 500, 200, 75);

      favouriteListTitle.setBounds(100, 580, 200, 20);
      favouriteScroll.setBounds(100, 600, 200, 75);

      userListTitle.setBounds(100, 680, 200, 20);
      userScroll.setBounds(100, 700, 200, 75);

      floorTitle.setBounds(100, 780, 200, 20);
      floorDropdown.setBounds(100, 800, 200, 20);

      addPOIButton.setBounds(100, 840, 200, 20);

      // add components to left panel
      container.add(searchBar);
      container.add(searchButton);
      container.add(poiLabel);
      container.add(washrooms);
      container.add(classrooms);
      container.add(genLabs);
      container.add(stairwells);
      container.add(entryExits);
      container.add(elevators);
      container.add(userCreatedPOIs);
      container.add(favourites);

      container.add(floorDropdown);
      container.add(allCurrentScroll);
      container.add(favouriteScroll);
      container.add(userScroll);

      container.add(floorTitle);
      container.add(allCurrentPOITitle);
      container.add(favouriteListTitle);
      container.add(userListTitle);

      container.add(addPOIButton);
      container.add(title);

      // Sets up the panel
      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(446, 590));

      exploreScroll = new JScrollPane();
      exploreScroll.setViewportView(container);
      exploreScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      exploreScroll.setBounds(0, 0, 446, 590);
      exploreScroll.setWheelScrollingEnabled(true);
      add(exploreScroll, BorderLayout.CENTER);
   }
    private boolean[] getFilterValeus() {
        boolean[] filterValues = {washrooms.isSelected(), classrooms.isSelected(), genLabs.isSelected(), stairwells.isSelected(), entryExits.isSelected(), elevators.isSelected(), userCreatedPOIs.isSelected(), favourites.isSelected()};
        return filterValues;
    }


}
