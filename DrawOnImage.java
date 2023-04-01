import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawOnImage extends JPanel {
    private JLabel imageLabel;
    private ImageIcon imageIcon;
    private Graphics graphics;
    private int x, y;
    
    public DrawOnImage() {
        // Set the panel's layout to BorderLayout
        setLayout(new BorderLayout());
        
        // Create the image label
        imageIcon = new ImageIcon("image.jpg");
        imageLabel = new JLabel(imageIcon);
        add(imageLabel, BorderLayout.CENTER);
        
        // Add a mouse listener to the image label
        imageLabel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Get the graphics object to draw on the image
                graphics = imageLabel.getGraphics();
                x = e.getX() - imageLabel.getX();
                y = e.getY() - imageLabel.getY();
                
                // Draw a larger oval at the mouse click location
                graphics.drawOval(x - 10, y - 10, 20, 20);
            }
        });
        
        // Disable the ability to drag the mouse
        imageLabel.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                // Do nothing
            }
        });
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw on Image Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DrawOnImage());
        frame.pack();
        frame.setVisible(true);
    }
}
