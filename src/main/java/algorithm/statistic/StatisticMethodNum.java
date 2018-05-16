package algorithm.statistic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 统计一个方法调用的次数
 * Created by zjm on 01/04/2018.
 */
public class StatisticMethodNum {

    /**
     * 原子操作类
     */
    private AtomicInteger at = new AtomicInteger(0);

    /**
     * 获取方法的调用次数
     * @return
     */
    public int getMethodCallNo(){
        return at.addAndGet(1);
    }

}
