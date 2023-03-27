import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class POIInfo extends JPanel {
    POI currPOI = new POI("Middle Sex College", "", "", 3);
    POIInfo() {

		JLabel title = new JLabel("POI Information");
		title.setBounds(30, 21, 333, 14);
		add(title);
		
		JLabel poiName = new JLabel("Name: Example");
		poiName.setBounds(30, 60, 333, 14);
		add(poiName);
		
		JLabel building = new JLabel("Building:");
		building.setBounds(30, 90, 333, 14);
		add(building);
		
		JLabel type = new JLabel("Type: Example");
		type.setBounds(30, 120, 333, 14);
		add(type);
		
		JLabel description = new JLabel("Description: Example");
		description.setBounds(30, 150, 333, 14);
		add(description);
		
		JLabel floor = new JLabel("Floor: Example");
		floor.setBounds(30, 180, 333, 14);
		add(floor);

        type.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        description.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        building.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        poiName.setFont(new Font("Balsamiq", Font.BOLD, 25));
        title.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        setBackground(Color.green);
        setLayout(null);
    }
}