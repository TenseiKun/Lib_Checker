package library;

import java.util.*;
import java.time.LocalDate;

public class App2 {
    public static void main(String[] args) {
        System.out.println("Welcome to Library Checker!");
        System.out.println("Use this system to keep track of all books");
        System.out.println();

        int i = 0;

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        try {

            System.out.println("1. Add a book");
            System.out.println("2. Display all books");
            System.out.println("3. Update books");
            System.out.println("4. Search books");
            System.out.println("5. Delete books");
            System.out.println("6. End Program");
            System.out.println("Type the number of your option, 1-6");
            int option = sc.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    AddBooks.addBooks(sc, sc1, i);
                    break;
                case 2:
                    DisplayBooks.displayBooks();
                    break;
                case 3:
                    UpdateBooks.updateBooks(sc, sc1);
                    break;
                case 4:
                    SearchBooks.searchBooks(sc);
                    break;
                case 5:
                    DeleteBooks.deleteBooks(sc, sc1);
                    break;
                case 6:
                    System.out.println("Confirmation: ");
                    System.out.println("Type \"Y\" to exit program, type anything to cancel.");
                    String confirmation = sc1.next();
                    System.out.println();
                    if (confirmation.equalsIgnoreCase("Y")) {
                        System.out.println("Ending Program!");
                        System.exit(0);
                    } else {
                        main(args);
                    }

                default:
                    System.out.println("Invalid option, retrying again");
                    System.out.println();
                    main(args);
                    return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number from the menu.");
            System.out.println();
            main(args);
        }
    }
}
