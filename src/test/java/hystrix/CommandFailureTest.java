package hystrix;

import org.junit.Test;

/**
 * Created by zjm on 2016/11/2.
 */
public class CommandFailureTest {
    @Test
    public void run() throws Exception {
        String s = new CommandFailure("World").execute();
        System.out.println(s);
    }

}