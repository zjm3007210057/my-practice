package design.produceAndConsume;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zjm on 18/04/2018.
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        executor.execute(producer);
        executor.execute(consumer);
        executor.shutdown();
    }
}
