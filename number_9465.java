import java.util.Scanner;

public class number_9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){

            int column = sc.nextInt();
            int sticker_score[][] = new int[2][column+1];
            int store_score[][] = new int[2][column+1];

            for(int j=0;j<sticker_score.length;j++){

                for(int k=1;k<sticker_score[j].length;k++){
                    
                    sticker_score[j][k] = sc.nextInt();
                }
            }
            store_score[0][1] = sticker_score[0][1];
            store_score[1][1] = sticker_score[1][1];
            for(int j=2;j<=column;j++){
                store_score[0][j] = Math.max(store_score[1][j-1], store_score[1][j-2])+sticker_score[0][j];
                store_score[1][j] = Math.max(store_score[0][j-1], store_score[0][j-2])+sticker_score[1][j];
            }
            System.out.println(Math.max(store_score[0][column], store_score[1][column]));
            sc.close();
        }
    }
    
}


