package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 特殊字符的测试
 * Created by zjm on 04/09/2017.
 */
public class SpecialCharaterTest {

    /**
     * 打印反斜杠"\"
     */
    public static void printBackSlash(){

    }

    public static void main(String[] args) {
        String s1 = "/Users/zjm/Downloads/ele-\\ vedio.sh";
        System.out.println(s1);
        String s2 = "/Users/zjm/Downloads/ele-vedio.sh";
        String command = "mv " + s1 + " " + s2;
        System.out.println(command);
        String [] cmd={"/bin/sh", command};
        try {
            Process ps = Runtime.getRuntime().exec(cmd);
            InputStreamReader reader = new InputStreamReader(ps.getInputStream());
            BufferedReader bf = new BufferedReader(reader);
            String line;
            while((line = bf.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\\ " + "@@");
    }
}
