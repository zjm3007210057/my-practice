package netty.chapter4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * Created by zjm on 2016/10/26.
 */
public class TimeServerHandler extends ChannelHandlerAdapter{

    private int count;

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
//        ByteBuf buf = (ByteBuf)msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "utf-8").substring(0, req.length-System.getProperty("line.separator").length());
        String body = (String)msg;
        System.out.println("服务端收到时间请求 : " + body + "; 请求数目 : " + ++count);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
        currentTime = currentTime + System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        ctx.close();
    }
}
