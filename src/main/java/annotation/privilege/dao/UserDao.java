package annotation.privilege.dao;


import annotation.privilege.Implement;
import annotation.privilege.Permission;
import annotation.privilege.model.Role;

/**
 * Created by zhang.jianming on 2017/1/17.
 */
@Implement(UserDaoImpl.class)
public interface UserDao extends BaseDao {

    @Permission({Role.ADMINISTRATOR, Role.SYSTEM})
    void save();

    @Permission(Role.SYSTEM)
    void delete();

    @Permission({Role.USER, Role.ADMINISTRATOR, Role.SYSTEM})
    void query();
}
