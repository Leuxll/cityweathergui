 
package com.cityweathergui;

import com.sun.tools.javac.Main;

public class City {

    //declare the fields for each instance of city object
    private String cityName;
    private int windSpeed;
    private int[] tempreture;

    //these are constructor methods
    //if we call the city method with no parameters this method will be called
    public City() {

        cityName = "-";
        windSpeed = -1;

    }

    //if we call the city method with parameters this method will be called
    //this is called polymorophism
    public City(String cityName, int windSpeed, int []temperature){

        this.cityName = cityName;
        this.windSpeed = windSpeed;
        this.tempreture = temperature;

    }

    //getter methods for city name, windspeed, and tempreture

    String getCityName(){
        return this.cityName;
    }

    int getWindSpeed(){
        return this.windSpeed;
    }

    int [] getTemp(){

        return this.tempreture;
    }

    String getTempString() {

        String TempString= "";

        for (int i  = 0; i < tempreture.length; i++) {

            if (i < tempreture.length - 1) {

                TempString += tempreture[i] + ", ";

            } else {
                TempString += tempreture[i];
            }

        }

        return TempString;

    }

    //setter or mutator methods
    void setCityName(String name){
        this.cityName = name;
    }

    String setWindSpeed(int windSpeed){

        if(windSpeed >= 0){
            this.windSpeed = windSpeed;
            return("New windspeed set");
        }
        else{
            return ("You cannot have a negative windspeed");
        }
    }

    void setTempreture(int[] tempreture){

        this.tempreture = tempreture;
    }

    int[] sortTemps(){

        for (int i = 0; i < tempreture.length - 1; i++){
            int index  = i;
            for (int j = i + 1; j < tempreture.length; j++){
                if (tempreture[j] < tempreture[index]) {
                    index = j;
                }
            }

            if (index != i){
                int smallestNumber = tempreture[index];
                tempreture[index] = tempreture[i];
                tempreture[i] = smallestNumber;
            }

        }

        return tempreture;
    }

    public int length() {

        int length = MainMenu.cityDatabase.length;
        return length;
    }
}
