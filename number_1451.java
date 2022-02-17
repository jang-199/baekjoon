import java.util.Scanner;

public class number_1451 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //세로
        int m = sc.nextInt();   //가로

        sc.nextLine();
        
        int rectangle[][] = new int[n+1][m+1];  //직사각형 숫자 저장 배열
        for (int i = 1; i <= n; i++) {
            String tempstring = " "+sc.nextLine();
            for (int j = 1; j <= m; j++) {
                rectangle[i][j] = tempstring.charAt(j) - '0';
            }
        }sc.close();

        long max = 0;
        long temp=0;

        for(int i=1;i<=m-2;i++){
            for(int j=i+1;j<=m-1;j++){
                temp = calsum(rectangle, 1, i, 1, n) * calsum(rectangle, i+1, j, 1, n) * calsum(rectangle, j+1, m, 1, n);
                if(max < temp){
                    max = temp;
                }
            }
        }
        for(int i=1;i<=n-2;i++){
            for(int j=i+1;j<=n-1;j++){
                temp = calsum(rectangle, 1, m, 1, i) * calsum(rectangle, 1, m, i+1, j) * calsum(rectangle, 1, m, j+1, n);
                if(max < temp){
                    max = temp;
                }

            }
        }
        for (int i=1; i<=n-1; i++) {
            for (int j=1; j<=m-1; j++) {
                temp = calsum(rectangle, 1, j, 1, n) * calsum(rectangle, j+1, m, 1, i) * calsum(rectangle, j+1, m, i+1, n);
                if(max < temp){
                    max = temp;
                }
            }
        }
        for (int i=1; i<=n-1; i++) {
            for (int j=1; j<=m-1; j++) {
                temp = calsum(rectangle, 1, j, 1, i) * calsum(rectangle, 1, j, i+1, n) * calsum(rectangle, j+1, m, 1, n);
                if(max < temp){
                    max = temp;
                }   
            }
        }
        for (int i=1; i<=n-1; i++) {
            for (int j=1; j<=m-1; j++) {
                temp = calsum(rectangle, 1, m, 1, i) * calsum(rectangle, 1, j, i+1, n) * calsum(rectangle, j+1, m, i+1, n);
                if(max < temp){
                    max = temp;
                }   
            }
        }
        for (int i=1; i<=n-1; i++) {
            for (int j=1; j<=m-1; j++) {
                temp = calsum(rectangle, 1, j, 1, i) * calsum(rectangle, j+1, m, 1, i) * calsum(rectangle, 1, m, i+1, n);
                if(max < temp){
                    max = temp;
                }   
            }
        }
        System.out.println(max);

    }

    static long calsum(int arr[][],int n_start,int n_end,int m_start,int m_end){
        long tmp=0;
        for(int i=m_start;i<=m_end;i++){
            for(int j=n_start;j<=n_end;j++){
                tmp+=arr[i][j];
            }
        }
        return tmp;
    }
}
