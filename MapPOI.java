import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MapPOI extends JLabel {
    POI poiData;
    static ImageIcon pin = new ImageIcon("images/locationPin.png");

    public MapPOI(int x, int y, POI poiObject) {
        // Set image 
        setIcon(pin);
        setSize(this.getPreferredSize());
        setLocation(x, y);

        poiData = poiObject;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("image clicked");

                String panelBackground1 = "#a012ff";
                POIInfo infoPanel = new POIInfo();

                JFrame infoFrame = new JFrame(poiData.getName());
                infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                infoFrame.setResizable(false);
                infoFrame.setLayout(null);
                infoFrame.setSize(446,590); 
                infoFrame.getContentPane().setBackground(Color.decode(panelBackground1)); 
                infoPanel.setSize(infoFrame.getPreferredSize());

                infoPanel.setVisible(true);
                infoFrame.getContentPane().add(infoPanel);
                infoFrame.setVisible(true);
            }
        });
    }
    
}
