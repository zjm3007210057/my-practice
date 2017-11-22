package algorithm.queue2stack;

import algorithm.exception.QueueEmptyException;

/**
 * 队列接口
 * Created by zjm on 22/11/2017.
 */
public interface Queue<T> {

    /**
     * 获取队列的元素个数
     * @return
     */
    int getSize();

    /**
     * 元素入队
     * @param data 数据
     */
    void enQueue(T data);

    /**
     * 第一个元素出队
     * @return
     */
    T deQueue() throws QueueEmptyException;

    /**
     * 是否为空队列
     * @return
     */
    boolean isEmpty();

    /**
     * 取第一个元素
     * @return
     */
    T peek() throws QueueEmptyException;
}
