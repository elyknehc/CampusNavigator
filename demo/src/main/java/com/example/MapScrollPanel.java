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
    private static JLabel mapHolder;
    private static Layers poiLayer;
    private JScrollPane scrollPane;

    private int kylesSmallD1ck = 3;
    
    private static String currentMap = "";
    private static ImageIcon map;
    private static final String NOMAPSELECTED = "./images/noMapAvailable.jpg";
    private static boolean editPos = false;
    private static JLabel editPosPrompt;

    /**
     * Constructor for Map Scroll panel. Sets up the image
     */
    public MapScrollPanel() {
        mapHolder = new JLabel();
        loadMap();

        poiLayer = new Layers();
        poiLayer.setSize(mapHolder.getPreferredSize());


        // TEST CODE
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

                User.setCreating(true);
                    Point viewPosition = scrollPane.getViewport().getViewPosition();
                    int x = e.getX() + viewPosition.x;
                int y = e.getY() + viewPosition.y;
                
                if (editPos) {
                    POI editPOI = User.getCurPoi();
                    editPOI.setX(x);
                    editPOI.setY(y);
                    editPos = false;
                    User.setCurPoi(null);
                    User.setCreating(false);
                    MapScrollPanel.repaintMapPOI();
                    return;
                }
                
                    POI curPOI = new POI("Name", "Description", "Category", User.getCurBuilding(), 1, x, y, 1,
                            User.getCurFloor(), false, !User.getAdmin());
                    User.setCurPoi(curPOI);
                    User.addToAllPOI(curPOI);
                    scrollPane.repaint();
                    new CreatePOIScreen(x, y, curPOI);
            }
        });

    }
    
    /**
     * Methods redraws the map after a POI has been added/removed from the map
     */
    public static void repaintMapPOI() {
        poiLayer.removeAllPOI();
        for (POI poi : User.getFilteredPOI()) {
            MapPOI tempPin = new MapPOI(poi);
            if (poi == User.getCurPoi()) {
                tempPin.highlight();
            }
            poiLayer.addPOItoMap(tempPin);
        }
    }

    public static void setEditPos(boolean set) {
        editPos = set;
    }

    /**
     * Method that loads the map into the program
     */
    public static void loadMap() {
        String currentUserSelection = "./images/" + User.getCurBuilding() + "-BF/" + User.getCurBuilding() + "-BF-" + Integer.toString(User.getCurFloor()) + ".jpg";
        
        if (currentMap.equals("")) {
            map = new ImageIcon(NOMAPSELECTED);
            currentMap = NOMAPSELECTED;
        } else if (!currentMap.equals(currentUserSelection) && (User.getCurBuilding() != null)){
            map = new ImageIcon(currentUserSelection);
            currentMap = currentUserSelection;
        }   

        
        mapHolder.setIcon(map);
        mapHolder.setSize(new Dimension(map.getIconWidth(), map.getIconHeight()));
        mapHolder.setLocation(0, 0);   
    }

    /**
     * Method that loads in a map based on the POI selected
     */
    public static void loadMapSelectedPOI() {
        loadMap();
    }
}
