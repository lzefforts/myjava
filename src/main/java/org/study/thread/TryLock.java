package org.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁特性:
 * 2.锁申请等待限时
 * TODO 并没有出现预期的输出
 * 预期输出为:
 *          9:My Job Done
 *          8:My Job Done
 * Created by ArnoldLee on 17/11/15.
 */
public class TryLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
//        System.out.println(this.lock);
        if(lock == 1){
            while (true){
                //如果lock1获得锁成功
                if(lock1.tryLock()){
//                    System.out.println("get lock1");
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //如果lock2获得锁成功
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getId() + ":My Job Done");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    }finally {
                        lock1.unlock();
                    }


                }
                else{
                    while (true){
                        //如果lock2获得锁成功
                        if (lock2.tryLock()){
//                            System.out.println("get lock2");
                            try {
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                //如果lock1获得锁成功
                                if (lock1.tryLock()) {
                                    try {
                                        System.out.println(Thread.currentThread().getId() + ":My Job Done");
                                        return;
                                    } finally {
                                        lock1.unlock();
                                    }
                                }
                            }finally {
                                lock2.unlock();
                            }
                        }


                    }



                }


            }
        }

    }

    public static void main(String[] args) {
        TryLock r1 = new TryLock(1);
        TryLock r2 = new TryLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
