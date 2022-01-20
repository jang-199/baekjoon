import java.util.Arrays;
import java.util.Scanner;

public class number_1915 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        int table[][] = new int [row][column];
        int temp[][] = new int [row][column];
        int max=0;///////////////////////////////////

        for(int i=0;i<row;i++){

            String s = sc.next();

            for(int j=0;j<column;j++){

                table[i][j] = s.charAt(j)-'0' ;

                if(table[i][j]==1){
                    temp[i][j] = 1;
                    max=1;
                }
            }
        }
        sc.close();
        for(int i=1;i<row;i++){  

            for(int j=1;j<column;j++){

                if(table[i-1][j-1]==1  && table[i-1][j]==1 && table[i][j]==1  && table[i][j-1]==1){
                    
                    int min_arr[] = {temp[i-1][j],temp[i-1][j-1],temp[i][j-1]};
                    temp[i][j] = Arrays.stream(min_arr).min().getAsInt() + 1;
                }
                max = Math.max(max,temp[i][j]);
            }
        }
        System.out.println((int)Math.pow(max, 2));    
    }
    
}
