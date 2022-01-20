import java.util.Scanner;

public class number_1946 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int tastcase = sc.nextInt();
        for (int t = 0; t < tastcase; t++) {

            int passcount=1;
            int interview_min;
            int headcount = sc.nextInt();
            int interview[] = new int[headcount + 1];   //0번째 인덱스 사용 안함

            for (int i = 1; i < headcount + 1; i++) {
                interview[sc.nextInt()] = sc.nextInt();     //인덱스 번호가 서류 등수
            }
            interview_min = interview[1];
            for(int i=1;i<interview.length;i++){    //서류2등은 서류 1등보다 면접 점수가 높아야함

                if(interview[i]<interview_min){
                    passcount+=1;
                    interview_min = interview[i];
                }
            }
            sb.append(passcount).append("\n");
        }
        System.out.print(sb);
        sc.close();
    }
}