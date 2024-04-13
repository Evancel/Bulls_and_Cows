import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int length = scanner.nextInt();
        int index = 0;
        int[] arr = new int[length];
        int max = 0;
        while(index<length){
            arr[index] = scanner.nextInt();
            index++;
        }

        for(int i = 0; i<arr.length; i++){
            if(arr[i]%4==0 && max< arr[i]){
                max = arr[i];
            }
        }
        System.out.println(max);
        scanner.close();
    }
}