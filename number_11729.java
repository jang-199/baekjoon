import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
//***************한 번에 하나의 원판만
//***************맨 위에 원판만 이동
//***************작은 원판 위에 큰 원판 불가
*/
public class number_11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());
        bw.write(((int)Math.pow(2,input)-1)+"\n");
        hanoi(input, 1, 2, 3);
        
        bw.flush();
		bw.close();
    }   
    
    static void hanoi(int n,int from,int dummy, int to) throws IOException{
        if(n==1){
            bw.write(from+" "+to+"\n");
        }
        else{
            hanoi(n-1, from, to, dummy);
            bw.write(from+" "+to+"\n");
            hanoi(n-1, dummy, from, to);
        }
    }
}
