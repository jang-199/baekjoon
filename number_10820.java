import java.util.Scanner;
public class number_10820 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        int upper=0, lower=0, num=0,empty=0;
        while(sc.hasNextLine()){ //EOF CHECK
            s = sc.nextLine();
            for(int i = 0; i < s.length();i++){
                char ch = s.charAt(i);
                if(Character.isUpperCase(ch)) upper++;
                else if(Character.isLowerCase(ch)) lower++;
                else if(Character.isDigit(ch))num++;
                else empty++;
            }System.out.println(lower+" "+upper+" "+num+" "+empty);
            upper=0; lower=0; num=0; empty=0;
        }sc.close(); 
        

    }
}
