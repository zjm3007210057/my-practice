package other;

/**
 * Created by zhang.jianming on 2017/1/18.
 */
public class TestInterface {

    public Test getTest(){
        return new Test() {
            @Override
            public void test() {
                System.out.println("test");
            }
        };
    }

    public static void main(String[] args) {
        TestInterface test = new TestInterface();
        test.getTest().test();
        System.out.println(test.getTest());
    }
}
