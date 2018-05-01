package pl.coderslab.pannels;

import pl.coderslab.dao.RoomDao;
import pl.coderslab.entity.Room;

import java.util.Scanner;

public class ReservationManagement {

    public static void reservationManagement() {

        Scanner scan = new Scanner(System.in);

        String answer = "";
        boolean shouldContinue = true;
        System.out.println("RESERVATIONS MANAGEMENT PANEL:");

        while (shouldContinue) {

            System.out.println("What would you like to do? Choose:");
            System.out.println("* view & change - type V");
            System.out.println("* quit - type Q");

            answer = scan.nextLine();

            switch (answer.toUpperCase()) {
                case "V":
                    break;
                case "Q":
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Incorrect input, please type again");
            }


        }
    }

}
