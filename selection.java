/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*******************************************************************************************************************************************************************************
선택정렬 프로세스
배열에서 최소값을 찾는다. -> 최소값을 첫번째 인덱스의 요소와  교환한다 -> 배열에서 최소값을 찾는다 -> 최소값을 두번째 인덱스의 요소와 교환한다. => 인덱스의 개수 -1만큼 반복
*******************************************************************************************************************************************************************************
메모리:29560KB
시간:360ms
*/
import java.util.Scanner;

public class selection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[sc.nextInt()];   //n크기의 배열 생성

        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }sc.close();

        new selection_Sort(arr);
        
        for(int i : arr){
            System.out.println(i);
        }
    }
}

class selection_Sort{
    selection_Sort(int list[]){
        
        for(int i=0;i<list.length-1;i++){       //전달받은 리스트의 0번째 인덱스부터 n-1번째 인덱스까지 반복 => n-1번 반복
            int min_idx=i;
            for(int j = i+1;j<list.length;j++){ //i+1번째 부터 마지막(n)번째 까지 비교하며 가장 작은값 탐색 => n-1번, n-2번,n-3번 ...n-(n-1)번 반복  ==> O(n^2)  
                //==> n(n-1)/2

                if(list[min_idx]>list[j]){
                    min_idx = j;
                }
                
            }new swap(list,i,min_idx);
        }
    }
}
class swap{                                // swap class
    int temp;                              //swap을 위한 변수 생성
    swap(int arr[],int x, int y){          //생성자를 통해 x번째 인자는 y번째 인덱스에, y번째 인자는 x번째 인덱스에 저장
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}