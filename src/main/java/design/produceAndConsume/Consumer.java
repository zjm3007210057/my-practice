package design.produceAndConsume;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 * Created by zjm on 18/04/2018.
 */
public class Consumer implements Runnable {

    /** 阻塞队列 */
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            String msg;
            while(!(msg = (String)queue.take()).equals("exit")){
                Thread.sleep(10);
                System.out.println("消费消息：" + msg);
            }
        }catch(InterruptedException e){

        }
    }
}
