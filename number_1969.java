import java.util.Arrays;
import java.util.Scanner;

public class number_1969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();     //가장 많은 염기 종류
        String example[] = {"A","C","G","T"};
        int DNA_cnt = sc.nextInt();     //입력될 DNA 개수
        int string_length = sc.nextInt();   //DNA 구성하는 염기 개수
        int ACGT[] = new int[4]; //염기 종류
        int hamming_distance=0;     //hamming distance의 합
        String DNA_arr[] = new String[DNA_cnt];

        sc.nextLine();  //위에서 nextInt함, 아래서 nextLine해야함, \n 지워야함

        for(int i=0;i<DNA_cnt;i++){
            DNA_arr[i] = sc.nextLine();
        }

        for(int i=0;i<string_length;i++){
            for(int j=0;j<DNA_cnt;j++){
                switch (DNA_arr[j].charAt(i)) {
                    case 'A':
                        ACGT[0]++;
                        break;
                    
                    case 'C':
                        ACGT[1]++;
                        break;

                    case 'G':
                        ACGT[2]++;
                        break;

                    case 'T':
                        ACGT[3]++;
                        break;
                    default:
                        break;
                }
            }

            int ACGT_max_index=0;   //제일 많이 나온 염기 인덱스
            int ACGT_max=0;     //제일 많이 나온 염기를 알기위해 염기 개수 카운팅

            for(int j=0;j<ACGT.length;j++){
                if(ACGT_max<ACGT[j]){
                    ACGT_max = ACGT[j];
                    ACGT_max_index = j;
                }
            }

            sb.append(example[ACGT_max_index]);     //hammming distance 합이 최소인 문자열을 하나씩 추가
            
            for(int k=0;k<DNA_cnt;k++)
            if(example[ACGT_max_index].charAt(0) != DNA_arr[k].charAt(i)){  //hamming distance 합 계산
                hamming_distance+=1;
            }
            
            Arrays.fill(ACGT, 0);
        }
        System.out.println(sb);
        System.out.println(hamming_distance);
        sc.close();
    }
}
