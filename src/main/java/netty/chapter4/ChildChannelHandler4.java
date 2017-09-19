package netty.chapter4;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by zhangjianming on 2016/9/21.
 */
public class ChildChannelHandler4 extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        System.out.println("报告,有一个客户端连接到本服务器");
        System.out.println("IP:" + socketChannel.localAddress().getHostName());
        System.out.println("Port" + socketChannel.localAddress().getPort());
        // 基于换行符号
        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        //基于指定字符串【换行符，这样功能等同于LineBasedFrameDecoder】
//        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, false, Delimiters.lineDelimiter()));
        //基于最大长度
//        socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(4));
        //解码转String
        socketChannel.pipeline().addLast(new StringDecoder());
        //在管道中添加我们自己的接受数据实现方法
        socketChannel.pipeline().addLast(new MyServerHandler4());
    }
}
