import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class number_1966 {
    public static void main(String[] args) {
        Queue<int[]> Q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        
        for(int k=0;k<testcase;k++){
            sc.nextInt();     //문서 개수 필요없음
            int sequence = sc.nextInt();  //몇 번째로 출력되는지 궁금한 문서 인덱스
            sc.nextLine();
            String document = sc.nextLine();
            String temp[] = document.split(" ");
            Integer doc_arr[] = Arrays.stream(temp).mapToInt(Integer::valueOf).boxed().toArray(Integer[]::new);     //정수 배열로 변환
           
            for(int i=0;i<doc_arr.length;i++){
                Q.offer(new int[]{i,doc_arr[i]});   //큐에 인덱스와 중요도 저장
            }

            int count=0;    //몇 번째 출력인지 카운드하는 변수

            while(!Q.isEmpty()){    //큐가 비어있을 때까지
                int current[] = Q.poll();   //큐의 맨 앞 값을 저장
                Boolean possibility = true;     //맨 앞의 문서보다 뒤에 중요도가 더 높은 문서가 있으면 flase,true면 출력 가능
                for(int q[] : Q){
                    if(q[1]>current[1]){    //큐의 맨 앞 값보다 중요도가 큰 것이 있는지 확인
                        possibility = false;    //중요도가 더 큰게 있다면 43번 라인으로
                    }
                }

                if(possibility){    //중요도가 더 큰게 없다면
                    count+=1;   //출력 횟수 하나 증가
                    if(current[0] == sequence){     //큐 맨 앞의 값이 찾는 문서의 인덱스와 같다면 중지
                        break;
                    }
                }
                else{
                    Q.offer(current);   //현재 값 큐의 맨 뒤로 재입력
                }
            }
            System.out.println(count);
            Q.clear();
        }
    }
}
