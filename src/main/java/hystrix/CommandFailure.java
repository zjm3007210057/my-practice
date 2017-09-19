package hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by zjm on 2016/11/1.
 */
public class CommandFailure extends HystrixCommand<String>{

    private final String name;

    public CommandFailure(String name){
        super(HystrixCommandGroupKey.Factory.asKey("I am a good boy"));
        this.name = name;
    }

    protected String run(){
        throw new RuntimeException("this command always fails");
    }

    protected String getFallback(){
        return "Hello Failure " + name + " !";
    }
}
