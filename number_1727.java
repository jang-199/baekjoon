import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class number_1727 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int man = Integer.valueOf(st.nextToken());
        int man_arr[] = new int [man+1];
        int woman = Integer.valueOf(st.nextToken());
        int woman_arr[] = new int [woman+1];
        int difference[][] = new int[man+1][woman+1];


        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<man+1;i++){
            man_arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(man_arr);


        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<woman+1;i++){
            woman_arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(woman_arr);


        for(int i=1;i<man+1;i++){

            for(int j=1;j<woman+1;j++){

                difference[i][j] = difference[i-1][j-1]+Math.abs(man_arr[i]-woman_arr[j]);   //같은 순서 남여 차이
                if(i>j){  //남자가 더 많을 때
                    difference[i][j] = Math.min(difference[i][j], difference[i-1][j]);
                }
                if(i<j){   //여자가 더 많을 때
                    difference[i][j] = Math.min(difference[i][j], difference[i][j-1]);
                }
            }
        }
        
        System.out.println(difference[man][woman]);
    }
}
