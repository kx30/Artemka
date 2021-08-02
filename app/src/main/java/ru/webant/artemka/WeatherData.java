package ru.webant.artemka;

import com.google.gson.annotations.SerializedName;

public class WeatherData {

    @SerializedName("current")
    private CurrentWeatherData currentWeatherData;


    public CurrentWeatherData getCurrentWeatherData() {
        return currentWeatherData;
    }

    public void setCurrentWeatherData(CurrentWeatherData currentWeatherData) {
        this.currentWeatherData = currentWeatherData;
    }
}
