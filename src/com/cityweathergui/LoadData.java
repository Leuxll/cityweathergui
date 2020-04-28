package com.cityweathergui;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadData {

    public static void LoadFile() throws IOException{

        String filePath = System.getProperty("user.dir") + "/datafile.txt";
        System.out.println(filePath);
        BufferedReader dataIn;
        dataIn = new BufferedReader(new FileReader(filePath));

        int numberofLines = 0;

        while (dataIn.readLine() != null) {
            numberofLines++;
        }

        int numberofCities = numberofLines / 3;
        dataIn = new BufferedReader(new FileReader((filePath)));

        for (int i = 0; i < numberofCities; i++){

            String cityName = dataIn.readLine();
            int winSpeed = Integer.parseInt(dataIn.readLine());
            String tempTemps = dataIn.readLine();
            String[] tempsTempsArray = tempTemps.split(",");
            int[] temperatures = new int[tempsTempsArray.length];

            for (int j = 0; j < temperatures.length; j++){
                temperatures[j] = Integer.parseInt(tempsTempsArray[j]);
            }

            MainMenu.cityDatabase[i] = new City(cityName, winSpeed, temperatures);

        }
    }

}
