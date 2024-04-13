import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        // Your code here
        String[] arr = sentence.split(" ");
        int max = 0;
        String res = "";

        for(int i = 0; i<arr.length; i++){
            if(max<arr[i].length()){
                max = arr[i].length();
                res = arr[i];
            }
        }
        System.out.println(res);
    }
}