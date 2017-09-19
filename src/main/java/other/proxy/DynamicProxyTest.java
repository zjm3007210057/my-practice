package other.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhang.jianming on 2016/12/26.
 */
public class DynamicProxyTest {

    interface IHello{
        void sayHello();
        void sayGoodBye();
    }

    static class Hello implements IHello{
        public void sayHello() {
            System.out.println("Say Hello !");
        }

        public void sayGoodBye() {
            System.out.println("Say GoodBye !");
        }
    }

    static class DynamicProxy implements InvocationHandler{

        Object object;

        Object bind(Object object){
            this.object = object;
            Object obj =  Proxy.newProxyInstance(object.getClass().getClassLoader(),
                    object.getClass().getInterfaces(), this);
            return obj;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Welcome to :");
            Object obj = method.invoke(object, args);
            return obj;
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello)new DynamicProxy().bind(new Hello());
        hello.sayHello();
        hello.sayGoodBye();
    }
}
