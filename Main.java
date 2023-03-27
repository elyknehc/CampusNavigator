import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Main {
        public static void main(String[] args) {
            new Main().createGUI();
        }
        public void createGUI() {
            JPanel footerPanel = new JPanel();
            footerPanel.setBounds(0, 523, 984, 38);
            footerPanel.setBackground(new Color(51, 153, 204));
            
            
            
            JPanel panelSwitch = new JPanel();
            panelSwitch.setBounds(0, 0, 333, 523);
            panelSwitch.setLayout(new CardLayout());
            
            POIInfo first = new POIInfo();
            panelSwitch.add(first);
            
            JPanel second = new JPanel();
            second.setBackground(new Color(0, 255, 255));
            panelSwitch.add(second);
            second.setLayout(null);
            
            JPanel third = new JPanel();
            third.setBackground(new Color(255, 0, 0));
            panelSwitch.add(third, "name_73555699515100");
            third.setLayout(null);

            JButton poiLayer = new JButton("POI Layer");
            poiLayer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelSwitch.removeAll();
                    panelSwitch.add(first);
                    panelSwitch.repaint();
                    panelSwitch.revalidate();
                }
            });
            footerPanel.add(poiLayer);        
            
            JButton poiCreate = new JButton("POI Create");
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
            adminEdit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelSwitch.removeAll();
                    panelSwitch.add(third);
                    panelSwitch.repaint();
                    panelSwitch.revalidate();
                }
            });
            footerPanel.add(adminEdit);

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

            // Framing
            JFrame main = new JFrame();
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setTitle("Western GIS");
            main.getContentPane().setLayout(null);
            main.setResizable(false);
            main.setSize(1000,600);
            main.getContentPane().add(panelSwitch);
            main.getContentPane().add(footerPanel);
            main.setVisible(true);
        }
    
}
