package com.example;
import java.awt.*;
import javax.swing.*;

public class MapScrollPanel extends JPanel {
    private JLabel mapHolder;
    private Layers classrooms;
    private Layers genLabs;
    private Layers stairwells;
    private Layers entry_exits;
    private Layers userCreated;
    private Layers favourites;
    
    private JScrollPane scrollPane;

    // public MapScrollPanel(String building, int floor) {
    public MapScrollPanel() {
        String building = "HSB";
        String floor = "1";
        
        // Get map and insert image into label
        ImageIcon map = new ImageIcon("images/" + building + "-BF/" + building + "-BF-" + floor+ ".jpg");
        mapHolder = new JLabel();
        mapHolder.setIcon(map);
        mapHolder.setSize(new Dimension(map.getIconWidth(), map.getIconHeight()));
        mapHolder.setLocation(0,0);

        // Set Classrooms Layer  
        classrooms = new Layers();
        classrooms.setSize(mapHolder.getPreferredSize());

        // Set GenLabs Layer  
        genLabs = new Layers();
        genLabs.setSize(mapHolder.getPreferredSize());

        // Set stairwells Layer  
        stairwells = new Layers();
        stairwells.setSize(mapHolder.getPreferredSize());

        // Set entry_exits Layer  
        entry_exits = new Layers();
        entry_exits.setSize(mapHolder.getPreferredSize());

        // Set userCreated Layer 
        userCreated = new Layers();
        userCreated.setSize(mapHolder.getPreferredSize());

        // Set favourites Layer  
        favourites = new Layers();
        favourites.setSize(mapHolder.getPreferredSize());

        // TEST CODE
        MapPOI pin = new MapPOI(300, 120, new POI("testPOI", "testDesrip", "test", "testBuilding", 1, 100, 100, 201, 2, false, false));
        classrooms.addPOItoMap(pin);

        // Set up container for layers and add all layers
        JLayeredPane layersContainer = new JLayeredPane();
        layersContainer.add(mapHolder, Integer.valueOf(0));
        layersContainer.add(classrooms, Integer.valueOf(1));
        layersContainer.add(genLabs, Integer.valueOf(2));
        layersContainer.add(stairwells, Integer.valueOf(3));
        layersContainer.add(entry_exits, Integer.valueOf(4));
        layersContainer.add(userCreated, Integer.valueOf(5));
        layersContainer.add(favourites, Integer.valueOf(6));

        layersContainer.setPreferredSize(new Dimension(map.getIconWidth(), map.getIconHeight()));

        // Set Scrollable Panel
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(layersContainer);
        scrollPane.setBounds(0,0, 800, 590);
        scrollPane.setWheelScrollingEnabled(true);
        
        // Sets up the panel
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        //Create a POI function
        
    }
}
