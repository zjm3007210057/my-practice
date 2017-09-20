package algorithm.sort;

/**
 * Created by zjm on 17/09/2017.
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(100000, 0, 1000000);
        int[] arr1 = ArrayUtils.copyArr(arr);
        int[] arr2 = ArrayUtils.copyArr(arr);
        long start = System.currentTimeMillis();
        SelectSort.selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("选择排序耗时" + (end - start) + "毫秒");
        start = System.currentTimeMillis();
        InsertSort.insertSort(arr1);
        end = System.currentTimeMillis();
        System.out.println("插入排序耗时" + (end - start) + "毫秒");
        start = System.currentTimeMillis();
        MergeSort.mergeSort(arr2);
        end = System.currentTimeMillis();
        System.out.println("归并排序耗时" + (end - start) + "毫秒");

        /*arr = ArrayUtils.generateNearSortArray(10000, 100);
        start = System.currentTimeMillis();
        SelectSort.selectSort(arr);
        end = System.currentTimeMillis();
        System.out.println("选择排序耗时" + (end - start) + "毫秒");
        arr = ArrayUtils.generateNearSortArray(10000, 1000);
        start = System.currentTimeMillis();
        InsertSort.insertSort(arr);
        end = System.currentTimeMillis();
        System.out.println("插入排序耗时" + (end - start) + "毫秒");
        arr = ArrayUtils.generateNearSortArray(10000, 1000);
        start = System.currentTimeMillis();
        InsertSort.insertSortBetter(arr);
        end = System.currentTimeMillis();
        System.out.println("优化插入排序耗时" + (end - start) + "毫秒");*/
    }
}
