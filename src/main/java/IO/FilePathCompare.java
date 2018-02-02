package IO;

import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 比较两个目录下面的文件名是否一样
 * Created by zjm on 06/01/2018.
 */
public class FilePathCompare {

    private List<String> list = new ArrayList<>();

    /**
     * 列出指定目录下（包括子目录）的所有文件放入map当中
     *
     * @param dir
     * @throws IOException
     */
    public List<String> listDirectory(File dir) throws Exception {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录" + dir + "不存在");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录");
        }
        String key;
        String fileName;
        File[] files = dir.listFiles();//不包含子目录下的文件
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listDirectory(file);//递归子目录
                } else {
                    key = file.toString();
                    if (key.endsWith("avi") || key.endsWith("mp4") || key.endsWith("wmv") || key.endsWith("mov")) {
                        fileName = key.replaceAll(" ", "").replaceAll("\\(", "").replaceAll("\\)", "")
                        .replaceAll("&", "").replaceAll(";", "").replace("-ys", "");
                        list.add(fileName);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 比较两个list里面的内容是否相同
     * @param sourcePath 原集合
     * @param destPath 目标集合
     * @return
     */
    public static List<String> hasTheSameFile(List<String> sourcePath, List<String> destPath){
        if(CollectionUtils.isEmpty(sourcePath) || CollectionUtils.isEmpty(destPath)){
            return null;
        }
        if(sourcePath.size() != destPath.size()){
            return null;
        }
        Set<String> set = new HashSet<>(sourcePath.size());
        for(String path : sourcePath){
            set.add(path);
        }
        List<String> res = new ArrayList<>();
        for(String path : destPath){
            if(!set.contains(path)){
                System.out.println(path);
                res.add(path);
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception{
        FilePathCompare f1 = new FilePathCompare();
        FilePathCompare f2 = new FilePathCompare();
        FilePathCompare f3 = new FilePathCompare();
        FilePathCompare f4 = new FilePathCompare();
        FilePathCompare f5 = new FilePathCompare();
        FilePathCompare f6 = new FilePathCompare();
        List<String> source1 = f1.listDirectory(new File("/Users/zjm/Documents/vedio/python接口测试"));
        List<String> dest1 = f2.listDirectory(new File("/Users/zjm/Documents/vedio/python接口测试-ys"));
        List<String> source2 = f3.listDirectory(new File("/Users/zjm/Documents/vedio/Redis从入门到高可用分布式实践"));
        List<String> dest2 = f4.listDirectory(new File("/Users/zjm/Documents/vedio/Redis从入门到高可用分布式实践-ys"));
        List<String> source3 = f5.listDirectory(new File("/Users/zjm/Documents/vedio/ssm到springboot从0开始开发校园商铺平台"));
        List<String> dest3 = f6.listDirectory(new File("/Users/zjm/Documents/vedio/ssm到springboot从0开始开发校园商铺平台-ys"));
        System.out.println(hasTheSameFile(source1, dest1).size());
        System.out.println(hasTheSameFile(source2, dest2).size());
        System.out.println(hasTheSameFile(source3, dest3).size());
    }
}
