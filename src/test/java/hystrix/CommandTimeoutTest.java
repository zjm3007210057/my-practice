package hystrix;

import org.junit.Test;

/**
 * Created by zjm on 2016/11/1.
 */
public class CommandTimeoutTest {
    @Test
    public void run() throws Exception {
        System.out.println(new CommandTimeout("World").execute());
    }

}