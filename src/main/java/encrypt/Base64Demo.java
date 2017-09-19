package encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by zjm on 2016/12/13.
 */
public class Base64Demo {

    private String publicKey = "密";
    private String pk;

    public void ency(){
        pk = new String("密".getBytes());
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            String s = encoder.encode(pk.getBytes());
            System.out.println(s);
            String str = "6L+Z5piv5LiA5bCB5rWL6K+V6YKu5Lu277yB";
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(str);
            String res = new String(bytes);
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Base64Demo demo = new Base64Demo();
        demo.ency();
    }
}
