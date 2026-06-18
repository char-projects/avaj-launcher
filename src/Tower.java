package src;
import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            Logs.log(String.format("Tower says: %s registered to weather tower.", flyable.toString()));
            flyable.setStatus(true);    
        }
    };

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        Logs.log(String.format("Tower says: %s unregistered from weather tower.", flyable.toString()));
        flyable.setStatus(false);
    };
    
    protected void conditionChanged() {
        for (Flyable flyable : new ArrayList<>(observers)) {
            try {
                flyable.updateConditions();
                this.checkHeight(flyable);
            } catch (Exception e) {
                System.out.println("Error updating aircraft");
            }
        }
    };

    private void checkHeight(Flyable flyable) {
        if (flyable.getCoordinates().getHeight() <= 0) {
            Logs.log(String.format("%s landing.", flyable.toString()));
            this.unregister(flyable);
        } else {
            flyable.setStatus(true);
        }
    }
}