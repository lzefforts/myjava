package org.study.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 * Created by ArnoldLee on 17/11/13.
 */
public class ReenterLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for(int j=0;j<10000000;j++){
            lock.lock();//手动加入lock
            try{
                i++;
            }finally {
                lock.unlock();//手动释放lock
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock tl = new ReenterLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
