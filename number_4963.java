import java.util.Arrays;
import java.util.Scanner;


public class number_4963 {
    static Boolean visited[][];
    static int map_arr[][];
    static int x_width;
    static int y_width;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int count_island;
        while(sc.hasNextInt()){
            count_island=0;
            y_width = sc.nextInt();
            x_width = sc.nextInt();
            if(y_width==0 && x_width==0) break;
            map_arr = new int[x_width][y_width];
            visited = new Boolean[x_width][y_width];
            for(Boolean k[]:visited){
                Arrays.fill(k, false);
            }
            
            for(int i=0;i<x_width;i++){
                for(int j=0;j<y_width;j++){
                    map_arr[i][j] = sc.nextInt();
                }
            }
            
            for(int i=0;i<x_width;i++){
                for(int j=0;j<y_width;j++){
                    if(DFS(i, j)){
                        count_island+=1;
                    }
                }
            }
            System.out.println(count_island);
        }sc.close();
    }

    static Boolean DFS(int x, int y){
        if(x == -1 || y == -1 || x == x_width || y == y_width){
            return false;
        } 
        if(map_arr[x][y] == 0||visited[x][y]==true){
            return false;
        }
        
        visited[x][y] = true;

        DFS(x-1, y-1);
        DFS(x-1, y);
        DFS(x-1, y+1);
        DFS(x, y-1);
        DFS(x, y+1);
        DFS(x+1, y-1);
        DFS(x+1, y);
        DFS(x+1, y+1);

        return true;
    }
}
