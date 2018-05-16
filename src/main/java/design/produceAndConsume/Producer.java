package design.produceAndConsume;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 * Created by zjm on 18/04/2018.
 */
public class Producer implements Runnable {

    /** 阻塞队列 */
    private BlockingQueue queue;

    public Producer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("启动生产者");
        for(int i=0; i<100; i++){
            try{
                queue.put("hello" + i);
                System.out.println("生产消息：hello" + i);
            }catch(InterruptedException e){

            }
        }
        try {
            queue.put("exit");
        } catch (InterruptedException e) {

        }
    }
}
