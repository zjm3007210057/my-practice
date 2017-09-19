package algorithm.sort;

/**
 * 插入排序
 * Created by zjm on 17/09/2017.
 */
public class InsertSort {

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr){
        int n = arr.length;
        int tmp;
        for(int i=1; i<n; i++){
            for(int j=i; j>0; j--){
                if(arr[j] > arr[j-1]){
                    tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }
}
