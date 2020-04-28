package com.cityweathergui;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DisplayDatabase extends JFrame {


    private JPanel displayDatabasePanel;
    private JButton mainMenuButton;
    private JEditorPane editorPane1;

    public DisplayDatabase(String title) {

        super(title);
        this.setContentPane(displayDatabasePanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();

        editorPane1.setEnabled(false);
        editorPane1.setContentType("text/html");
        try {
            editorPane1.setText(DisplayMethod.CreatHTMLTable());
        } catch (IOException e) {
            System.out.println("Can not load file.");
        }

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu obj = null;
                obj = new MainMenu("Main Menu");
                obj.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new DisplayDatabase("Display Database");
        frame.setVisible(true);

    }

}
