import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class quick {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[Integer.valueOf(bf.readLine())];

        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.valueOf(bf.readLine());
        }

        new quick_Sort(arr);

        StringBuilder sb = new StringBuilder();

        for(int k : arr){
            sb.append(k+ "\n");
        }
        System.out.print(sb);
    }
}

class quick_Sort{
    quick_Sort(int arr[]){
        sort(arr, 0, arr.length-1);
    }

    void sort(int arr[], int start, int end){
        int sec = partition(arr,start,end);     //두개의 파티션으로 나누고 두번째 파티션의 첫번째 인덱스를 저장
        if(start<sec-1){    //왼쪽 파티션의 인자는 1개 => 정렬할 필요 없음. 따라서 오른쪽 파티션이 시작점에서 1개 이상 차이날때만 함수를 재귀호출
            sort(arr, start, sec-1);
        }
        if(sec<end){
            sort(arr, sec, end);
        }
    }

    int partition(int arr[], int start,int end){
        int pivot = arr[(start + end) / 2];     //배열의 중간값을 피벗으로 설정
        while(start <= end){
            while(arr[start]<pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end){    //start와 end가 만나서 지나쳤는지 확인
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }
    
    void swap(int arr[], int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}