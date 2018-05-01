package pl.coderslab.entity;

public class Group {

    private int id;
    private String name;
    private int user_id;

    public Group(int id, String name, int user_id){
        this.id = id;
        this.name = name;
        this.user_id = user_id;
    }

    public Group( String name, int user_id){
        this.name = name;
        this.user_id = user_id;
    }

    public Group(){}

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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
