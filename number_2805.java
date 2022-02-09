import java.util.Arrays;
import java.util.Scanner;

public class number_2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int length = sc.nextInt();
        int tree_arr[] = new int[n];

        for(int i=0;i<n;i++){
            tree_arr[i] = sc.nextInt();
        }sc.close();

        int min=0;
        int max=Arrays.stream(tree_arr).max().getAsInt() - 1;
        int mid=0;
        int result=0;

        while(min<=max){
            long sum=0;
            mid = (min+max)/2;  //최소길이와 최대길이의 평균

            for(int i=0;i<tree_arr.length;i++){
                if(tree_arr[i]>=mid){
                    sum+=tree_arr[i]-mid;
                }
                
            }
            if(sum<length){
                max=mid-1;
            }
            else{
                min=mid+1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
