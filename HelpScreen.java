
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;

public class HelpScreen extends JFrame{
    HelpScreen() {
        String panelBackground1 = "#a012ff";
        
        // Title Label
        JLabel title = new JLabel("Western GIS");
        title.setForeground(Color.black);
        title.setFont(new Font("Balsamiq", Font.BOLD, 55));
        title.setBounds(140, 40, 400, 50);

        // Instructions Label

        JLabel instructionsTag = new JLabel("Instructions:");
        JTextArea instructions = new JTextArea();
        instructions.setText("Aenean convallis nisl aliquet felis pulvinar, quis auctor nulla volutpat. Aliquam faucibus condimentum commodo. Pellentesque dolor sem, elementum vestibulum rutrum eget, interdum ut odio. Sed faucibus lacus et venenatis convallis. Aliquam interdum, libero ut porttitor ultrices, augue eros euismod arcu, in tristique urna nunc eget odio. Proin venenatis pretium arcu. In fermentum, nisi ac porttitor convallis, urna magna lobortis lectus, quis scelerisque est orci sed diam. Proin eu odio lectus. Ut id sodales tortor. In urna urna, varius id pulvinar et, venenatis vel diam. Vestibulum ultrices, diam ut tincidunt pretium, est urna consequat orci, sit amet aliquet massa magna et lectus. Phasellus luctus vel ipsum eu scelerisque.");
        instructions.setWrapStyleWord(true);
        instructions.setLineWrap(true);
        instructions.setEditable(false);
        instructionsTag.setForeground(Color.black);
        instructionsTag.setBackground(Color.decode(panelBackground1));
        instructionsTag.setFont(new Font("Balsamiq", Font.BOLD, 20));
        instructionsTag.setBounds(40, 110, 300, 50);
        instructions.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        instructions.setBounds(40, 150, 500, 300);
        // Return to App Button

        JButton returnButton = new JButton("Return to App");
        returnButton.setFont(new Font("Balsamiq", Font.BOLD, 18));
        returnButton.setBounds(200, 500, 200,50);
        returnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });

        // Framing
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Help Screen");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(600,600);
        this.getContentPane().setBackground(Color.decode(panelBackground1));
        this.add(title);
        this.add(instructionsTag);
        this.add(instructions);
        this.add(returnButton);
        this.setVisible(true);
    }
}
