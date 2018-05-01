package pl.coderslab.dao;

import pl.coderslab.entity.Reservation;
import pl.coderslab.utils.DbUtil;
import pl.coderslab.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String CREATE_USER_QUERY = "INSERT INTO Users(name,email,password) VALUES (?,?,?)";
    private static final String ADD_USER_TO_GROUP_QUERY = "UPDATE Users SET user_group_id=? WHERE id=?";
    private static final String READ_USER_QUERY = "SELECT * FROM Users where id = ?";
    private static final String READ_USER_BY_NAME_QUERY = "SELECT * FROM Users where name = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE Users SET name = ? , email = ?, password = ?, user_group_id =? WHERE id = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM Users WHERE id = ?";
    private static final String FIND_ALL_USERS_QUERY = "SELECT * FROM Users";


    static public void create(String name, String email) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_USER_QUERY);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public void addToGroup(int userGroupId, int id) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD_USER_TO_GROUP_QUERY);
            statement.setInt(1, userGroupId);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public User read(int userId) {

        User user = new User();
        try (Connection connection = DbUtil.getConnection()) {
             PreparedStatement statement = connection.prepareStatement(READ_USER_QUERY);
             statement.setInt(1, userId);
             ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setUserGroupId(resultSet.getInt("user_group_id"));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    static public User readByName(String name) {

        User user = new User();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_USER_BY_NAME_QUERY);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setUserGroupId(resultSet.getInt("user_group_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    static public List<User> readAllUsers() {

        List<User> allUsers = new ArrayList<>();
        User user = new User();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_USERS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setUserGroupId(resultSet.getInt("user_group_id"));
                allUsers.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    static public void update(User user) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_QUERY);
            statement.setInt(5, user.getId());
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getUserGroupId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public void delete(int userId) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_QUERY);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}