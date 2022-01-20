import java.util.Scanner;

public class number_2609 {
    public static void main(String[] args) {
    /*최소공배수 = 두 수의 곱 / 최대공약수
      최대공약수 = GCD(A,B) => GCD(B,A%B)  if (A%B == 0) GCB == B  cf.유클리드 호제법 O(logn)*/ 
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.close();
        int G_result = GCD(A,B);
        int L_result = A*B/G_result;
        System.out.println(G_result);
        System.out.println(L_result);
    } 

    static int GCD(int A, int B){
        if(A%B==0){
            return B;
        }
        else{
            return GCD(B,A%B);
        }
    }
    
}
