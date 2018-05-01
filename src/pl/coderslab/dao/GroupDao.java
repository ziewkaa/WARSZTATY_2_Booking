package pl.coderslab.dao;

import pl.coderslab.entity.Group;
import pl.coderslab.entity.User;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroupDao {

    private static final String CREATE_GROUP_QUERY = "INSERT INTO Groups(name) VALUES (?)";
    private static final String READ_GROUP_QUERY = "SELECT * FROM Groups where id = ?";
    private static final String READ_ALL_USERS_IN_GROUP_QUERY = "SELECT * FROM Users WHERE group_id = ?";
    private static final String UPDATE_GROUP_QUERY = "UPDATE Groups SET name=? WHERE id = ?";
    private static final String DELETE_GROUP_QUERY = "DELETE FROM Groups WHERE id = ?";
    private static final String FIND_ALL_GROUPS_QUERY = "SELECT * FROM Groups";

    public void create( String name) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_GROUP_QUERY);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Group read(int id) {

        Group group = new Group();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_GROUP_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                group.setId(resultSet.getInt("id"));
                group.setName(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return group;
    }

    public List<Group> readAllGroups() {

        List<Group> allGroups = new ArrayList<>();
        Group group = new Group();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_GROUPS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                group.setId(resultSet.getInt("id"));
                group.setName(resultSet.getString("name"));
                allGroups.add(group);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allGroups;
    }

    public List<User> readAllUsersInGroup() {

        List<User> allGroupUsers = new ArrayList<>();
        User user = new User();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_ALL_USERS_IN_GROUP_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setUserGroupId(resultSet.getInt("user_group_id"));
                allGroupUsers.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allGroupUsers;
    }

    public void update(Group group) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_GROUP_QUERY);
            statement.setInt(2, group.getId());
            statement.setString(1, group.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_GROUP_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
