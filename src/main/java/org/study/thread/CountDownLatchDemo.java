package org.study.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程控制工具类,俗称到计数器
 *
 * Created by ArnoldLee on 17/11/28.
 */
public class CountDownLatchDemo implements Runnable {

    static final CountDownLatch end = new CountDownLatch(10);//需要有10个线程完成任务
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            //模拟检查任务
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("check complete");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            exec.submit(demo);
        }

        System.out.println("waiting....");
//        Long count = end.getCount();
//        System.out.println("count:"+count);
        //等待检查,主线程等待10个线程完成任务
        end.await();
        //发射火箭
        System.out.println("Fire!");
        exec.shutdown();

    }

}
