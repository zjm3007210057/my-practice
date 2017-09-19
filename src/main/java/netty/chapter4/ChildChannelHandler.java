package netty.chapter4;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by zhangjianming on 2016/10/19.
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel e) throws Exception {

        System.out.println("客户端链接到服务端");

    }
}
