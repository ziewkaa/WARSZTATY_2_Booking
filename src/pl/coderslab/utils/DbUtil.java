package pl.coderslab.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static String DB_URL = "jdbc:mysql://localhost:3306/Booking?useSSL=false";
    private static String DB_USER = "root";
    private static String DB_PASS = "coderslab";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}