import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MapScrollPanel extends JPanel {
    private JLabel imageLabel;
    private ImageIcon imageIcon;
    private List<Oval> ovals = new ArrayList<>();
    private int ovalSize = 20;

    public MapScrollPanel() {
        // Set the panel's layout to BorderLayout
        setLayout(new BorderLayout());

        // Create the image label and add it to a JScrollPane
        imageIcon = new ImageIcon("images/TESTMAP.jpg");
        imageLabel = new JLabel(imageIcon) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Oval oval : ovals) {
                    g.setColor(Color.black);
                    g.drawOval(oval.x - ovalSize / 2, oval.y - ovalSize / 2, ovalSize, ovalSize);
                }
            }
        };
        JScrollPane scrollPane = new JScrollPane(imageLabel);
        add(scrollPane, BorderLayout.CENTER);

        // Add a mouse listener to the image label
        imageLabel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            
            if (User.getIsCreating() == true) {
                Point viewPosition = scrollPane.getViewport().getViewPosition();
                int x = e.getX() + viewPosition.x;
                int y = e.getY() + viewPosition.y;
                ovals.add(new Oval(x, y));
                imageLabel.repaint();
                new CreatePOIScreen();
            }
        
                
            }
        });


        // Add a listener to the scroll pane to update the oval's position when scrolling
        scrollPane.getViewport().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                imageLabel.repaint();
            }
        });
    }

    private static class Oval {
        int x;
        int y;

        public Oval(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
