import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int n = scanner.nextInt();

        scanner.close();

        int result;
        while (n % 100 > 99){
            n = n / 10;
        }
        n = n / 10;
        result = n % 10;
        System.out.println(result);
    }
}