import java.util.Scanner;

public class AdminMenu {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int adminChoice;

            System.out.println("1. See all Customers");
            System.out.println("2. See all Rooms");
            System.out.println("3. See all Reservations");
            System.out.println("4. Add a Room");
            System.out.println("5. Back to Main Menu");

            System.out.println("Please select a number from a menu option");
            adminChoice=sc.nextInt();

            switch (adminChoice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
            }
    }
}
