import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel{
    private JButton enterButton;
    private JTextField passwordField;
    private String password;
    
    LoginPanel() {
        // create JPanel for left panel and set properties
        setBounds(0, 0, 333, 523);
        setLayout(null);

        // LEFT PANEL
        // create JLabels for password prompt and set properties
        JLabel passwordLabel1 = new JLabel("Enter a password for admin access,");
        passwordLabel1.setBounds(55, 250, 250, 50);
        passwordLabel1.setFont(new Font("Balsamiq", Font.PLAIN, 10));
        JLabel passwordLabel2 = new JLabel("or leave blank for general access:");
        passwordLabel2.setBounds(55, 265, 250, 50);
        passwordLabel2.setFont(new Font("Balsamiq", Font.PLAIN, 10));


        // create JTextField for password input and set properties
        passwordField = new JTextField();
        passwordField.setBounds(55, 310, 200, 25);

        // create JButton for entering password and set properties
        enterButton = new JButton("Enter");
        enterButton.setBounds(55, 350, 200, 25);
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==enterButton) {
                    password = passwordField.getText();
                    if (password.equals("adminPassword")){
                        System.out.println("Correct password");
                    }
                }
                System.out.println(password); //Filler
            }
        });

        // create JLabel for title
        JLabel titleLabel = new JLabel("Western University GIS");
        titleLabel.setBounds(50, 20, 340, 60);
        titleLabel.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        // add components to left panel
        add(passwordLabel1);
        add(passwordLabel2);
        add(passwordField);
        add(enterButton);
        add(titleLabel);
    }

}
