import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    MainFrame() {

        JButton middlesexButton = new JButton("Middlesex College");
        middlesexButton.setBounds(400, 100, 200, 50);

        JButton building2 = new JButton("Building 2");
        building2.setBounds(400, 200, 200, 50);

        JButton building3 = new JButton("Building 3");
        building3.setBounds(400, 400, 200, 50);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000,600);
        this.setTitle("Map Selection Screen");
        this.setVisible(true);
        this.add(middlesexButton);
        this.add(building2);
        this.add(building3);
    }
}