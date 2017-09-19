package IO.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by zhangjianming on 2016/10/24.
 */
public class MyServer {

    private String ip;
    private int port;
    private IoHandler ioHandler;
    private ByteBuffer buffer;

    public void myMethod()throws Exception{
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(ip, port));
        Selector selector = Selector.open();
        new Thread(new ReactorTask()).start();
        SelectionKey skey = channel.register(selector, SelectionKey.OP_ACCEPT, ioHandler);
        int num = selector.select();
        Set<SelectionKey> keys = selector.selectedKeys();
        Iterator it = keys.iterator();
        while(it.hasNext()){
            SelectionKey selectionKey = (SelectionKey) it.next();
            // TODO: 2016/10/24  逻辑
        }
        SocketChannel socketChannel = channel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.socket().setReuseAddress(true);
        SelectionKey ckey = socketChannel.register(selector, SelectionKey.OP_READ, ioHandler);
        int res = socketChannel.read(buffer);
    }

    class ReactorTask implements Runnable{
        public void run(){
            System.out.println("工作中");
        }
    }

    class IoHandler{

    }
}
