package annotation.privilege;

import annotation.privilege.model.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于指定Dao层的方法的可访问的人员的访问权限
 * Created by zhang.jianming on 2017/1/17.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {

    Role[] value();
}
