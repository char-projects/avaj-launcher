public class JetPlane extends Aircraft {
    public JetPlane(long p_id, string p_name, Coordinates p_coordinates);

    public void updateConditions() {
        if ("SUN") {
            latitude += 10;
            height += 2;
        } else if ("RAIN") {
            latitude += 5;
        } else if ("FOG") {
            latitude += 1;
        } else if ("SNOW") {
            height -= 7;
        }
    };
}