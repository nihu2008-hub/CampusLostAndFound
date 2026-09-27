import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LostFoundSystem system = new LostFoundSystem();

        while (true) {

            System.out.println("\n================================");
            System.out.println("     CAMPUS LOST & FOUND");
            System.out.println("================================");

            System.out.println("1. Report Lost Item");
            System.out.println("2. Report Found Item");
            System.out.println("3. View All Items");
            System.out.println("4. Search Item");
            System.out.println("5. Mark Item as Claimed");
            System.out.println("6. Remove Item");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addItem(sc, system, "LOST");
                    break;

                case 2:
                    addItem(sc, system, "FOUND");
                    break;

                case 3:
                    system.displayItems();
                    break;

                case 4:

                    System.out.print("\nEnter keyword: ");
                    String keyword = sc.nextLine();

                    system.searchItem(keyword);
                    break;

                case 5:

                    System.out.print("\nEnter Item ID: ");
                    int claimId = sc.nextInt();

                    system.claimItem(claimId);
                    break;

                case 6:

                    System.out.print("\nEnter Item ID: ");
                    int removeId = sc.nextInt();

                    system.removeItem(removeId);
                    break;

                case 7:

                    System.out.println("\nThank you for using Campus Lost & Found!");
                    sc.close();
                    return;

                default:
                    System.out.println("\nInvalid choice.");
            }
        }
    }

    private static void addItem(Scanner sc,
                                LostFoundSystem system,
                                String type) {

        System.out.print("\nEnter item name: ");
        String name = sc.nextLine();

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        System.out.print("Enter location: ");
        String location = sc.nextLine();

        System.out.print("Enter date: ");
        String date = sc.nextLine();

        system.addItem(
                type,
                name,
                description,
                location,
                date
        );
    }
}