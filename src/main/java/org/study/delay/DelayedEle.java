package org.study.delay;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by ArnoldLee on 2018/12/7.
 */
class DelayedEle implements Delayed {

    private final long delayTime; //延迟时间
    private final long expire;  //到期时间
    private String data;   //数据

    public DelayedEle(long delay, String data) {
        delayTime = delay;
        this.data = data;
        expire = System.currentTimeMillis() + delay;
    }

    /**
     * 剩余时间=到期时间-当前时间
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis() , TimeUnit.MILLISECONDS);
    }

    /**
     * 优先队列里面优先级规则
     */
    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) -o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DelayedElement{");
        sb.append("delay=").append(delayTime);
        sb.append(", expire=").append(expire);
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {


        DelayQueue<DelayedEle> delayQueue = new DelayQueue<DelayedEle>();

        LocalDateTime beginTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(beginTime));


        DelayedEle element1 = new DelayedEle(1000,"zlx");
        DelayedEle element2 = new DelayedEle(1000,"gh");

        delayQueue.offer(element1);
        delayQueue.offer(element2);

        try {
            element1 =  delayQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(formatter.format(endTime));

        System.out.println(element1);


    }
}
