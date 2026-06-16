package src;

public abstract class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String type;
    static private long idCounter = 1;

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
}