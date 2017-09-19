package netty.chapter10;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created by zjm on 2016/10/27.
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest>{

    private final String url;

    public HttpFileServerHandler(String url){
        this.url = url;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

}
