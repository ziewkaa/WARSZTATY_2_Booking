package pl.coderslab.entity;

public class Hotel {

    private int id;
    private String name;
    private String address;
    private int number;
    private boolean animals;
    private String description;
    private int rooms;

    public Hotel(int id, String name, String address, int number, boolean animals, String description, int rooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.animals = animals;
        this.description = description;
        this.rooms = rooms;
    }
    public Hotel(String name, String address, int number, boolean animals, String description, int rooms) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.animals = animals;
        this.description = description;
        this.rooms = rooms;
    }

    public Hotel(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getAnimals() {
        return animals;
    }

    public void setAnimals(boolean animals) {
        this.animals = animals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
}
