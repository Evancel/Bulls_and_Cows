import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int n = 0;
        int k = 0;
        do {
            n = scanner.nextInt();
        } while (n < 0 || n > 10000);

        do {
            k = scanner.nextInt();
        } while (k < 0 || k > 10000);

        System.out.println(k / n);

        scanner.close();
    }
}