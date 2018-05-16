package leetcode.array;

/**
 * 给定一个数组arr，其中分成两段，两端严格单调递增，然后给定一个数，找出这个数的位置，如果不存在返回-1
 * @link {https://leetcode.com/problems/search-in-rotated-sorted-array/description/}
 * ex：
 * arr=[6,9,1,3,5]查找9：返回1，查找7：返回-1
 * Created by zjm on 17/04/2018.
 */
public class FindTarget {

    /**
     * 查找正确的下标使得arr[i] = n
     * @param arr
     * @param n
     * @return
     */
    public static int getTarget(int[] arr, int n){
        if(arr == null || arr.length < 1){
            return -1;
        }
        int right = arr.length - 1;
        int left = 0;
        int mid = (right + left) / 2;
        while(left <= right){
            //if arr[mid] > n
            if(arr[mid] > n){
                //if arr[mid] < arr[right],means that arr is ordered from mid to right
               if(arr[mid] < arr[right]){
                   right = mid - 1;
               } else {
                   //if arr[left] < n, means n is in left arr
                   if(n > arr[left]){
                        right = mid - 1;
                   }else if(n < arr[left]) {
                       //if arr[left] > n, means n is in right arr(or means arr is ordered from left to mid)
                       left = mid + 1;
                   }else {
                       return left;
                   }
               }
            }else if(arr[mid] < n){
                //if arr[mid] > arr[left], means arr is ordered from left to mid
                if(arr[mid] > arr[left]){
                    left = mid + 1;
                }else {
                    if(arr[right] < n){
                        right = mid - 1;
                    }else if(arr[right] == n){
                        return right;
                    }else {
                        left = mid + 1;
                    }
                }
            }else {
                return mid;
            }
        }
        return -1;
    }

}
