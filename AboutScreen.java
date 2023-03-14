import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;

public class AboutScreen extends JFrame implements ActionListener {
    JButton button;

    AboutScreen(){

    JLabel title = new JLabel("Western GIS");
    title.setForeground(Color.black);
    title.setFont(new Font("Serif", Font.BOLD, 55));
    title.setBounds(150, 10, 310,100);


    // Framing
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("About");
    this.setLayout(null);
    this.setSize(600,600);
    this.getContentPane().setBackground(Color.white);
    this.add(title);
    this.add(returnButton);
    this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button) {
            System.out.println("Hello");
        }
    }
}