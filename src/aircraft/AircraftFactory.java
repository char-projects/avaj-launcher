package src.aircraft;
// Singleton

public class AircraftFactory {
    private static AircraftFactory instance;
    private static long id = 0;

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return (instance);
    }

    private long nextId() {
        return (++id);
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) { 
        long p_id = nextId();       
        if (p_type.toLowerCase().equals("helicopter")) {
            return new Helicopter(p_id, p_name, p_coordinates);
        } else if (p_type.toLowerCase().equals("jetplane")) {
            return new JetPlane(p_id, p_name, p_coordinates);
        } else if (p_type.toLowerCase().equals("balloon")) {
            return new Balloon(p_id, p_name, p_coordinates);
        } else {
            System.out.println("Error identifying " + p_type);
            return (null);
        }
    };
}