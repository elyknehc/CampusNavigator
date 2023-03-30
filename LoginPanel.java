import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener{
    JButton enterButton;
    private JPasswordField passwordField;
    String password;
    
    LoginPanel() {
        // create JPanel for left panel and set properties
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 333, 600);
        leftPanel.setLayout(null);

        // LEFT PANEL
        // create JLabels for password prompt and set properties
        JLabel passwordLabel1 = new JLabel("Enter a password for admin access,");
        passwordLabel1.setBounds(55, 250, 250, 50);
        JLabel passwordLabel2 = new JLabel("or leave blank for general access:");
        passwordLabel2.setBounds(55, 265, 250, 50);

        // create JTextField for password input and set properties
        passwordField = new JPasswordField(20);
        // passwordField.setBounds(55, 310, 200, 25);

        // create JButton for entering password and set properties
        enterButton = new JButton("Enter");
        enterButton.setBounds(55, 350, 200, 25);
        enterButton.addActionListener(this);

        // create JLabel for title
        JLabel titleLabel = new JLabel("WESTERN GIS");
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 30));
        titleLabel.setBounds(50, 40, 300, 40);

        // create image and JLabel for Western Logo
        JLabel logoLabel = new JLabel();
        logoLabel.setBounds(50, 125, 200, 50);
        ImageIcon westernLogo = new ImageIcon("./images/westernLogo.png");
        Image logoImage = westernLogo.getImage().getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_SMOOTH);
        westernLogo = new ImageIcon(logoImage);
        logoLabel.setIcon(westernLogo);

        // add components to left panel
        add(passwordLabel1);
        add(passwordLabel2);
        add(passwordField);
        add(enterButton);
        add(titleLabel);
        add(logoLabel);
        }

    // Button event handler
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==enterButton) {
            TempMain.ChangeScreen("poiInfo");
        }
    }
}
