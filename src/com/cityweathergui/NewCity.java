package com.cityweathergui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCity extends JFrame{
    private JPanel newCityPanel;
    private JTextField newCityNameTextField;
    private JTextField newCityWindSpeedTextField;
    private JTextField newCityTemperatures;
    private JButton cancelButton;
    private JButton addNewCityButton;
    private JLabel updateLabel;

    int currentCity = EditCities.selectedCity;

    public NewCity(String title) {

        super(title);
        this.setContentPane(newCityPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainMenu obj = new MainMenu("Main Menu");
                obj.setVisible(true);
                dispose();

            }
        });

        addNewCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String checkTemps = newCityTemperatures.getText();
                checkTemps = checkTemps.replace(",", "");
                checkTemps = checkTemps.replace("-", "");

                if (checkTemps.matches("[0-9]+") && newCityWindSpeedTextField.getText().matches("[0-9]+")) {

                    if (EditCitiesMethod.AddCity(newCityNameTextField.getText(), Integer.valueOf(newCityWindSpeedTextField.getText()), newCityTemperatures.getText().split(","))) {
                    updateLabel.setForeground(Color.black);
                    updateLabel.setText("City " + newCityNameTextField.getText() + " has been added to the database.");

                    } else {

                        updateLabel.setForeground(Color.red);
                        updateLabel.setText("Database is full, " + newCityNameTextField.getName() + " has not been added to the database.");

                    }

                } else {

                    updateLabel.setText("City not update, please verify data");
                    updateLabel.setForeground(Color.red);

                }

            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new NewCity("New City");
        frame.setVisible(true);

    }

}
