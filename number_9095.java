import java.util.Scanner;

public class number_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int i=0;i<testcase;i++){
            int test_num = sc.nextInt();
            System.out.println(checknum(0, test_num));
        }sc.close();
    }
    static int checknum(int currentsum, int goalnum){
        if(currentsum>goalnum) return 0;
        if(currentsum==goalnum) return 1;

        int temp=0;
        for(int i=1;i<=3;i++){
            temp += checknum(currentsum+i, goalnum);
        }
        return temp;
    }
}
