import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a new Scanner to get user input
        Scanner sc = new Scanner(System.in);

        // Read the integer from the user
        int input = sc.nextInt();

        // TODO: Write your code here to check and print whether the input is positive, negative, or zero.
        // Remember the requirements of the problem statement, and make sure to adhere to Java coding style conventions.
        if (input == 0) {
            System.out.println("Zero");
        } else if (input > 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }

        // Do not forget to close the Scanner once you are done with it
        sc.close();
    }
}