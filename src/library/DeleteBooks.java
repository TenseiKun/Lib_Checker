package library;

import java.util.*;

public class DeleteBooks {
    public static void deleteBooks(Scanner sc1, Scanner sc) {
        System.out.println("Delete Book Menu:");

        System.out.println("1. Delete a book");
        System.out.println("2. Return to Main Menu");
        System.out.println("Type the number of your option, 1-2");

        try {
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
                    System.out.println();
                    for (Books e : BooksStorage.c) {
                        System.out.println(e);
                        System.out.println();
                    }
                    System.out.println("----------------------------------------------");

                    System.out.print("Enter book number to delete: ");
                    try {
                        int id = sc1.nextInt();
                        System.out.println();

                        boolean found = false;
                        for (Books e : BooksStorage.c) {
                            if (e.getId() == id) {
                                System.out.println("----------------------------------------------");
                                System.out.println(e);
                                System.out.println("----------------------------------------------");
                                System.out.println("Confirmation: ");
                                System.out.println("Type \"Y\" to delete, type anything to cancel.");
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

                    } catch (Exception e) {
                        System.out.println("Invalid book ID. Please enter a valid number.");
                        sc1.nextLine();
                        deleteBooks(sc1, sc);
                        return;
                    }

                case 2:
                    App2.main(null);
                    break;

                default:
                    System.out.println("Invalid option. Retry again.");
                    deleteBooks(sc1, sc);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            sc1.nextLine(); 
            deleteBooks(sc1, sc);
        }
    }
}
