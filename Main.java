import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Main {
    public boolean isAdmin = true;
        public static void main(String[] args) {
            new Main().createGUI();
        }
        public void createGUI() {
            
            String panelBackground1 = "#a012ff";
            JPanel footerPanel = new JPanel();
            footerPanel.setBounds(0, 0, 1384, 72);
            footerPanel.setBackground(Color.decode(panelBackground1));

            JLabel logoLabel = new JLabel();
            logoLabel.setBounds(50, 125, 200, 50);
            ImageIcon westernLogo = new ImageIcon("./images/westernLogo.png");
            Image logoImage = westernLogo.getImage().getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_SMOOTH);
            westernLogo = new ImageIcon(logoImage);
            logoLabel.setIcon(westernLogo);
            footerPanel.add(logoLabel);

            
            JPanel panelSwitch = new JPanel();
            panelSwitch.setBounds(0, 73, 446, 590);
            panelSwitch.setLayout(new CardLayout());

            LoginPanel first = new LoginPanel();
            first.setBackground(Color.white);
            panelSwitch.add(first);
        
            POIInfo third = new POIInfo();
            third.setBackground(Color.white);
            panelSwitch.add(third);
            
            mapExplorePanel second = new mapExplorePanel();
            second.setBackground(Color.white);
            panelSwitch.add(second);

                        // Added a container to hold the map on the right side
            JPanel rightContainer = new JPanel();
            rightContainer.setBounds(445, 71, 939, 590);
            rightContainer.setLayout(new CardLayout());


            JPanel mainPicture = new JPanel();
            ImageIcon icon = new ImageIcon("./images/main.jpg"); // Replace with the path to your image
            Image image = icon.getImage();
            int panelWidth = rightContainer.getWidth(); // Replace with the name of your panel
            int panelHeight = rightContainer.getHeight(); // Replace with the name of your panel
            Image scaledImage = image.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(scaledIcon);
            mainPicture.add(imageLabel);
            rightContainer.add(mainPicture);

            // Added scrollable
            MapScrollPanel mapScroll = new MapScrollPanel();
            rightContainer.add(mapScroll);


            JButton mapExplore = new JButton("Map Explore Screen");
            mapExplore.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelSwitch.removeAll();
                    panelSwitch.add(second);
                    panelSwitch.repaint();
                    panelSwitch.revalidate();
                   rightContainer.removeAll();
                   rightContainer.add(mapScroll);
                   rightContainer.repaint();
                   rightContainer.revalidate();
                }
            });
            footerPanel.add(mapExplore);        
            
            JButton infoButton = new JButton("POI Information Screen");
            infoButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelSwitch.removeAll();
                    panelSwitch.add(third);
                    panelSwitch.repaint();
                    panelSwitch.revalidate();
                }
            });
            footerPanel.add(infoButton);

            JButton poiCreate = new JButton("Create POI");
            poiCreate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelSwitch.removeAll();
                    panelSwitch.add(second);
                    panelSwitch.repaint();
                    panelSwitch.revalidate();
                }
            });
            footerPanel.add(poiCreate);

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

            JButton adminEdit = new JButton("Admin Edit");
            adminEdit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelSwitch.removeAll();
                    panelSwitch.add(first);
                    panelSwitch.repaint();
                    panelSwitch.revalidate();
                }
            });
            footerPanel.add(adminEdit);
            if (isAdmin) {
                adminEdit.setVisible(true);
            } else {
                adminEdit.setVisible(false);
            }
            
            // Framing
            JFrame main = new JFrame();
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setTitle("Western GIS");
            main.getContentPane().setLayout(null);
            main.setResizable(false);
            main.setSize(1400,700);
            main.getContentPane().add(panelSwitch);
            main.getContentPane().add(footerPanel);
            main.getContentPane().add(rightContainer);


            main.setVisible(true);
        }
    
}
