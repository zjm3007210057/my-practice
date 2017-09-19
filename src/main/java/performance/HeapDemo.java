package performance;

/**
 * Created by zjm on 2017/2/19.
 */
public class HeapDemo {

    private int size;
    private int[] heap;

    /**
     * 创建最大堆
     * @param heap
     * @param size
     */
    public void buildHeap(int[] heap, int size){
        int node = (size - 1) / 2;
        for(int i = node; i >= 0; i--){
            maxHeap(heap, i, size);
        }
    }

    /**
     * 生成最大堆
     * @param heap
     * @param index
     * @param size
     */
    public void maxHeap(int[] heap, int index, int size){
        int imax = index;
        int ileft = 2 * imax + 1;
        int iright = 2 * (imax + 1);
        if(ileft < size && heap[ileft] > heap[index]){
            imax = ileft;
        }
        if(iright < size && heap[iright] > heap[imax]){
            imax = iright;
        }
        if(imax != index){
            swap(heap, imax, index);
            maxHeap(heap, imax, size);
        }
    }

    /**
     * 交换数组两元素的值
     * @param array
     * @param start
     * @param end
     */
    public void swap(int[] array, int start, int end){
        int tmp = array[start] ^ array[end];
        array[start] = tmp ^ array[start];
        array[end] = tmp ^ array[end];
    }

    /**
     * 堆排序
     * @param heap
     * @return
     */
    public int[] sortHeap(int[] heap){
        int size = heap.length;
        buildHeap(heap, size);
        for(int i=size-1; i>0; i--){
            swap(heap, 0, i);
            maxHeap(heap, 0, i);
        }
        return heap;
    }
}
