package com.example;
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
/**
 * This class is responsible for showing an exit warning if the user closes without changes saved
 * @author Group51
 */

public class ExitWarning extends JFrame {
	// Create a new frame and pass in a new POI object through it
    ExitWarning() {
        // Create the labels and get information from current 
        JLabel Prompt1 = new JLabel("You have unsaved changes");
        Prompt1.setBounds(70, 70, 600, 60);
        JLabel Prompt2 = new JLabel("are you sure you want to exit?");
        Prompt2.setBounds(60, 110, 600, 60);
        JButton Exit = new JButton("Exit");
        Exit.setBounds(70, 337, 150, 50);
        JButton Continue = new JButton("Continue");
        Continue.setBounds(375, 337, 150, 50);
        ExitListener exitListener = new ExitListener();
        ContinueListener continueListener = new ContinueListener(this);
        Exit.addActionListener(exitListener);
        Continue.addActionListener(continueListener);


        // Set the font for each label
        Prompt1.setFont(new Font("Balsamiq", Font.BOLD, 32));
        Prompt2.setFont(new Font("Balsamiq", Font.BOLD, 32));

        // Add frames
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Exit Warning");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(600, 600);
        this.getContentPane().setBackground(Color.white);
        this.add(Prompt1);
        this.add(Prompt2);
        this.add(Exit);
        this.add(Continue);
        this.setVisible(true);
    }

    private class ExitListener implements ActionListener {
        //Listener for closing the button
        public void actionPerformed(ActionEvent e) {
            Main.exitProgram();
            System.exit(0);
        }
    }
    //Keep going on. Returns to the program.
    private class ContinueListener implements ActionListener {
        private JFrame ExitFrame;

        /**
         * @param ExitFrame, leave the panel
         */
        public ContinueListener(JFrame ExitFrame) {
            this.ExitFrame = ExitFrame;
        }

        /**
         * Exit the frame
         */
        public void actionPerformed(ActionEvent e) {
            ExitFrame.setVisible(false);
        }
    }
}