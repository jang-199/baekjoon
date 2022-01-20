import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class min_heap {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        minimum_heap minimum_heap = new minimum_heap();
        int n = Integer.valueOf(bf.readLine());     //입력할 개수

        for(int i=0;i<n;i++){

            minimum_heap.insert(Integer.valueOf(bf.readLine()));
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){

            sb.append(minimum_heap.delete()+"\n");
        }
        System.out.println(sb);
    }
}

class minimum_heap{
    private ArrayList<Integer> heap;
    minimum_heap(){
        heap = new ArrayList<>();
        heap.add(-1);
    }
    
    void insert(int param){     //삽입 메소드

        heap.add(param);

        int last_position = heap.size()-1;  //마지막 index 저장

        while(last_position>1 && heap.get(last_position / 2) > heap.get(last_position)){    //root node 아닌지 확인하고 부모 노드보다 작은지 확인 => 최소힙은 자식 노드보다 부모 노드의 값이 작아야함 => 자식이 더 작으면 부모와 swap

            int temp = heap.get(last_position / 2);     //부모 노드 값 저장

            heap.set(last_position / 2, heap.get(last_position));   //부모 노드에 현재 값(자식 노드) 저장
            heap.set(last_position,temp);   //맨 마지막 노드(자식노드)자식 노드에 부모 노드 값 저장

            last_position /= 2;     //한 번 부모와 자식을 비교했으면 last_position(자식 인덱스)를 그 부모의 인덱스 값으로 바꿔줌으로써 자식->부모로 하나씩 올라가면서 체크
        }
    }
    int delete(){   //삭제 메소드

        if(heap.size()-1 <1){   //예외처리
            return 0;
        }

        int deletednum = heap.get(1);   //루트노드를 저장 =>나중에 삭제한 값 리턴하기 위해

        heap.set(1,heap.get(heap.size()-1));    //루트노드에 맨 마지막 자식 노드를 저장
        heap.remove(heap.size()-1);     //맨 마지막 자식 노드 삭제

        int position = 1;   //인덱스를 루트노드로 초기화

        while((position * 2) < heap.size()){    //왼쪽 자식노드가 존재하는지 확인하고

            int min = heap.get(position * 2);     //왼쪽 자식노드 값 저장
            int min_position = position * 2;    //왼쪽 자식노드 인덱스 저장

            if( ((position * 2 + 1) < heap.size()) && min > heap.get(position * 2 + 1) ){     //오른쪽 자식노드가 있는지 확인 && 왼쪽 자식노드(min)보다 오른쪽 자식노드가 작으면

                min = heap.get(position*2+1);   //오른쪽 자식노드 값 저장
                min_position = position * 2 + 1;    //오른쪽 자식노드의 인덱스 저장
            }     

            if(heap.get(position)<min){     //루트노드가 더 작으면 교체할 필요 없으니 break
                break;
            }
            
            int temp = heap.get(position);  //루트노드 값 저장

            heap.set(position, heap.get(min_position));     //루트 노드에 작은 값을 가진 자식노드 값을 저장
            heap.set(min_position, temp);   //자식 노드에 루트노드 값을 저장

            position = min_position;    //자식 노드 인덱스를 저장
        }
        return deletednum;
    }

}
