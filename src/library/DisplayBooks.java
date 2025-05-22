package library;

import java.util.*;
import java.time.LocalDate;

public class DisplayBooks {
    public static void displayBooks() {
        if (BooksStorage.c.isEmpty()) {
            System.out.println("There's no book(s) in the list!");
            System.out.println();
            Main.main(null);
        }
        System.out.println("Here's the list of all the book(s) that you have added: ");
        System.out.println("----------------------------------------------");
        System.out.println();
        for (Books e : BooksStorage.c) {
            System.out.println(e);
            System.out.println();
        }
        System.out.println("----------------------------------------------");
        Main.main(null);
    }
}
