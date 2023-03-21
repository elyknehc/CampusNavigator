import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Main {
        public static void main(String[] args) {
            new Main().createGUI();
        }
        public void createGUI() {
            String panelBackground1 = "#373E98";
            JPanel footerPanel = new JPanel();
            footerPanel.setBounds(0, 523, 1284, 38);
            footerPanel.setBackground(Color.decode(panelBackground1));
            footerPanel.setBorder(BorderFactory.createLineBorder(Color.black));

            
            JPanel panelSwitch = new JPanel();
            panelSwitch.setBounds(0, 0, 400, 523);
            panelSwitch.setLayout(new CardLayout());

            LoginPanel first = new LoginPanel();
            first.setBackground(Color.decode(panelBackground1));
            panelSwitch.add(first);

        
            POIInfo third = new POIInfo();
            third.setBackground(Color.decode(panelBackground1));
            panelSwitch.add(third);

            
            mapExplorePanel second = new mapExplorePanel();
            second.setBackground(Color.decode(panelBackground1));
            panelSwitch.add(second);


            JButton mapExplore = new JButton("Map Explore Screen");
            mapExplore.setForeground(Color.white);
            mapExplore.setBackground(Color.black);
            mapExplore.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelSwitch.removeAll();
                    panelSwitch.add(second);
                    panelSwitch.repaint();
                    panelSwitch.revalidate();
                }
            });
            footerPanel.add(mapExplore);        
            
            JButton infoButton = new JButton("POI Information Screen");
            infoButton.setForeground(Color.white);
            infoButton.setBackground(Color.black);
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
            poiCreate.setForeground(Color.white);
            poiCreate.setBackground(Color.black);
            poiCreate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelSwitch.removeAll();
                    panelSwitch.add(second);
                    panelSwitch.repaint();
                    panelSwitch.revalidate();
                }
            });
            footerPanel.add(poiCreate);

            JButton adminEdit = new JButton("Admin Edit");
            adminEdit.setForeground(Color.white);
            adminEdit.setBackground(Color.black);
            adminEdit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelSwitch.removeAll();
                    panelSwitch.add(first);
                    panelSwitch.repaint();
                    panelSwitch.revalidate();
                }
            });
            footerPanel.add(adminEdit);


            JButton helpButton = new JButton("Help Button");
            helpButton.setForeground(Color.white);
            helpButton.setBackground(Color.black);
            helpButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new HelpScreen();
                }
            });
            footerPanel.add(helpButton);

            JButton aboutButton = new JButton("About");
            aboutButton.setForeground(Color.white);
            aboutButton.setBackground(Color.black);
            aboutButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new AboutScreen();
                }
            });
            footerPanel.add(aboutButton);

            // Framing
            JFrame main = new JFrame();
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setTitle("Western GIS");
            main.getContentPane().setLayout(null);
            main.setResizable(false);
            main.setSize(1200,600);
            main.getContentPane().add(panelSwitch);
            main.getContentPane().add(footerPanel);
            main.setVisible(true);
        }
    
}
