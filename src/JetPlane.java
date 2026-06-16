package src;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "JetPlane";
    }

    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
        this.weatherTower.register(this);
        Logs.log(String.format("Tower says: JetPlane #%s registered to weather tower.", name, id));
    }

    // public void updateConditions() {
    //     if ("SUN") {
    //         latitude += 10;
    //         height += 2;
    //     } else if ("RAIN") {
    //         latitude += 5;
    //     } else if ("FOG") {
    //         latitude += 1;
    //     } else if ("SNOW") {
    //         height -= 7;
    //     }
    // };
}