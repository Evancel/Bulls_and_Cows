import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int choice = scanner.nextInt();
        String s = "";
        switch(choice){
            case 1:
                s = "You have chosen a square";
                break;
            case 2:
                s = "You have chosen a circle";
                break;
            case 3:
                s = "You have chosen a triangle";
                break;
            case 4:
                s = "You have chosen a rhombus";
                break;
            default:
                s = "There is no such shape!";
                break;
        }

        System.out.println(s);
        scanner.close();
    }
}