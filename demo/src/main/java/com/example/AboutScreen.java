package com.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * This class serves as the about screen telling the users about our group
 * @author Kevin Chau
 */

public class AboutScreen extends JFrame {
    AboutScreen(){
        //Set properties of the about screen
        String panelBackground1 = "#a012ff";
        JLabel title = new JLabel("Western GIS");
        title.setFont(new Font("Balsamiq", Font.BOLD, 55));
        title.setBounds(140, 40, 400, 50);

        // About Label
        JLabel version = new JLabel("Version 0.0");
        JLabel date = new JLabel("Released March 6th 2023");
        JLabel creators = new JLabel("Creators:");
        JLabel Kevin = new JLabel("Kevin Chau");
        JLabel Kyle = new JLabel("Kyle Chen");
        JLabel Andy = new JLabel("Andy Hwang");
        JLabel Michael = new JLabel("Michael Gao");
        JLabel Arsalaan = new JLabel("Arsalaan Ali");
        JLabel questions = new JLabel("Questions? Contact: kchau57@uwo.ca");
        version.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        version.setBounds(30, 110, 400, 50);
        date.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        date.setBounds(30, 140, 400, 50);
        creators.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        creators.setBounds(30, 200, 400, 50);
        Kevin.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        Kevin.setBounds(30, 230, 400, 50);
        Kyle.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        Kyle.setBounds(30, 260, 400, 50);
        Andy.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        Andy.setBounds(30, 290, 400, 50);
        Michael.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        Michael.setBounds(30, 320, 400, 50);
        Arsalaan.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        Arsalaan.setBounds(30, 350, 400, 50);
        questions.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        questions.setBounds(30, 410, 500, 50);

        // Return to App Button

        JButton returnButton = new JButton("Return to App");
        returnButton.setFont(new Font("Balsamiq", Font.BOLD, 18));
        returnButton.setBounds(200, 480, 200,50);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Framing
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("About Screen");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(600,600);
        this.getContentPane().setBackground(Color.decode(panelBackground1));
        this.add(title);
        this.add(returnButton);
        this.add(version);
        this.add(date);
        this.add(creators);
        this.add(Kevin);
        this.add(Michael);
        this.add(Andy);
        this.add(Kyle);
        this.add(Arsalaan);
        this.add(questions);
        this.setVisible(true);
    }

}