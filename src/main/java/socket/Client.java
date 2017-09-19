package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by zhangjianming on 2016/9/21.
 */
public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        try{
            socket = new Socket("localhost", 8888);
            //获取输出流,向服务器发送信息
            OutputStream os = socket.getOutputStream();//字节流
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：admin； 密码：123");
            pw.flush();
            socket.shutdownOutput();
            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(is);
            String info = null;
            while((info = reader.readLine()) != null){
                System.out.println("我是客户端，服务器说：" + info);
            }
            is.close();
            reader.close();
            pw.close();
            os.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
