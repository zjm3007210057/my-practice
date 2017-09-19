package performance;

import java.io.*;

/**
 * Created by zjm on 2017/2/18.
 */
public class SerilizableTest {

    public static void main(String[] args) {
        User user = new User();
        user.setNick("nick");
        user.setName("name");
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("test.txt"));
            //如果User不实现Serializable则不能进行写入文件操作
            os.writeObject(user);
            os.flush();
            os.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            user.setName("newName");
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("test.txt"));
            User u = (User)is.readObject();
            is.close();
            System.out.println(u.getName());
            System.out.println(u.getNick());
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
class User implements Serializable{
    private static String name;
    private transient String nick;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
