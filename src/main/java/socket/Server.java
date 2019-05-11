package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhangjianming on 2016/9/21.
 */
public class Server {

    private static final int PORT = 8000;

    private int port;

    private ServerSocket serverSocket;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功，端口是：" + port);
            //防止后面的while true阻塞主线程
            new Thread(() -> doStart()).start();
        } catch (IOException e) {
            System.out.println("服务端启动失败");
            e.printStackTrace();
        }
    }

    public void doStart() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("服务端接受客户端连接成功");
                new ClientHandler(socket).start();
            } catch (IOException e) {
                System.out.println("服务端接受客户端连接失败");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /*try {
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
        }*/
        Server server = new Server(PORT);
        server.start();
    }
}
