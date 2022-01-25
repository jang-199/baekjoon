import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class number_2800 {
    static String set[];
    static String arr[] = new String[200];
    static StringBuilder sb;
    static String input;
    static Boolean vist[];
    static int bracket[];  //괄호 쌍의 인덱스를 저장할 리스트
    static Set<String> set1 = new HashSet<>();  //괄호를 제거한 문자열을 저장할 집합
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sb = new StringBuilder();
        input = sc.nextLine();   //입력받은 문자열
        Stack<Integer> stack = new Stack<>();    //괄호 쌍을 찾을 스택
        arr = input.split("");     //입력받은 문자열을 하나씩 쪼개 담은 배열
        bracket = new int [arr.length];
        vist = new Boolean[arr.length];

        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("(")){
                stack.push(i); 
            }

            else if(arr[i].equals(")")){
                bracket[i] = stack.pop();   //닫는 괄호 인덱스에는 여는 괄호 인덱스 저장
                bracket[bracket[i]] = i;    //여는 괄호 인덱스에는 닫는 괄호 인덱스 저장  
            }            
        }
        DFS(0);
        
        ArrayList<String> list = new ArrayList<>(set1);
        Collections.sort(list);

        for(String s : list){
            if(s.equals(input)) continue;
            System.out.println(s);
        }
        sc.close();
    }

    static void DFS(int current){
        if(current == arr.length){
            set1.add(String.valueOf(sb));
            return;
        }
        if(arr[current].equals("(")){
            vist[bracket[current]] = true;
            DFS(current+1);
            vist[bracket[current]] = false;
        }
        if(arr[current].equals(")") && vist[current]){
            DFS(current+1);
        }
        else{
            sb.append(arr[current]);
            DFS(current+1);
            if(0!=sb.length()){
                sb.delete(sb.length()-1, sb.length());
            } 
        }
    }
}
