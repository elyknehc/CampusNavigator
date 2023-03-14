import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;

public class HelpScreen extends JFrame implements ActionListener{
    HelpScreen() {
        // Title Label
        JLabel title = new JLabel("Western GIS");
        title.setForeground(Color.black);
        title.setFont(new Font("Serif", Font.BOLD, 55));
        title.setBounds(150, 10, 310,100);

        // Instructions Label

        JLabel instructions = new JLabel("Instructions:");
        instructions.setForeground(Color.black);

        // Return to App Button

        JButton returnButton = new JButton("Return to App");
        returnButton.setFont(new Font("Serif", Font.BOLD, 18));
        returnButton.setBounds(200, 460, 200, 50);



        // Framing
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Help Screen");
        this.setLayout(null);
        this.setSize(600,600);
        this.getContentPane().setBackground(Color.white);
        this.add(title);
        this.add(returnButton);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
}
