package com.example.demo.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Service class for handling weather-related operations.
 */
public class WeatherService {

    private static final String WEATHER_URL = "https://wttr.in/Calgary,CA"; // Custom format

    /**
     * Fetches weather data from the weather API.
     *
     * @return the weather data as a string
     * @throws Exception if an error occurs while fetching the weather data
     */
    public static String fetchWeatherData() throws Exception {

        System.out.println("Fetching Wearher...... ");
        URL url = new URL(WEATHER_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setInstanceFollowRedirects(true); // Follow redirects
        connection.setRequestMethod("GET");




        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line).append("\n");
        }
        reader.close();

//

        System.out.println(result.toString());
        System.out.println("Completed fetching weather data.");
        return result.toString();


    }
}
