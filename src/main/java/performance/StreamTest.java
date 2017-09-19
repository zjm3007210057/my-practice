package performance;

import java.util.Collections;

/**
 * Created by zjm on 2017/2/18.
 */
public class StreamTest {


    private Collections collections;

    public void collectionTest(){

    }

    public static void main(String[] args) {
        /*List<String> list = new ArrayList<String>(Arrays.asList("one", "two"));
        Stream<String> stream = list.stream();
        list.forEach(System.out::println);*/
        int a = 5;
        int b = 7;
        int c = a ^ b;
        a = c ^ a;
        b = c ^ b;
        System.out.println("a : " + a + "; b : " + b);
    }
}
