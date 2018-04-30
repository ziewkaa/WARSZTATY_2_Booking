package pl.coderslab.dao;

import pl.coderslab.entity.Hotel;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {

    private static final String CREATE_HOTEL_QUERY = "INSERT INTO Hotels( name,  address, number, animals, description, rooms) VALUES (?,?,?,?,?,?)";
    private static final String READ_HOTEL_QUERY = "SELECT * FROM Hotels where id = ?";
    private static final String UPDATE_HOTEL_QUERY = "UPDATE Hotels SET name = ? , address = ?, number = ?, animals =?, description =?, rooms =? WHERE id = ?";
    private static final String DELETE_HOTEL_QUERY = "DELETE FROM Hotels WHERE id = ?";
    private static final String FIND_ALL_HOTEL_QUERY = "SELECT * FROM Hotels";


    public void create(String name, String address, int number, boolean animals, String description, int rooms) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_HOTEL_QUERY);
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setInt(3, number);
            statement.setBoolean(4, animals);
            statement.setString(5, description);
            statement.setInt(6, rooms);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Hotel read(int id) {

        Hotel hotel = new Hotel();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_HOTEL_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hotel.setId(resultSet.getInt("id"));
                hotel.setName(resultSet.getString("name"));
                hotel.setAddress(resultSet.getString("address"));
                hotel.setNumber(resultSet.getInt("number"));
                hotel.setAnimals(resultSet.getBoolean("animals"));
                hotel.setDescription(resultSet.getString("description"));
                hotel.setRooms(resultSet.getInt("rooms"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel;
    }

    public List<Hotel> readAllHotels() {

        List<Hotel> allHotels = new ArrayList<>();
        Hotel hotel = new Hotel();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_HOTEL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hotel.setId(resultSet.getInt("id"));
                hotel.setName(resultSet.getString("name"));
                hotel.setAddress(resultSet.getString("address"));
                hotel.setNumber(resultSet.getInt("number"));
                hotel.setAnimals(resultSet.getBoolean("animals"));
                hotel.setDescription(resultSet.getString("description"));
                hotel.setRooms(resultSet.getInt("rooms"));
                allHotels.add(hotel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allHotels;
    }

    public void update(Hotel hotel) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_HOTEL_QUERY);
            statement.setInt(7, hotel.getId());
            statement.setString(1, hotel.getName());
            statement.setString(2, hotel.getAddress());
            statement.setInt(3, hotel.getNumber());
            statement.setBoolean(4, hotel.getAnimals());
            statement.setString(5, hotel.getDescription());
            statement.setInt(6, hotel.getRooms());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_HOTEL_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
