package com.example;
import java.net.*;
import java.io.*;
import java.math.BigDecimal;

import org.json.*;

/**
 * This class is used to retrieve information for the Weather API
 * @author Group 51
 */
public class WeatherApi {
    //Set up connection to API
    private static String weatherApiURL = "https://api.open-meteo.com/v1/forecast?latitude=43.0083&longitude=-81.27&current_weather=true&timeformat=unixtime&timezone=auto";

    /**
     * Method that retrieves the weather from the weather API
     * @return an array that contains the temperature, as well as a code that represents the weather condition
     */
    public static float[] getWeather() {
        float[] weatherReturn = new float[2];
        try {

            //Sets the information of the weather with an API request, returns two floats for the user
            URL requestURL = new URL(weatherApiURL);
            URLConnection yc = requestURL.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(yc.getInputStream()));
            String inputLine;
            inputLine = in.readLine();
            JSONObject weatherParse = new JSONObject(inputLine);
            JSONObject currentWeather = (JSONObject) weatherParse.get("current_weather");
            weatherReturn[0] = ((BigDecimal) currentWeather.get("temperature")).floatValue();
            weatherReturn[1] = (float) (int) currentWeather.get("weathercode");
            in.close();

        } catch (Exception e) {
            System.out.println(e);
            return new float[] { -99, -99 };
        }
        return weatherReturn;
    }

    /**
     * Returns the  number from the API that can be interpreted.
     * @param code the code received from the Weather API
     * @return returns a string for the user that can be interpreted.
     */
    public static String translateWeatherCode(float code) {
        if (code <= 0) {
            return "Clear";
        }
        else if (code <= 3) {
            return "Cloudy";
        }
        else if (code <= 48) {
            return "Foggy";
        }
        else if (code <= 57) {
            return "Drizzle";
        }
        else if (code <= 67) {
            return "Rain";
        }
        else if (code <= 77) {
            return "Snow";
        }
        else if (code <= 82) {
            return "Heavy Rain";
        }
        else if (code <= 86) {
            return "Heavy Snow";
        }
        else if (code <= 99) {
            return "Thunderstorm";
        }
        return "Clear";
    }

}
