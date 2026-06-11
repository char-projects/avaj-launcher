public class Baloon extends Aircraft {
    public Baloon(long p_id, string p_name, Coordinates p_coordinate);
    
    public void updateConditions(
        if ("SUN") {
            longitude += 2;
            height += 4;
        } else if ("RAIN") {
            height -= 5;
        } else if ("FOG") {
            height -= 3;
        } else if ("SNOW") {
            height -= 15;
        }
    );
}