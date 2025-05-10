package library;
import java.util.*;
import java.time.LocalDate;

import java.util.*;

public class UpdateBooks {
    public static void updateBooks(Scanner sc1, Scanner sc) {
        if (BooksStorage.c.isEmpty()) {
            System.out.println("There's no book(s) in the list!");
            System.out.println();
            App2.main(null);
            return;
        }

        boolean found = false;
        System.out.println("Here's the list of all the book(s): ");
        System.out.println("----------------------------------------------");
        for (Books e : BooksStorage.c) {
            System.out.println(e);
            System.out.println();
        }
        System.out.println("----------------------------------------------");

        System.out.print("Enter Book ID to update: ");
        int id = sc1.nextInt();
        System.out.println();

        Books bookToUpdate = null;
        for (Books e : BooksStorage.c) {
            if (e.getId() == id) {
                bookToUpdate = e;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found :<");
            System.out.println();
            updateBooks(sc1, sc);
            return;
        }

        System.out.println("Are you sure you want to update this book? Y/N");
        System.out.println("----------------------------------------------");
        System.out.println(bookToUpdate);
        System.out.println("----------------------------------------------");
        String confirmation = sc1.next();
        System.out.println();

        if (confirmation.equalsIgnoreCase("Y")) {
            System.out.println();
            try {
                System.out.print("Enter your book name: ");
                
                String newBookName = sc.nextLine();
                System.out.print("Quantity: ");
                int newQuantity = sc.nextInt();
                sc.nextLine(); // clear buffer
                System.out.print("Author name: ");
                String newAuthor = sc.nextLine();
                System.out.print("Publisher: ");
                String newPublisher = sc.nextLine();

                bookToUpdate.setBookName(newBookName);
                bookToUpdate.setAuthor(newAuthor);
                bookToUpdate.setPublisher(newPublisher);
                bookToUpdate.setQuantity(newQuantity);

                System.out.println("\nBook updated successfully!");
            } catch (Exception e) {
                System.out.println("Invalid input, Retry again");
                updateBooks(sc1, sc);
            }
        } else {
            System.out.println("Update cancelled.");
        }

        System.out.println();
        App2.main(null);
    }
}
