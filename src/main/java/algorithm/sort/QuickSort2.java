package algorithm.sort;

/**
 * 快速排序，分成三段，小于、等于以及大于
 * Created by zjm on 27/09/2017.
 */
public class QuickSort2 {

    /**
     * quick sort
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * quick sort
     * @param arr
     * @param left start index
     * @param right end index
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (right - left < 15) {
            InsertSort.insertSort(arr, left, right);
        }
        int index = findIndex(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    /**
     * find index and make all the left elements less than arr[index]
     * and all the right elements large than arr[index]
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int findIndex(int[] arr, int left, int right) {
        int tmp = arr[left];
        int l = left + 1;
        int r = right;
        int swap;
        while (l < r) {
            while (arr[l] < tmp && l <= r) {
                l++;
            }
            while (arr[r] > tmp && r > l) {
                r--;
            }
            if (l >= r) {
                break;
            }
            swap = arr[r];
            arr[r] = arr[l];
            arr[l] = swap;
            l++;
            r--;
        }
        arr[left] = arr[r];
        arr[r] = tmp;
        return r;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(10, 0, 20);
        quickSort(arr);
    }
}
