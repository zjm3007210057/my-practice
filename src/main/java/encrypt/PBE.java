package encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * Created by zhangjianming on 2016/9/23.
 */
public class PBE {

    private static String str = "my encrypt test";

    public static void main(String[] args) {
        jdkPBE();
    }

    public static void jdkPBE(){
        try{
            //初始化盐
            SecureRandom random = new SecureRandom();
            byte[] salt = random.generateSeed(8);
            //口令和密钥
            String password = "immoc";
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
            Key key = factory.generateSecret(pbeKeySpec);

            //加密
            PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
            Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
            cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
            byte[] result = cipher.doFinal(str.getBytes());
            System.out.println("my encrypt test--加密后为：" + Base64.encodeBase64String(result));

            //解密
            String encrypt = Base64.encodeBase64String(result);
            cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
            result = cipher.doFinal(result);
            System.out.println(encrypt + "--解密结果为：" + new String(result));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
