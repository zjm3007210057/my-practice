package algorithm.tree;

/**
 * 二叉搜索树的实现，二叉搜索树和二叉堆有一点不同，即它不一定是完全二叉树
 * Created by zjm on 10/11/2017.
 */
public class BinarySearchTree extends BinaryTree{

    //二叉搜索树里面所含节点的个数
    private int count;

    //跟节点
    private Node root;

    //构造函数
    public BinarySearchTree() {
        count = 0;
    }

    /**
     * 增添元素
     * @param item 元素
     */
    public void addItem(int item){
        if(root == null){
            root = assembleNode(null, item);
            count++;
            return;
        }
        Node tmp = root;
        Node parent = null;
        while(tmp != null){
            parent = tmp;
            if(tmp.getValue() < item){
                //待插入的值大于跟节点，往右子树走
                tmp = tmp.getRightNode();
            }else if(tmp.getValue() > item){
                //待插入的值小于跟节点，往左子树走
                tmp = tmp.getLeftNode();
            }else{
                //待插入的值等于跟节点，直接返回（如果插入的不是单个数值而是一个字典，则可以根据key的值跟新value）
                //当插入的是map(key, value),发现key存在后直接跟新value
                //即：map.put(key, newValue)
                return;
            }
        }
        assembleNode(parent, item);
        count++;
    }

    /**
     * 元素item是否存在于二叉搜索树中
     * @param item
     * @return
     */
    public boolean isExisted(int item){
        if(root == null){
            return false;
        }
        while(root != null){
            if(root.getValue() < item){
                //从右子树寻找
                root = root.getRightNode();
            }else if(root.getValue() > item){
                //从左子树寻找
                root = root.getLeftNode();
            }else {
                return true;
            }
        }
        return false;
    }

    //获取二叉搜索树里面节点的个数
    public int getCount(){
        return this.count;
    }

    /**
     * 获取跟节点
     * @return 根节点
     */
    public Node getRoot(){
        return this.root;
    }

}
