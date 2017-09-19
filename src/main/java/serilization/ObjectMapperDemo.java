package serilization;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

/**
 * Created by zjm on 2017/3/3.
 */
public class ObjectMapperDemo {

    public void convert(BaseObject object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(object);
            String js = JSON.toJSONString(object);
            System.out.println(js);
            System.out.println(js.equals(json));//false
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ObjectMapperDemo demo = new ObjectMapperDemo();
        BaseObject object = new BaseObject();
        String[] array = {"a", "b", "v"};
        object.setHeight(15);
        object.setSex(true);
        object.setUserName("luowu");
        object.setUserCode("code");
        object.setArray(array);
        BaseObject bo = new BaseObject();
        bo.setInnerBaseObject(object);
        String[] strings = {"vn", "dm", "dsf"};
        bo.setArray(strings);
        bo.setUserCode("hekol");
        bo.setSex(false);
        bo.setHeight(187);
        demo.convert(bo);
    }
}
