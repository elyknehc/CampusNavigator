package com.example;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Map Scroll panel holds the image of the user and the user can scroll through the image to see parts of it.
 * @author group 51
 */


public class MapScrollPanel extends JPanel {

    //Declare instance varaibles
    private JLabel mapHolder;
    private static Layers poiLayer;
    private JScrollPane scrollPane;

    private int kylesSmallDick = 20;
    
    private String currentMap = "";
    private ImageIcon map;
    private final String NOMAPSELECTED = "./images/noMapAvailable.jpg";

    // public MapScrollPanel(String building, int floor) {

    /**
     * Constructor for Map Scroll panel. Sets up the image
     */
    public MapScrollPanel() {
        mapHolder = new JLabel() {
            // protected void paintComponent(Graphics g) {
            //     super.paintComponent(g);
            //     for (POI poi : User.getAllPOI()) {
            //         g.setColor(Color.black);
            //         g.drawOval(poi.getX() - kylesSmallDick / 2, poi.getY() - kylesSmallDick / 2, kylesSmallDick, kylesSmallDick);
            //     }
            // }
        };

        
        loadMap();

        poiLayer = new Layers();
        poiLayer.setSize(mapHolder.getPreferredSize());


        // TEST CODE
        User.addToAllPOI(new POI("testPOI", "testDescrip", "test", "MC", 1, 100, 100, 201, 1, false, false));
        for (POI poi : User.getFilteredPOI()) {
            MapPOI tempPin = new MapPOI(poi);
            poiLayer.addPOItoMap(tempPin);
        }



        // Set up container for layers and add all layers
        JLayeredPane layersContainer = new JLayeredPane();
        layersContainer.add(mapHolder, Integer.valueOf(0));
        layersContainer.add(poiLayer, Integer.valueOf(1));

        layersContainer.setPreferredSize(new Dimension(map.getIconWidth(), map.getIconHeight()));

        // Set Scrollable Panel
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(layersContainer);
        scrollPane.setBounds(0, 0, 800, 590);
        scrollPane.setWheelScrollingEnabled(true);

        // Sets up the panel
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);


        scrollPane.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (User.getIsCreating() == true) {
                    Point viewPosition = scrollPane.getViewport().getViewPosition();
                    int x = e.getX() + viewPosition.x;
                    int y = e.getY() + viewPosition.y;
                    POI curPOI = new POI("Name", "Description", "Category", User.getCurBuilding(), 1, x, y, 1,
                            User.getCurFloor(), false, false);
                    User.setCurPoi(curPOI);
                    User.addToAllPOI(curPOI);
                    scrollPane.repaint();
                    new CreatePOIScreen(x, y, curPOI);
                }
            }
        });

    }
    
    public static void repaintMapPOI() {
        for (POI poi : User.getFilteredPOI()) {
            MapPOI tempPin = new MapPOI(poi);
          //  poiLayer.addPOItoMap(tempPin);
        }
    }

    public static void removeCancelledPOI(POI currentPOI) {
        
    }

    public void loadMap() {
        // NEED TO ADD CURRENT FLOOR
        String currentUserSelection = "./images/" + User.getCurBuilding() + "-BF/" + User.getCurBuilding() + "-BF-" + "1" + ".jpg";
        
        if (currentMap.equals("")) {
            map = new ImageIcon(NOMAPSELECTED);
            currentMap = NOMAPSELECTED;
        } else if (!currentMap.equals(currentUserSelection) && (User.getCurBuilding() != null)){
            map = new ImageIcon(currentUserSelection);
            currentMap = currentUserSelection;
        }   

        System.out.println(currentMap);
        
        mapHolder.setIcon(map);
        mapHolder.setSize(new Dimension(map.getIconWidth(), map.getIconHeight()));
        mapHolder.setLocation(0, 0);
        
    }
}
