package thread;

/**
 * Created by zjm on 17/10/2017.
 */
public class ThreadView implements Runnable{

    int n = 10;

    public synchronized void setN1() throws InterruptedException {
        n = 20;
        Thread.sleep(500);//6
        System.out.println("setN1:n=" + n);
    }

    public synchronized void setN2() throws InterruptedException {
        n = 50;
        Thread.sleep(200);//5
        System.out.println("setN2:n" + n);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadView t1 = new ThreadView();
        Thread t = new Thread(t1);//1
        t.start();//2
        t1.setN2();//3
        System.out.println("main thread n=" + t1.n);//4
    }

    @Override
    public void run() {
        try{
            setN1();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
