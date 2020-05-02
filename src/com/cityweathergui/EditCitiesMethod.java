package com.cityweathergui;

import com.sun.tools.javac.Main;

import java.io.IOException;

public class EditCitiesMethod {

    public static void DeleteCity(int SelectedCity) {

        int lastCity = 0;

        for (int i = SelectedCity; i < MainMenu.cityDatabase.length - 1; i++) {

            if (MainMenu.cityDatabase[i].getWindSpeed() > 0) {

                MainMenu.cityDatabase[i] = MainMenu.cityDatabase[i + 1];
                lastCity = i;

            }

        }

        MainMenu.cityDatabase[lastCity] = new City();

    }

    public static void UpdateCity(int currentCity, String cityName, int windSpeed, String[] tempArray) {

        int temperatures [] = new int[tempArray.length];
        for (int j = 0; j < tempArray.length; j++) {

            temperatures[j] = Integer.parseInt(tempArray[j]);

        }

        MainMenu.cityDatabase[currentCity] = new City(cityName, windSpeed, temperatures);

        try {
            SaveFile.SaveData();;
        } catch (IOException ex) {
            System.out.println("Error in saving file");
        }

    }

    public static boolean AddCity(String cityName, int windSpeed, String [] tempTempArray) {

        boolean added = false;

        int temperatures [] = new int [tempTempArray.length];

        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = Integer.parseInt(tempTempArray[i]);
        }

        for (int i = 0; i < MainMenu.cityDatabase.length; i++) {
            if (MainMenu.cityDatabase[i].getWindSpeed() < 0) {
                MainMenu.cityDatabase[i] = new City(cityName, windSpeed, temperatures);
                added = true;
                break;
            }
        }

        try {
            SaveFile.SaveData();;
        } catch (IOException ex) {
            System.out.println("Error in saving file");
        }

        return added;
    }

}
