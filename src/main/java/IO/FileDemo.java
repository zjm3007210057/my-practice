package IO;

import java.io.File;

/**
 * Created by zhangjianming on 2016/9/22.
 */
public class FileDemo {

    public static void main(String[] args) {
        File file = new File("E:\\work\\东方明珠文件");
        System.out.println(file.exists());
    }


}
