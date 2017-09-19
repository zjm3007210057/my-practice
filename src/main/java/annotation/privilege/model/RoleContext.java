package annotation.privilege.model;

/**
 * 作为一个提供用户权限上下文的单元存在，使用枚举来实现单例模式，
 * ThreadLocal提供了对当前线程权限数据的访问
 * Created by zhang.jianming on 2017/1/17.
 */
public enum RoleContext {

    INSTANCE;

    private ThreadLocal<Role> role = new ThreadLocal<Role>();

    public Role getCurrentRole(){
        return role.get();
    }

    public void setCurrentRole(Role role){
        this.role.set(role);
    }
}
