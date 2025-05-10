package library;
import java.util.*;

public class DeleteBooks {
    public static void deleteBooks(Scanner sc1, Scanner sc) {
        System.out.println("Delete Book Menu:");
        System.out.println("1. Delete a book");
        System.out.println("2. Return to Main Menu");
        int option = sc1.nextInt();
        System.out.println();

        switch (option) {
            case 1:
                if (BooksStorage.c.isEmpty()) {
                    System.out.println("There's no book(s) in the list!");
                    System.out.println();
                    deleteBooks(sc1, sc);
                    return;
                }

                System.out.println("Here's the list of all the book(s):");
                System.out.println("----------------------------------------------");
                for (Books e : BooksStorage.c) {
                    System.out.println(e);
                    System.out.println();
                }
                System.out.println("----------------------------------------------");

                System.out.print("Enter book ID to delete: ");
                int id = sc1.nextInt();
                System.out.println();

                boolean found = false;
                for (Books e : BooksStorage.c) {
                    if (e.getId() == id) {
                        System.out.println("Are you sure you want to delete this book? Y/N");
                        System.out.println(e);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Book not found :<");
                    System.out.println();
                    deleteBooks(sc1, sc);
                    return;
                }

                String confirmation = sc1.next();
                System.out.println();

                if (confirmation.equalsIgnoreCase("Y")) {
                    Iterator<Books> iter = BooksStorage.c.iterator();
                    while (iter.hasNext()) {
                        if (iter.next().getId() == id) {
                            iter.remove();
                            System.out.println("The book has been deleted from the list.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Cancelled. Book was not deleted.");
                }

                System.out.println();
                deleteBooks(sc1, sc);
                break;

            case 2:
                App2.main(null);
                break;

            default:
                System.out.println("Invalid option. Returning to Main Menu.");
                deleteBooks(sc1, sc);
                break;
        }
    }
}
