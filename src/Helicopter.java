package src;

class Helicopter extends Aircraft {
    private WeatherTower weatherTower;

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Helicopter";
    }
    
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            coordinates.changeLongitude(10);
            coordinates.changeHeight(2);
            Logs.log(String.format("%s: The view today is worth the fuel.", this.toString()));
        } else if (weather.equals("RAIN")) {
            coordinates.changeLongitude(5);
            Logs.log(String.format("%s: Rain is just nature trying to clean my windows.", this.toString()));
        } else if (weather.equals("FOG")) {
            coordinates.changeLongitude(1);
            Logs.log(String.format("%s: The fog is hiding the view. How rude.", this.toString()));
        } else if (weather.equals("SNOW")) {
            coordinates.changeHeight(-12);
            Logs.log(String.format("%s: Cold weather detected. Requesting a blanket.", this.toString()));

        }
    }
}