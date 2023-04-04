package com.example;
import javax.swing.*;
import java.util.*;
/**
 * This class repesents the POI layers. POI layers can be filtered
 * @author Group 51
 */
public class Layers extends JLabel {

    /**
     * Constructor for a layer
     * Creates a new layer, sets the location and visibility of the layer
     */
    public Layers() {
        setLocation(0,0);
        setVisible(true);
    }

    /**
     * Adds a poi to the map
     * @param newPOI a new poi to be added
     */
    public void addPOItoMap(MapPOI newPOI) {
        add(newPOI);
        repaint();
    }

    /**
     * Removes a POI from the map
     * @param newPOI remove a poi from the map
     */
    public void removePOIFromMap(MapPOI newPOI) {
        remove(newPOI);
    }

    /**
     * Remove all POIs
     */
    public void removeAllPOI() {
        removeAll();
        repaint();
    } 
}
