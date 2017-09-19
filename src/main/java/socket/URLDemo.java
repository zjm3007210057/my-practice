package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zhangjianming on 2016/9/21.
 */
public class URLDemo {

    public static void main(String[] args){
        URL imooc = null;
        try {
            imooc = new URL("http://www.imooc.com");
            URL url = new URL(imooc, "/index.html?username=tom#test");//#号后面表示描点
            System.out.println("协议：" + url.getProtocol());
            System.out.println("主机：" + url.getHost());
            //如果未指定端口号，则使用默认端口号，此时返回值为-1
            System.out.println("端口:" + url.getPort());
            System.out.println("文件路径" + url.getPath());
            System.out.println("文件名" + url.getFile());
            System.out.println("相对路径" + url.getRef());
            System.out.println("查询字符串" + url.getQuery());
            /**
             * 输出结果：
             协议：http
             主机：www.imooc.com
             端口:-1
             文件路径/index.html
             文件名/index.html?username=tom
             相对路径test
             查询字符串username=tom
             */
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //通过URL的openStream方法获取URL对象所表示的资源的字节输入流
        InputStream is = null;
        try {
            is = imooc.openStream();
            //将字节输入流转换成字符输入流
            InputStreamReader reader = new InputStreamReader(is);
            //为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(reader);
            String data = br.readLine();
            while(data != null){
                System.out.println(data);
                data = br.readLine();
            }
            is.close();
            reader.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
