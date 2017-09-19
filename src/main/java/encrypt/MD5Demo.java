package encrypt;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by zjm on 2016/12/15.
 */
public class MD5Demo {

    //神奇的魔术，把常量变为变量
    private static final int RAND_CONST = new Random().nextInt();

    public static void main(String[] args) {
        System.out.println(RAND_CONST);
        try {
            String msg = "MD5测试";
            MessageDigest md = MessageDigest.getInstance("MD5");
            MessageDigest md1 = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(msg.getBytes());
            byte[] bytes1 = md1.digest(msg.getBytes());
            String msg2 = DigestUtils.md5Hex(bytes);
            System.out.println(DigestUtils.sha256Hex(bytes1));
            System.out.println(msg2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
