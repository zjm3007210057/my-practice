package algorithm.queue2stack;

import algorithm.exception.QueueEmptyException;

/**
 * 自定义实现的队列
 * Created by zjm on 22/11/2017.
 */
public class LinkedQueue<T> implements Queue<T>{

    /**
     * 队列中的头元素
     */
    private Node<T> head;

    /**
     * 尾指针
     */
    private Node<T> lastPoint;

    /**
     * 队列的规模
     */
    private int size;


    /**
     * 初始化size和head
     */
    public LinkedQueue() {
        size = 0;
        head = null;
        lastPoint = null;
    }

    /**
     * 组装节点
     * @param pre 前一个节点
     * @param date 数据元素
     * @return node 新增的节点
     */
    private Node assembleNode(Node pre, T date){
        Node node = new Node();
        node.setPre(pre);
        node.setDate(date);
        node.setNext(null);
        return node;
    }

    /**
     * @see Queue#getSize()
     * @return
     */
    public int getSize() {
        return 0;
    }

    /**
     * @see Queue#enQueue(T)
     * @param data 数据
     */
    public void enQueue(T data) {
        if(head == null){
            assembleNode(head, data);
            size++;
            lastPoint = head;
            return;
        }
        lastPoint = assembleNode(lastPoint, data);
        size++;
    }

    /**
     * @see Queue#deQueue()
     * @return
     */
    public T deQueue() {
        if(head == null){
            throw new QueueEmptyException("队列为空队列，无法取出元素");
        }
        T data = head.getDate();
        head = head.getNext();
        head.setPre(null);
        size--;
        return data;
    }

    /**
     * @see Queue#isEmpty()
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @see Queue#peek()
     * @return
     */
    public T peek() {
        if(head == null){
            throw new QueueEmptyException("队列为空队列，无法获取头元素的值!");
        }
        return head.getDate();
    }
}
