package netty.chapter4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by zjm on 2016/10/26.
 */
public class ClientMain {

    public void connect(String inetHost,int inetPort) throws Exception{

        EventLoopGroup group = new NioEventLoopGroup();

        try {

            Bootstrap b = new Bootstrap();

            b.group(group);								//group 组
            b.channel(NioSocketChannel.class);			//channel 通道
            b.option(ChannelOption.TCP_NODELAY, true);	//option 选项
            b.handler(new MyChildChannelHandler());		//handler 处理

            //发起异步链接
            ChannelFuture f = b.connect(inetHost, inetPort);

            //等待客户端链路关闭
            f.channel().closeFuture().sync();

        } finally{
            group.shutdownGracefully();
        }

    }

    class MyChildChannelHandler extends ChannelInitializer<SocketChannel>{
        public void initChannel(SocketChannel ch){
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));//解决粘包
            ch.pipeline().addLast(new StringDecoder());
            ch.pipeline().addLast(new TimeClientHandler());
        }
    }

    public static void main(String[] args)throws Exception{
        try{
            int port = 9098;
            new ClientMain().connect("localhost", port);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
