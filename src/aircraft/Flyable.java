package src.aircraft;
import src.weather.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        p_tower.register(this);
    };

    public abstract void updateConditions();
    public abstract long getId();
    public abstract String getType();
    public abstract String getName();
    public abstract String toString();
    public abstract Coordinates getCoordinates();
    public abstract void setStatus(boolean flag);
    public abstract boolean getStatus();
}