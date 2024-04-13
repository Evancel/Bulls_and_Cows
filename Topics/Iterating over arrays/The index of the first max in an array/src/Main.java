import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
            if(max<arr[i]){
                max = arr[i];
                max_index=i;
            }
        }
        System.out.println(max_index);

        sc.close();
    }
}