package design.extend;

/**
 * Created by zjm on 16/01/2018.
 */
public class Child extends Parent {

    @Override
    public void print() {
        System.out.println("这是子类的一个打印方法");
//        super.print();
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.print();
    }
}
