package src.weather;
import src.aircraft.Coordinates;

import java.util.StringJoiner;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class WeatherProvider {
    // Singleton
    public static final WeatherProvider instance = new WeatherProvider();
    private WeatherProvider() {};
    public static WeatherProvider getInstance() {
        return (instance);
    }

    private static final String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

    private final Map<String, String> districtWeather = new HashMap<>();
        
    private String generateWeather() {
        Random random = new Random();
        int index = random.nextInt(weather.length);
        return(weather[index]);
    }

    public void updateWeather() {
        districtWeather.put("District 1", generateWeather());
        districtWeather.put("District 2", generateWeather());
        districtWeather.put("District 3", generateWeather());
        districtWeather.put("District 4", generateWeather());
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int longitude = p_coordinates.getLongitude();
        int latitude = p_coordinates.getLatitude();
        int height = p_coordinates.getHeight();

        String district;
        if (longitude < 500 && height <= 50) {
            district = "District 3";
        } else if (longitude < 500 && height > 50) {
            district = "District 2";
        } else if (longitude >= 500 && latitude < 500) {
            district = "District 1";
        } else {
            district = "District 4";
        }

        String weatherStr = districtWeather.get(district);
        return (weatherStr);
    };
}