package src;

class JetPlane extends Aircraft {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.type = "JetPlane";
    }

    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
        this.weatherTower.register(this);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            coordinates.changeLatitude(10);
            coordinates.changeHeight(2);
            Logs.log(String.format("%s: Sun height & lat change", this.toString()));
        } else if (weather.equals("RAIN")) {
            coordinates.changeLatitude(5);
            Logs.log(String.format("%s: Rain lat change", this.toString()));
        } else if (weather.equals("FOG")) {
            coordinates.changeLatitude(1);
            Logs.log(String.format("%s: Fog lat change", this.toString()));
        } else if (weather.equals("SNOW")) {
            coordinates.changeHeight(-7);
            Logs.log(String.format("%s: Snow height change", this.toString()));
        }
    }
}