import java.util.Arrays;
import java.util.Scanner;

public class number_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx[] = new int [26];
        Arrays.fill(idx,-1); //배열 -1로 초기화
        char s[] = sc.nextLine().toCharArray(); //char로 한 글자씩
        sc.close();
        
        for(int i=s.length-1;i>=0;i--){ //역순으로..
            idx[(int)s[i] - 'a'] = i; //역순으로 마지막 글자부터 
        }

        for(int k : idx){
            System.out.println(k);
        }
    }
}
