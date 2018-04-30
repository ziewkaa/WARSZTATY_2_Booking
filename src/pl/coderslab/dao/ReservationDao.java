package pl.coderslab.dao;

public class ReservationDao {

    private static final String FIND_ALL_USER_RESERVATIONS = "SELECT * FROM Reservations JOIN Rooms ON Rooms.id = Reservations.room_id JOIN Users ON Users.id = Reservations.user_id WHERE user_id = ?";


}
