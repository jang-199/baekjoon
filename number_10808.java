
import java.util.Scanner;

public class number_10808 {
    public static void main(String[] args) {
        
        int arr[] = new int[26];
        Scanner sc = new Scanner(System.in); 
        String S_input = sc.nextLine();
        sc.close();
        for(int i=0;i<S_input.length();i++){
            int idx = (int)S_input.charAt(i)-97;
            arr[idx] = arr[idx]+1;
        }
        for(int k : arr){
            System.out.print(k + " ");
        }
        
        
    }
}
