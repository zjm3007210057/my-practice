package hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by zjm on 2016/10/31.
 */
public class CommandHelloWorld extends HystrixCommand<String>{

    private final String name;

    public CommandHelloWorld(String name){
        super(HystrixCommandGroupKey.Factory.asKey("I am fine"));
        this.name = name;
    }

    protected String run(){
//        System.out.println("Hello " + name + "!");
        throw new RuntimeException("error");
    }

    protected String getFallback(){
        return "Failure " + name + " !";
    }

}
