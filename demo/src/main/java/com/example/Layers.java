package com.example;
import javax.swing.*;
import java.util.*;

public class Layers extends JLabel {
    public Layers() {
        setLocation(0,0);
        setVisible(true);
    }

    public void addPOItoMap(MapPOI newPOI) {
        add(newPOI);
    }

    public void removePOIFromMap(MapPOI newPOI) {
        remove(newPOI);
    }

    public void removeAllPOI() {
        removeAll();
    } 
}
