package pl.coderslab.entity;

public class Room {

    private int id;
    private int space;
    private String description;
    private double price;

    public Room(int id, int space, String description, double price) {
        this.id = id;
        this.space = space;
        this.description = description;
        this.price = price;
    }

    public Room(int space, String description, double price) {
        this.space = space;
        this.description = description;
        this.price = price;
    }

    public Room(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
