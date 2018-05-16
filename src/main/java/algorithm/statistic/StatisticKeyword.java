package algorithm.statistic;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * 统计关键字出现的次数并排序
 * Created by zjm on 01/04/2018.
 */
public class StatisticKeyword {

    /**
     * 统计file里面关键字出现的次数并从小到大排序，关键字根据list获取
     * @param keywords 关键字列表
     * @param file 原始文件
     * @return
     */
    public static Map<String, Integer> statistic(List<String> keywords, File file){
        if(CollectionUtils.isEmpty(keywords)){
            return null;
        }
        if(!file.exists()){
            return null;
        }
        BufferedReader bf = null;
        Map<String, Integer> map = new HashMap<>();
        String line;
        try{
            bf = new BufferedReader(new FileReader(file));
            while((line = bf.readLine()) != null){
                for(String keyword : keywords){
                    if(line.contains(keyword)){
                        if(map.get(keyword) == null){
                            map.put(keyword, 1);
                        }else {
                            map.put(keyword, map.get(keyword) + 1);
                        }
                    }
                }
            }
            if(MapUtils.isNotEmpty(map)){
                List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
                Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(bf != null){
                try{
                    bf.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return map;
    }
}
