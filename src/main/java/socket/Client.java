package socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by zhangjianming on 2016/9/21.
 */
public class Client {

    private static final int PORT = 8000;

    private static final int SLEEP = 5000;

    public static void main(String[] args) {
        try{
            final Socket socket = new Socket("localhost", PORT);
            new Thread(() -> {
                System.out.println("客户端启动成功");
                String msg = "hello world \\r\\n";
                while(true) {
                    try {
                        System.out.println("客户端发送数据：" + msg);
                        socket.getOutputStream().write(msg.getBytes());
                    } catch (IOException e) {
                        System.out.println("socket写数据出错");
                        e.printStackTrace();
                    }
                    sleep();
                }
            }).start();
            /*//获取输出流,向服务器发送信息
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
            os.close();*/
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
