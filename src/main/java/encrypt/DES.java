package encrypt;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.Security;

/**
 * Created by zhangjianming on 2016/9/23.
 */
public class DES {

    public static String str = "imooc security des";

    public static void main(String[] args) {
        jdkDES();
        bcDES();
    }

    //生成key
    public static void jdkDES(){
        try {
            //DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：
            // 加密反馈模式、OFB：输出反馈模式
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            /*
            如果init()步骤省略的话，会根据算法自动使用默认的密钥长度。指定长度时，若第一步密钥
            生成器使用的是“DES”算法，则密钥长度必须是56位；若是“DESede”，则可以是112或
            168位，其中112位有效；若是“AES”，可以是128, 192或256位；若是“Blowfish”，
            则可以是32至448之间可以被8整除的数；“HmacMD5”和“HmacSHA1”默认的密钥长度都
            是64个字节。
            */
            keyGenerator.init(56);//指定key的位数
            SecretKey secretKey = keyGenerator.generateKey();//生成密钥
            byte[] bytesKey = secretKey.getEncoded();
            //key的转换
            DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            Key convertSecretKey = factory.generateSecret(desKeySpec);
            //加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
            byte[] result = cipher.doFinal(str.getBytes());
            System.out.println("imooc security des--加密后的结果为:" + Hex.encodeHexString(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println("imooc security des--解密后的结果为：" + new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bcDES() {
        try{
            Security.addProvider(new BouncyCastleProvider());
            //生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES", "BC");
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytes = secretKey.getEncoded();

            //key转换
            DESKeySpec desKeySpec = new DESKeySpec(bytes);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            Key convertSecretKey = factory.generateSecret(desKeySpec);

            //加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
            byte[] result = cipher.doFinal(str.getBytes());
            System.out.println("imooc security des--bc加密后的结果为:" + Hex.encodeHexString(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println("imooc security des--bc解密后的结果为：" + new String(result));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
