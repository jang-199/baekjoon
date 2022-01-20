import java.util.Scanner;

public class number_11501 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int tastcase = sc.nextInt();
        
        for (int t = 0; t < tastcase; t++) {    //테스트 케이스만큼 반복

            int max=0;  //최고가
            long profit=0;
            int day = sc.nextInt();
            int stock_price[] = new int[day];

            for(int j =0;j<day;j++){
                stock_price[j] = sc.nextInt();
            }

            for(int j=stock_price.length-1;j>=0;j--){
                if(stock_price[j]>max){    //당일 가격이 최고가라면 최고가 업데이트
                    max = stock_price[j];
                }
                else{   //당일 가격이 최고가 아니면 최고가에서 당일 매도 가격 차감
                    profit += max - stock_price[j];
                }
            }
            sb.append(profit).append("\n");
        }
        
        System.out.print(sb);
        sc.close();
    }
}


