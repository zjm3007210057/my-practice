package encrypt;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * Created by zhangjianming on 2016/9/23.
 */
public class TripleDES {

    public static String str = "imooc security des";

    public static void main(String[] args) {
        jdk3DES();
    }

    public static void jdk3DES(){
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");

//            keyGenerator.init(168);//指定key的位数
            keyGenerator.init(new SecureRandom());//生成默认长度的key
            SecretKey secretKey = keyGenerator.generateKey();//生成密钥
            byte[] bytesKey = secretKey.getEncoded();
            //key的转换
            DESedeKeySpec desKeySpec = new DESedeKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
            Key convertSecretKey = factory.generateSecret(desKeySpec);
            //加密
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
            byte[] result = cipher.doFinal(str.getBytes());
            System.out.println("imooc security des--加密后的结果为:" + Hex.encodeHexString(result));

            //解密
            String encrypt = Hex.encodeHexString(result);
            cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println(encrypt + "--解密后的结果为：" + new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
