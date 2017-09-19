package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjm on 2017/1/29.
 */
public class Combination3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k >= 4 || n >= 10 || k >= n || k < 1 || n < 1){
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        if(k == 1){
            list.add(n);
            res.add(list);
        }else if(k == 2){
            if(n == 2){
                return res;
            }
            res = combinationSum2(n);
        }else {
            if(n < 6){
                return res;
            }
            int num = n / 3;
            List<List<Integer>> list1;
            for(int i = 1; i < num; i++){
                List<Integer> list2 = new ArrayList<Integer>();
                list2.add(i);
                list1 = combinationSum2(n - i);
                for(int j = 0; j < list1.size(); j++){
                    list2.add(list1.get(j).get(0));
                    list2.add(list1.get(j).get(1));
                    res.add(list2);
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> combinationSum2(int n){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int num = n / 2;
        for(int i = 1; i < num+1; i++){
            List<Integer> list = new ArrayList<Integer>(2);
            list.add(i);
            list.add(n - i);
            res.add(list);
        }
        return res;
    }

}
