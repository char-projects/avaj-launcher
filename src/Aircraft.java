package src;

public abstract class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String type;
    static private long idCounter = 1;
    protected boolean status = false;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;
        this.type = "Default";
    };

    private long nextId() {
        return (Aircraft.idCounter++);
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