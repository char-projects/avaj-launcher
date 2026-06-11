// Singleton

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (longitude < 0 || latitude < 0 || height < 0) {
            return null;
        } else if (height > 100) {
            height = 100;
        }
    };
}