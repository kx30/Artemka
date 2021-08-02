package ru.webant.artemka;

import com.google.gson.annotations.SerializedName;

public class CurrentWeatherData {

    @SerializedName("temp_f")
    private double currentTemperatureF;


    public double getCurrentTemperatureF() {
        return currentTemperatureF;
    }


    public void setCurrentTemperatureF(double currentTemperatureF) {
        this.currentTemperatureF = currentTemperatureF;
    }
}
