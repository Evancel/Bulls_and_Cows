import java.util.Scanner;

public class Main {

    public static int getNumberOfMaxParam(int a, int b, int c) {
        // write a body here
        int max = a;
        int indexMax = 1;

        int[] arr = new int[]{a,b,c};
        for(int i = 0; i<arr.length; i++){
            if (max < arr[i]) {
                max = arr[i];
                indexMax=(i+1);
            }
        }
        return indexMax;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();

        System.out.println(getNumberOfMaxParam(a, b, c));
    }
}