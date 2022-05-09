import java.util.Scanner;

class number_24418{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int metrics[][] = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                metrics[i][j] =  sc.nextInt();
            }
        }

        sc.close();

        for(int i=1;i<size;i++){
            metrics[0][i] = metrics[0][i-1] + metrics[0][i];
            metrics[i][0] = metrics[i-1][0] + metrics[i][0];
        }


        for(int i=1;i<size;i++){
            for(int j=1;j<size;j++){
                if((metrics[i-1][j]+metrics[i][j]) > (metrics[i][j-1]+metrics[i][j])){//아래->오른쪽이 더 빠를 때
                    metrics[i][j] = metrics[i][j-1]+metrics[i][j];
                }else{
                    metrics[i][j] = metrics[i-1][j]+metrics[i][j];
                }
            }
        }

        System.out.println(metrics[size-1][size-1]);
    }
}