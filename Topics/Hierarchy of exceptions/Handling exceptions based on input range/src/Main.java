import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        try {
            if (input < 0) {
                throw new ArithmeticException();
            } else if (input >= 0 && input <= 100) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                System.out.println(input);
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getClass().getSimpleName());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }
}