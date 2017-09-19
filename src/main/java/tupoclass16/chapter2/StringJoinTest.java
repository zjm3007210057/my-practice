package tupoclass16.chapter2;

/**
 * Created by zjm on 2016/11/2.
 */
public class StringJoinTest {

    static void display(){
        String s1 = "ab12";
        String s2 = "ab" + "12";
        System.out.println(s1 == s2);
        final String str1 = "ab";
        final String str2 = "12";
        String s3 = str1 + str2;
        System.out.println(s1 == s3);
    }

    public static void main(String[] args) {
        String s1 = "helloworld";
        String s2 = "hello" + "world";
        System.out.println(s1 == s2);
        String str1 = "hello";
        String str2 = "world";
        String s3 = str1 + str2;
        System.out.println(s1 == s3);
        display();
    }
}
