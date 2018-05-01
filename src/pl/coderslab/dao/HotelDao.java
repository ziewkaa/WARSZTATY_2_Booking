package pl.coderslab.dao;

import pl.coderslab.entity.Hotel;
import pl.coderslab.entity.Room;
import pl.coderslab.entity.User;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {

    private static final String CREATE_HOTEL_QUERY = "INSERT INTO Hotels( name,  address, number, animals, description) VALUES (?,?,?,?,?)";
    private static final String READ_HOTEL_QUERY = "SELECT * FROM Hotels where id = ?";
    private static final String READ_ALL_ROOMS_IN_HOTEL_QUERY = "SELECT * FROM Rooms WHERE hotel_id = ?";
    private static final String UPDATE_HOTEL_QUERY = "UPDATE Hotels SET name = ? , address = ?, number = ?, animals =?, description =?, rooms =? WHERE id = ?";
    private static final String DELETE_HOTEL_QUERY = "DELETE FROM Hotels WHERE id = ?";
    private static final String FIND_ALL_HOTELS_QUERY = "SELECT * FROM Hotels";


    static public void create(String name, String address, String number, int animals, String description) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CREATE_HOTEL_QUERY);
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, number);
            statement.setInt(4, animals);
            statement.setString(5, description);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public Hotel read(int id) {

        Hotel hotel = new Hotel();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_HOTEL_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hotel.setId(resultSet.getInt("id"));
                hotel.setName(resultSet.getString("name"));
                hotel.setAddress(resultSet.getString("address"));
                hotel.setNumber(resultSet.getString("number"));
                hotel.setAnimals(resultSet.getInt("animals"));
                hotel.setDescription(resultSet.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel;
    }

    static public Room[] readAllRoomsInHotel(int id) {

        List<Room> hotelRooms = new ArrayList<>();
        Room room = new Room();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_ALL_ROOMS_IN_HOTEL_QUERY);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                room.setId(resultSet.getInt("id"));
                room.setSpace(resultSet.getInt("space"));
                room.setDescription(resultSet.getString("description"));
                room.setPrice(resultSet.getDouble("price"));
                hotelRooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Room[] rArray = new Room[hotelRooms.size()];
        rArray = hotelRooms.toArray(rArray);
        return rArray;
    }

    static public List<Hotel> readAllHotels() {

        List<Hotel> allHotels = new ArrayList<>();
        Hotel hotel = new Hotel();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_HOTELS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                hotel.setId(resultSet.getInt("id"));
                hotel.setName(resultSet.getString("name"));
                hotel.setAddress(resultSet.getString("address"));
                hotel.setNumber(resultSet.getString("number"));
                hotel.setAnimals(resultSet.getInt("animals"));
                hotel.setDescription(resultSet.getString("description"));
                allHotels.add(hotel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allHotels;
    }

    static public void update(Hotel hotel) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_HOTEL_QUERY);
            statement.setInt(6, hotel.getId());
            statement.setString(1, hotel.getName());
            statement.setString(2, hotel.getAddress());
            statement.setString(3, hotel.getNumber());
            statement.setInt(4, hotel.getAnimals());
            statement.setString(5, hotel.getDescription());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public void delete(int id) {

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_HOTEL_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
