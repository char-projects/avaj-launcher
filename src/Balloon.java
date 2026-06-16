package src;

class Balloon extends Aircraft {
    private WeatherTower weatherTower;
    
    public Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "Balloon";
    }

    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
        this.weatherTower.register(this);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            coordinates.changeLongitude(2);
            coordinates.changeHeight(4);
            Logs.log("Balloon Sun height & lat change");
        } else if (weather.equals("RAIN")) {
            coordinates.changeHeight(-5);
            Logs.log("Balloon Rain height change");
        } else if (weather.equals("FOG")) {
            coordinates.changeHeight(-3);
            Logs.log("Balloon Fog height change");
        } else if (weather.equals("SNOW")) {
            coordinates.changeHeight(-15);
            Logs.log("Balloon Snow height change");
        }
    }
}