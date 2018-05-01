package pl.coderslab.entity;

public class Hotel {

    private int id;
    private String name;
    private String address;
    private String number;
    private int animals;
    private String description;

    public Hotel(int id, String name, String address, String number, int animals, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.animals = animals;
        this.description = description;
    }
    public Hotel(String name, String address, String number, int animals, String description) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.animals = animals;
        this.description = description;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAnimals() {
        return animals;
    }

    public void setAnimals(int animals) {
        this.animals = animals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
