import java.io.*;

public class shell {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   //Scanner입력 후 println으로 출력=> 시간 초과 
        int arr[] = new int [Integer.parseInt(br.readLine())];                      //Buffered입력 후 println으로 출력=> 시간 초과 
                                                                                    //Scanner입력 후 StringBuilder 출력 => 정답
        for(int i=0;i<arr.length;i++){                                              ///Buffered입력 후 StringBuilder 출력 => 정답
            arr[i] = Integer.parseInt(br.readLine());
        }

        new chell_sort(arr);

        StringBuilder sBuilder = new StringBuilder();

        for(int k : arr){
            sBuilder.append(String.valueOf(k)+"\n");
        }

        System.out.print(sBuilder);
    }
}

class chell_sort{
    int[] gap = { 1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937, 	//Ciura sequence = {1, 4, 10, 23, 57, 132, 301, 701, 1750} 이후 2.25를 곱하여 확장
		8858, 19930, 44842, 100894, 227011, 510774,
		1149241, 2585792, 5818032, 13090572, 29453787, 
		66271020, 149109795, 335497038, 754868335, 1698453753};

    chell_sort(int arr[]){
        int gap_idx = Cal_Gap(arr.length); 
        for (int i = gap_idx; i >= 0; i--) {
 
			for (int j = 0; j < gap[i]; j++) {	// 각 부분 리스트에 대해 삽입정렬을 한다.
				new insertion_Sort_1(arr, j, arr.length-1, gap[i]);
			}
		}
    }
  
    int Cal_Gap(int length){
        int idx = 0;
        while(gap[idx]<(length/2)){     //배열 길이의 절반 이하인 gap 검색
            idx++;
        }
        return idx;
    }
}

class insertion_Sort_1{
    insertion_Sort_1(int arr[],int start, int end, int gap){
        int idx, temp;
        for(int i=start;i<=end;i+=gap){
            temp = arr[i];
            
            for(idx=i-gap;idx>=0 && temp<arr[idx];idx-=gap){
                arr[idx+gap] = arr[idx];      //배열 오른쪽으로 한 칸씩 이동
            }
            arr[idx+gap] = temp;
        }
    }
}