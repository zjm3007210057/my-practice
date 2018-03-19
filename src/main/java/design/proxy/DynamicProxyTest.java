package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Dynamic Proxy Test
 * Created by zjm on 06/03/2018.
 */
public class DynamicProxyTest {

    interface IHello{
        void say();
    }

    static class Hello implements IHello{

        public void say() {
            System.out.println("Hello World !");
        }
    }

    static class DynamicProxy implements InvocationHandler{

        public Object object;

        public Object bind(Object object){
            this.object = object;
            return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                    object.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Welcome");
            Object o = method.invoke(object, args);
            return o;
        }
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.say();
    }

}
