import java.util.Scanner;

class EvenUpperCase {

    public static String upperEvenLetters(String message) {
        // write your code here
        StringBuilder sb = new StringBuilder(message);
        for(int i = 0; i<sb.length(); i+=2){
            sb.setCharAt(i,Character.toUpperCase(sb.charAt(i)));
        }
        message = sb.toString();
        return message;
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        System.out.println(upperEvenLetters(message));
    }
}