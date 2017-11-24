package algorithm.queue2stack;

/**
 * 栈接口
 * Created by zjm on 24/11/2017.
 */
public interface Stack<T> {

    /**
     * 元素入栈
     * @param data
     */
    void push(T data);

    /**
     * 元素出栈
     * @return
     */
    T pop();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 获取栈里面的元素个数，即栈的大小
     * @return
     */
    int getDepth();

    /**
     * 查看栈顶的元素
     * @return
     */
    T peek();
}
