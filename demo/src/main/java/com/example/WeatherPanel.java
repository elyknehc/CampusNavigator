package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This class is for the weather panel that displays the current weather
 * @author Kevin Chau
 */

public class WeatherPanel extends JPanel {
    public static WeatherApi weather = new WeatherApi();

    public WeatherPanel() {
        String  panelBackground1 = "#a012ff";
        setBackground(Color.decode(panelBackground1));
        setBounds(1200, 0, 200, 72);
        float[] values = WeatherApi.getWeather();
        float temperature = 0;
        String conditions = WeatherApi.translateWeatherCode(values[1]);
        temperature = values[0];
        JLabel weatherTitle = new JLabel("London");
        JLabel weatherTemperature = new JLabel(temperature + "C");
        JLabel weatherConditions = new JLabel(conditions);
        weatherTitle.setFont(new Font("Balsamiq", Font.PLAIN, 20));
        weatherTemperature.setFont(new Font("Balsamiq", Font.PLAIN, 32));
        add(weatherTitle);
        add(weatherTemperature);
        add(weatherConditions);
    }
}
