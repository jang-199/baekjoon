import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class number_1107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int channel = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> broken = new ArrayList<>();   //고장난 키 번호를 저장하는 리스트

        for(int i=0;i<n;i++){
            broken.add(sc.nextInt());
        }sc.close();

        int min = Math.abs(100 - channel);  //시작 채널에서 목표 채널까지 +,-로만 사용하여 이동했을 때 버튼을 누른 횟수

        for(int i=0;i<1000000;i++){     //channel 최대가 500000이므로 고장나지 않은 키가 9 뿐이라면 999999를 눌러서 내려야함

            Boolean button_broken = false;

            for(int j=0;j<String.valueOf(i).length();j++){  //i의 길이만큼 반복
                
                if(broken.contains(String.valueOf(i).charAt(j)-'0')){   //번호 i를 누르려면 고장난 키를 사용해야 하는지 확인
                    button_broken = true;   //고장난 버튼을 사용해야함을 기록
                    break;  //고장난 번호를 사용해야한다면 안쪽 for문 탈출
                }
            }

            if(!button_broken && ((Math.abs(channel - i) + String.valueOf(i).length()) <min)){  //channel - i의 절댓값은 +또는-키로 이동하는 횟수이고 i의 자릿수 개수는 번호를 누른 횟수
                min = Math.abs(channel - i) + String.valueOf(i).length();
            }
            
        }
        System.out.println(min);
        
    }
}
