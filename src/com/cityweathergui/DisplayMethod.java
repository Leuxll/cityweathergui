package com.cityweathergui;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.Arrays;

public class DisplayMethod {

    public static String CreatHTMLTable() throws IOException {

        City Database = new City();
        LoadData.LoadFile();
        String HTMLString = "<html><body><tr>" +
                "<th><font color = \"red\">City</font></th>" +
                "<th><font color = \"red\">Windspeed</font></th>" +
                "<th><font color = \"red\">Temperatures</font></th>";

        for (int i = 0; i < MainMenu.cityDatabase.length; i++) {

            if (MainMenu.cityDatabase[i].getCityName().equals("-") == false) {

                HTMLString += "<tr>";
                HTMLString += "<td>" + MainMenu.cityDatabase[i].getCityName() + "</td>";
                HTMLString += "<td>" + MainMenu.cityDatabase[i].getWindSpeed() + "</td>";
                HTMLString += "<td>" + Arrays.toString(MainMenu.cityDatabase[i].getTemp()) + "</td>";
                HTMLString += "</tr>";

            } else {
                break;
            }

        }

        HTMLString += "</table></html>";
        return HTMLString;
    }

}
