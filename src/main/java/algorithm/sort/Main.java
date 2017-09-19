package algorithm.sort;

/**
 * Created by zjm on 17/09/2017.
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(10000, 0, 3);
        long start = System.currentTimeMillis();
        SelectSort.selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("选择排序耗时" + (end - start) + "毫秒");
        arr = ArrayUtils.generateRandomArray(10000, 0, 3);
        start = System.currentTimeMillis();
        InsertSort.insertSort(arr);
        end = System.currentTimeMillis();
        System.out.println("插入排序耗时" + (end - start) + "毫秒");

        arr = ArrayUtils.generateNearSortArray(10000, 100);
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
        System.out.println("优化插入排序耗时" + (end - start) + "毫秒");
    }
}
