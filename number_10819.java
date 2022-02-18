import java.util.Arrays;
import java.util.Scanner;

public class number_10819 {
    static int max=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int list[] = new int[n];
        int temparr[] = new int[n];
        Boolean visited[] = new Boolean[n];
        Arrays.fill(visited, false);
       

        for(int i=0;i<n;i++){
            list[i] = sc.nextInt();
        }sc.close();
        
        DFS_1(list, temparr, visited, 0);

        System.out.println(max);
       
    }

    static int calsum12(int arr[],int arr_size){
        int temp=0;
        for(int i=0;i<arr_size-1;i++){
            temp += Math.abs(arr[i]-arr[i+1]); 
        }
        return temp;
    }

    static void DFS_1(int arr[],int temparr[],Boolean visited[],int current_idx){
        
        if(current_idx==arr.length){
            max = Math.max(max,calsum12(temparr, temparr.length));
            return;
            
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                temparr[current_idx] = arr[i];
                visited[i] = true;
                DFS_1(arr, temparr, visited, current_idx+1);
                visited[i] = false;
            }
        }
    }
}
