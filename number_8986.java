//문제:: 전봇대들의 위치 x0, x1, ..., xN-1이 주어지면, 모든 이웃한 전봇대들의 거리가 같도록 전봇대들을 이동할 때(x0에 위치한 전봇대는 고정), 
//       이동 거리의 합이 최소가 되도록 하는 프로그램을 작성하시오.

import java.util.Arrays;
import java.util.Scanner;

public class number_8986 {
    static long arr[];  //전봇대 위치 저장할 배열
    static long tmparr[] = new long[3];     //이동거리 최솟값을 구하기 위한 배열
    static int n;   //전봇대 개수
    static long start;  //1차원 좌표 시작 위치 저장할 변수
    static long end;    //1차원 좌표 끝 위치 저장할 변수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        arr = new long[n];  //전봇대 개수만큼 배열 생성
        

        for(int i=0;i<n;i++){
            arr[i] = sc.nextLong();     //전봇대 위치 저장
        }sc.close();

        
        ternary_search();

        System.out.println(Arrays.stream(tmparr).min().getAsLong());
    }

    static void ternary_search(){   //삼분탐색 함수
        start = arr[0];     //1차원 좌표 시작 
        end = arr[n-1];     //1차원 좌표 끝
        while(end-start >= 3){  //int형 변수를 3으로 나눌것이기 때문에 시작에서 끝가지의 거리 최솟값은 3
            long tmp_start = cal_distance(start + (end-start)/3);   
            long tmp_end = cal_distance(end - (end-start)/3);

            if(tmp_start > tmp_end){
                start = start + (end-start)/3;
            }
            else if(tmp_start == tmp_end){
                start = start + (end-start)/3;
                end = end - (end-start)/3;
            }
            else{
                end = end - (end-start)/3;
            }
        }
        for(int i=0;i<3;i++){
            tmparr[i]=cal_distance(start+i);
        }
    }

    static long cal_distance(long l){   //총 이동거리 연산 함수
        long stored=0;
        for(int i=0;i<n;i++){
            stored += Math.abs(arr[i]-i*l);
        }
        return stored;
    }
}
