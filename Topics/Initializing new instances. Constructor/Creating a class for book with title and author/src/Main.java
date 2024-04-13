// Import required library
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String [] arg) {
        // Your code here!
        Scanner sc = new Scanner(System.in);
        String[] inputBookInfo = sc.nextLine().split(",");
        String title = inputBookInfo[0].trim();
        String author = inputBookInfo[1].trim();

        Book book = new Book(title,author);
        System.out.println(book.getBookInfo());
        sc.close();
    }
}

// Define Book Class
class Book {
    // Class variables for title and author
    private String title;
    private String author;

    // Constructor goes here
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    // Return book information method
    public String getBookInfo() {
        return String.format("%s by %s\n",title,author);
    }
}