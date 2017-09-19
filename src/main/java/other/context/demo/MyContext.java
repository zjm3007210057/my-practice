package other.context.demo;

/**
 * 上下文信息类
 * Created by zjm on 2017/2/21.
 */
public class MyContext {
/*
    private CommenInformation information;

    private static final ThreadLocal<MyContext> LOCAL = new ThreadLocal<MyContext>(){
        @Override
        protected MyContext initialValue(){
            return new MyContext();
        }
    };

    private MyContext(){}

    public static MyContext getContext(){
        return LOCAL.get();
    }

    public static void removeContext(){
        LOCAL.remove();
    }

    public CommenInformation getInformation() {
        return information;
    }

    public void setInformation(CommenInformation information) {
        this.information = information;
    }

    public static ThreadLocal<MyContext> getLOCAL() {
        return LOCAL;
    }
    */

    private static ThreadLocal<CommenInformation> context = new ThreadLocal<CommenInformation>();

    private MyContext(){}

    public static <T extends CommenInformation> T get(){
        return (T) context.get();
    }

    public static void set(CommenInformation information){
        context.set(information);
    }

    public static void clear(){
        context.remove();
    }
}
