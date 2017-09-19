package IO;

/**
 * Created by zjm on 15/09/2017.
 */
public class TestMain {

    public static void main(String[] args) {
//        /Users/zjm/Documents/vedio/vue-elem-ys/第09章项目实战-ratings评价列表页实现
        String s = "9-1 ratings组件开发-overview开发（1）";
        String ss = s.replaceAll(" ", "\\\\ ").replaceAll("（", "").replaceAll("）", "");
        System.out.println(s);
        System.out.println(ss);
        System.out.println("\\");
    }
}
