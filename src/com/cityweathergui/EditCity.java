package com.cityweathergui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCity extends JFrame{
    private JPanel editCityPanel;
    private JTextField cityTextField;
    private JTextField windSpeedTextField;
    private JTextField tempTextField;
    private JButton cancelButton;
    private JButton updateButton;
    private JLabel cityLabel;
    private JLabel windSpeedLabel;
    private JLabel tempLabel;
    private JLabel updatedLabel;

    int currentCity = EditCities.selectedCity;

    public EditCity(String title) {

        super(title);
        this.setContentPane(editCityPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        SetLabels();

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EditCities obj = new EditCities("Edit Cities");
                obj.setVisible(true);
                dispose();

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String checkTemps = tempTextField.getText();
                checkTemps = checkTemps.replace(",", "");
                checkTemps = checkTemps.replace("-", "");

                if (checkTemps.matches("[0-9]+") && windSpeedTextField.getText().matches("[0-9]+")) {

                    EditCitiesMethod.UpdateCity(currentCity, cityTextField.getText(), Integer.valueOf(windSpeedTextField.getText()), tempTextField.getText().split(","));
                    updatedLabel.setForeground(Color.black);
                    updatedLabel.setText("City Updated");
                    SetLabels();

                } else {

                    updatedLabel.setText("City not update, please verify data");
                    updatedLabel.setForeground(Color.red);

                }

            }
        });

    }

    public void SetLabels() {

        cityLabel.setText("Current City: " + MainMenu.cityDatabase[currentCity].getCityName());
        windSpeedLabel.setText("Current Windspead: " + MainMenu.cityDatabase[currentCity].getWindSpeed());
        tempLabel.setText("Current Temperatures: " + MainMenu.cityDatabase[currentCity].getTempString());

    }

    public static void main(String[] args) {

        JFrame frame = new EditCity("Edit City");
        frame.setVisible(true);

    }

}
