package netty.chapter10;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created by zjm on 2016/10/27.
 */
public class HttpFileServer {

    private static  final String DEFAULT_URL = "/src/main/java/com/netty/";

    public void bind(final int port, final String url) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch)throws Exception{
                        ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                        ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
                        ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                        ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                        ch.pipeline().addLast("fileServerHandler",new HttpFileServerHandler(url));
                    }
                });
            ChannelFuture f = b.bind("localhost", port).sync();
            System.out.println("Http 文件目录服务器启动，网址是：" + "localhost:" + port + url);
            f.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception{
        int port = 8080;
        String url = DEFAULT_URL;
        new HttpFileServer().bind(port, url);
    }
}
