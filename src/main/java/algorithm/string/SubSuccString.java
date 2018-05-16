package algorithm.string;

import org.apache.commons.lang3.StringUtils;

/**
 * 统计连续出现的子串，返回子串
 * 比如：abbaaacccdhhhhh 返回hhhh
 * Created by zjm on 23/04/2018.
 */
public class SubSuccString {

    /**
     * 获取连续出现最长的子串
     * @param src
     * @return
     */
    public String getSubSuccString(String src){
        if(StringUtils.isBlank(src)){
            return "";
        }
        int length = src.length();
        int index = 1;
        int left = 0;
        int right = 0;
        int temp = 1;
        int max = 1;
        char first = src.charAt(0);
        for(int i=1; i<length; i++){
            if(first == src.charAt(i)){
                max++;
                right = i;
            }else {

            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "abc";
        char a = s.charAt(0);
        int length = s.length();
        System.out.println(s.charAt(length));
        if(a == 'a'){
            System.out.println("hehe");
        }
    }

}
