package com.cityweathergui;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveFile {

    public static void SaveData() throws IOException {

        PrintWriter dataOut;

        dataOut = new PrintWriter (new FileWriter("datafile.txt"));

        for (int i = 0; i < MainMenu.cityDatabase.length; i++) {

            if (MainMenu.cityDatabase[i].getCityName().equals("-") == false) {

                dataOut.println(MainMenu.cityDatabase[i].getCityName());
                dataOut.println(MainMenu.cityDatabase[i].getWindSpeed());

                int temperatures[] = MainMenu.cityDatabase[i].getTemp();

                String tempString = "";

                for (int j = 0; j < temperatures.length; j++) {

                    if (j < temperatures.length - 1) {
                        tempString += temperatures[j] + ",";
                    } else {
                        tempString += temperatures[j];
                    }

                }
                dataOut.println(tempString);
            } else
                break;
        }

        dataOut.close();

    }
}

