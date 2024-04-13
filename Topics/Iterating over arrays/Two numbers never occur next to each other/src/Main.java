import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];

        boolean isOccured = true;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                if (i == 0) {
                    if (arr[i+1] == m) {
                        isOccured = false;
                    }
                } else if (i == arr.length-1) {
                    if (arr[i-1] == m) {
                        isOccured = false;
                    }
                } else {
                    if (arr[i+1] == m || arr[i-1] == m) {
                        isOccured = false;
                    }
                }
            }
        }
        System.out.println(isOccured);

        sc.close();
    }
}
