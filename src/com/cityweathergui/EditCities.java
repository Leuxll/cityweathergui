package com.cityweathergui;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EditCities extends JFrame{

    int selectedCity = 0;

    private JPanel editCitiesPanel;
    private JButton mainMenuButton;
    private JComboBox citiesComboBox;
    private JButton deleteCityButton;

    public void ResetComboBox() {

        citiesComboBox.removeAllItems();

        for (int i = 0; i < MainMenu.cityDatabase.length; i++) {
            if (MainMenu.cityDatabase[i].getWindSpeed() > -1) {
                citiesComboBox.addItem(MainMenu.cityDatabase[i].getCityName());

            }
        }
    }

    public EditCities(String title) {

        super(title);
        this.setContentPane(editCitiesPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        ResetComboBox();

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainMenu obj = new MainMenu("Main Menu");
                obj.setVisible(true);
                dispose();

            }
        });

        deleteCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SetCity();
                System.out.println(selectedCity);
                String[] options = {"Confirm", "Cancel"};
                int confirmation = JOptionPane.showOptionDialog(null, "Are you sure you want to delete " +
                                    MainMenu.cityDatabase[selectedCity].getCityName() + "?", "Confirmation", JOptionPane.PLAIN_MESSAGE,
                                    1, null, options, options[0]);

                if (confirmation == 0) {

                    EditCitiesMethod.DeleteCity(selectedCity);
                        ResetComboBox();
                    try {
                        SaveFile.SaveData();
                        JOptionPane.showMessageDialog(rootPane, "Delete Successful");
                    } catch (IOException ioException) {
                        System.out.println("Could not save file.");
                    }

                }

            }
        });
    }

    public void SetCity() {

        selectedCity = citiesComboBox.getSelectedIndex();
        EditCitiesMethod.DeleteCity(selectedCity);

    }

    public static void main(String[] args) {

        JFrame frame = new EditCities("Edit Cities");
        frame.setVisible(true);

    }

}
