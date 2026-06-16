package src;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    
    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "Balloon";
    }

    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
        this.weatherTower.register(this);
        Logs.log(String.format("Tower says: Balloon #%s registered to weather tower.", name, id));
    }

    // public void updateConditions(
    //     if ("SUN") {
    //         longitude += 2;
    //         height += 4;
    //     } else if ("RAIN") {
    //         height -= 5;
    //     } else if ("FOG") {
    //         height -= 3;
    //     } else if ("SNOW") {
    //         height -= 15;
    //     }
    // );
}