package algorithm.queue2stack;

/**
 * 数组实现栈
 * Created by zjm on 24/11/2017.
 */
public class ArrayStack<T> implements Stack {

    /**
     * 数组保存栈中的元素
     */
    private Object[] datas;

    /**
     * 最后索引,指向下一个差元素插入的位置
     */
    private int lastIndex;

    /**
     * 栈的元素个数
     */
    private int deepth;

    /**
     * 栈的容量
     */
    private int capacity;

    /**
     * 栈默认容量
     */
    private int DEFAULT_CAPACITY = 8;

    /**
     * 无参构造函数
     */
    public ArrayStack() {
        new ArrayStack(DEFAULT_CAPACITY);
    }

    /**
     * 构造函数
     * @param capacity 栈的容量
     */
    public ArrayStack(int capacity) {
        if(capacity < 0){
            throw new RuntimeException("队列的元素不能为负值!");
        }
        this.capacity = capacity;
        datas = new Object[capacity];
        deepth = 0;
        lastIndex = 0;
    }

    /**
     * @see Stack#push(Object)
     * @param data
     */
    public void push(Object data) {
        //如果队列元素达到数组的容量，进行扩容
        if(deepth >= capacity){
            //扩容的数组容量为之前的两倍
            Object[] tmp = new Object[2 * capacity];
            //将原数组里的元素copy到新的数组中
            System.arraycopy(datas, 0, tmp, 0, capacity);
            datas = tmp;
            lastIndex = capacity;
            datas[lastIndex++] = data;
            capacity *= 2;
            deepth++;
            return;
        }
        datas[lastIndex++] = data;
        deepth++;
    }

    /**
     * @see Stack#pop()
     * @return
     */
    public T pop() {
        if(isEmpty()){
            throw new RuntimeException("栈已经为空，不能弹出元素!");
        }
        deepth--;
        return (T)datas[--lastIndex];
    }

    /**
     * @see Stack#isEmpty()
     * @return
     */
    public boolean isEmpty() {
        return deepth == 0;
    }

    /**
     * @see Stack#getDepth()
     * @return
     */
    public int getDepth() {
        return this.deepth;
    }

    /**
     * @see Stack#peek()
     * @return
     */
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("栈已经为空，不能弹出元素!");
        }
        return (T)datas[lastIndex - 1];
    }

}
