package examples1200.chapter6Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjm on 2016/12/22.
 */
public class ThreadList {

    public static ThreadGroup getRootThreadGroups(){
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();//获得当前线程组
        while(true){
            //如果getParent返回值为空，则是跟线程组
            System.out.println(rootGroup.getName());
            if(rootGroup.getParent() != null){
                rootGroup = rootGroup.getParent();
            }else{
                break;
            }
        }
        return rootGroup;
    }

    //获取给定线程组中的所有线程名
    public static List<String> getThreads(ThreadGroup group){
        List<String> threadList = new ArrayList<String>();
        Thread[] threads = new Thread[group.activeCount()];//根据活动线程数创建线程组
        int count = group.enumerate(threads, false);
        for(int i=0; i<count; i++){
            threadList.add(group.getName() + "线程组: " + threads[i].getName());
        }
        return threadList;
    }

    public static List<String> getThreadGroups(ThreadGroup group){
        List<String> threadList = getThreads(group);
        ThreadGroup[] groups = new ThreadGroup[group.activeGroupCount()];
        int count = group.enumerate(groups, false);
        for(int i=0; i<count; i++){
            threadList.addAll(getThreads(groups[i]));//利用getThreads方法获得线程名列表
        }
        return threadList;
    }

    public static void main(String[] args) {
        for(String s : getThreadGroups(getRootThreadGroups())){
            System.out.println(s);
        }
    }
}
