package src;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "Helicopter";
    }
    
    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
        this.weatherTower.register(this);
        Logs.log(String.format("Tower says: Helicopter #%s registered to weather tower.", name, id));
    }

    // public void updateConditions(
    //     if ("SUN") {
    //         longitude += 10;
    //         height += 2;
    //     } else if ("RAIN") {
    //         longitude += 5;
    //     } else if ("FOG") {
    //         longitude += 1;
    //     } else if ("SNOW") {
    //         height -= 12;
    //     }
    // );
}