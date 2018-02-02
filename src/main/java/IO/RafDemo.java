package IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by zhangjianming on 2016/9/22.
 */
public class RafDemo {

    public static void main(String[] args) throws IOException{
        File temp = new File("E:\\work\\temp");
        if(!temp.exists()){
            temp.mkdir();
        }
        File file = new File(temp, "raf.dat");
        if(!file.exists()){
            file.createNewFile();
        }
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        //指针的位置
        System.out.println(raf.getFilePointer());
        raf.write('A');//只写了一个字节
        System.out.println(raf.getFilePointer());
        raf.write('B');
        System.out.println(raf.getFilePointer());
        int i = 0x7fffffff;
        //用write方法每次只能写入一个字节，如果要把i写进去就得写4次
        raf.write(i>>>24);//高8位
        raf.write(i>>>16);//次高8位
        raf.write(i>>>8);//次高8位
        raf.write(i);//低8位
        System.out.println(raf.getFilePointer());
        //可以直接写入int
        raf.writeInt(i);//上面即是writeInt的源码
        System.out.println(raf.getFilePointer());
        String s = "中国";
        byte[] gbk = s.getBytes("gbk");
        raf.write(gbk);
        System.out.println(raf.getFilePointer());
        //读文件，必须把指针返回到最开始
        raf.seek(0);
        String str = null;
        while((str = raf.readLine()) != null){
            System.out.println(str);
        }
        raf.seek(0);
        byte[] buf = new byte[(int)raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));
        raf.close();

        String sss = "a/b/c.txt";
        System.out.println(sss.substring(0, sss.lastIndexOf("/")));
    }
}
