package algorithm.queue2stack;

/**
 * 队列和栈使用的节点
 * Created by zjm on 22/11/2017.
 */
public class Node<T> {

    /**
     * 节点元素
     */
    private T date;

    /**
     * 下一个节点
     */
    private Node next;

    /**
     * 上一个节点
     */
    private Node pre;

    //get and set methods

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }
}
