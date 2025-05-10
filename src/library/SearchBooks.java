package library;
import java.util.*;

public class SearchBooks {
    public static void searchBooks(Scanner sc) {
        if (BooksStorage.c.isEmpty()) {
            System.out.println("There's no book(s) in the list!");
            System.out.println();
            App2.main(null);
            return;
        }

        boolean found = false;
        System.out.print("Enter Book Name to Search: ");
        String name = sc.next();
        System.out.println();

        System.out.println("----------------------------------------------");
        for (Books e : BooksStorage.c) {
            if (e.getBookName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(e);
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book Not Found");
        }

        System.out.println("----------------------------------------------");
        App2.main(null);
    }
}
