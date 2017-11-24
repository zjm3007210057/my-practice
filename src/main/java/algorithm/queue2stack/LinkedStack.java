package algorithm.queue2stack;

/**
 * 链表实现栈
 * Created by zjm on 24/11/2017.
 */
public class LinkedStack<T> implements Stack<T> {

    /**
     * 尾节点
     */
    private Node<T> lastNode;

    /**
     * 栈的深度
     */
    private int depth;

    public LinkedStack() {
        lastNode = null;
        depth = 0;
    }

    /**
     * @see Stack#push(Object)
     * @param data
     */
    public void push(T data) {
        lastNode = NodeAssemble.assembleNode(lastNode, data);
        depth++;
    }

    /**
     * @see Stack#pop()
     * @return
     */
    public T pop() {
        if(isEmpty()){
            throw new RuntimeException("栈已经为空，不能弹出元素!");
        }
        T res = lastNode.getDate();
        lastNode = lastNode.getPre();
        depth--;
        return res;
    }

    /**
     * @see Stack#isEmpty()
     * @return
     */
    public boolean isEmpty() {
        return depth == 0;
    }

    /**
     * @see Stack#getDepth()
     * @return
     */
    public int getDepth() {
        return this.depth;
    }

    /**
     * @see Stack#peek()
     * @return
     */
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("栈已经为空，不能弹出元素!");
        }
        return lastNode.getDate();
    }
}
