package sms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取resources下面的文件并解析内容存入map当中
 * Created by zjm on 02/02/2018.
 */
public class Authorilize {

    /**
     * 存放用户名和密码的map
     */
    private static final Map<String, String> map = new HashMap<>();

    /**
     * 获取map
     * @return
     */
    public static Map<String, String> getMap() {
        return map;
    }

    /**
     * 读取文件内容并存入map
     */
    static{
        BufferedReader br = null;
        FileReader fi = null;
        try{
            File file = new File(Authorilize.class.getClassLoader().getResource("key.txt").getPath());
            fi = new FileReader(file);
            br = new BufferedReader(fi);
            String line;
            while((line = br.readLine()) != null){
                map.put(line.split("=")[0], line.split("=")[1]);
            }
        }catch(Exception e){
            System.out.println("读取用户名密码文件出错" + e);
        }finally {
            if(br != null){
                try{
                    br.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(fi != null){
                try{
                    fi.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}
