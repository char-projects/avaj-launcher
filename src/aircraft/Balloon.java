package src.aircraft;
import src.weather.WeatherTower;
import src.Logs;

class Balloon extends Aircraft {
    private WeatherTower weatherTower;
    
    public Balloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Balloon";
    }

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            coordinates.changeLongitude(2);
            coordinates.changeHeight(4);
            Logs.log(String.format("%s: Perfect weather. My passengers forgot they are scared of heights.", this.toString()));
        } else if (weather.equals("RAIN")) {
            coordinates.changeHeight(-5);
            Logs.log(String.format("%s: This weather is turning my balloon into a swimming pool.", this.toString()));
        } else if (weather.equals("FOG")) {
            coordinates.changeHeight(-3);
            Logs.log(String.format("%s: Is this fog or did the world disappear?", this.toString()));
        } else if (weather.equals("SNOW")) {
            coordinates.changeHeight(-15);
            Logs.log(String.format("%s: Snowflakes are cute until they start adding weight.", this.toString()));
        }
    }
}