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

        performSearch(sc); // Directly start searching
    }

    private static void performSearch(Scanner sc) {
        System.out.print("Enter Book Name to Search: ");
        String name = sc.next();
        System.out.println();

        List<Books> matchedBooks = new ArrayList<>();
        for (Books e : BooksStorage.c) {
            if (e.getBookName().toLowerCase().contains(name.toLowerCase())) {
                matchedBooks.add(e);
            }
        }

        if (matchedBooks.isEmpty()) {
            System.out.println("Book Not Found");
            System.out.println();
            // Instead of going back to main, show search menu with empty matchedBooks
            searchMenu(sc, matchedBooks, name);
            return;
        }

        displayMatchedBooks(matchedBooks);
        searchMenu(sc, matchedBooks, name); // Pass search term also
    }

    private static void searchMenu(Scanner sc, List<Books> matchedBooks, String searchTerm) {
        while (true) {
            System.out.println("Search Menu:");
            System.out.println("1. Search again");
            System.out.println("2. Delete Books");
            System.out.println("3. Update Books");
            System.out.println("4. Return to Main Menu");
            System.out.println("Type the number of your option, 1-4");

            try {
                int option = sc.nextInt();
                System.out.println();

                switch (option) {
                    case 1:
                        performSearch(sc);
                        return;
                    case 2:
                        if (matchedBooks.isEmpty()) {
                            System.out.println("No matched books to delete.");
                            System.out.println();
                            continue; 
                        }
                        displayMatchedBooks(matchedBooks);
                        handleDelete(sc, matchedBooks, searchTerm);
                        return;
                    case 3:
                        if (matchedBooks.isEmpty()) {
                            System.out.println("No matched books to update.");
                            System.out.println();
                            continue; 
                        }
                        displayMatchedBooks(matchedBooks);
                        handleUpdate(sc, matchedBooks, searchTerm);
                        return;
                    case 4:
                        App2.main(null);
                        return;
                    default:
                        System.out.println("Invalid option. Try again.\n");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }

    private static void displayMatchedBooks(List<Books> matchedBooks) {
        if (matchedBooks.isEmpty()) {
            System.out.println("No matched books.");
            return;
        }

        System.out.println("Matched Book(s):");
        System.out.println("----------------------------------------------");

        for (Books b : matchedBooks) {
            System.out.println(b);
            System.out.println();
        }

        System.out.println("----------------------------------------------");
    }

    private static void handleDelete(Scanner sc, List<Books> matchedBooks, String searchTerm) {
        System.out.print("Enter Book number to delete: ");
        try {
            int id = sc.nextInt();
            System.out.println();

            Books target = null;
            for (Books b : matchedBooks) {
                if (b.getId() == id) {
                    target = b;
                    break;
                }
            }

            if (target == null) {
                System.out.println("Book not found in search results.");
                searchMenu(sc, matchedBooks, searchTerm);
                return;
            }

            System.out.println("----------------------------------------------");
            System.out.println(target);
            System.out.println("----------------------------------------------");
            System.out.println("Confirmation:");
            System.out.println("Type \"Y\" to delete, type anything else to cancel.");

            String confirm = sc.next();
            if (confirm.equalsIgnoreCase("Y")) {
                BooksStorage.c.remove(target);
                matchedBooks.remove(target); 
                System.out.println("The book has been deleted.");
            } else {
                System.out.println("Cancelled. Book was not deleted.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input.");
            sc.nextLine();
        }

        System.out.println();

        if (matchedBooks.isEmpty()) {
            System.out.println("No matched books remaining.");
            System.out.println();
            searchMenu(sc, matchedBooks, searchTerm);
        } else {
            searchMenu(sc, matchedBooks, searchTerm);
        }
    }

    private static void handleUpdate(Scanner sc, List<Books> matchedBooks, String searchTerm) {
        System.out.print("Enter Book number to update: ");
        try {
            int id = sc.nextInt();
            System.out.println();

            Books target = null;
            for (Books b : matchedBooks) {
                if (b.getId() == id) {
                    target = b;
                    break;
                }
            }

            if (target == null) {
                System.out.println("Book not found in search results.");
                searchMenu(sc, matchedBooks, searchTerm);
                return;
            }

            System.out.println("----------------------------------------------");
            System.out.println(target);
            System.out.println("----------------------------------------------");
            System.out.println("Confirmation:");
            System.out.println("Type \"Y\" to update, type anything else to cancel.");

            String confirm = sc.next();
            if (confirm.equalsIgnoreCase("Y")) {
                System.out.print("Enter new book name: ");
                sc.nextLine(); // clear buffer
                String newName = sc.nextLine();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();

                sc.nextLine(); // clear buffer
                System.out.print("Author name: ");
                String newAuthor = sc.nextLine();

                System.out.print("Publisher: ");
                String newPublisher = sc.nextLine();

                target.setBookName(newName);
                target.setQuantity(quantity);
                target.setAuthor(newAuthor);
                target.setPublisher(newPublisher);

                // Remove from matchedBooks if no longer matches search term
                if (!newName.toLowerCase().contains(searchTerm.toLowerCase())) {
                    matchedBooks.remove(target);
                }

                System.out.println();
                displayMatchedBooks(matchedBooks); 

                System.out.println("\nBook updated successfully!");
            } else {
                System.out.println("Cancelled. Book was not updated.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input.");
            sc.nextLine();
        }

        System.out.println();
        searchMenu(sc, matchedBooks, searchTerm);

    }
}
