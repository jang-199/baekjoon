import java.util.Scanner;

/*
문제
이 문제는 아주 평범한 배낭에 관한 문제이다.

한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.

준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.

입력
첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다. 두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.

입력으로 주어지는 모든 수는 정수이다.

출력
한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.
*/



public class number_12865 {
    static int k,n;
    static int W[],v[],dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //총 물건의 개수
        k = sc.nextInt();   //가방에 넣을 수 있는 최대 무게
        W = new int[n];      //물건의 무게 배열
        v = new int[n];      //물건의 가치 배열
        dp = new int [101][100001];
        for(int i=0;i<n;i++){
            W[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }sc.close();
        System.out.print(kn(0,0));


    }

    public static int kn(int i,int w){
        if(dp[i][w]>0) return dp[i][w];     //이미 저장된 값이 있다면(재귀를 통해 연산이 한 번 되었던 것이라면 그냥 리턴)
        if(i==n) return 0;

        int n1=0;
        if(w+W[i]<=k){
            n1 = v[i] + kn(i+1,w+W[i]);     //포함

        }
        int n2 = kn(i+1,w);     //미포함
        return dp[i][w] = Math.max(n1,n2);  //처음 재귀로 들어가는 중에는 배열에 저장
    }

}


//1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
// 2^n(모든 경우의 수 체크),재귀로 들어갈 때 나올때 둘 다 최댓값 비교를 해야함. 이 점을 배열로 보완할 것
// public class number_12865 {
//     static int k,n;
//     static int W[],v[];
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();   //총 물건의 개수
//         k = sc.nextInt();   //가방에 넣을 수 있는 최대 무게
//         W = new int[n];      //물건의 무게 배열
//         v = new int[n];      //물건의 가치 배열
        
//         for(int i=0;i<n;i++){
//             W[i] = sc.nextInt();
//             v[i] = sc.nextInt();
//         }
//         System.out.print(kn(0,0));


//     }

//     public static int kn(int i,int w){
//         if(i==n) return 0;

//         int n1=0;
//         if(w+W[i]<=k){   //무게 체크하고 가능하면
//             n1 = v[i] + kn(i+1,w+W[i]);     //포함

//         }
//         int n2 = kn(i+1,w);
//         return Math.max(n1, n2);
//     }

// }

