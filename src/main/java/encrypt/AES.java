package encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * Created by zhangjianming on 2016/9/23.
 */
public class AES {

    public static String str = "imooc security des";

    public static void main(String[] args) {
        jdkAES();
    }

    public static void jdkAES(){
        //生成Key
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//            keyGenerator.init(256);
            keyGenerator.init(new SecureRandom());//生成默认长度的key
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            //key转换
            Key key = new SecretKeySpec(keyBytes, "AES");

            //加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(str.getBytes());
            System.out.println("imooc security des--加密结果：" + Base64.encodeBase64String(result));

            //解密
            String encrypt = Base64.encodeBase64String(result);
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(result);
            System.out.println(encrypt + "--解密结果：" + new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
