// Singleton

public class WeatherProvider {
    private string[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private WeatherProvider() {};

    // Generate random weather here
    public string getCurrentWeather(Coordinates coordinates) {};
}