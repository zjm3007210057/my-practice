package other.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by zhang.jianming on 2016/12/29.
 */
public class GenericTest {

    private Map<String, Integer> score;

    public static void main(String[] args) throws Exception{
        Class<GenericTest> clazz = GenericTest.class;
        Field f = clazz.getDeclaredField("score");
        Class<?> a = f.getType();
        System.out.println("score的类型是 : " + a);
        Type type = f.getGenericType();
        if(type instanceof ParameterizedType){
            ParameterizedType pType = (ParameterizedType)type;
            Type rType = pType.getRawType();
            System.out.println("原始类型是 : " + rType);
            Type[] tArgs = pType.getActualTypeArguments();
            System.out.println("泛型类型信息是: ");
            for(int i=0; i<tArgs.length; i++){
                System.out.println("第" + i + "个泛型类型是 : " + tArgs[i]);
            }
        }else{
            System.out.println("获取泛型类型出错！");
        }
    }
}
