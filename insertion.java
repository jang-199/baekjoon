/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*******************************************************************************************************************************************************************************
메모리:22088KB
시간:360ms
*/
import java.util.Scanner;

public class insertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int [sc.nextInt()];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }sc.close();
        new insertion_Sort(arr);
        for(int k : arr){
            System.out.println(k);
        }
    }
}

class insertion_Sort{
    insertion_Sort(int arr[]){
        int idx, temp;
        for(int i=1;i<arr.length;i++){
            temp = arr[i];
            for(idx=i-1;idx>=0 && temp<arr[idx];idx--){
                arr[idx+1] = arr[idx];      //배열 오른쪽으로 한 칸씩 이동
            }
            arr[idx+1] = temp;
        }
    }
    
}