package offer;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字
 * Input:
 *  {2, 3, 1, 0, 2, 5}
 * Output:
 *   2
 * Created by zjm on 2019/3/11.
 */
public class FindDuplicateNum {

    public static int findDuplicateNum(int[] arr) {
        if(null == arr || arr.length == 0) {
            return -1;
        }
        int tmp;
        for(int i = 0; i < arr.length; i++) {
            while(arr[i] != i) {
                if(arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                tmp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 1, 9, 3, 5, 0, 7};
        System.out.println(findDuplicateNum(arr));
    }
}
