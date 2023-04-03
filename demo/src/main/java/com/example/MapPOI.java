package com.example;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MapPOI extends JLabel {
    POI poiData;
    final static ImageIcon normalPin = new ImageIcon("images/locationPinNormal.png");
    final static ImageIcon highlightPin = new ImageIcon("images/locationPinHighlight.png");

    public MapPOI(POI poiObject) {
        // Set image 
        setIcon(normalPin);
        setSize(this.getPreferredSize());
        setLocation(poiObject.getX(), poiObject.getY());

        poiData = poiObject;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("image clicked");
                setIcon(highlightPin);
                new POIInfo(poiData);
                
            }
        });
    }
    
}
