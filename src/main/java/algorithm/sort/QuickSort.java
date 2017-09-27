package algorithm.sort;

/**
 * 快速排序
 * Created by zjm on 21/09/2017.
 */
public class QuickSort {

    /**
     * 从数组一侧比较快速排序
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 从数组两端比较快速排序
     *
     * @param arr
     */
    public static void quickSortBySwap(int[] arr) {
        quickSortBySwap(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序，排序的下标从left到right（闭区间）
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = findIndex(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    /**
     * 快速排序，排序的下标从left到right（闭区间）
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSortBySwap(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        if(right - left <= 15){
            InsertSort.insertSort(arr, left, right);
        }
        int index = findIndexBySwap(arr, left, right);
        quickSortBySwap(arr, left, index - 1);
        quickSortBySwap(arr, index + 1, right);
    }

    /**
     * 找出元素的具体索引,对arr[left, right]部分进行partition操作
     * 从数组的左边进行比较
     *
     * @param arr
     * @param left
     * @param right
     * @return index，使得arr[left,...index-1] < arr[index];arr[index+1,...right] > arr[index]
     */
    public static int findIndex(int[] arr, int left, int right) {
        int tmp = arr[left];
        int l = left;
        int swap;
        for(int i=left+1; i<=right; i++){
            if(arr[i] < tmp){
                if(i != (l+1)){
                    swap = arr[l+1];
                    arr[l+1] = arr[i];
                    arr[i] = swap;
                }
                l++;
            }
        }
        swap = arr[left];
        arr[left] = arr[l];
        arr[l] = swap;
        return l;
    }

    /**
     * 找出元素的具体索引,对arr[left, right]部分进行partition操作
     * 从数组两边分别比较
     *
     * @param arr
     * @param left
     * @param right
     * @return index，使得arr[left,...index-1] < arr[index];arr[index+1,...right] > arr[index]
     */
    public static int findIndexBySwap(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int tmp = arr[left];
        while (l < r) {
            while (arr[r] >= tmp && r > l) {
                r--;
            }
            if (r > l) {
                arr[l] = arr[r];
                l++;
            }
            while (arr[l] < tmp && r > l) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        arr[l] = tmp;
        return l;
    }

}
