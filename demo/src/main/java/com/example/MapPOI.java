package com.example;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MapPOI extends JLabel {
    POI poiData;
    static ImageIcon pin = new ImageIcon("images/locationPin.png");
    public MapPOI(POI poiObject) {
        // Set image 
        setIcon(pin);
        setSize(this.getPreferredSize());
        setLocation(poiObject.getX(), poiObject.getY());

        poiData = poiObject;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("image clicked");
                new POIInfo(poiData);
            }
        });
    }
    
}
