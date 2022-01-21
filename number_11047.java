import java.util.Scanner;

public class number_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coin = sc.nextInt();    //동전 개수
        int total = sc.nextInt();   // 만들어야할 금액
        int coin_arr[] = new int[coin];     //동전 구성

        for(int i=coin-1;i>=0;i--){
            coin_arr[i] = sc.nextInt();     // 액수가 큰 것부터
        }
        int idx=0;
        int count=0;
        while(total!=0){
            while(coin_arr[idx]<=total){
                total-=coin_arr[idx];
                count++;
            }
            idx++;
            
        }
        System.out.println(count);
    }
}
