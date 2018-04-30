package pl.coderslab.dao;

import pl.coderslab.entity.Room;
import pl.coderslab.entity.User;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {

    private static final String CREATE_ROOM_QUERY = "INSERT INTO Rooms(id, space, description, price) VALUES (?,?,?,?)";
    private static final String READ_ROOM_QUERY = "SELECT * FROM Rooms where id = ?";
    private static final String UPDATE_ROOM_QUERY = "UPDATE Rooms SET space = ? , description = ?, price = ? WHERE id = ?";
    private static final String DELETE_ROOM_QUERY = "DELETE FROM Rooms WHERE id = ?";
    private static final String FIND_ALL_ROOMS_QUERY = "SELECT * FROM Rooms";


    public void create( int space, String description, double price) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_ROOM_QUERY);
            statement.setInt(1, space);
            statement.setString(2, description);
            statement.setDouble(3, price);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Room read(int id) {

        Room room = new Room();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_ROOM_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                room.setId(resultSet.getInt("id"));
                room.setSpace(resultSet.getInt("space"));
                room.setDescription(resultSet.getString("description"));
                room.setPrice(resultSet.getDouble("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return room;
    }

    public List<Room> readAllRooms() {

        List<Room> allRooms = new ArrayList<>();
        Room room = new Room();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_ROOMS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                room.setId(resultSet.getInt("id"));
                room.setSpace(resultSet.getInt("space"));
                room.setDescription(resultSet.getString("descritpion"));
                room.setPrice(resultSet.getDouble("price"));
                allRooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allRooms;
    }

    public void update(Room room) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM_QUERY);
            statement.setInt(4, room.getId());
            statement.setInt(1, room.getSpace());
            statement.setString(2, room.getDescription());
            statement.setDouble(3, room.getPrice());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(Integer id) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_ROOM_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
