package src;

public abstract class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String type;
    protected boolean status = false;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
        this.type = "Default";
    };

    public long getId() {
        return (this.id);
    };

    public String getType() {
        return (this.type);
    };

    public String getName() {
        return (this.name);
    };

    public String toString() {
        return (String.format("%s#%s(%d)", this.type, this.name, this.id));
    };

    public Coordinates getCoordinates() {
        return (coordinates);
    };

    public void setStatus(boolean flag) {
        this.status = flag;
    };

    public boolean getStatus() {
        return (this.status);
    };
}