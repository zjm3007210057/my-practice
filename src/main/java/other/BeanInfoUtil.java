package other;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by zjm on 2017/3/15.
 */
public class BeanInfoUtil {

    public static void setProperty(User user, String name) throws Exception{
        PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
        Method setMethod = pd.getWriteMethod();
        setMethod.invoke(user, "Tom");
        System.out.println("set name : " + user.getName());
    }

    public static void getProperty(User user, String name)throws Exception{
        PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
        Method getMethod = pd.getReadMethod();
        Object userName = getMethod.invoke(user);
        System.out.println("get nme : " + userName.toString());
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("zhang san");
        try{
            setProperty(user, "name");
            getProperty(user, "name");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
