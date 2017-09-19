package netty.singleClient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * Created by zhangjianming on 2016/10/20.
 */
public class TimeClientHandler extends ChannelHandlerAdapter {

    private static final Logger LOGGER = Logger.getLogger(TimeClientHandler.class.getName());
    private final ByteBuf firstMessage;

    public TimeClientHandler() {
        byte[] req = "query time order".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);// 将请求消息发送给服务端
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        LOGGER.warning("Unexpected exception from downstrema : "
                + cause.getMessage());
        ctx.close();
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("Now is : " + body);

    }
}
