package pl.coderslab.entity;

public class Room {

    private int id;
    private int space;
    private String description;
    private double price;
    private int hotel_id;

    public Room(int id, int space, String description, double price, int hotel_id) {
        this.id = id;
        this.space = space;
        this.description = description;
        this.price = price;
        this.hotel_id = hotel_id;
    }

    public Room(int space, String description, double price, int hotel_id) {
        this.space = space;
        this.description = description;
        this.price = price;
        this.hotel_id = hotel_id;
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

    public int getHotelId() {
        return hotel_id;
    }

    public void setHotelId(int hotel_id) {
        this.hotel_id = hotel_id;
    }
}
