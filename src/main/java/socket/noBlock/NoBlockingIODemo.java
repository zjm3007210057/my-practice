package socket.noBlock;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by zjm on 2017/3/19.
 */
public class NoBlockingIODemo {

    Selector selector = null;

    private ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);

    public void testNioNoBlockSelector(){

        try{
            selector = Selector.open();
            SocketAddress address = new InetSocketAddress(10030);
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.socket().bind(address);
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    handleKey(key);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void handleKey(SelectionKey key){
        ServerSocketChannel server = null;
        SocketChannel client = null;
        try{
            if(key.isAcceptable()){
                server = (ServerSocketChannel)key.channel();
                client = server.accept();
                System.out.println("accept client : " + client.socket().getRemoteSocketAddress().toString());
                client.configureBlocking(false);
                client.register(selector, SelectionKey.OP_READ);
            }
            if(key.isReadable()){
                client = (SocketChannel)key.channel();
                receiveBuffer.clear();
                int count = client.read(receiveBuffer);
                if(count > 0){
                    String receiveString = new String(receiveBuffer.array(), 0, count);
                    System.out.println("server accept client data : " + receiveString);
                    client.register(selector, SelectionKey.OP_READ);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
