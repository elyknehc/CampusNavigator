package com.example;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class represents a MAP poi label, which is UI that can be clicked for the user.
 */
public class MapPOI extends JLabel {
    POI poiData;
    //Imges and POI declarations
    final static ImageIcon normalPin = new ImageIcon("images/locationPinNormal.png");
    final static ImageIcon highlightPin = new ImageIcon("images/locationPinHighlight.png");

    public MapPOI(POI poiObject) {
        // Set image 
        //Sets the location of the POI
        setIcon(normalPin);
        setSize(this.getPreferredSize());
        setLocation(poiObject.getX(), poiObject.getY());

        poiData = poiObject;
        //Adds a mouse listener for the POI to be clickable
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("image clicked");
                setIcon(highlightPin);
                new POIInfo(poiData);
            }
            public void mouseExited(MouseEvent e) {
                setIcon(normalPin);
            }
        });

    }
    
}
