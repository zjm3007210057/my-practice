package IO;

import org.apache.commons.collections.MapUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 列出File的一些常用操作如：过滤、遍历等操作
 * Created by zhangjianming on 2016/9/22.
 */
public class FileUtils {

    private static List<String> list = new ArrayList<>(100);

    /**
     * 列出指定目录下（包括子目录）的所有文件放入map当中
     *
     * @param dir
     * @throws IOException
     */
    public static List<String> listDirectory(File dir) throws Exception {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录" + dir + "不存在");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录");
        }
        String key;
        File[] files = dir.listFiles();//不包含子目录下的文件
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listDirectory(file);//递归子目录
                } else {
                    /*key = file.toString();//.replaceAll(" ", "");
                    value = file.toString().replaceAll(" ", "-").replaceAll("（", "").replaceAll("）", "").replaceAll("\\(", "").replaceAll("\\)", "");
                    if (key.endsWith("avi") || key.endsWith("mp4") || key.endsWith("wmv") || key.endsWith("mov")) {
                        value = value.replace(prefix, replace);
                        map.put(key, value);
                        System.out.println(key);
                    }*/
                    key = file.toString();
                    if (key.endsWith("avi") || key.endsWith("mp4") || key.endsWith("wmv") || key.endsWith("mov")) {
                        list.add(key);
                        System.out.println(key);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 原视频目录中包含空格等特殊字符，需要先将这些特殊字符去掉（即要先创建去掉特殊字符的目录，然后把原视频移到该目录下，再删除原来的目录）
     * @param list
     * @return
     */
    private static Map<String, String> mkdirCommand(List<String> list){
        Map<String, String> res = new HashMap<>(list.size());
        String filePath;
        String command;
        String mvCommand;
        for(String path : list){
            if(path.contains(" ") || path.contains("(") || path.contains(")")){
                filePath = path.substring(0, path.lastIndexOf("/")).replaceAll(" ", "").replaceAll("\\(", "").replaceAll("\\)", "");
                command = "mkdir -p " + filePath;
                res.put(command, command);
            }
        }
        return res;
    }

    /**
     * 创建多级目录,给压缩视频使用
     * @param map
     * @throws Exception
     */
    public static List<String> generateMkdirConnand(Map<String, String> map){
        String command;
        List<String> res = new ArrayList<>(map.size());
        for(Map.Entry<String, String> entry : map.entrySet()){
            command = "mkdir -p " + entry.getValue();
            res.add(command);
        }
        return res;
    }

    /**
     * 生成需要新建目录的map，相当于把所有需要新建的目录加到map里面
     * map 的key为原来的目录，value为原来的目录后面加上-ys
     * @param list
     * @return
     */
    public static Map<String, String> generateDirectory(List<String> list, String fileTitle){
        Map<String, String> map = new HashMap<>();
        String dir;
        for(String fileName : list){
            dir = fileName.substring(0, fileName.lastIndexOf("/"));
            dir = dir.replaceAll(" ", "");
            map.put(dir, dir.replaceAll(fileTitle, fileTitle + "-ys"));
        }
        return map;
    }

    /**
     * 文件移动命令生成
     * 将文件名中含有空格和英文括号的文件重新命名
     * @param list
     * @return
     * @throws Exception
     */
    public static Map<String, String> generateMVCommand(List<String> list)throws Exception{
        Map<String, String> res = new HashMap<>(list.size());
        String value;
        String command;
        String rmCommand;
        String tmp;
        for(String fileName : list) {
            tmp = fileName.substring(0, fileName.lastIndexOf("/"));
            if(tmp.contains(" ") || tmp.contains("(") || tmp.contains(")")){
                tmp = fileName.substring(0, fileName.lastIndexOf("/")).replaceAll(" ", "\\\\ ").replaceAll("\\(","\\\\(").replaceAll("\\)", "\\\\)").replaceAll("&", "\\\\&");
                rmCommand = "rm -r " + tmp;
                res.put(rmCommand, tmp);
            }
            if(fileName.contains(" ") || fileName.contains("(") || fileName.contains("&") || fileName.contains(")")){
                value = fileName.replaceAll(" ", "").replaceAll("（","").replaceAll("）", "")
                        .replaceAll("\\(","").replaceAll("\\)", "").replaceAll("&", "").replaceAll(";", "");
                fileName = fileName.replaceAll(" ", "\\\\ ").replaceAll("\\(","\\\\(").replaceAll("\\)", "\\\\)").replaceAll("&", "\\\\&").replaceAll(";", "\\\\;");
                command = "mv " + fileName + " " + value;
                res.put(command, value);
            }else {
                value = fileName.replaceAll("（","").replaceAll("）", "");
                res.put(fileName, value);
            }
        }
        return res;
    }

    /**
     * 生成压缩视频命令
     * @param map
     * @return。
     */
    public static List<String> generateCompileCommand(Map<String, String> map){
        List<String> res = new ArrayList<>(map.size());
        String command;
        for(Map.Entry<String, String> entry : map.entrySet()){
            command = "ffmpeg -i " + entry.getKey() + " -vcodec libx264 -preset fast -crf 28 -y -acodec libmp3lame -ab 30k " + entry.getValue();
            res.add(command);
        }
        return res;
    }

    /**
     * 获取压缩视频的文件名和生成压缩后的文件名并放入map中
     * @param list
     * @param fileTile
     * @return
     */
    public static Map<String, String> getVideoMap(List<String> list, String fileTile){
        Map<String, String> map = new HashMap<>(list.size());
        String key;
        String value;
        for(String fileName : list){
            key = fileName;
            fileName = fileName.replaceAll(" ", "\\\\ ");
            value = fileName.replaceAll(fileTile, fileTile + "-ys");
            value = value.replaceAll("（", "").replaceAll("）", "");
            map.put(key, value);
        }
        return map;
    }

    /**
     * 去除文件目录中的空格等特殊字符
     * @param list
     * @return
     */
    public static List<String> rmFilePathSpace(List<String> list){
        List<String> res = new ArrayList<>(list.size());
        for(String path : list){
            path = path.replaceAll(" ", "").replaceAll("\\(", "").replaceAll("\\)", "");
            res.add(path);
        }
        return res;
    }

    /**
     * <p>生成最后可执行的文件,其中命令包括：</p>
     * <ul>
     *     <ui>将文件重新命名，去除空格和英文括号特殊字符</ui>
     *     <ui>生成创建文件夹命令，创建的文件夹为原目录的课程名后面加上“-ys”，表示压缩之意</ui>
     *     <ui>生成视频压缩命令，将原目录里面的视频进行压缩</ui>
     * </ul>
     * @param filePath 需要进行视频压缩的目录
     * @param fileTitle 课程名
     * @param outputFile 输出文件
     * @return bash脚本
     */
    public static File generateBashFile(String filePath, String fileTitle, String outputFile){
        BufferedWriter bw = null;
        File file = null;
        try{
            file = new File(outputFile);
            File sourceFile = new File(filePath);
            bw = new BufferedWriter(new FileWriter(file));
            //获取最开始目录下的文件list
            List<String> firstFileList = listDirectory(sourceFile);
            //生成原始文件创建文件目录命令
            Map<String, String> sourceFileMVCommand = mkdirCommand(firstFileList);
            if(MapUtils.isNotEmpty(sourceFileMVCommand)){
                for(Map.Entry<String, String> cmd : sourceFileMVCommand.entrySet()){
                    bw.write(cmd.getKey() + "\n");
                }
            }
            bw.flush();
            Map<String, String> fileMvMap = generateMVCommand(firstFileList);//生成移动文件命令，将有空格和括号的文件移到符合规范的文件

            //将文件移动命令写入文件
            firstFileList = new ArrayList<>(fileMvMap.size());
            for(Map.Entry<String, String> entry : fileMvMap.entrySet()){
                if(entry.getKey().startsWith("mv")){
                    bw.write(entry.getKey() + "\n");
                }
                firstFileList.add(entry.getValue());
            }
            for(Map.Entry<String, String> entry : fileMvMap.entrySet()){
                if(entry.getKey().startsWith("rm")){
                    bw.write(entry.getKey() + "\n");
                }
                firstFileList.add(entry.getValue());
            }
            bw.flush();

            //再次获取经过文件名更改后的filePath里面文件名
            firstFileList = listDirectory(sourceFile);
            //生成需要创建的目录map
            Map<String, String> createDirMap = generateDirectory(firstFileList, fileTitle);
            //生成创建目录命令的list
            List<String> createDirList = generateMkdirConnand(createDirMap);
            //将创建目录的命令写入文件
            for(String cmd : createDirList) {
                bw.write(cmd + "\n");
            }
            bw.flush();
            //生成压缩视频的map
            firstFileList = rmFilePathSpace(listDirectory(sourceFile));
            Map<String, String> videoMap = getVideoMap(firstFileList, fileTitle);
            //生成压缩视频命令list
            List<String> compressList = generateCompileCommand(videoMap);
            //将视频压缩命令写入文件
            for(String cmd : compressList) {
                bw.write(cmd + "\n");
            }
            bw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }


    public static void main(String[] args) throws Exception {
//        listDirectory(new File("/Users/zjm/Documents/vedio/前端小白入门/前端小白入门1"));
//        listDirectory(new File("/Users/zjm/Documents/vedio/前端小白入门/前端小白入门2"));
        generateBashFile("/Users/zjm/Documents/vedio/java企业级电商项目架构演进之路Tomcat集群和Redis分布式", "java企业级电商项目架构演进之路Tomcat集群和Redis分布式", "/Users/zjm/Downloads/java企业级电商项目架构演进之路Tomcat集群和Redis分布式.sh");
//        getMap("/Users/zjm/Downloads/python分布式爬虫list.txt", "/Users/zjm/Downloads/python分布式爬虫list1.txt");
       /* try {
            FileUtils.listDirectory(new File("/Users/zjm/Documents/vedio/vue-elem-ys/第09章项目实战-ratings评价列表页实现"));

        } catch (Exception e) {
            e.printStackTrace();
        }*/
//        /Users/zjm/Documents/vedio/vue.js饿了吗/第1章 课程简介
        /*String s1 = "/Users/zjm/Documents/vedio/vue.js饿了吗/第1章-课程简介/2-2\\\\ 课程安排.avi";
        String s2 = "/Users/zjm/Documents/vedio/vue.js饿了吗/第1章-课程简介/2-2课程安排.avi";
        String command = "mv " + s1 + " " + s2;
        try {
            Process ps = Runtime.getRuntime().exec(command);
            InputStreamReader reader = new InputStreamReader(ps.getInputStream());
            BufferedReader bf = new BufferedReader(reader);
            String line;
            while((line = bf.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*InputStreamReader is = null;
        InputStreamReader is1 = null;
        BufferedReader bf = null;
        BufferedReader bf1 = null;
        BufferedWriter writer = null;
        try {
            File file = new File("/Users/zjm/Downloads/list.txt");
            File file1 = new File("/Users/zjm/Downloads/list1.txt");
            File file2 = new File("/Users/zjm/Downloads/test1.sh");
            is = new InputStreamReader(new FileInputStream(file));
            is1 = new InputStreamReader(new FileInputStream(file1));
            bf = new BufferedReader(is);
            bf1 = new BufferedReader(is1);
            writer = new BufferedWriter(new FileWriter(file2));
            String line;
            String line1;
            String s;
            while ((line = bf.readLine()) != null && (line1 = bf1.readLine()) != null) {
                s = "mv " + line + " " + line1;
                System.out.println(s);
                writer.write(s + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(writer != null){
                try{
                    writer.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(is != null){
                try{
                    is.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(is1 != null){
                try{
                    is1.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(bf != null){
                try{
                    bf.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(bf1 != null){
                try{
                    bf1.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }*/
        String s = "us/fs/rew/你哈佛/fds.text";
        System.out.println(s.substring(0, s.lastIndexOf("/")) + "-ys");
    }
}
