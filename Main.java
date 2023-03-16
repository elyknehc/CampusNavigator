import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Main implements ActionListener {
        JButton aboutButton;
        JButton helpButton;
        public static void main(String[] args) {
            new Main().createGUI();
        }
        public void createGUI() {
            POIInfo poiPanel = new POIInfo();
            JPanel footerPanel = new JPanel();
            aboutButton = new JButton("About");
            helpButton = new JButton("Help");
            aboutButton.addActionListener(this); // use this as the ActionListener
            helpButton.addActionListener(this);
            footerPanel.add(aboutButton);
            footerPanel.add(helpButton);
            footerPanel.setPreferredSize(new Dimension(1000, 40));
            footerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            JFrame main = new JFrame();
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setTitle("Western GIS");
            main.setResizable(false);
            main.setSize(1000,600);
            main.getContentPane().setBackground(Color.white);
            main.add(poiPanel, BorderLayout.WEST);
            main.add(footerPanel, BorderLayout.SOUTH);
            main.setVisible(true);
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==aboutButton) {
                new AboutScreen();
            }
            else if  (e.getSource()==helpButton) {
                new HelpScreen();
            }
        }
}
