package encrypt;

import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

/**
 * Created by zjm on 2016/12/19.
 */
public class RSADemo {

    public static KeyPair generateKeyPair(){
        try{
            Security.addProvider(new BouncyCastlePQCProvider());
            SecureRandom random = new SecureRandom();
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024, random);
            return generator.generateKeyPair();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
