package netty.chapter1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by zhangjianming on 2016/9/20.
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        System.out.println("报告");
        System.out.println("信息：有一客户端连接到服务端");
        System.out.println("IP：" + socketChannel.localAddress().getHostName());
        System.out.println("Port:" + socketChannel.localAddress().getPort());
        System.out.println("报告完毕");
    }
}
