package IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 替换文件夹下面文件的名字，针对特定文件夹下有相同文件名前缀或者后缀的情况
 * Created by zjm on 21/03/2018.
 */
public class FileNameReplace {

    private static List<String> list = new ArrayList<>(100);

    /**
     * 列出path下面所有的文件名
     * @param path 文件夹
     * @return
     */
    public static List<String> listFileName(File path){
        if(!path.exists()){
            throw new RuntimeException("文件夹" + path.getName() + "不存在");
        }
        if(!path.isDirectory()){
            throw new IllegalArgumentException(path.getName() + "不是目录");
        }
        File[] files = path.listFiles();//不包含子目录下的文件
        if(files != null && files.length > 0){
            for(File file : files){
                if(file.isDirectory()){
                    listFileName(file);
                }else {
                    list.add(file.toString());
                }
            }
        }
        return list;
    }

    /**
     * 替换文件夹为filePath下，文件明中含有sourceString被替换成destString
     * @param path 文件夹
     * @param sourceString 原文件名中存在的字符串
     * @param destString 替换的字符串
     */
    public static void replaceFileName(File path, String sourceString, String destString){
        List<String> list = listFileName(path);
        File outFile = null;
        BufferedWriter bw = null;
        String mvCommand;
        try{
            outFile = new File("/Users/zjm/Downloads/replaceFileName.sh");
            bw = new BufferedWriter(new FileWriter(outFile));
            for(String name : list){
                mvCommand = "mv " + name + " " + name.replaceAll(sourceString, destString);
                bw.write(mvCommand + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw != null){
                try{
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        File path = new File("/Users/zjm/Documents/vedio/java企业级电商项目架构演进之路Tomcat集群和Redis分布式");
        replaceFileName(path, "更多课程加qq群413648244-----", "");
    }
}
