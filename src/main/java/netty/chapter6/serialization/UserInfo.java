package netty.chapter6.serialization;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * Created by zjm on 2016/10/26.
 */
public class UserInfo implements Serializable{

    private static final long serialVersionUID = 4522397779296864862L;

    private String userName;

    private int userId;

    public UserInfo buildUserName(String userName){
        this.userName = userName;
        return this;
    }

    public UserInfo buildUserId(int userId){
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public byte[] codeC(ByteBuffer buffer){
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        byte[] value = this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userId);
        buffer.flip();
        value = null;
        byte[] result = new byte[buffer.remaining()];//返回limit-position
        buffer.get(result);
        return result;
    }
}
