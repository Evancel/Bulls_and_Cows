import java.util.Scanner;

class MultipleFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        System.out.println(f(x));
        scanner.close();
    }

    public static double f(double x) {
        //call your implemented methods here.

        double res = 0.0;
        if(x<=0){
            res = f1(x);
        } else if(x>0 && x<1){
            res = f2(x);
        }else{
            res = f3(x);
        }
        return res;
    }

    //implement your methods here
    public static double f1 (double x){
        return Math.pow(x,2) + 1;
    }

    public static double f2 (double x){
        return 1/Math.pow(x,2);
    }

    public static double f3 (double x){
        return Math.pow(x,2)-1;
    }
}