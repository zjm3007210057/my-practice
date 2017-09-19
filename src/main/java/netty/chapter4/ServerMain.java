package netty.chapter4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by zjm on 2016/10/26.
 */
public class ServerMain {

    public void bind(int port)throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new MyChildChannelHandler());
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        }finally{
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    class MyChildChannelHandler extends ChannelInitializer<SocketChannel>{
        protected void initChannel(SocketChannel channel)throws Exception{
            channel.pipeline().addLast(new LineBasedFrameDecoder(1024));//解决粘包
            channel.pipeline().addLast(new StringDecoder());
            channel.pipeline().addLast(new TimeClientHandler());
        }
    }

    public static void main(String[] args)throws Exception{
        try{
            int port = 9098;
            new ServerMain().bind(port);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
