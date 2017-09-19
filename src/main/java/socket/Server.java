package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhangjianming on 2016/9/21.
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            //调用accept方法监听客户端连接
            System.out.println("***服务器即将启动，等待客户端的连接");
            Socket socket = serverSocket.accept();
            InputStreamReader is = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(is);
            String info = null;
            while((info = reader.readLine()) != null){
                System.out.println("我是服务器，客户端说：" + info);
            }
            socket.shutdownInput();
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎您");
            pw.flush();
            pw.close();
            os.close();
            is.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
