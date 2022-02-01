import java.util.*;

public class number_1260 {
    static Boolean visit[];
    static LinkedList<Integer> adjlist[];
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();   //vertex
        int m = sc.nextInt();   //edge
        int v = sc.nextInt();   //start vertex
        visit = new Boolean[n+1];   //방문한 정점을 기록할 배열
        Arrays.fill(visit, false);  
        adjlist = new LinkedList[n+1];  //연결리스트 배열 변수, 정점은 1부터 시작이라 +1 필요(0번은 사용 안함)
        
        for(int i=0;i<n+1;i++){
            adjlist[i] = new LinkedList<>();    //배열에 연결리스트 선언
        }
        
        for(int i=0;i<m;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjlist[from].add(to);  //양방향으로 저장
            adjlist[to].add(from);
           
        }sc.close();

        for(int i=0;i<n+1;i++){
            Collections.sort(adjlist[i]);   //문제 조건에 방문할 정점이 여러 개가 있으면 작은 것부터 방문하라는 조건으로 인해 정렬 필요
        }

        DFS(v);
        System.out.println();
        Arrays.fill(visit, false);
        BFS(v);
        
    }

   static void DFS(int v){
       if(visit[v]){
           return;
        }
        visit[v] = true;
        System.out.print(v + " ");
        for(int i=0;i<adjlist[v].size();i++){
            int tmp = adjlist[v].get(i);
            if(!visit[tmp]){
                DFS(tmp);
            }
        }
   }

   static void BFS(int v){
        Queue<Integer> adjQ = new LinkedList<>();
       
        visit[v] = true;
        adjQ.offer(v);
        System.out.print(v + " ");
        
        while(!adjQ.isEmpty()){

            int node =adjQ.poll();

            for(int i=0;i<adjlist[node].size();i++){
                int temp = adjlist[node].get(i);
                if(!visit[temp]){
                    visit[temp] = true;
                    System.out.print(temp + " ");
                    adjQ.offer(temp);
                }
            }
        }
    }

}
