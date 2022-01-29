import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class number_13335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int[]> readyQ = new LinkedList<>();    
        Queue<Integer> Q = new LinkedList<>();    

        int n = sc.nextInt();   //트럭 수
        int w = sc.nextInt();   //다리 길이
        int l = sc.nextInt();   //최대 하중   

        int cnt=0;  //소요된 시간 카운팅 변수
        int current_total_weight=0;     //다리 위의 트럭 무게
        
        for(int k=0;k<n;k++){
            Q.offer(sc.nextInt());     
        }sc.close();
                
        while(!Q.isEmpty() || !readyQ.isEmpty()){
            cnt++;

            if(!readyQ.isEmpty() &&  w<=cnt - readyQ.peek()[0]){
                current_total_weight -= readyQ.poll()[1];
            }

            if(!Q.isEmpty() && current_total_weight + Q.peek()<=l){    //다리 무게 제한을 초과하지 않을때
                
                current_total_weight += Q.peek();
                readyQ.offer(new int[]{cnt,Q.poll()});  //다리 위에 올라간 시간과 트럭을 큐에 추가
            }   
        }
        System.out.println(cnt);
    }
}
