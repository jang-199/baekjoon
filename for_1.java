import java.util.Scanner;
public class for_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int count=0,new_num=start;
        while(true){
            new_num = new_num%10*10+(new_num/10 + new_num%10)%10;
            count++;
            if(new_num == start){
                break;
            }
        }
        System.out.println(count);
        sc.close();
    }
    
}
