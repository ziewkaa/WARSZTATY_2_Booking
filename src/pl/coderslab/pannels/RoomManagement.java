package pl.coderslab.pannels;

import pl.coderslab.dao.HotelDao;
import pl.coderslab.dao.RoomDao;
import pl.coderslab.entity.Hotel;
import pl.coderslab.entity.Room;

import java.util.Scanner;

public class RoomManagement {

    public static void roomManagement() {

        Scanner scan = new Scanner(System.in);

        String answer = "";
        boolean shouldContinue = true;
        System.out.println("ROOMS MANAGEMENT PANEL:");

        while (shouldContinue) {

            System.out.println("What would you like to do? Choose:");
            System.out.println("* view - type V");
            System.out.println("* add - type A");
            System.out.println("* add Room to Hotel - type AH");
            System.out.println("* edit - type E");
            System.out.println("* delete - type D");
            System.out.println("* quit - type Q");

            answer = scan.nextLine();

            switch (answer.toUpperCase()) {
                case "V":
                    if(RoomDao.readAllRooms().size() == 0){
                        System.out.println("There are no Rooms to show");
                        break;
                    } else {
                        System.out.println("ROOMS:");
                        for (Room room : RoomDao.readAllRooms()) {
                            System.out.println("ID: " + room.getId() + " Capacity: " + room.getSpace() + " Price: " + room.getPrice() + " Description" + room.getDescription());
                        }
                    }
                    break;
                case "A":
                    System.out.println("Type the Room data as follows:");
                    System.out.println("Capacity: ");
                    int capacity = Integer.parseInt(scan.nextLine());
                    System.out.println("Description: ");
                    String description = scan.nextLine();
                    System.out.println("Price: ");
                    double price = Double.parseDouble(scan.nextLine());
                    RoomDao.create(capacity, description, price);
                    System.out.println("New Room was added to the database. What would you like to do next?");
                    answer = scan.nextLine();
                    break;
                case "AH":
                    System.out.println("Type chosen Hotel ID:");
                    int hotel_id = Integer.parseInt(scan.nextLine());
                    System.out.println("Type chosen Room ID: ");
                    int room_id = Integer.parseInt(scan.nextLine());
                    RoomDao.addToHotel( hotel_id, room_id);
                    System.out.println("The Room was added to the Hotel. What would you like to do next?");
                    answer = scan.nextLine();
                    break;
                case "E":
                    System.out.println("Type ID of chosen Room");
                    int id = scan.nextInt();
                    Room toUpdate = RoomDao.read(id);
                    System.out.println("Type new Capacity");
                    toUpdate.setSpace(Integer.parseInt(scan.nextLine()));
                    System.out.println("Type new Price");
                    toUpdate.setPrice(Double.parseDouble(scan.nextLine()));
                    System.out.println("Type new Description");
                    toUpdate.setDescription(scan.nextLine());
                    RoomDao.update(toUpdate);
                    System.out.println("Chosen Room was edited. What would you like to do next?");
                    answer = scan.nextLine();
                    break;
                case "D":
                    System.out.println("Type ID of chosen Room");
                    RoomDao.delete(scan.nextInt());
                    System.out.println("Chosen Room was deleted. What would you like to do next?");
                    answer = scan.nextLine();
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
