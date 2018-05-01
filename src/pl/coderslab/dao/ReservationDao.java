package pl.coderslab.dao;

import pl.coderslab.entity.Reservation;
import pl.coderslab.entity.Status;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReservationDao {

    private static final String CREATE_RESERVATION_QUERY = "INSERT INTO Reservations(reserved, from, to, description, user_id, room_id, status) VALUES (?,?,?,?,?,?,?)";
    private static final String READ_RESERVATION_QUERY = "SELECT * FROM Reservations where id = ?";
    private static final String READ_ALL_RESERVATIONS_QUERY = "SELECT * FROM Reservations where id = ?";
    private static final String UPDATE_RESERVATION_QUERY = "UPDATE Reservations SET reserved=?, from=?, to=?, description=?, user_id=?, room_id=?, status=? WHERE id = ?";
    private static final String DELETE_RESERVATION_QUERY = "DELETE FROM Reservations WHERE id = ?";
    private static final String UPDATE_RESERVATION_STATUS_QUERY= "UPDATE Reservations SET status=? WHERE id = ?";


    public static Reservation create(Reservation reservation) {
        reservation = new Reservation();
        try (Connection connection = DbUtil.getConnection()) {
             PreparedStatement statement = connection.prepareStatement(CREATE_RESERVATION_QUERY);
             statement.setString(1, reservation.getReserved().toString());
             statement.setString(2, reservation.getFrom().toString());
             statement.setString(3, reservation.getTo().toString());
             statement.setString(4, reservation.getDescription());
             statement.setInt(5, reservation.getUserId());
             statement.setInt(6, reservation.getRoomId());
             statement.setString(7, reservation.getStatus().toString());
             statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservation;
    }

    public static Reservation read(int id) throws Exception {
        Reservation reservation = new Reservation();
        try (Connection connection = DbUtil.getConnection()) {
             PreparedStatement statement = connection.prepareStatement(READ_RESERVATION_QUERY);
             statement.setInt(1, id);
             ResultSet resultSet = statement.executeQuery() ;
             while (resultSet.next()) {
                 reservation.setId(resultSet.getInt("id"));
                 reservation.setReserved(LocalDateTime.parse(resultSet.getString("reserved")));
                 reservation.setFrom(LocalDateTime.parse(resultSet.getString("from")));
                 reservation.setTo(LocalDateTime.parse(resultSet.getString("to")));
                 reservation.setDescription(resultSet.getString("description"));
                 reservation.setUserId(resultSet.getInt("user_id"));
                 reservation.setRoomId(resultSet.getInt("room_id"));
                 reservation.setStatus((Status) resultSet.getObject("status"));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservation;
    }


    public static Reservation[] readAllReservations() throws Exception {

        ArrayList<Reservation> reservations = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(READ_ALL_RESERVATIONS_QUERY);
            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setId(resultSet.getInt("id"));
                    reservation.setReserved(LocalDateTime.parse(resultSet.getString("reserved")));
                    reservation.setFrom(LocalDateTime.parse(resultSet.getString("from")));
                    reservation.setTo(LocalDateTime.parse(resultSet.getString("to")));
                    reservation.setDescription(resultSet.getString("description"));
                    reservation.setUserId(resultSet.getInt("user_id"));
                    reservation.setRoomId(resultSet.getInt("room_id"));
                    reservation.setStatus((Status) resultSet.getObject("status"));
                    reservations.add(reservation);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Reservation[] rArray = new Reservation[reservations.size()];
            rArray = reservations.toArray(rArray);
            return rArray;

        }

        public static void update (Reservation reservation){
            try (Connection connection = DbUtil.getConnection()) {
                PreparedStatement statement = connection.prepareStatement(UPDATE_RESERVATION_QUERY);
                statement.setInt(7, reservation.getId());
                statement.setString(1, reservation.getReserved().toString());
                statement.setString(2, reservation.getFrom().toString());
                statement.setString(3, reservation.getTo().toString());
                statement.setString(4, reservation.getDescription());
                statement.setInt(5, reservation.getUserId());
                statement.setInt(6, reservation.getRoomId());
                statement.setString(7, reservation.getStatus().toString());
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void updateStatus (Reservation reservation){

            try (Connection connection = DbUtil.getConnection()) {
                 PreparedStatement statement = connection.prepareStatement(UPDATE_RESERVATION_STATUS_QUERY);
                statement.setInt(2, reservation.getId());
                statement.setString(1, reservation.getStatus().toString());
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void delete ( int reservationId){
            try (Connection connection = DbUtil.getConnection()) {
                PreparedStatement statement = connection.prepareStatement(DELETE_RESERVATION_QUERY);
                statement.setInt(1, reservationId);
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
