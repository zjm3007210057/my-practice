package annotation.privilege.factory;

import annotation.privilege.Implement;
import annotation.privilege.Permission;
import annotation.privilege.dao.BaseDao;
import annotation.privilege.model.Role;
import annotation.privilege.model.RoleContext;

import java.lang.annotation.AnnotationFormatError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhang.jianming on 2017/1/17.
 */
public class DaoProxyFactory {

    /**
     * <span>
     *     1. 提供一个简单的工厂，用于生产一个代理对象。传入一个需要代理的接口，用于产生实现该接口的代理对象。
     * </span>
     * <span>
     *     2. 由于接口上使用Implement这个Annotation来指定这个接口所对应的实现类，
     *     所以我们可以获取这个实现类会创建一个实际被代理的对象。
     * </span>
     * @param dao
     * @param <T>
     * @return
     */
    public static <T> T newRoleDaoProxy(Class<T> dao){
        Implement implAnnotation = dao.getAnnotation(Implement.class);
        if(implAnnotation == null){
            throw new AnnotationFormatError("该接口未定义实现类的注解");
        }
        BaseDao implClass = null;
        try{
            implClass = implAnnotation.value().newInstance();
        }catch(Exception e){
            throw new RuntimeException("该接口所定义的实现类不能实例化", e);
        }
        return (T) Proxy.newProxyInstance(
                DaoProxyFactory.class.getClassLoader(),
                new Class<?>[]{dao},
                new RoleInvocationHandler(implClass)
        );
    }

    private static final class RoleInvocationHandler implements InvocationHandler{
        private BaseDao target;

        public RoleInvocationHandler(BaseDao target){
            this.target = target;
        }

        public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{
            Permission permitAnnotation = method.getAnnotation(Permission.class);
            /**
             * 迭代方法的允许权限，并与当前线程用户的权限做比较，如果发现两者相等，
             * 说明当前用户的权限与方法执行的权限一致，因此跳出循环，
             * 执行outter标签后面的方法，允许用户执行。
             *
             * 迭代完成后，当前线程用户的权限没有与方法中定义的权限一致，
             * 说明用户无权执行这样的操作，因此抛出安全异常
             */
            outter:
            if(permitAnnotation != null){
                Role currentRole = RoleContext.INSTANCE.getCurrentRole();
                for(Role permitRole : permitAnnotation.value()){
                    if(permitRole.equals(currentRole)){
                        break outter;
                    }
                }
                throw new SecurityException("当前用户不允许执行此操作");
            }
            return method.invoke(target, args);
        }
    }
}
