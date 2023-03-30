import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MapScrollPanel extends JPanel {
    private JLabel mapHolder = new JLabel();
    private JLabel pinLabel = new JLabel();
    private JScrollPane scrollPane = new JScrollPane();

    public MapScrollPanel() {
        // Get map and insert image into label
        ImageIcon map = new ImageIcon("images/TESTMAP.jpg");
        mapHolder.setIcon(map);
        mapHolder.setSize(new Dimension(map.getIconWidth(), map.getIconHeight()));
        mapHolder.setLocation(0,0);

        // Get location pin image and insert image into label
        ImageIcon pin = new ImageIcon("images/locationPin.png");
        pinLabel.setIcon(pin);
        // label.setSize(new Dimension(map.getIconWidth(), map.getIconHeight()));
        pinLabel.setSize(pinLabel.getPreferredSize());
        pinLabel.setLocation(100, 100);

        // Set up container for layers
        JLayeredPane layersContainer = new JLayeredPane();
        layersContainer.add(pinLabel, Integer.valueOf(1));
        layersContainer.add(mapHolder, Integer.valueOf(0));
        layersContainer.setPreferredSize(new Dimension(map.getIconWidth(), map.getIconHeight()));

        // Set Scrollable Panel
        scrollPane.setViewportView(layersContainer);
        scrollPane.setBounds(0,0, 800, 590);
        scrollPane.setWheelScrollingEnabled(true);
        
        // Sets up the panel
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }
}
