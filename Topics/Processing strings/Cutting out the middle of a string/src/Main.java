import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if(s.length()%2==1){
            int mid = s.length()/2;
            String firstPart = s.substring(0,mid);
            String secondPart = s.substring(mid+1);
            s = firstPart + secondPart;
        }else{
            int mid = s.length()/2-1;
            String firstPart = s.substring(0,mid);
            String secondPart = s.substring(mid+2);
            s = firstPart + secondPart;
        }

        System.out.println(s);
    }
}