package pl.coderslab.pannels;

import pl.coderslab.dao.ReservationDao;
import pl.coderslab.dao.RoomDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Reservation;
import pl.coderslab.entity.Room;
import pl.coderslab.entity.User;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {

    public static void userManagement() throws Exception {

        Scanner scan = new Scanner(System.in);

        String answer = "";
        boolean shouldContinue = true;
        System.out.println("USERS MANAGEMENT PANEL:");

        while (shouldContinue) {

            System.out.println("What would you like to do? Choose:");
            System.out.println("* view Users and Reservations - type V");
            System.out.println("* quit - type Q");

            answer = scan.nextLine();

            switch (answer.toUpperCase()) {
                case "V":
                    System.out.println("Type name of searched User");
                    answer = scan.nextLine();
                    while(UserDao.readByName(answer) == null){
                        System.out.println("Incorrect Username, type again");
                        answer = scan.nextLine();
                    }
                    int searched = UserDao.readByName(answer).getId();
                    List<Reservation> searchedReservations = new ArrayList<>();
                    for (Reservation reservation : ReservationDao.readAllReservations()){
                        if(reservation.getUserId() == searched){
                            searchedReservations.add(reservation);
                        }
                    }
                    for (Reservation reservation : searchedReservations){
                        System.out.println("ID: " + reservation.getId() + " Status:" + reservation.getStatus() + " Reserved on: " + reservation.getReserved());
                    }
                    System.out.println("Type ID of chosen Reservation:");
                    int reservationId = Integer.parseInt(scan.nextLine());

                    for (Reservation r : searchedReservations){
                        if(r.getId() == reservationId){
                            System.out.println("Description: " + r.getDescription() + " Reserved from: " + r.getFrom()+ " Reserved to: " + r.getTo());
                        }
                    }
                    break;
                case "Q":
                    System.out.println("Bye!");
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Incorrect input, please type again");
            }


        }


    }
}
