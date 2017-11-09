package algorithm.tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 最大堆
 * Created by zjm on 09/11/2017.
 */
public class MaxHeap {

    //使用数组来存储元素
    private Object[] objects;

    //堆的大小
    private int size;

    //堆中的元素个数
    private int count;

    //构造函数
    public MaxHeap(int size) {
        if(size < 1){
            throw new IllegalArgumentException("堆的大小不能小于1");
        }
        this.size = size;
        objects = new Object[size + 1];
        count = 0;
    }

    /**
     * 插入元素
     * @param o
     */
    public void add(Object o){
        if(count == 0){
            objects[++count] = o;
            return;
        }
        //扩容，每次新增一倍的空间
        if(count >= size){
            objects = Arrays.copyOf(objects, size * 2 + 1);
            size *= 2;
        }
        objects[++count] = o;
        shiftUp(o);
    }

    public Object getItem(){
        if(count == 0){
            return null;
        }
        Object o = objects[1];
        objects[1] = objects[count--];
        shiftDown(objects[1]);
        return o;
    }

    /**
     * 获取堆里面的元素个数
     * @return
     */
    public int getCount(){
        return this.count;
    }

    //获取堆里面的数组
    public Object[] getObjects() {
        return objects;
    }

    //元素上升操作，使加入新的元素后依然满足最大堆的性质
    private void shiftUp(Object o){
        int index = count;
        while(index >1 && compareTo(o, objects[index / 2]) > 0){
            objects[index] = objects[index / 2];
            objects[index / 2] = o;
            index /= 2;
        }
    }

    //元素下降操作，使得删除元素后堆依然维持最大堆的性质
    private void shiftDown(Object o){
        int index = 1;
        int point;
        Object max;
        while(2 * index <= count){
            max = objects[2 * index];
            point = 2 * index;
            if((2 * index < count) && compareTo(objects[2 * index + 1], objects[index * 2]) > 0){
                max = objects[2 * index + 1];
                point = 2 * index + 1;
            }
            if(compareTo(o, max) <= 0){
                objects[index] = objects[point];
                objects[point] = o;
            }
            index = point;
        }
    }

    /**
     * 对比两个数值，前者大于后者返回1，小于返回-1，等于返回0
     * @param object1
     * @param object2
     * @return
     */
    private int compareTo(Object object1, Object object2){
        if(object1 instanceof Integer){
            if((Integer)object1 < (Integer)object2){
                return -1;
            }else if((Integer)object1 > (Integer)object2){
                return 1;
            }else{
                return 0;
            }
        }
        if(object1 instanceof Long){
            if((Long)object1 < (Long)object2){
                return -1;
            }else if((Long)object1 > (Long)object2){
                return 1;
            }else{
                return 0;
            }
        }
        if(object1 instanceof Double){
            if((Double)object1 < (Double)object2){
                return -1;
            }else if((Double)object1 > (Double)object2){
                return 1;
            }else{
                return 0;
            }
        }
        if(object1 instanceof Float){
            if((Float)object1 < (Float)object2){
                return -1;
            }else if((Float)object1 > (Float)object2){
                return 1;
            }else{
                return 0;
            }
        }
        return String.valueOf(object1).compareTo(String.valueOf(object2));

    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        for(int i=1; i<11; i++){
            heap.add(new Random().nextInt(50));
        }
        Object[] arr = heap.getObjects();
        for(int i=1; i<11; i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println("==============");
        for(int i=1; i<11; i++){
            System.out.print(heap.getItem());
            System.out.print("  ");
        }
    }
}
