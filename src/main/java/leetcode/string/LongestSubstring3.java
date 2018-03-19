package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * the third problem in leetcode
 * Created by zjm on 07/02/2018.
 */
public class LongestSubstring3 {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * eg:
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
     * "pwke" is a subsequence and not a substring
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        if(s.length() < 2){
            return s.length();
        }
        int res = 0;
        //todo
        return res;
    }
}
