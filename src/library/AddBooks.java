package library;
import java.util.*;
import java.time.LocalDate;

public class AddBooks {

    public static void addBooks(Scanner sc, Scanner sc1, int i) {
        sc.nextLine();
        try {
            System.out.print("Enter your book name: ");
            String bookName = sc.nextLine();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            System.out.print("Author name: ");
            String author = sc1.nextLine();
            System.out.print("Publisher: ");
            String publisher = sc1.nextLine();
            int maxId = 0;
            for (Books b : BooksStorage.c) {
                if (b.getId() > maxId) {
                    maxId = b.getId();
                }
            }
            int id = maxId + 1;
            String dateA = LocalDate.now().toString();
            BooksStorage.c.add(new Books(id, bookName, author, publisher, dateA, quantity));
            System.out.println("\nSuccessfully added!");
        } catch (Exception e) {
            System.out.println("Invalid response for the question, repeat your entry:");
            System.out.println();
            addBooks(sc, sc1, i);
        }
        App2.main(null);
    }

}