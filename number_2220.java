import java.util.ArrayList;
import java.util.Scanner;

public class number_2220 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int temp;
        arr.add(0);     //heap에서 0번째 인덱스 사용 안함
        arr.add(1);     //최대힙 root 초기화
        int n = sc.nextInt(); 
        sc.close();  
        for(int i=2;i<=n;i++){

            arr.add(i);     //맨 마지막에 추가
            
            temp = arr.get(i);        //         \\
            arr.set(i, arr.get(i-1)); //          ||=>> 1과 추가된 수의 위치를 swap (1이 맨 마지막에 있어야 최대 swap횟수를 충족)
            arr.set(i-1, temp);       //         //

            int max_value = i-1;    //최댓값 인덱스     1과 swap했으므로 마지막에서 두번째가 마지막에 추가된 수

            while(max_value != 1){  //루트노드가 아닐때 반복

                temp = arr.get(max_value);                  //       \\ 
                arr.set(max_value, arr.get(max_value / 2)); //        ||=>> 마지막에 추가된 수(가장 큰 수)를 루트 노드에 도달할 때까지 반복
                arr.set(max_value / 2, temp);               //       //
                max_value /= 2;     //부모노드 인덱스
            }
        }
        for(int i=1;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
    }
    
}
