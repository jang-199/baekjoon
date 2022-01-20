/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*******************************************************************************************************************************************************************************

메모리:22332KB
시간:344ms
*/
import java.util.Scanner;

public class bubble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int [sc.nextInt()];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }sc.close();
        new bobble_sort(arr);
        for(int k : arr){
            System.out.println(k);
        }
    }
}

class bobble_sort{
    bobble_sort(int arr[]){
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
}