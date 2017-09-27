package algorithm.sort;

/**
 * Created by zjm on 17/09/2017.
 */
public class Main {

    public static void main(String[] args) {
        long start;
        long end;
        int[] arr;
        int[] arr0;
        int[] arr1;
        int[] arr2;
        int[] arr3;
        int[] arr4;
        arr = ArrayUtils.generateRandomArray(100000, 0, 1000000);
        arr0 = ArrayUtils.copyArr(arr);
        arr1 = ArrayUtils.copyArr(arr);
        arr2 = ArrayUtils.copyArr(arr);
        arr3 = ArrayUtils.copyArr(arr);
        arr4 = ArrayUtils.copyArr(arr);
        start = System.currentTimeMillis();
        QuickSort.quickSort(arr);
        end = System.currentTimeMillis();
        System.out.println("使用辅助空间快速排序耗时" + (end - start) + "毫秒");//100000, 18毫秒
        start = System.currentTimeMillis();
        QuickSort.quickSortBySwap(arr0);
        end = System.currentTimeMillis();
        System.out.println("使用元素交换快速排序耗时" + (end - start) + "毫秒");//100000, 15毫秒
        start = System.currentTimeMillis();
        InsertSort.insertSort(arr1);
        end = System.currentTimeMillis();
        System.out.println("插入排序耗时" + (end - start) + "毫秒");//100000, 1784毫秒
        start = System.currentTimeMillis();
        MergeSort.mergeSort(arr2);
        end = System.currentTimeMillis();
        System.out.println("归并排序耗时" + (end - start) + "毫秒");//100000, 26毫秒
        start = System.currentTimeMillis();
        MergeSort.mergeSortBU(arr3);
        end = System.currentTimeMillis();
        System.out.println("归并排序耗时" + (end - start) + "毫秒");//100000, 21毫秒start = System.currentTimeMillis();
        start = System.currentTimeMillis();
        QuickSort2.quickSort(arr4);
        end = System.currentTimeMillis();
        System.out.println("插入2排序耗时" + (end - start) + "毫秒");//100000, 21毫秒
        System.out.println(ArrayUtils.equals(arr, arr0));
        System.out.println(ArrayUtils.equals(arr0, arr1));
        System.out.println(ArrayUtils.equals(arr1, arr2));
        System.out.println(ArrayUtils.equals(arr2, arr3));
        System.out.println(ArrayUtils.equals(arr3, arr4));

        //近乎有序数组
        arr = ArrayUtils.generateNearSortArray(100000, 100);
        arr0 = ArrayUtils.copyArr(arr);
        arr1 = ArrayUtils.copyArr(arr);
        arr2 = ArrayUtils.copyArr(arr);
        arr3 = ArrayUtils.copyArr(arr);
        arr4 = ArrayUtils.copyArr(arr);
        start = System.currentTimeMillis();
        QuickSort.quickSort(arr);
        end = System.currentTimeMillis();
        System.out.println("使用辅助空间快速排序耗时" + (end - start) + "毫秒");//100000, 93毫秒
        start = System.currentTimeMillis();
        QuickSort.quickSortBySwap(arr0);
        end = System.currentTimeMillis();
        System.out.println("使用元素交换快速排序耗时" + (end - start) + "毫秒");//100000, 149毫秒
        start = System.currentTimeMillis();
        InsertSort.insertSort(arr1);
        end = System.currentTimeMillis();
        System.out.println("插入排序耗时" + (end - start) + "毫秒");//100000, 11毫秒
        start = System.currentTimeMillis();
        MergeSort.mergeSort(arr2);
        end = System.currentTimeMillis();
        System.out.println("归并排序耗时" + (end - start) + "毫秒");//100000, 6毫秒
        start = System.currentTimeMillis();
        MergeSort.mergeSortBU(arr3);
        end = System.currentTimeMillis();
        System.out.println("归并排序耗时" + (end - start) + "毫秒");//100000, 11毫秒
        start = System.currentTimeMillis();
//        QuickSort2.quickSort(arr4);
        end = System.currentTimeMillis();
        System.out.println("插入2排序耗时" + (end - start) + "毫秒");
        System.out.println(ArrayUtils.equals(arr, arr0));
        System.out.println(ArrayUtils.equals(arr0, arr1));
        System.out.println(ArrayUtils.equals(arr1, arr2));
        System.out.println(ArrayUtils.equals(arr2, arr3));
//        System.out.println(ArrayUtils.equals(arr4, arr3));

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
