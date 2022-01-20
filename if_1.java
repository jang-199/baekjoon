import java.util.Scanner;

public class if_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        sc.close();
        if(minute-45<0){
            if(hour-1<0){
                hour = 23;
            }else{
                hour = hour -1;
            }
            minute = minute+15;
        }
        else{
            minute = minute-45;
        }
        System.out.println(hour+" "+ minute);
    }
    
}
