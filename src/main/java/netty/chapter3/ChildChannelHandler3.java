package netty.chapter3;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * http://www.itstack.org/?post=7
 * 1、在netty中能否有自动的把接收的Bytebuf数据转String，不需要我手动处理？
 答：有，可以在管道中添加一个StringDecoder。
 2、在网络传输过程中有半包粘包的问题，netty能解决吗？
 答：能，netty提供了很丰富的解码器，在正确合理的使用下就能解决半包粘包问题。
 3、常用的String字符串下有什么样的解码器呢？
 答：不仅在String下有处理半包粘包的解码器在处理其他的数据格式也有，其中谷歌的protobuf数据格式就是其中一个。
 对于String的有一下常用的三种：
 1、LineBasedFrameDecoder            基于换行
 2、DelimiterBasedFrameDecoder      基于指定字符串
 3、FixedLengthFrameDecoder         基于字符串长度

 * Created by zhangjianming on 2016/9/20.
 */
public class ChildChannelHandler3 extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel e) throws Exception {

        System.out.println("报告");
        System.out.println("信息：有一客户端链接到本服务端");
        System.out.println("IP:" + e.localAddress().getHostName());
        System.out.println("Port:" + e.localAddress().getPort());
        System.out.println("报告完毕");

        // 解码器
        // 基于换行符号
//        e.pipeline().addLast(new LineBasedFrameDecoder(1024));

        // 基于指定字符串【换行符，这样功能等同于LineBasedFrameDecoder】
//		e.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, false, Delimiters.lineDelimiter()));

        // 基于最大长度
//		e.pipeline().addLast(new FixedLengthFrameDecoder(4));

        // 解码转Sring
        e.pipeline().addLast(new StringDecoder());

        // 在管道中添加我们自己的接收数据实现方法
        e.pipeline().addLast(new MyServerHandler3());

    }
}
