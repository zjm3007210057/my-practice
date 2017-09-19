package other;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zjm on 2016/12/23.
 */
public class SerilizationDemo {

    public static void test()throws Exception{
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(os);
        out.writeObject(new User("zhangsan", 16));
        byte[] bytes = os.toByteArray();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream is = new ObjectInputStream(in);
        User user = (User)is.readObject();
        System.out.println(user);
    }

    public static void main(String[] args) {
        try{
            test();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
