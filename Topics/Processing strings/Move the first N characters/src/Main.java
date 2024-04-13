import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();

        if(n<s.length()){
            String firstPart = s.substring(0,n);
            String secondPart = s.substring(n);

            s = secondPart + firstPart;
        }

        System.out.println(s);

    }
}