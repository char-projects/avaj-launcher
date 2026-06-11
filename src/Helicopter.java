public class Helicopter extends Aircraft {
    public Helicopter(long p_id, string p_name, Coordinates p_coordinate);
    
    public void updateConditions(
        if ("SUN") {
            longitude += 10;
            height += 2;
        } else if ("RAIN") {
            longitude += 5;
        } else if ("FOG") {
            longitude += 1;
        } else if ("SNOW") {
            height -= 12;
        }
    );
}