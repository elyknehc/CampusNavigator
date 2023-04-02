package com.example;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class TempMain extends JFrame {
    static private CardLayout cLayout = new CardLayout(); //cardlayout;
    static private JPanel screens = new JPanel(cLayout);
    private int curScreen;

    public static void main(String[] args) {
        TempMain frame = new TempMain();
    }
    
    public static void ChangeScreen(String PanelName) {
        cLayout.show(screens, PanelName);
    }

    public TempMain() {
        super("Western GIS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        
        //declare all Panels
        POIInfo poiInfo = new POIInfo();
        LoginPanel loginPanel = new LoginPanel();

        //add all panels
        screens.add(loginPanel, "loginScreen");
        screens.add(poiInfo, "poiInfo");

        add(screens);
        setResizable(false);
        setVisible(true);
        cLayout.show(screens, "loginScreen");
    }
}
