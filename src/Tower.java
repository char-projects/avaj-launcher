package src;
import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();
    // private List<Flyable> allAircrafts = new ArrayList<>();

    public void register(Flyable p_flyable) {
        // if (!allAircrafts.contains(p_flyable)) {
        //     allAircrafts.add(p_flyable);
        // }
        if (!observers.contains(p_flyable)) {
            observers.add(p_flyable);
            Logs.log(String.format("Tower says: %s registered to weather tower.", p_flyable.toString()));
            p_flyable.setStatus(true);    
        }
    };

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        Logs.log(String.format("Tower says: %s unregistered from weather tower.", p_flyable.toString()));
        p_flyable.setStatus(false);
    };
    
    protected void conditionChanged() {
        for (Flyable p_flyable : new ArrayList<>(observers)) {
            try {
                p_flyable.updateConditions();
                if (p_flyable.getCoordinates().getHeight() <= 0) {
                    Logs.log(String.format("%s landing.", p_flyable.toString()));
                    this.unregister(p_flyable);
                } else {
                    p_flyable.setStatus(true);
                }
            } catch (Exception e) {
                System.out.println("Error updating aircraft");
            }
        }
    };

    // public void logFinalCoordinates() {
    //     Logs.log("\nFinal aircraft coordinates:\n");
    //     for (Flyable flyable : allAircrafts) {
    //         Coordinates coordinates = flyable.getCoordinates();
    //         Logs.log(String.format("%s: Long %d, Lat %d, Height %d",
    //             flyable.toString(),
    //             coordinates.getLongitude(),
    //             coordinates.getLatitude(),
    //             coordinates.getHeight()));
    //     }
    // }
}