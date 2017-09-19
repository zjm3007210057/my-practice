package hystrix;

import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.concurrent.Future;

/**
 * Created by zjm on 2016/11/1.
 */
public class HelloWorldTest {

    @Test
    public void run() throws Exception {
        System.out.println( new CommandHelloWorld("World").execute());
        System.out.println(  new CommandHelloWorld("Bob").execute());
    }

    @Test
    public void testAsychronous() throws Exception{
        Future<String> fs = new CommandHelloWorld("World ").queue();
        Observable<String> ho = new CommandHelloWorld("World ").observe();
        ho.subscribe(new Observer<String>() {
            public void onCompleted() {

            }

            public void onError(Throwable e) {
                e.printStackTrace();
            }

            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }
        });
        ho.subscribe(new Action1<String>() {
            public void call(String s) {
                System.out.println(s);
            }
        });
        String s1 = new CommandHelloWorld("World ").execute();
        String s2 = fs.get();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(fs.get());
    }

}