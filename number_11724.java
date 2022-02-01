import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class number_11724 {
    
    static LinkedList<Integer> ajlist[];
    static Boolean visit[];
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        ajlist = new LinkedList[n+1];
        visit = new Boolean[n+1];
        Arrays.fill(visit, false);

        for(int i=0;i<n+1;i++){
            ajlist[i] = new LinkedList<>();
        }

        for(int i=0;i<m;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            ajlist[from].add(to);
            ajlist[to].add(from);
        }sc.close();

        for(int i=1;i<n+1;i++){
            if(DFS(i)){
                count+=1;
            }
        }
        System.out.println(count);
    }

    static Boolean DFS(int v){
        if(visit[v]){
            return false;
        }
        visit[v] = true;
        for(int i=0;i<ajlist[v].size();i++){
            int current_node = ajlist[v].get(i);
            if(!visit[current_node]){
                DFS(current_node);
            }
        }
        return true;
    }
}
