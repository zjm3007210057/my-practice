package other.context.demo;

/**
 * Created by zjm on 2017/2/21.
 */
public class Main {

    public static void main(String[] args) {
        CommenInformation information = new CommenInformation();
        information.setName("I am test");
        information.setCode("abc");
        MyContext.set(information);
        System.out.println(MyContext.get());
        for(int i=0; i<3; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(MyContext.get());
                }
            }).start();
        }
    }
}
