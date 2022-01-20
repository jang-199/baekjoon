import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class radix {
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[Integer.valueOf(bf.readLine())];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.valueOf(bf.readLine());
        }

        new radix_sort(arr);
        for(int k : arr){
            System.out.println(k);
        }
    }

    
    
    
    
}

class radix_sort{
    int arr[];
    radix_sort(int arr[]){
        this.arr = arr;
        sort();
    }
    void counting_sort(int exp, int arr[]){
        
        int cnt_arr[] = new int [10];  //0~9
        for(int val : arr){
            cnt_arr[(val / exp) % 10]++;     //최솟값 기준으로 인덱스를 지정하고 개수 +1
        }

        for(int i=1;i<cnt_arr.length;i++){
            cnt_arr[i] += cnt_arr[i-1];
        }

        int out[] = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            int current = arr[i];
            int pos_in_cnt_arr = cnt_arr[(current / exp) % 10] -1;
            out[pos_in_cnt_arr] = current;
            cnt_arr[(current / exp) % 10]--;
        }

        System.arraycopy(out, 0, arr, 0, arr.length);
    }

    
    int[] radixsort(int arr[]){
        int max = Arrays.stream(arr).max().getAsInt();
        for(int i = 1;max/i>0;i*=10){
            counting_sort(i,arr);
        }
        return arr;
    }

    void sort(){
        Map<Boolean,List<Integer>> split_arr = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.partitioningBy(i->i<0)  //true = negative, false = positive
        );   
        
        int negative_val[] = radixsort(split_arr.get(true).stream()
            .mapToInt(Integer::intValue)
            .map(Math::abs)
            .toArray()
        );

        int positive_val[] = radixsort(split_arr.get(false)
            .stream()
            .mapToInt(Integer::intValue)
            .toArray()
        );

        for(int i= negative_val.length-1,j=0;i>=0;i--,j++){
            arr[j] = -negative_val[i];
        }
        System.arraycopy(positive_val, 0, arr, negative_val.length, positive_val.length);
    }
}

