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
            for(int j=i; j>0 && (arr[j] < arr[j-1]); j--){
                tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr, int left, int right){
        int tmp;
        for(int i=left + 1; i<=right; i++){
            for(int j=i; j>left && (arr[j] < arr[j-1]); j--){
                tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }
        }
    }

    /**
     * 改进插入排序
     * @param arr
     */
    public static void insertSortBetter(int[] arr){
        int n = arr.length;
        int j;
        int e;
        for(int i=1; i<n; i++){
            e = arr[i];
            for(j=i; j>0 && (arr[j-1] > e); j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 2, 9, 3, 5, 8, 7};
        insertSort(arr, 3, 7);
        System.out.println("");
    }

}
