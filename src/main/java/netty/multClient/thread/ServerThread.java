package netty.multClient.thread;

import netty.multClient.handler.ServerHandler;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import static org.jboss.netty.channel.Channels.pipeline;

/**
 * 服务器线程
 */
public class ServerThread implements Runnable {

	//服务器处理工厂
	private static final NioServerSocketChannelFactory FACTORY = new NioServerSocketChannelFactory(
			Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

	//服务器启动器
	private static final ServerBootstrap bootstrap = new ServerBootstrap(
			FACTORY);

	//处理客户端pipeline
	private static final ChannelPipelineFactory PIPELINE_FACTORY = new ChannelPipelineFactory() {

		public ChannelPipeline getPipeline() throws Exception {
			ChannelPipeline pipleline = pipeline();
			pipleline.addLast("encode", new StringEncoder());
			pipleline.addLast("decode", new StringDecoder());
			pipleline.addLast("handler", new ServerHandler());//设置服务器handler
			return pipleline;
		}
	};

	static {
		bootstrap.setPipelineFactory(PIPELINE_FACTORY);
	}

	public void run() {
		bootstrap.bind(new InetSocketAddress(8080));
	}

}
