package algorithm.queue2stack;

import algorithm.exception.QueueEmptyException;

/**
 * 采用循环数组的方式实现队列
 * Created by zjm on 22/11/2017.
 */
public class ArrayQueue<T> implements Queue<T> {

    /**
     * 数组来存储队列元素，使用的是循环数组
     */
    private Object[] datas;

    /**
     * 队列元素的个数
     */
    private int size;

    /**
     * 头指针
     */
    private int preIndex;

    /**
     * 尾指针
     */
    private int lastIndex;

    /**
     * 队列的容量
     */
    private int capacity;

    /**
     * 队列默认容量
     */
    private int DEFAULT_CAPACITY = 8;

    /**
     * 无参构造函数
     */
    public ArrayQueue() {
        new ArrayQueue(DEFAULT_CAPACITY);
    }

    /**
     * 构造函数
     * @param capacity 队列初始容量
     */
    public ArrayQueue(int capacity) {
        if(capacity < 0){
            throw new QueueEmptyException("队列的元素不能为负值!");
        }
        this.capacity = capacity;
        datas = new Object[capacity];
        size = 0;
        preIndex = 0;
        lastIndex = 0;
    }

    /**
     * @see Queue#getSize()
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @see Queue#enQueue(Object)
     * @param data 数据
     */
    public void enQueue(T data) {
        //如果队列元素达到数组的容量，进行扩容
        if(size >= capacity){
            //扩容的数组容量为之前的两倍
            Object[] tmp = new Object[2 * capacity];
            //判断数组中的尾指针是否已经折返，表现为数值小于头指针，尾指针表示元素将要插入的位置
            //ex:数组[2, 3, 4, 0, 0, 0....],此时尾指针的位置为3，表示入队的元素将放在数组下标为3的位置
            if(lastIndex <= preIndex && lastIndex != 0){
                //将数组中的元素拷贝到新开辟的数组当中，因为尾指针已经折返，这时需要先将头指针（也是尾指针）的元素到最后的元素先
                //拷贝到新数组中，然后将起始位置到尾指针的元素拷贝到新数组中
                //ex：考虑已经满的数组[6, 7, 8, 9, 1, 2]，假定尾指针（也是头指针）现在下标4的位置，也就是数值为1的元素位置（数组下标从0开始）
                //插入新元素到尾指针位置之前先将数组元素1，2拷贝到新数组中，然后将6，7，8，9拷贝到新的数组中，
                //即插入到新数组中后为[1, 2, 6, 7, 8, 9, ......],此时再将头指针设为0，表示下次出队弹出第1个元素，将尾指针设为capacity
                System.arraycopy(datas, lastIndex, tmp, 0, capacity - lastIndex);
                System.arraycopy(datas, 0, tmp, capacity - lastIndex, lastIndex);
            }else {
                System.arraycopy(datas, 0, tmp, 0, capacity);
            }
            datas = tmp;
            preIndex = 0;
            lastIndex = capacity;
            datas[lastIndex++] = data;
            capacity *= 2;
            size++;
            return;
        }
        if(lastIndex >= capacity - 1){
            datas[lastIndex] = data;
            lastIndex = 0;
        }else {
            datas[lastIndex++] = data;
        }
        size++;
    }

    /**
     * @see Queue#deQueue()
     * @return
     * @throws QueueEmptyException
     */
    public T deQueue() {
        if(isEmpty()){
            throw new QueueEmptyException("队列为空，不能取出元素");
        }
        T res;
        if(preIndex >= capacity - 1){
            res = (T)datas[preIndex];
            preIndex = 0;
        }else{
            res = (T)datas[preIndex++];
        }
        size--;
        return res;
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
     * @throws QueueEmptyException
     */
    public T peek() {
        if(isEmpty()){
            throw new QueueEmptyException("队列为空，不能取出元素");
        }
        return (T)datas[preIndex];
    }

}
