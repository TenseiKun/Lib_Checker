package library;

import java.time.LocalDate;

public class Books {
    private int id;
    private String bookName;
    private String author;
    private String publisher;
    private String dateA;
    private int quantity;

    Books(int id, String bookName, String author, String publisher, String dateA, int quantity) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.dateA = dateA;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDateA() {
        return dateA;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "Book No. " + id + ": " +
                "Book Name: " + capitalizeFirstLetter(bookName) + "\n" +
                "Author Name: " + capitalizeFirstLetter(author) + "\n" +
                "Quantity: " + quantity + "\n" +
                "Publisher: " + capitalizeFirstLetter(publisher) + "\n" +
                "Date Added: " + dateA;
    }

    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
