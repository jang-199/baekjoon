//33333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
import java.io.*;
public class merge {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[Integer.valueOf(br.readLine())];
        
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.valueOf(br.readLine());
        }
        new merge_sort(arr);
        for(int k : arr){
            sb.append(String.valueOf(k)+"\n");
        }
        System.out.print(sb);
    }
}

class merge_sort{
    //int tmp[];
    merge_sort(int arr[]){
        int tmp[] = new int[arr.length];
        Sort(arr, tmp, 0, arr.length-1);

    }
    void Sort(int arr[],int tmp[], int start, int end){
        if(start<end){
            int center = (start+end)/2;
            Sort(arr, tmp, start, center);
            Sort(arr, tmp, center+1, end);
            Merge(arr,tmp,start,center,end);
        }
    }
    void Merge(int arr[],int tmp[],int start,int center, int end){
        for(int i = start;i<=end;i++){
            tmp[i] = arr[i];
        }
        int partition1 = start;
        int partition2 = center+1;
        int idx = start;
        while(partition1<=center && partition2<=end){
            if(tmp[partition1]<=tmp[partition2]){   //앞쪽 파이티션의 값이 작은 경우
                arr[idx] = tmp[partition1]; 
                partition1++;
            }
            else{                                   //뒤쪽 파이션의 값이 작은 경우
                arr[idx] = tmp[partition2]; 
                partition2++;
            }
            idx++;
        }
        for(int i=0;i<=center-partition1;i++){ //앞쪽 파티션에 값이 남아있는 경우 cf.뒤쪽은 그냥 남아있기 때문에 신경 안써도 됨.
             arr[idx+i] = tmp[partition1+i];
        }
    }
}


//2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
// import java.io.*;
// public class merge{
//     static int arr[];
//     static int tmp[];
//     public static void main(String[] args) throws NumberFormatException, IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         arr = new int[Integer.valueOf(br.readLine())];
//         tmp = new int[arr.length];
//         for(int i=0;i<arr.length;i++){
//             arr[i] = Integer.valueOf(br.readLine());
//         }
//         merge_sort(0,arr.length-1);
//         for(int k : arr){
//             sb.append(String.valueOf(k)+"\n");
//         }
//         System.out.print(sb);
//     }
    
//     static void merge_sort(int start, int end){
//         if (start < end) {
//             int center = (start + end) / 2;
//             merge_sort(start, center);
//             merge_sort(center + 1, end);
//             for(int i = start;i<=end;i++){
//                 tmp[i] = arr[i];
//             }
//             int partition1 = start;
//             int partition2 = center+1;
//             int idx = start;
//             while(partition1<=center && partition2<=end){
//                 if(tmp[partition1]<=tmp[partition2]){   //앞쪽 파이티션의 값이 작은 경우
//                     arr[idx] = tmp[partition1]; 
//                     partition1++;
//                 }
//                 else{                                   //뒤쪽 파이션의 값이 작은 경우
//                     arr[idx] = tmp[partition2]; 
//                     partition2++;
//                 }
//                 idx++;
//                 for(int i=0;i<=center-partition1;i++){  //앞쪽 파티션에 값이 남아있는 경우 cf.뒤쪽은 그냥 남아있기 때문에 신경 안써도 됨.
//                     arr[idx+i] = tmp[partition1+i];
//                 }
//             }
//         }
//     }
// }
//11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111

// class merge_sort{
//     //int tmp[];
//     merge_sort(int arr[]){
//         int tmp[] = new int[arr.length];
//         Sort(arr, tmp, 0, arr.length-1);

//     }
//     void Sort(int arr[],int tmp[], int start, int end){
//         if(start<end){
//             int center = (start+end)/2;
//             Sort(arr, tmp, start, center);
//             Sort(arr, tmp, center+1, end);
//             Merge(arr,tmp,start,center,end);
//         }
//     }
//     void Merge(int arr[],int tmp[],int start,int center, int end){
//         for(int i = start;i<=end;i++){
//             tmp[i] = arr[i];
//         }
//         int partition1 = start;
//         int partition2 = center+1;
//         int idx = start;
//         while(partition1<=center && partition2<=end){
//             if(tmp[partition1]<=tmp[partition2]){   //앞쪽 파이티션의 값이 작은 경우
//                 arr[idx] = tmp[partition1]; 
//                 partition1++;
//             }
//             else{                                   //뒤쪽 파이션의 값이 작은 경우
//                 arr[idx] = tmp[partition2]; 
//                 partition2++;
//             }
//             idx++;
//         }
//         for(int i=0;i<=center-partition1;i++){ //앞쪽 파티션에 값이 남아있는 경우 cf.뒤쪽은 그냥 남아있기 때문에 신경 안써도 됨.
//              arr[idx+i] = tmp[partition1+i];
//         }
//     }
// }


