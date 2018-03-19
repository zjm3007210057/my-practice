package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * the first problem in leetcode
 * Created by zjm on 07/02/2018.
 */
public class TwoSum1 {

    /**
     * this method does not consider the situation of nums contains two same elements
     * and negative elements
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * @param nums
     * @param target
     * @return
     */
    public int[] towSum(int[] nums, int target){
        if(nums.length < 2){
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= target){
                map.put(nums[i], i);
            }
        }
        if(map.size() < 2){
            return new int[]{};
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(map.containsKey(target - entry.getKey())){
                return new int[]{map.get(entry.getKey()), map.get(target-entry.getKey())};
            }
        }
        return new int[]{};
    }

    /**
     * consider the situation of nums contains two same elements but not consider the
     * situation of negative elements
     * @param nums
     * @param target
     * @return
     */
    public int[] towSum2(int[] nums, int target){
        if(nums.length < 2){
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= target){
                if(map.get(nums[i]) != null){
                    if(nums[i] * 2 == target){
                        return new int[]{map.get(nums[i]), i};
                    }
                }
                map.put(nums[i], i);
            }
        }
        if(map.size() < 2){
            return new int[]{};
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(map.containsKey(target - entry.getKey())){
                return new int[]{map.get(entry.getKey()), map.get(target-entry.getKey())};
            }
        }
        return new int[]{};
    }

    /**
     * consider the situation of nums contains two same elements and negative elements
     * @param nums
     * @param target
     * @return
     */
    public int [] twoSum3(int[] nums, int target){
        if(nums.length < 2){
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>((int) (nums.length * 1.5) + 1);
        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) != null){
                if(nums[i] * 2 == target){
                    return new int[]{map.get(nums[i]), i};
                }
            }
            map.put(nums[i], i);
        }
        if(map.size() < 2){
            return new int[]{};
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(map.containsKey(target - entry.getKey())){
                return new int[]{map.get(entry.getKey()), map.get(target-entry.getKey())};
            }
        }
        return new int[]{};
    }
}
