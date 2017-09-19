package algorithm.sort;

/**
 * 选择排序
 * Created by zjm on 17/09/2017.
 */
public class SelectSort {

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        int n = arr.length;
        int index;
        int min;
        int tmp;
        for(int i=0; i<n; i++){
            min = arr[i];
            index = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] <  min){
                    index = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }

}
