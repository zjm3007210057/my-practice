package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjm on 10/11/2017.
 */
public class BinarySearchTree {

    //二叉搜索树的大小
    private int size;

    //二叉搜索树里面所含节点的个数
    private int count;

    //二叉树存放的list
    private List<BinaryTree> list;

    //构造函数
    public BinarySearchTree(int size) {
        if(size < 1){
            throw new IllegalArgumentException("二叉所搜树的节点个数不能小于1");
        }
        this.size = size;
        count = 0;
        list = new ArrayList<>(size);
    }

    public void addItem(BinaryTree node){
        if(count >= size){
            List<> = new ArrayList<>(size * 2);
        }
    }

    //获取二叉搜索树里面节点的个数
    public int getCount(){
        return this.count;
    }
}
