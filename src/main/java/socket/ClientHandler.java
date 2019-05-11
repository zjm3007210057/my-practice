package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by zjm on 2019/3/19.
 */
public class ClientHandler {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        //如果不新起线程，后面的doStart方法，即客户端读写就会阻塞前面Server类里面的doStart->accept方法，导致ServerSocket永远无法接收新的客户端连接
        new Thread(() -> doStart()).start();
    }

    public void doStart() {
        try {
            InputStream stream = socket.getInputStream();
            while(true) {
                byte[] date = new byte[1024];
                int len;
                while((len = stream.read(date)) != -1){
                    String msg = new String(date, 0, len);
                    System.out.println("我是服务器，客户端说：" + msg);
                    socket.getOutputStream().write(date);
                }
            }
        } catch (IOException e) {
            System.out.println("获取socket输入流错误");
            e.printStackTrace();
        }
    }
}
