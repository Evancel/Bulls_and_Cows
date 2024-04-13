import java.util.Scanner;

public class Main {
    /*
    public static void main(String[] args) {
        char a = 'a';
        int n = a;
        System.out.println(n);
    }
     */

    public static String transformString(String s) {
        // implement your string processing here
        char[] arr = new char[s.length()];
        /*
        for(int i = 0; i< arr.length; i++){
            arr[i] = s.charAt(i);
            int temp = arr[i];
            if(temp>=97 && temp<122){
                arr[i] = ++arr[i];
            }else if(temp>48 && temp<=57){
                arr[i] = --arr[i];
            }else if(temp==48){
                arr[i] = '9';
            }else if(temp==122){
                arr[i] = 'a';
            }
        }
         */

        for(int i = 0; i< arr.length; i++){
            arr[i] = s.charAt(i);
            if(arr[i]>='a' && arr[i]<'z'){
                arr[i] = ++arr[i];
            }else if(arr[i]>'0' && arr[i]<='9'){
                arr[i] = --arr[i];
            }else if(arr[i]=='0'){
                arr[i] = '9';
            }else if(arr[i]=='z'){
                arr[i] = 'a';
            }
        }

        s = String.valueOf(arr);
        return s;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(transformString(s));
    }
}