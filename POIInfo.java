import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class POIInfo extends JPanel {
    POI currPOI = new POI("Middle Sex College", "", "", 3);
    POIInfo() {
        // Label
        JLabel title = new JLabel("POI Information");
        JLabel poiName = new JLabel("Name: " + currPOI.getName());
        JLabel building = new JLabel("Building: " + currPOI.getCategory());
        JLabel type = new JLabel("Type: ");
        JLabel description = new JLabel("Description: " + currPOI.getDescription());
        type.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        description.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        building.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        poiName.setFont(new Font("Balsamiq", Font.BOLD, 25));
        title.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        // Panel
        JPanel POIpanel = new JPanel();
        POIpanel.setLayout(new BoxLayout(POIpanel, BoxLayout.Y_AXIS));
        POIpanel.setBorder(BorderFactory.createLineBorder(Color.black));
        POIpanel.add(Box.createRigidArea(new Dimension(15, 20))); // Add some spacing between components
        POIpanel.add(title);
        POIpanel.add(Box.createRigidArea(new Dimension(15, 20))); // Add some spacing between components
        POIpanel.add(poiName);
        POIpanel.add(Box.createRigidArea(new Dimension(15, 20))); // Add some spacing between components
        POIpanel.add(building);
        POIpanel.add(Box.createRigidArea(new Dimension(15, 20))); // Add some spacing between components
        POIpanel.add(type);
        POIpanel.add(Box.createRigidArea(new Dimension(15, 20))); // Add some spacing between components
        POIpanel.add(description);
        POIpanel.setVisible(true);
        setLayout(new BorderLayout());
        add(POIpanel);
    }
}