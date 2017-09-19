package netty.multClient.main;

import netty.multClient.heartbeat.ClientHeartbeatUtil;
import netty.multClient.thread.ClientThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 第二个客户端
 *
 */
public class SecondClientMain {
	
	private static final int SEND_MILLISECOND = 3000;
	
	//单线程池,只与一个Server连接,减少开销
	private static final ExecutorService service = Executors.newSingleThreadExecutor();
	
	public static void main(String[] args) {
		
		try {
			ClientThread clientThread = new ClientThread("client2");
			service.submit(clientThread);
			//启动心跳
			ClientHeartbeatUtil util = new ClientHeartbeatUtil(SEND_MILLISECOND);
			util.start(clientThread.getName());
		} catch (Exception e) {
			System.out.println("unknow exception: " + e.getMessage());
		}
		

	}
}
