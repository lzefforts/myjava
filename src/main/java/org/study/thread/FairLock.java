package org.study.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁(排队的锁)
 * Created by ArnoldLee on 17/11/15.
 */
public class FairLock implements Runnable {
    //ReentrantLock(true) 构造公平锁
    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){

            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");
            } finally {
                fairLock.unlock();
            }

        }

    }

    public static void main(String[] args) {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1,"Thread_t1");
        Thread t2 = new Thread(r1,"Thread_t2");
        t1.start();
        t2.start();
    }
}
