import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int choice;
        
            System.out.println("1. Find and reserve a room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");

            System.out.println("Please select a number from a menu option");
            choice=sc.nextInt();

            switch (choice){
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
