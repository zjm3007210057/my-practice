package thread;

/**
 * Created by zjm on 2017/2/9.
 */
public class ThreadLocalDemo {

    private static class MyThreadLocal implements Runnable{

        private ThreadLocal<Integer> threadLocal = new ThreadLocal();

        @Override
        public void run() {
            threadLocal.set((int)(Math.random() * 100D));
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){

            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) throws Exception{
        MyThreadLocal myThreadLocal = new MyThreadLocal();
        Thread thread1 = new Thread(myThreadLocal);
        Thread thread2 = new Thread(myThreadLocal);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
