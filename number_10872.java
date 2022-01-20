import java.util.Scanner;

public class number_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextInt()));
        sc.close();
    }
    static int factorial(int param){
        if(param==0) return 1;
        return param*factorial(param-1);
    }
}
