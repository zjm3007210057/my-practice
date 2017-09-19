package IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 视频压缩
 * Created by zjm on 01/09/2017.
 */
public class VideoCompress {

    private static String vedioCompressFileList;

    private static String bashFile;

    /**
     * 生成视频压缩的bash脚本
     * @param map
     */
    public static void generateVedioCompressBash(Map<String, String> map){
        File file = new File(bashFile);
        BufferedWriter bw = null;
        String line = null;
        try{
            bw = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : map.entrySet()){
                line = "ffmpeg -i " + entry.getKey() + " -vcodec libx264 -preset fast -crf 28 -y -acodec libmp3lame -ab 32k " + entry.getValue();
                System.out.println(line);
                bw.write(line + "\n");
            }
        }catch(IOException e){
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
    }

    /**
     * 生成视频压缩文件列表
     * @param map
     */
    public static void getVedioCompressFileList(Map<String, String> map) {
        File file = new File(vedioCompressFileList);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        bashFile = "/Users/zjm/Documents/vedio/玩转算法面试leetcode题库分门别类详细解析-ys/execute.sh";
        String dir = "/Users/zjm/Documents/vedio/玩转算法面试leetcode题库分门别类详细解析";
        List<String> list = FileUtils.listDirectory(new File(dir));
//        Map<String, String> map = FileUtils.getMap("/Users/zjm/Downloads/python分布式爬虫list.txt", "/Users/zjm/Downloads/python分布式爬虫list1.txt");
//        generateVedioCompressBash(list);
    }
}
