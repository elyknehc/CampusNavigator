package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This class is for the weather panel that displays the current weather
 * @author Kevin Chau
 */

public class WeatherPanel extends JPanel {
    // Call a new WeatherApi object
    public static WeatherApi weather = new WeatherApi();

    /** 
     * This methoc creates a weather panel
     */
    public WeatherPanel() {
        String  panelBackground1 = "#a012ff";
        setBackground(Color.decode(panelBackground1));
        setBounds(1100, 0, 220, 72);
        float[] values = WeatherApi.getWeather();
        float temperature = 0;
        String conditions = WeatherApi.translateWeatherCode(values[1]);
        temperature = values[0];

        if (values[0] == -99 || values[1] == -99) {

        }
        JLabel weatherTitle = new JLabel("London");
        JLabel weatherTemperature = new JLabel(temperature + "C");
        JLabel weatherConditions = new JLabel();

        if (conditions.equals("Cloudy")) {
            ImageIcon cloudyIcon = new ImageIcon("./images/weather/cloudy.png");
            weatherConditions.setIcon(cloudyIcon);
        }
        if (conditions.equals("Rain")) {
            ImageIcon cloudyIcon = new ImageIcon("./images/weather/Drizzle.png");
            weatherConditions.setIcon(cloudyIcon);
        }
        if (conditions.equals("Clear")) {
            ImageIcon cloudyIcon = new ImageIcon("./images/weather/sun.png");
            weatherConditions.setIcon(cloudyIcon);
        }
        if (conditions.equals("Foggy")) {
            ImageIcon cloudyIcon = new ImageIcon("./images/weather/Foggy.png");
            weatherConditions.setIcon(cloudyIcon);
        }
        if (conditions.equals("Drizzle")) {
            ImageIcon cloudyIcon = new ImageIcon("./images/weather/Drizzle.png");
            weatherConditions.setIcon(cloudyIcon);
        }
        if (conditions.equals("Snow")) {
            ImageIcon cloudyIcon = new ImageIcon("./images/weather/Snow.png");
            weatherConditions.setIcon(cloudyIcon);
        }
        if (conditions.equals("Heavy Rain")) {
            ImageIcon cloudyIcon = new ImageIcon("./images/weather/Drizzle.png");
            weatherConditions.setIcon(cloudyIcon);
        }
        if (conditions.equals("Heavy Snow")) {
            ImageIcon cloudyIcon = new ImageIcon("./images/weather/Snow.png");
            weatherConditions.setIcon(cloudyIcon);
        }
        if (conditions.equals("Thunderstorm")) {
            ImageIcon cloudyIcon = new ImageIcon("./images/weather/Thunder.png");
            weatherConditions.setIcon(cloudyIcon);
        }
        if (values[0] == -99 || values[1] == -99) {
            weatherTemperature.setText("Weather Unavailable");
            ImageIcon cloudyIcon = new ImageIcon("./images/weather/nointernet.png");
            weatherConditions.setIcon(cloudyIcon);
        }
        add(weatherTitle);
        add(weatherTemperature);
        add(weatherConditions);
    }
}
