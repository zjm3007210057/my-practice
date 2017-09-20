package algorithm.sort;

/**
 * 归并排序
 * Created by zjm on 19/09/2017.
 */
public class MergeSort {

    /**
     * 归并排序
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        merge(arr, 0, arr.length-1);
    }

    /**
     * 将数组从left到right归并
     * @param arr
     * @param left 做下标
     * @param right 右下标
     */
    private static void merge(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        merge(arr, left, mid);
        merge(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * 将数组从left到right归并
     * @param arr
     * @param left 左下标
     * @param mid 中间下标
     * @param right 右下标
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right-left+1];
        int index = 0;
        int l = left;
        int r = right;
        int m = mid;
        int p = 0;
        //逐个归并
        while(left <= mid && right > m){
            if(arr[left] <= arr[m+1]){
                tmp[index] = arr[left];
                left++;
            }else {
                tmp[index] = arr[m+1];
                m++;
            }
            index++;
        }
        //将左边剩余的归并
        while(left<=mid){
            tmp[index] = arr[left];
            index++;
            left++;
        }
        //将右边剩余的归并
        while(right>m){
            tmp[index] = arr[m+1];
            m++;
            index++;
        }
        //从临时数组拷贝到原数组
        while(l <= r){
            arr[l] = tmp[p];
            l++;
            p++;
        }
    }

}
