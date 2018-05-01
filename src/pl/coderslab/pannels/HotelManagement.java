package pl.coderslab.pannels;

import pl.coderslab.dao.HotelDao;
import pl.coderslab.entity.Hotel;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.util.Scanner;

public class HotelManagement {

        public static void hotelManagement() {

            Scanner scan = new Scanner(System.in);

            String answer = "";
            boolean shouldContinue = true;
            System.out.println("HOTELS MANAGEMENT PANEL:");

                while (shouldContinue) {

                    System.out.println("What would you like to do? Choose:");
                    System.out.println("* view - type V");
                    System.out.println("* add - type A");
                    System.out.println("* edit - type E");
                    System.out.println("* delete - type D");
                    System.out.println("* quit - type Q");

                    answer = scan.nextLine();

                    switch (answer.toUpperCase()) {
                        case "V":
                            if(HotelDao.readAllHotels().size() == 0){
                                System.out.println("There are no Hotels to show");
                                break;
                            } else {
                                System.out.println("HOTELS:");
                                for (Hotel hotel : HotelDao.readAllHotels()) {
                                    System.out.println("ID: " + hotel.getId() + " Name: " + hotel.getName() + " Address: " + hotel.getAddress() + " Description" + hotel.getDescription() + " Contact Number: " + hotel.getNumber());
                                }
                            }
                            break;
                        case "A":
                            System.out.println("Type the hotel data as follows:");
                            System.out.println("Name: ");
                            String name = scan.nextLine();
                            System.out.println("Address: ");
                            String address = scan.nextLine();
                            System.out.println("Contact Number: ");
                            String number = scan.nextLine();
                            System.out.println("Animals accepted - 1 if Accepted or 0 if Not: ");
                            int animals = Integer.parseInt(scan.nextLine());
                            System.out.println("Description: ");
                            String description = scan.nextLine();
                            HotelDao.create(name, address, number, animals, description);
                            System.out.println("New Hotel was added to the database. What would you like to do next?");
                            answer = scan.nextLine();
                            break;
                        case "E":
                            System.out.println("Type ID of chosen Hotel");
                            int id = scan.nextInt();
                            Hotel toUpdate = HotelDao.read(id);
                            System.out.println("Type new Name");
                            toUpdate.setName(scan.nextLine());
                            System.out.println("Type new Address");
                            toUpdate.setAddress(scan.nextLine());
                            System.out.println("Type new Contact Number");
                            toUpdate.setNumber(scan.nextLine());
                            System.out.println("Type TRUE - FALSE for Accepted animals:");
                            toUpdate.setAnimals(Integer.parseInt(scan.nextLine()));
                            System.out.println("Type new Description");
                            toUpdate.setDescription(scan.nextLine());
                            HotelDao.update(toUpdate);
                            System.out.println("Chosen Hotel was edited What would you like to do next?");
                            answer = scan.nextLine();
                            break;
                        case "D":
                            System.out.println("Type ID of chosen Hotel");
                            HotelDao.delete(scan.nextInt());
                            System.out.println("Chosen Hotel was deleted. What would you like to do next?");
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
