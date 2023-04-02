package com.example;
import java.net.*;
import java.io.*;
import java.math.BigDecimal;

import org.json.*;

public class WeatherApi {
    private static String weatherApiURL = "https://api.open-meteo.com/v1/forecast?latitude=43.0083&longitude=-81.27&current_weather=true&timeformat=unixtime&timezone=auto";

    public static void main(String[] args) throws Exception {
        float[] weather = getWeather();
        System.out.println(weather[0]);
        System.out.println(translateWeatherCode(weather[1]));
    }

    public static float[] getWeather() {
        float[] weatherReturn = new float[2];
        try {
            URL requestURL = new URL(weatherApiURL);
            URLConnection yc = requestURL.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(yc.getInputStream()));
            String inputLine;
            inputLine = in.readLine();
            JSONObject weatherParse = new JSONObject(inputLine);
            JSONObject currentWeather = (JSONObject) weatherParse.get("current_weather");
            System.out.println(currentWeather);
            weatherReturn[0] = ((BigDecimal) currentWeather.get("temperature")).floatValue();
            weatherReturn[1] = (float) (int) currentWeather.get("weathercode");
            in.close();

        } catch (Exception e) {
            System.out.println(e);
            return new float[] { -99, -99 };
        }
        return weatherReturn;
    }

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
