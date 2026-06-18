package src;
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

    // public static void formatCoordLog(int longitude, int latitude, int height) {
    //     StringJoiner longJoin = new StringJoiner(": ");
    //     StringJoiner latJoin = new StringJoiner(": ");
    //     StringJoiner heightJoin = new StringJoiner(": ");
    //     StringJoiner coordJoin = new StringJoiner(", ");

    //     String longitudeStr = Integer.toString(longitude);
    //     String latitudeStr = Integer.toString(latitude);
    //     String heightStr = Integer.toString(height);

    //     longJoin.add("Longitude").add(longitudeStr);
    //     String joinerLong = longJoin.toString();
    //     latJoin.add("Latitude").add(latitudeStr);
    //     String joinerLat = latJoin.toString();
    //     heightJoin.add("Height").add(heightStr);
    //     String joinerHeight = heightJoin.toString();

    //     coordJoin.add(joinerLong).add(joinerLat).add(joinerHeight);
    //     String coordStr = coordJoin.toString();
    //     Logs.log(coordStr);
    // };

    public String getCurrentWeather(Coordinates coordinates) {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        // WeatherProvider.formatCoordLog(longitude, latitude, height);

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
        Logs.log(String.format("Weather Provider says: The weather in %s is %s", district, weatherStr));
        return (weatherStr);
    };
}