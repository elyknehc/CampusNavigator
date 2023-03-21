import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class POIInfo extends JPanel {
    POI currPOI = new POI("Middle Sex College", "", "", 3);
    POIInfo() {
		JLabel title = new JLabel("POI Information");
		title.setBounds(50, 20, 340, 60);
		add(title);
		
		JLabel poiName = new JLabel("Name: Example");
		poiName.setBounds(50, 70, 340, 60);
		add(poiName);
		
		JLabel building = new JLabel("Building:");
		building.setBounds(50, 120, 340, 60);
		add(building);
		
		JLabel type = new JLabel("Type: Example");
		type.setBounds(50, 170, 170, 60);
		add(type);
		
		JLabel description = new JLabel("Description: Example");
		description.setBounds(50, 220, 340, 60);
		add(description);
		
		JLabel floor = new JLabel("Floor: Example");
		floor.setBounds(50, 270, 340, 60);
		add(floor);

        type.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        description.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        building.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        poiName.setFont(new Font("Balsamiq", Font.BOLD, 32));
        title.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		floor.setFont(new Font("Balsamiq", Font.PLAIN, 20));
		type.setForeground(Color.white);
		description.setForeground(Color.white);
		building.setForeground(Color.white);
		poiName.setForeground(Color.white);
		title.setForeground(Color.white);
		floor.setForeground(Color.white);
        setLayout(null);
    }
}