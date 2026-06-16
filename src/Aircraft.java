package src;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String type;
    static private long idCounter = 1;

    protected Aircraft(String name, Coordinates coordinate) {
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;
        this.type = "Default";
    };

    private long nextId() {
        return (Aircraft.idCounter++);
    }
}