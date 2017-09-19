package annotation.privilege.dao;

/**
 * Created by zhang.jianming on 2017/1/17.
 */
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("UserDaoImpl.save()");
    }

    public void delete() {
        System.out.println("UserDaoImpl.delete()");
    }

    public void query() {
        System.out.println("UserDaoImpl.query()");
    }
}
