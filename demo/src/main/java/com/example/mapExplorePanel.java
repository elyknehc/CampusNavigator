package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.*;

/**
 * This class represents a panel for uses to choose which properties they want to view on a map
 * @author Group 51
 */
public class mapExplorePanel extends JPanel {
   JTextField searchBar;
   JCheckBox washrooms, classrooms, genLabs, stairwells, entryExits, elevators, userCreatedPOIs, favourites, restaurants, computerLabs, collabRooms;
   static JList<String> floors;
   static JScrollPane floorDropdown;
   
   private JScrollPane exploreScroll;
   private static JPanel container = new JPanel();

   // Initializing for Search function
   final DefaultListModel<POI> preResultsList = new DefaultListModel<POI>();
   ArrayList<POI> allPOI = new ArrayList<POI>();

   // Initializing for Current Map POI scrollpane
   final static DefaultListModel<POI> allCurrentPOI = new DefaultListModel<POI>();
   static ArrayList<POI> filteredPOI;
   static JList<POI> allCurrentPOIList;
   static JLabel allCurrentPOITitle;
   static JScrollPane allCurrentScroll;

   // Initializing for Favourite POI scrollpane
   final DefaultListModel<POI> favouritePOIs = new DefaultListModel<POI>();
   ArrayList<POI> favouritePOIPulled;
   JList<POI> favouriteList;
   JLabel favouriteListTitle;
   JScrollPane favouriteScroll;

   // Initializing for User POI Scrollpane
   final DefaultListModel<POI> users = new DefaultListModel<POI>();
   ArrayList<POI> userPOIPulled;
   JList<POI> userList;
   JLabel userListTitle;
   JScrollPane userScroll;

   public mapExplorePanel() {
      // create JPanel for left panel and set properties
      container.setLayout(null);
      container.setPreferredSize(new Dimension(446, 970));

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

      // Function to return text from the searchbar
      searchButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            allPOI = (ArrayList<POI>) User.getAllPOI();

            String searchText = searchBar.getText().toLowerCase();
            preResultsList.clear();
            for (int i = 0; i < allPOI.size(); i++) {
                if ((allPOI.get(i).toString().toLowerCase()).contains(searchText)) {
                    preResultsList.addElement(allPOI.get(i));
                }
            }
        }
    });

     final JList<POI> resultList = new JList<POI>(preResultsList);
     JScrollPane searchDisplay = new JScrollPane(resultList);
     searchDisplay.setBounds(100,100,200,175);
     searchDisplay.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
     container.add(searchDisplay);
     searchDisplay.setVisible(true);
     
     resultList.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            POI selected = resultList.getSelectedValue();
            
            User.setCurBuilding(selected.getBuilding());
            User.setCurFloor(selected.getFloor());
            User.setCurPoi(selected);
            MapScrollPanel.loadMapSelectedPOI();
            MapScrollPanel.repaintMapPOI();
            new POIInfo(selected);
        }
     });

      // create JLabel for POI Layers subheading and set properties
      JLabel poiLabel = new JLabel("POI Layers");
      poiLabel.setFont(new Font("Arial", Font.BOLD, 16));
      poiLabel.setBounds(100, 285, 200, 25);

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
      restaurants = new JCheckBox("Restaurants");
      computerLabs = new JCheckBox("Computer Labs");
      collabRooms = new JCheckBox("Collaboration Rooms");//HERE
      restaurants.addActionListener(CheckBoxListener);
      computerLabs.addActionListener(CheckBoxListener);
      collabRooms.addActionListener(CheckBoxListener);


    
      washrooms.setBounds(100, 310, 200, 20);
      classrooms.setBounds(100, 330, 200, 20);
      genLabs.setBounds(100, 350, 200, 20);
      stairwells.setBounds(100, 370, 200, 20);
      entryExits.setBounds(100, 390, 200, 20);
      elevators.setBounds(100, 410, 200, 20);
      userCreatedPOIs.setBounds(100, 430, 200, 20);
      favourites.setBounds(100, 450, 200, 20);
      restaurants.setBounds(100, 470, 200, 20);
      computerLabs.setBounds(100, 490, 200, 20);
      collabRooms.setBounds(100, 510, 200, 20);
      
      // Floors dropdown to edit the floor map displayed
     
      loadFloors();
      JLabel floorTitle = new JLabel("Floors");

      // Sets the current map POI scrollpane
      updateCurrentPOI();
      allCurrentPOIList.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            POI selected = resultList.getSelectedValue();

            User.setCurBuilding(selected.getBuilding());
            User.setCurFloor(selected.getFloor());
            User.setCurPoi(selected);

            MapScrollPanel.loadMapSelectedPOI();
            MapScrollPanel.repaintMapPOI();
            new POIInfo(selected);
        }
     });

      // Sets the favourite POI Scrollpane
      updateFavouritePOI();
      favouriteList.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            POI selected = resultList.getSelectedValue();

            User.setCurBuilding(selected.getBuilding());
            User.setCurFloor(selected.getFloor());
            User.setCurPoi(selected);

            MapScrollPanel.loadMapSelectedPOI();
            MapScrollPanel.repaintMapPOI();
            new POIInfo(selected);
        }
      });

      // Sets the user POI Scrollpane
      updateUserPOI();
      userList.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            POI selected = resultList.getSelectedValue();

            User.setCurBuilding(selected.getBuilding());
            User.setCurFloor(selected.getFloor());
            User.setCurPoi(selected);

            MapScrollPanel.loadMapSelectedPOI();
            MapScrollPanel.repaintMapPOI();
            new POIInfo(selected);
        }
      });
      

      // create JButton for adding POIs and set properties
      JButton addPOIButton = new JButton("Add POI");

      allCurrentPOITitle.setBounds(100, 540, 200, 20);
      allCurrentScroll.setBounds(100, 560, 200, 75);

      favouriteListTitle.setBounds(100, 640, 200, 20);
      favouriteScroll.setBounds(100, 660, 200, 75);

      userListTitle.setBounds(100, 740, 200, 20);
      userScroll.setBounds(100, 760, 200, 75);

      floorTitle.setBounds(100, 840, 200, 20);

      addPOIButton.setBounds(100, 930, 200, 20);

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
      container.add(restaurants);
      container.add(collabRooms);
      container.add(computerLabs);

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
      exploreScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      add(exploreScroll, BorderLayout.CENTER);
}


