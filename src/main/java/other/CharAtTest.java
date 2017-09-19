package other;

/**
 * Created by zjm on 2017/2/22.
 */
public class CharAtTest {

    public static void main(String[] args) {
        String s = "";
//        System.out.println(s.charAt(0));//报错，因为charAt()没有做字符串空检验
//        String str = null;
        System.out.println(s.startsWith(""));//如果s为null，会报空指针
    }
}
