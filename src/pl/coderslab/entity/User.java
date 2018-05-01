package pl.coderslab.entity;

import pl.coderslab.utils.BCrypt;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private int userGroupId;

    public User(int id, String name, String email, String password, int userGroupId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userGroupId = userGroupId;
    }

    public User(String name, String email, String password, int userGroupId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userGroupId = userGroupId;
    }

    public User (){};

    public Integer getId() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }
}
