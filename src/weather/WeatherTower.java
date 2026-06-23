package src.weather;
import src.aircraft.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return (WeatherProvider.getInstance().getCurrentWeather(p_coordinates));
    };

    public void changeWeather() {
        WeatherProvider.getInstance().updateWeather();
        conditionChanged();
    };
}