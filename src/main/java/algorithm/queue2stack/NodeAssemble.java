package algorithm.queue2stack;

/**
 * 组装节点类
 * Created by zjm on 24/11/2017.
 */
public class NodeAssemble {

    /**
     * 组装节点
     * @param pre 前一个节点
     * @param date 数据元素
     * @return node 新增的节点
     */
    public static <T>Node assembleNode(Node pre, T date){
        Node node = new Node();
        node.setPre(pre);
        node.setDate(date);
        node.setNext(null);
        return node;
    }
}
