class InputReader {
    public static String getString() {
        // write your code here
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        return s;
    }
}