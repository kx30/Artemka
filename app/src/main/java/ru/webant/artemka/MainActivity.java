package ru.webant.artemka;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static ru.webant.artemka.Constants.API_KEY;
import static ru.webant.artemka.Constants.END_POINT;

public class MainActivity extends AppCompatActivity {

    TextView currentTemperature;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentTemperature = findViewById(R.id.currentTemperature);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(END_POINT)
                .build();


        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        Call<WeatherData> currentWeatherRequest = weatherApi.getCurrentWeather(API_KEY, "Rostov-on-Don");


        currentWeatherRequest.enqueue(new Callback<WeatherData>() {

            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                CurrentWeatherData currentWeatherData = response.body().getCurrentWeatherData();
                currentTemperature.setText(String.valueOf(currentWeatherData.getCurrentTemperatureF()));
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}