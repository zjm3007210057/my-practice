package performance;

import com.google.common.base.Objects;

/**
 * Created by zjm on 2017/2/18.
 */
public class ObjectsTest {

    public static void main(String[] args) {
        String s1 = "abs";
        String s2 = "abs";
        System.out.println(Objects.equal(s1, s2));
    }
}
