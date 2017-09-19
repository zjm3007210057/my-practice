package hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by zjm on 2016/11/1.
 */
public class CommandTimeout extends HystrixCommand<String>{

    private final String name;

    public CommandTimeout(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("this is timeout test"));
        this.name = name;
    }

    @Override
    protected String getFallback() {
        return "you did failure " + name + " !";
    }

    @Override
    protected String run() throws Exception {
        System.out.println("run method start !");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("run method end!");
        return "";
    }
}
