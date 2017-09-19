package algorithm.sort;

import java.util.Random;

/**
 * 工具类
 * Created by zjm on 17/09/2017.
 */
public class ArrayUtils {

    /**
     * 生成一个随机的数组
     * @param n 数组的大小
     * @param left 随机数组的的最小值
     * @param right 随机数组的最大值
     * @return 生成的随机数组
     */
    public static int[] generateRandomArray(int n, int left, int right){
        if(left >= right){
            throw new RuntimeException("the left value must less than right value");
        }
        if(n < 1){
            throw new RuntimeException("the array size must large than 0");
        }
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = new Random().nextInt(right - left + 1) + left;
        }
        return arr;
    }

}
