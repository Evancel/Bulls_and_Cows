import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int greaterThan = sc.nextInt();

        for(int e:arr){
            if(e>greaterThan) {
                sum += e;
            }
        }
        System.out.println(sum);
        sc.close();
    }
}