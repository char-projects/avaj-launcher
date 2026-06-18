package src;

class Helicopter extends Aircraft {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "Helicopter";
    }
    
    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
        this.weatherTower.register(this);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            coordinates.changeLongitude(10);
            coordinates.changeHeight(2);
            Logs.log(String.format("%s: Sun height & long change", this.toString()));
        } else if (weather.equals("RAIN")) {
            coordinates.changeLongitude(5);
            Logs.log(String.format("%s: Rain long change", this.toString()));
        } else if (weather.equals("FOG")) {
            coordinates.changeLongitude(1);
            Logs.log(String.format("%s: Fog long change", this.toString()));
        } else if (weather.equals("SNOW")) {
            coordinates.changeHeight(-12);
            Logs.log(String.format("%s: Snow height change", this.toString()));

        }
    }
}