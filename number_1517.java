// 문제
// N개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에 대해서 버블 소트를 수행할 때, Swap이 총 몇 번 발생하는지 알아내는 프로그램을 작성하시오. ==>> inversion countung ==>> 역순인 것의 개수를 구하는 것 ==>> 버블 또는 합병으로 가능

// 버블 소트는 서로 인접해 있는 두 수를 바꿔가며 정렬하는 방법이다. 예를 들어 수열이 3 2 1 이었다고 하자. 이 경우에는 인접해 있는 3, 2가 바뀌어야 하므로 2 3 1 이 된다. 다음으로는 3, 1이 바뀌어야 하므로 2 1 3 이 된다. 다음에는 2, 1이 바뀌어야 하므로 1 2 3 이 된다. 그러면 더 이상 바꿔야 할 경우가 없으므로 정렬이 완료된다.

// 입력
// 첫째 줄에 N(1 ≤ N ≤ 500,000)이 주어진다. 다음 줄에는 N개의 정수로 A[1], A[2], …, A[N]이 주어진다. 각각의 A[i]는 0 ≤ |A[i]| ≤ 1,000,000,000의 범위에 들어있다. 
//>>>>>>>>>>>>>>>>>> 버블정렬 O(n^2)만큼의 비교 횟수를 가짐, 시간제한 1초 ==> 버블 정렬로 불가능, 합병 정렬로 풀어야함

// 출력
// 첫째 줄에 Swap 횟수를 출력한다


import java.util.Scanner;
public class number_1517 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int arr[] = new int[sc.nextInt()];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }sc.close();
        
        System.out.print(new merge_sort_for_bobble(arr).cnt);

    }
    
}

class merge_sort_for_bobble{
    long cnt=0;   // int로 선언해서 8번 틀렸네 푸항항 나는 멍청이 뚜잇뚜잇뚜잇~!@#$$  Integer.MaxValue = 32147483647 
    merge_sort_for_bobble(int arr[]){
        int tmp[] = new int[arr.length];
        Sort(arr, tmp, 0, arr.length-1);
    }
    void Sort(int arr[],int tmp[], int start, int end){
        if(start<end){
            int center = (start+end)/2;
            Sort(arr, tmp, start, center);
            Sort(arr, tmp, center+1, end);
            Merge(arr,tmp,start,center,end);
        }
    }
    void Merge(int arr[],int tmp[],int start,int center, int end){
        for(int i = start;i<=end;i++){
            tmp[i] = arr[i];
        }
        int partition1 = start;
        int partition2 = center+1;
        int idx = start;
        while(partition1<=center && partition2<=end){
            if(tmp[partition1]<=tmp[partition2]){   //앞쪽 파이티션의 값이 작은 경우
                arr[idx] = tmp[partition1]; 
                partition1++;
            }
            else{                                   //뒤쪽 파이션의 값이 작은 경우
                arr[idx] = tmp[partition2]; 
                partition2++;
                cnt  += (center - partition1 + 1 ); //앞쪽 파티션의 남이있는 배열의 인자 개수만큼 더함
            }
            idx++;
        }
        for(int i=0;i<=center-partition1;i++){ //앞쪽 파티션에 값이 남아있는 경우 cf.뒤쪽은 그냥 남아있기 때문에 신경 안써도 됨
            arr[idx+i] = tmp[partition1+i];
            
        }
    }
}