import java.util.Scanner;

public class number_6603 {
    static int size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while((size = sc.nextInt())!=0){
            Boolean pick[] = new Boolean[size];//stored choiced
            int set[] = new int[size]; //number set
            for (int i = 0; i < size; i++) {
                set[i] = sc.nextInt();
            }
            lotto(0, 0, pick, set);
            System.out.println();
        }sc.close();
    }

    static void lotto(int start, int depth,Boolean pick[],int set[]){
        
        for(int i = start;i<size;i++){
            pick[i] = true;
            lotto(i+1, depth+1, pick, set); ////////pick을 초기화하지 않으면 pick 맨 마지막이 계속 널임= 마지막까지초기화가 안됨
            pick[i] = false;
        }

        if(depth==6){
            for(int i=0;i<size;i++){
                if(pick[i]){
                    System.out.print(set[i]+" "); 
                }
            }System.out.println();
        }        
    }
}
