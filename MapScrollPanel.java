import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class MapScrollPanel extends JPanel {
    private JLabel label = new JLabel();
    private JScrollPane scrollPane = new JScrollPane();

    public MapScrollPanel() {
        // Sets up the panel
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 550));
        
        // Get image and insert image into label
        ImageIcon map = new ImageIcon("images/TESTMAP.jpg");
        label.setIcon(map);
        label.setPreferredSize(new Dimension(map.getIconWidth(), map.getIconHeight()));

        // Set Scrollable Panel
        scrollPane.setViewportView(label);
        scrollPane.setBounds(0,0, 800, 300);
        scrollPane.setWheelScrollingEnabled(true);
        add(scrollPane, BorderLayout.CENTER);
    }
}
