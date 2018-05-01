package pl.coderslab.programs;

import pl.coderslab.entity.Reservation;
import pl.coderslab.pannels.HotelManagement;
import pl.coderslab.pannels.ReservationManagement;
import pl.coderslab.pannels.RoomManagement;
import pl.coderslab.pannels.UserManagement;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.util.Scanner;

public class AdminProgram {

    public static void main(String[] args) {


        try (Connection conn = DbUtil.getConnection()) {
            Scanner scan = new Scanner(System.in);

            String answer = "";
            boolean shouldContinue = true;

            while (shouldContinue) {

                System.out.println("ADMINISTRATOR PROGRAM:");
                System.out.println("Welcome! Choose what would you like to do");
                System.out.println("* Hotels Management - 1");
                System.out.println("* Rooms Management - 2");
                System.out.println("* Users Management - 3");
                System.out.println("* Reservations Management - 4");
                System.out.println("* End Program - Q");

                answer = scan.nextLine();

                switch (answer.toLowerCase()) {

                    case "1":
                        HotelManagement.hotelManagement();
                        break;
                    case "2":
                        RoomManagement.roomManagement();
                        break;
                    case "3":
                        UserManagement.userManagement();
                        break;
                    case "4":
                        ReservationManagement.reservationManagement();
                        break;
                    case "Q":
                        System.out.println("Bye!");
                        shouldContinue = false;
                        break;
                }

            }
        } catch (Exception e){
            e.getLocalizedMessage();
        }
    }
}
