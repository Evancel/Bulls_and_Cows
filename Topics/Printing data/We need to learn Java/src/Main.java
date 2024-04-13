class Main {
    public static void main(String[] args) {
        // put your code here
        String s = "I love JAVA very much forever!";
        String[] arr = s.split(" ");
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}