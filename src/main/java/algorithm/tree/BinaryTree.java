package algorithm.tree;

/**
 * 二叉树
 * Created by zjm on 10/11/2017.
 */
public class BinaryTree {

    //左子树
    private BinaryTree leftChild;

    //右子树
    private BinaryTree rightChild;

    //父节点
    private BinaryTree parent;

    //值
    private int key;

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTree rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTree getParent() {
        return parent;
    }

    public void setParent(BinaryTree parent) {
        this.parent = parent;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
