import java.util.Scanner;

public class jnumber_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.close();
        System.out.println(fibo(input));   
    }
    static int fibo(int n){
        if(n==1) return 1;
        if(n==0) return 0;
        return fibo(n-1)+fibo(n-2);
    }
    
}
