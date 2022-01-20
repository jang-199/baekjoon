import java.util.Scanner;

public class number_11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[sc.nextInt()][2];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<2;j++){
                arr[i][j] = sc.nextInt();
            }
        }sc.close();
        new quick_Sort__1(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
        
    }
}

class quick_Sort__1{
    quick_Sort__1(int arr[][]){
        sort(arr, 0, arr.length-1);
    }

    void sort(int arr[][], int start, int end){
        int sec = partition(arr,start,end);     //두개의 파티션으로 나누고 두번째 파티션의 첫번째 인덱스를 저장
        if(start<sec-1){    //왼쪽 파티션의 인자는 1개 => 정렬할 필요 없음. 따라서 오른쪽 파티션이 시작점에서 1개 이상 차이날때만 함수를 재귀호출
            sort(arr, start, sec-1);
        }
        if(sec<end){
            sort(arr, sec, end);
        }
    }

    int partition(int arr[][], int start,int end){
        int pivot_x = arr[(start + end) / 2][0];     //배열의 중간값을 피벗으로 설정
        int pivot_y = arr[(start + end) / 2][1];     //배열의 중간값을 피벗으로 설정
        while(start <= end){
            while(arr[start][0]<=pivot_x){
                if(arr[start][0]==pivot_x){     //피벗과 x축 값이 같을때
                    if(arr[start][1]<pivot_y){  //비벗보다 y축 값이 작으면
                        start++;                //작은 것으로 간주하고 계속 진행
                    }
                    else break;                 //피벗과 x축 값이 같을때 비벗보다 y축 값이 크면 큰 것으로 간주하고 루프 탈출
                }
                else{start++;}                  //피벗보다 값이 작으므로 계속 진행
                
            } 
            while(arr[end][0] >= pivot_x){
                if(arr[end][0] == pivot_x) {    //피벗과 x축 값이 같을때
					if(arr[end][1] > pivot_y){  //비벗보다 y축 값이 크면
                        end--;                  //큰 것으로 간주하고 계속 진행
                    } 
					else break;                 //피벗과 x축 값이 같을때 비벗보다 y축 값이 작으면 작은 것으로 간주하고 루프 탈출
				}else {
					end--;                      //피벗보다 값이 크므로 계속 진행
				}
            } 
            if(start <= end){    //start와 end가 만나서 지나쳤는지 확인
                
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }
    
    void swap(int arr[][], int start, int end){
        int temp_x = arr[start][0];
        int temp_y = arr[start][1];
        arr[start][0] = arr[end][0];
        arr[start][1] = arr[end][1];
        arr[end][0] = temp_x;
        arr[end][1] = temp_y;
    }
}
