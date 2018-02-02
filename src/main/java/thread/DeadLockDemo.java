package thread;

/**
 * 死锁实例
 * Created by zjm on 16/01/2018.
 */
public class DeadLockDemo implements Runnable{

    boolean flag;

    static Object o1 = new Object();
    static Object o2 = new Object();

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if(this.flag){
            synchronized (o1){
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }else {
            synchronized (o2){
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread demo1 = new Thread(new DeadLockDemo(true));
        Thread demo2 = new Thread(new DeadLockDemo(false));
        demo1.start();
        demo2.start();
    }
}
