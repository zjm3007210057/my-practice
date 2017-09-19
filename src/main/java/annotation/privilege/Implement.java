package annotation.privilege;

import annotation.privilege.dao.BaseDao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来指定Dao接口对应的实现类
 * Created by zhang.jianming on 2017/1/17.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Implement {

    Class<? extends BaseDao> value();
}
