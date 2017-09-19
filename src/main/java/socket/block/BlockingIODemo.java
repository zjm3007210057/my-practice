package socket.block;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by zjm on 2017/3/19.
 */
public class BlockingIODemo {

    public void blockSocket() throws Exception{
        ServerSocket serverSocket = new ServerSocket(10028);
        Socket socket = null;
        try{
            while(true){
                socket = serverSocket.accept();
                System.out.println("accept socket : " + socket.getRemoteSocketAddress().toString());
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while(true){
                    String line = reader.readLine();
                    System.out.println("socket accept message : " + line);
                    if(StringUtils.equals(line, "end")){
                        break;
                    }
                    socket.sendUrgentData(0xff);
                }
            }
        }catch(SocketException e){
            System.out.println("client break down");
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            System.out.println("socket close : " + socket.getRemoteSocketAddress().toString());
            socket.close();
        }
    }
}
