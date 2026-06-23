package src.aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    
    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    };

    public int getLongitude() {
        return this.longitude;
    };

    public int getLatitude() {
        return this.latitude;
    };

    public int getHeight() {
        return this.height;
    };

    public void changeLongitude(int p_longitude) {
        longitude += p_longitude;
        if (longitude < 0) {
            longitude = 1;
        }
    };

    public void changeLatitude(int p_latitude) {
        latitude += p_latitude;
        if (latitude < 0) {
            latitude = 1;
        }
    };

    public void changeHeight(int p_height) {
        height += p_height;
        if (height > 100) {
            height = 100;
        } else if (height < 0) {
            height = 0;
        }
    };
}