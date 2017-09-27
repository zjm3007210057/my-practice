package algorithm.sort;

import java.util.Random;

import static java.lang.Math.min;

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
    public static void merge(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        if(right - left <= 15){
            InsertSort.insertSort(arr, left, right);
        }
        int mid = (left + right) / 2;
        merge(arr, left, mid);
        merge(arr, mid + 1, right);
        //面对近乎排序好的数组可以加上下面的if语句做优化，如果完全无序，则不加
        if(arr[mid] > arr[mid+1]) {
            merge(arr, left, mid, right);
        }
    }

    /**
     * 将数组从left到right归并
     * @param arr
     * @param left 左下标
     * @param mid 中间下标
     * @param right 右下标
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        //选择最左侧的元素进行比较，如果数组原本有序会退化为n方的算法，所以进行优化，随机选择元素作为基数对比
        //随机选择一个数组元素并将其和第一个元素交换（为了不改变代码）
        int random = new Random().nextInt(right - left + 1) + left;
        int swap = arr[random];
        arr[random] = arr[left];
        arr[left] = swap;
        int[] tmp = new int[right-left+1];//临时数组，选择最左侧的元素进行比较
        int index = 0;
        int l = left;
        int r = right;
        int m = mid;
        int p = 0;//临时数组下标
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

    /**
     * 从左到右依次merge
     * @param arr
     */
    public static void mergeSortBU(int[] arr){
        int n = arr.length;
        for(int i=1; i<n; i+=i){
            for(int j=0; j+i<n; j+=i+i){
                merge(arr, j, j+i-1, min(j+i+i-1, n-1));
            }
        }
    }

}