private void updateUserPOI() {
    userPOIPulled = (ArrayList<POI>) User.getAllPOI();

    for (int i = 0; i < userPOIPulled.size(); i++ ) {
        if (userPOIPulled.get(i).getIsUser()) {
            users.addElement(userPOIPulled.get(i));
        }
    }
    userList = new JList<POI>(users);
    userListTitle = new JLabel("User Points of Interest");
    userScroll = new JScrollPane(userList);
    userScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    userScroll.setBounds(100, 760, 200, 75);
    container.add(userScroll);
}


private void updateFavouritePOI() {
    favouritePOIPulled = (ArrayList<POI>) User.getAllPOI();

    for (int i = 0; i < favouritePOIPulled.size(); i++ ) {
        if (favouritePOIPulled.get(i).getIsFavourite()) {
            favouritePOIs.addElement(favouritePOIPulled.get(i));
        }
    }
    favouriteList = new JList<POI>(favouritePOIs);
    favouriteListTitle = new JLabel("Favourite Points of Interest");
    favouriteScroll = new JScrollPane(favouriteList);
    favouriteScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    favouriteScroll.setBounds(100, 660, 200, 75);
    container.add(favouriteScroll);
}


public static void updateCurrentPOI() {
    filteredPOI = (ArrayList<POI>) User.getFilteredPOI();
      for (int i = 0; i < filteredPOI.size() ; i++) {
         allCurrentPOI.addElement(filteredPOI.get(i));
      }
    allCurrentPOIList = new JList<POI>(allCurrentPOI);
    allCurrentPOITitle = new JLabel("Current Points of Interest");
    allCurrentScroll = new JScrollPane(allCurrentPOIList);
    allCurrentScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    allCurrentScroll.setBounds(100, 560, 200, 75);
    container.add(allCurrentScroll);
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

    public static void loadFloors() {
        String[] floorNums = {"1", "2", "3", "4", "5"};
        if (User.getCurBuilding() == null) {
            User.setCurFloor(1);
        }


        floors = new JList<String>(floorNums);
        floorDropdown = new JScrollPane(floors);

        floors.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JList target = (JList)e.getSource();
                int index = target.locationToIndex(e.getPoint());
                Object item = target.getModel().getElementAt(index);

                String selectedFloor = item.toString();
                if (!User.getCurBuilding().equals("MC") && selectedFloor.equals("5")) {
                    selectedFloor = "4";
                }

                User.setCurFloor(Integer.parseInt(selectedFloor));

                System.out.println(User.getCurFloor());

                loadFloors();
                MapScrollPanel.loadMapSelectedPOI();
                MapScrollPanel.repaintMapPOI();
            }
        });

          floorDropdown.setBounds(100, 860, 200, 50);
          container.add(floorDropdown);
    }
}
