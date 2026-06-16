package src;
// Singleton

public class WeatherProvider {
    public static WeatherProvider weatherProvider;
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };
    private WeatherProvider() {};

    public static WeatherProvider getWeatherProvider() {
		return WeatherProvider.weatherProvider;
	}

    public static String getCurrentWeather(Coordinates coordinates) {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        if (longitude < 500 && height <= 50) {
            return (weather[2]);
        } else if (longitude < 500 && height > 50) {
            return (weather[1]);
        } else if (longitude >= 500 && latitude < 500) {
            return (weather[0]);
        } else {
            return (weather[3]);
        }
    };
}