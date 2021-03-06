package algorithm.tree;

import java.util.Random;

/**
 * 二叉树
 * Created by zjm on 10/11/2017.
 */
public class BinaryTree {

    //根节点
    private Node root;

    //二叉树的元素的个数
    private int count;

    //先序遍历二叉树，先遍历节点，然后左节点，最后右节点
    public void preSearch(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.getValue());
        preSearch(root.getLeftNode());
        preSearch(root.getRightNode());
    }

    //中序遍历二叉树，先遍历左子树，然后根节点，最后右子树
    public void midSearch(Node root){
        if(root == null){
            return;
        }
        midSearch(root.getLeftNode());
        System.out.println(root.getValue());
        midSearch(root.getRightNode());
    }

    //后序遍历二叉树，先遍历左子树，然后右子树，最后根节点
    public void postSearch(Node root){
        if(root == null){
            return;
        }
        postSearch(root.getLeftNode());
        postSearch(root.getRightNode());
        System.out.println(root.getValue());
    }

    //添加元素
    public void addItem(int item) {
        if (root == null) {
            assembleNode(null, item);
            count++;
            return;
        }
        Node tmp = root;
        while (tmp != null) {
            if (tmp.getLeftNode() == null) {
                Node node = assembleNode(tmp, item);
                tmp.setLeftNode(node);
            } else if (tmp.getParentNode() == null) {
                Node node = assembleNode(tmp, item);
                tmp.setLeftNode(node);
            }
            //随机选择左右子树
            if(new Random().nextBoolean()){
                tmp = tmp.getLeftNode();
            }else {
                tmp = tmp.getRightNode();
            }
        }
        count++;
    }

    //获取根节点
    public Node getRoot() {
        return root;
    }

    //获取元素的个数
    public int getCount() {
        return count;
    }

    //组装Node节点
    protected Node assembleNode(Node parentNode, int item) {
        Node node = new Node();
        node.setLeftNode(null);
        node.setRightNode(null);
        node.setValue(item);
        node.setParentNode(parentNode);
        return node;
    }
}
