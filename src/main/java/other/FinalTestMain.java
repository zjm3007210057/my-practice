package other;

/**
 * Created by zhang.jianming on 2016/12/26.
 */
public class FinalTestMain {

    public static void main(String[] args)throws ClassNotFoundException {
        System.out.println(FinalTest.str);
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        cl.loadClass("FinalTest");
        System.out.println("系统加载FinalTest类");
        Class.forName("FinalTest");
    }
}

class FinalTest {

    static{
        System.out.println("静态初始化！");
    }

    static final String str = "this is test for final";

}
