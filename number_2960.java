import java.util.Arrays;
import java.util.Scanner;

public class number_2960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count=0 ;
        sc.close();
        int arr[] = new int[n]; //n개만큼 배열 생성
        Arrays.fill(arr,1); //1로 초기화
        for(int i=2;i<=n;i++){
            for(int j=i;j<=n;j+=i){
                if(arr[j-1]!=1) continue; // 한 번 지워진 수는 pass 
                arr[j-1] = 0; //해당 수 지움
                count += 1; //지운 횟수
                
                if(count == k) { //k 번째 지웠을 때
                    System.out.println(j);
                    System.exit(0);
                }
            }
        }
    }
}
