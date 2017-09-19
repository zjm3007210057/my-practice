package asynchronization;

/**
 * 在JAVA平台,实现异步调用的角色有如下三个角色:
 *   调用者 取货凭证   真实数据
 *   一个调用者在调用耗时操作,不能立即返回数据时,先返回一个取货凭证.然后在过一断时间后
 *   凭取货凭证来获取真正的数据.
 *
 * Created by zjm on 2016/11/2.
 */
public class FutureTicket {

    private Object data = null;
    private boolean completed = false;

    public synchronized void makeRealData(){
        if(this.completed)
            return;
        try{
            //模拟耗时操作
            Thread.sleep(10000);
        }catch(Throwable t){
            // TODO: 2016/11/2
        }
        this.data = "返回的数据";
        this.completed = true;
        notifyAll();
    }

    public synchronized Object getData(){
        while(!this.completed){
            try{
                wait();
            }catch(Throwable t){
                // TODO: 2016/11/2
            }
        }
        return this.data;
    }

    public boolean isCompleted(){
        return this.completed;
    }
}
