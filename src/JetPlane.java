package src;

class JetPlane extends Aircraft {
    private WeatherTower weatherTower;

    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "JetPlane";
    }

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            coordinates.changeLatitude(10);
            coordinates.changeHeight(2);
            Logs.log(String.format("%s: Clear skies. Time to break some speed records.", this.toString()));
        } else if (weather.equals("RAIN")) {
            coordinates.changeLatitude(5);
            Logs.log(String.format("%s: The sky is crying. I guess I made it jealous.", this.toString()));
        } else if (weather.equals("FOG")) {
            coordinates.changeLatitude(1);
            Logs.log(String.format("%s: Flying blind? Sounds like a terrible idea.", this.toString()));
        } else if (weather.equals("SNOW")) {
            coordinates.changeHeight(-7);
            Logs.log(String.format("%s: Winter is here. Someone check my wings for ice.", this.toString()));
        }
    }
}