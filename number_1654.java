import java.util.Arrays;
import java.util.Scanner;

public class number_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //가지고 있는 랜선 개수
        int need_n = sc.nextInt();  //필요한 랜선 개수
        int lancable_arr[] = new int[n];

        for(int i=0;i<n;i++){
            lancable_arr[i] = sc.nextInt();
        }sc.close();

        long start=1;
        long end=Arrays.stream(lancable_arr).max().getAsInt();

        while(start<=end){
            long mid = (start + end)/2;
            long possible = 0;

            for(int i=0;i<lancable_arr.length;i++){
                possible += lancable_arr[i]/mid;
            }
            
            if(possible >= need_n){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        
        System.out.println(end);
    }
}
