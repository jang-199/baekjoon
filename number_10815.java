import java.util.Arrays;
import java.util.Scanner;

public class number_10815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int own = sc.nextInt();     //가지고 있는 카드 개수
        int own_arr[] = new int[own];   //가지고 있는 카드 구성 배열
        for(int i=0;i<own;i++){
            own_arr[i] = sc.nextInt();
        }
        Arrays.sort(own_arr);   //이분탐색을 위한 정렬

        int check = sc.nextInt();   //비교할 수 개수
        int check_arr[] = new int[check];   //비교할 수 구성
        for(int i=0;i<check;i++){
            check_arr[i] = sc.nextInt();
        }
        
        sc.close();

        for(int i=0;i<check;i++){
            System.out.print(binary_search(own_arr,check_arr,i)+" ");
        }


    }

    public static int binary_search(int own[],int check[],int check_idx){
      
        int start=0;
        int end=own.length-1;
        int mid=0;
        while(start<=end){
            mid = (start + end) / 2;

            if(own[mid]==check[check_idx]){
                return 1;
            }

            if(own[mid]<check[check_idx]){
                start = mid + 1;
            }
            else{
                end = mid-1;
            }
        }
        return 0;
    }
}
