package src;
// Singleton

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        
        if (type.toLowerCase().equals("helicopter")) {
            return new Helicopter(name, coordinates);
        } else if (type.toLowerCase().equals("jetplane")) {
            return new JetPlane(name, coordinates);
        } else if (type.toLowerCase().equals("balloon")) {
            return new Balloon(name, coordinates);
        } else {
            System.out.println("Error identifying " + type);
            return (null);
        }
    };
}