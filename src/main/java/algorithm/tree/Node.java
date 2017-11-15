package algorithm.tree;

/**
 * 节点
 * Created by zjm on 11/11/2017.
 */
public class Node {

    //左节点
    private Node leftNode;

    //右节点
    private Node rightNode;

    //值
    private int value;

    //父节点
    private Node parentNode;

    //get and set methods

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }
}
