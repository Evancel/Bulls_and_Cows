import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        int n = 0;
        int sum = 0;
        do{
            n = scanner.nextInt();
            sum += n;
        } while(n!=0);

        System.out.println(sum);
    }
}