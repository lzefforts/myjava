package org.study.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ArnoldLee on 17/11/30.
 */
public class DivTask implements Runnable{
    int a,b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a/b;
        System.out.println(re);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ThreadPoolExecutor pools = new ThreadPoolExecutor(0,Integer.MAX_VALUE,
        ThreadPoolExecutor pools = new TraceThreadPoolExecutor(0,Integer.MAX_VALUE,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>()
                );

        for(int i=0;i<5;i++){
//            pools.submit(new DivTask(100,i));//用submit方法无法打印出异常信息
//            Future future = pools.submit(new DivTask(100,i));
//            future.get();
            pools.execute(new DivTask(100,i));//用execute方法能打印出异常信息
        }

    }

}
