package socket.block;

import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.jni.Proc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created by zjm on 2017/3/19.
 */
public class MultiThreadBlockingIODemo {

    public void multiThreadBlocking(){
        try{
            ServerSocket serverSocket = new ServerSocket(10029);
            Thread thread = new Thread(new Acceptor(serverSocket));
            thread.start();
            Scanner scanner = new Scanner(System.in);
            scanner.next();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    class Acceptor implements Runnable{
        private ServerSocket serverSocket;

        public Acceptor(ServerSocket serverSocket){
            this.serverSocket = serverSocket;
        }

        public void run(){
            while(true){
                Socket socket = null;
                try{
                    socket = serverSocket.accept();
                    if(socket != null){
                        System.out.println("accept socket : " + socket.getRemoteSocketAddress().toString());
                        Thread thread = new Thread(new Processor(socket));
                        thread.start();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class Processor implements Runnable{
        private Socket socket;

        public Processor(Socket socket){
            this.socket = socket;
        }

        public void run(){
            try{
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = null;
                while(true){
                    line = in.readLine();
                    System.out.println("accept message : " + line);
                    if(StringUtils.equals(line, "end")){
                        break;
                    }
                    socket.sendUrgentData(0xff);
                    Thread.sleep(5000);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }catch(SocketException e){
                System.out.println("client broke down");
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                try{
                    socket.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
