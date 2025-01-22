import api.AdminResource;
import model.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class AdminMenu {
    private static final AdminResource adminResource = AdminResource.getSingleton();
    public static void adminMenu() {
        Scanner sc= new Scanner(System.in);
        String adminChoice="";

        printMenu();
        try {
            do {
                adminChoice = sc.nextLine();

                if (adminChoice.length() == 1) {
                    switch (adminChoice.charAt(0)) {
                        case '1':
                            displayAllCustomers();
                            break;
                        case '2':
                            displayAllRooms();
                            break;
                        case '3':
                            displayAllReservations();
                            break;
                        case '4':
                            addRoom();
                            break;
                        case '5':
                            MainMenu.printMainMenu();
                            break;
                        default:
                            System.out.println("Unknown action\n");
                            break;
                    }
                } else {
                    System.out.println("Error: Invalid action\n");
                }
            } while (adminChoice.charAt(0) != '5' || adminChoice.length() != 1);
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Enter Something from menu");
        }
    }


    public static void printMenu(){
        System.out.print("\nAdmin Menu\n" +
                "-------------------------------------------------------------------\n" +
                "1. See all Customers\n" +
                "2. See all Rooms\n" +
                "3. See all Reservations\n" +
                "4. Add a Room\n" +
                "5. Back to Main Menu\n" +
                "Please select a number from a menu option:\n");
    }

    private static void displayAllCustomers(){
        Collection<Customer> customers = adminResource.getAllCustomers();

        if(customers.isEmpty()){
            System.out.println("no customer found");
        }else{
            adminResource.getAllCustomers().forEach(System.out::println);
        }
    }

    private static void displayAllRooms(){
        Collection<IRoom> rooms = adminResource.getAllRooms();

        if(rooms.isEmpty()){
            System.out.println("no room found");
        }else{
            adminResource.getAllRooms().forEach(System.out::println);
        }
    }

    private static void displayAllReservations(){
        adminResource.displayAllReservations();
    }

    private static void addRoom() {
        final Scanner sc = new Scanner(System.in);

        System.out.println("Enter room number:");
        final String roomNumber = sc.nextLine();

        System.out.println("Enter price per night:");
        final double roomPrice = enterRoomPrice(sc);

        System.out.println("Enter room type: 1 for single bed, 2 for double bed:");
        final RoomType roomType = enterRoomType(sc);

        final Room room = new Room(roomNumber, roomPrice, roomType);

        adminResource.addRoom(Collections.singletonList(room));
        System.out.println("Room added successfully!");

        System.out.println("Would like to add another room? Y/N");
        addAnotherRoom();
    }

    private static double enterRoomPrice(final Scanner sc) {
        try {
            return Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException exp) {
            System.out.println("Invalid room price! Please, enter a valid double number. " +
                    "Decimals should be separated by point (.)");
            return enterRoomPrice(sc);
        }
    }

    private static RoomType enterRoomType(final Scanner sc) {
        try {
            int roomTypeChoice = Integer.parseInt(sc.nextLine());
            return switch (roomTypeChoice) {
                case 1 -> RoomType.SINGLE;
                case 2 -> RoomType.DOUBLE;
                default -> {
                    System.out.println("Invalid choice! Please select 1 for SINGLE or 2 for DOUBLE.");
                    yield enterRoomType(sc);
                }
            };
        } catch (IllegalArgumentException exp) {
            System.out.println("Invalid room type! Please, choose 1 for single bed or 2 for double bed:");
            return enterRoomType(sc);
        }
    }

    private static void addAnotherRoom() {
        final Scanner sc = new Scanner(System.in);

        try {
            String anotherRoom;

            anotherRoom = sc.nextLine();

            while ((anotherRoom.charAt(0) != 'Y' && anotherRoom.charAt(0) != 'N')
                    || anotherRoom.length() != 1) {
                System.out.println("Please enter Y (Yes) or N (No)");
                anotherRoom = sc.nextLine();
            }

            if (anotherRoom.charAt(0) == 'Y') {
                addRoom();
            } else if (anotherRoom.charAt(0) == 'N') {
                printMenu();
            } else {
                addAnotherRoom();
            }
        } catch (StringIndexOutOfBoundsException ex) {
            addAnotherRoom();
        }
    }

}
