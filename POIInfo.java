import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;

public class POIInfo extends JFrame implements ActionListener {

    POIInfo() {
        // Label
        JLabel title = new JLabel("getName()");
        title.setFont(new Font("Balsamiq", Font.PLAIN, 20));


        // Panel
        JPanel POI = new JPanel();
        JPanel map = new JPanel();
        POI.setBounds(0, 0, 400, 600);
        POI.setBorder(BorderFactory.createLineBorder(Color.black));
        map.setBounds(400,0,600, 600);
        map.setBackground(Color.red);



        // Framing
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Place of Interest Screen");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1000,600);
        this.getContentPane().setBackground(Color.white);
        POI.add(title);
        this.add(POI);
        this.add(map);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}