package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MapSelectionPanel extends JPanel implements ActionListener {
    JButton ucButton, mbButton, hsbButton;
    JPanel currentPanel;
    
    public MapSelectionPanel() {
        setPreferredSize(new Dimension(667, 500));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        
        ucButton = new JButton("University College");
        ucButton.addActionListener(this);
        add(ucButton, c);
        
        c.gridy = 1;
        mbButton = new JButton("Middlesex Building");
        mbButton.addActionListener(this);
        add(mbButton, c);
        
        c.gridy = 2;
        hsbButton = new JButton("Health Science Building");
        hsbButton.addActionListener(this);
        add(hsbButton, c);
        
        currentPanel = this;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ucButton) {
            // Direct the user to the University College panel
            UniversityCollegePanel ucPanel = new UniversityCollegePanel();
            setCurrentPanel(ucPanel);
        }
        else if (e.getSource() == mbButton) {
            // Direct the user to the Middlesex Building panel
            MiddlesexBuildingPanel mbPanel = new MiddlesexBuildingPanel();
            setCurrentPanel(mbPanel);
        }
        else if (e.getSource() == hsbButton) {
            // Direct the user to the Health Science Building panel
            HealthScienceBuildingPanel hsbPanel = new HealthScienceBuildingPanel();
            setCurrentPanel(hsbPanel);
        }
    }
    
    public void setCurrentPanel(JPanel newPanel) {
        // Replace the current panel with the new panel
        remove(currentPanel);
        currentPanel = newPanel;
        add(currentPanel);
        revalidate();
        repaint();
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Map Selection Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MapSelectionPanel());
        frame.pack();
        frame.setVisible(true);
    }
}

class UniversityCollegePanel extends JPanel {
    public UniversityCollegePanel() {
        setPreferredSize(new Dimension(667, 500));
        JLabel label = new JLabel("University College Map");
        add(label);
    }
}

class MiddlesexBuildingPanel extends JPanel {
    public MiddlesexBuildingPanel() {
        setPreferredSize(new Dimension(667, 500));
        JLabel label = new JLabel("Middlesex Building Map");
        add(label);
    }
}

class HealthScienceBuildingPanel extends JPanel {
    public HealthScienceBuildingPanel() {
        setPreferredSize(new Dimension(667, 500));
        JLabel label = new JLabel("Health Science Building Map");
        add(label);
    }
}
