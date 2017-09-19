package netty.chapter4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by zjm on 2016/10/26.
 */
public class TimeClientHandler extends ChannelHandlerAdapter{

    private int count;

    private byte[] req;

    public TimeClientHandler(){
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf msg = null;
        for(int i=0; i<100; i++){
            msg = Unpooled.buffer(req.length);
            msg.writeBytes(req);
            ctx.writeAndFlush(msg);
        }
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf)msg;
//        req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
        String body = (String)msg;
        System.out.println("Now is : " + body + " ; the count is : " + ++count);
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        ctx.close();
    }
}
