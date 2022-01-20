import java.util.Scanner;

public class io_and_fundamental{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        String B = sc.next();
        sc.close();
        System.out.println(A * (Character.getNumericValue(B.charAt(2))));
		System.out.println(A * (Character.getNumericValue(B.charAt(1))));
		System.out.println(A * (Character.getNumericValue(B.charAt(0))));
		System.out.println(A * Integer.parseInt(B));
    }
}


