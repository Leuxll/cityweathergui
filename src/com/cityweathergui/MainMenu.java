package com.cityweathergui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

public class MainMenu extends JFrame {

    public static City [] cityDatabase = new City[10];

    private JPanel mainMenuPanel;
    private JButton displayDatabaseButton;
    private JButton editCitiesButton;
    private JButton saveButton;
    private JButton exitAndSaveButton;


    public MainMenu(String title) {

        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainMenuPanel);
        this.pack();

        displayDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayDatabase obj = new DisplayDatabase("Display Database");
                obj.setVisible(true);
                dispose();
            }
        });
        editCitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditCities obj = new EditCities("Edit Cities");
                obj.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) throws IOException{

        JFrame frame = new MainMenu("Main Menu");
        frame.setVisible(true);

        for (int i = 0; i < MainMenu.cityDatabase.length; i++){

            MainMenu.cityDatabase[i] = new City();

        }

        LoadData.LoadFile();
        System.out.println(Arrays.toString(cityDatabase));

    }
}
