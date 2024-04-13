import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int fhours = scanner.nextInt() * 60*60;
        int fminutes = scanner.nextInt() * 60;
        int fseconds = scanner.nextInt();

        int lhours = scanner.nextInt() * 60*60;
        int lminutes = scanner.nextInt() * 60;
        int lseconds = scanner.nextInt();

        System.out.println((lhours + lminutes + lseconds) - (fhours + fminutes + fseconds));
    }
}