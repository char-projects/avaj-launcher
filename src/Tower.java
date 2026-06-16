package src;
import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            Logs.log(String.format("Tower says: %s#%s(%d) registered to weather tower.", flyable.getType(), flyable.getName(), flyable.getId()));    
        }
    };

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        Logs.log(String.format("Tower says: %s#%s(%d) unregistered from weather tower.", flyable.getType(), flyable.getName(), flyable.getId()));    
    };
    
    protected void conditionChanged() {};
}