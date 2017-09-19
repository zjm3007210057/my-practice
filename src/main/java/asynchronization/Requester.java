package asynchronization;

/**
 * Created by zjm on 2016/11/2.
 */
public class Requester {

    public FutureTicket request(){
        final FutureTicket ft = new FutureTicket();
        //在新的线程中调用耗时操作
        new Thread(){
            public void run(){
                ft.makeRealData();
            }
        }.start();
        ft.getData();
        return ft;
    }
}
