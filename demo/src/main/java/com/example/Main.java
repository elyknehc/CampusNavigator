package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * This class serves as our main driver that contains the main frame where everything will be working off of
 * @authors Kevin Chau, Andy Hwang, Kyle Chen, Arsalaan Ali, Michael Gao
 */
public class Main {

    static JButton adminEdit;
    private static JFrame main;

    public static void main(String[] args) {
        Json.readFile();
        new Main().createGUI();
        System.out.println(User.getAllPOI());
    }

    public void createGUI() {
            String  panelBackground1 = "#a012ff";
            JPanel footerPanel = new JPanel();
            footerPanel.setBounds(0, 0, 1384, 72);
            footerPanel.setBackground(Color.decode(panelBackground1));

            JLabel logoLabel = new JLabel();
            logoLabel.setBounds(50, 125, 200, 50);
            ImageIcon westernLogo = new ImageIcon("./images/westernLogo.png");
            Image logoImage = westernLogo.getImage().getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(),
                    Image.SCALE_SMOOTH);
            westernLogo = new ImageIcon(logoImage);
            logoLabel.setIcon(westernLogo);
            footerPanel.add(logoLabel);

            final WeatherPanel weather = new WeatherPanel();

            final JPanel panelSwitch = new JPanel();
            panelSwitch.setBounds(0, 73, 446, 590);
            panelSwitch.setLayout(new CardLayout());

            final LoginPanel first = new LoginPanel();
            panelSwitch.add(first);
        

            final mapExplorePanel second = new mapExplorePanel();
            second.setBackground(Color.white);
            panelSwitch.add(second);

            // Added a container to hold the map on the right side
            final JPanel rightContainer = new JPanel();
            rightContainer.setBounds(445, 71, 939, 590);
            rightContainer.setLayout(new CardLayout());

            final MapSelection selection = new MapSelection();
            rightContainer.add(selection);

            // Added scrollable
            final MapScrollPanel mapScroll = new MapScrollPanel();
            rightContainer.add(mapScroll);

            JButton mapSelect = new JButton("Map Select");
            mapSelect.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rightContainer.removeAll();
                    rightContainer.add(selection);
                    rightContainer.repaint();
                    rightContainer.revalidate();
                }
            });
            footerPanel.add(mapSelect);

            JButton mapExplore = new JButton("Map Explore Screen");
            mapExplore.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelSwitch.removeAll();
                    panelSwitch.add(second);
                    panelSwitch.repaint();
                    panelSwitch.revalidate();
                   rightContainer.removeAll();
                   rightContainer.repaint();
                   rightContainer.revalidate();
                   rightContainer.add(mapScroll);
                   mapScroll.loadMap();
                }
            });
            footerPanel.add(mapExplore);

            JButton helpButton = new JButton("Help Button");
            helpButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new HelpScreen();
                }
            });
            footerPanel.add(helpButton);

            JButton aboutButton = new JButton("About");
            aboutButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new AboutScreen();
                }
            });
            footerPanel.add(aboutButton);

            adminEdit = new JButton("Admin Edit");
            adminEdit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelSwitch.removeAll();
                    panelSwitch.add(first);
                    panelSwitch.repaint();
                    panelSwitch.revalidate();
                }
            });
            footerPanel.add(adminEdit);

            // Framing
            main = new JFrame();
            FrameListener listener = new FrameListener();
            main.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            main.addWindowListener(listener);
            main.setTitle("Western GIS");
            main.getContentPane().setLayout(null);
            main.setResizable(false);
            main.setSize(1400, 700);
            main.getContentPane().add(weather);
            main.getContentPane().add(panelSwitch);
            main.getContentPane().add(footerPanel);
            main.getContentPane().add(rightContainer);
            main.setVisible(true);
        }

        public static void setAdmin(boolean set) {
            if (User.getAdmin()) {
                adminEdit.setVisible(true);
            } else {
                adminEdit.setVisible(false);
            }
        }

        private class FrameListener extends WindowAdapter {
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowListener method called: windowClosed.");
                if (true) {
                    new ExitWarning();
                } else {
                    exitProgram();
                }
            }
        }
    
        public static void exitProgram() {
            main.setVisible(false);
            System.exit(0);
        }
    
}

