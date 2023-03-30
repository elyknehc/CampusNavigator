import java.awt.*;
import javax.swing.*;

public class MapSelection extends JPanel {

    MapSelection() {
        this.setLayout(null);

        JButton middlesexButton = new JButton("Middlesex College");
        middlesexButton.setBounds(100, 300, 200, 50);

        JButton building2 = new JButton("Building 2");
        building2.setBounds(300, 300, 200, 50);

        JButton building3 = new JButton("Building 3");
        building3.setBounds(500, 300, 200, 50);

        this.add(middlesexButton);
        this.add(building2);
        this.add(building3);
    }
}