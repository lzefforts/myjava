package org.study.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁特性:
 * 1.中断响应
 *
 * Created by ArnoldLee on 17/11/13.
 */
public class InLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public InLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            if(lock == 1){
                lock1.lockInterruptibly();
                try{
                   Thread.sleep(500);
                }catch (InterruptedException e){
                }
                lock2.lockInterruptibly();
            }else{
                lock2.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                }
                lock1.lockInterruptibly();
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId()+":线程退出");

        }

    }

    public static void main(String[] args) throws InterruptedException {
        InLock r1 = new InLock(1);
        InLock r2 = new InLock(2);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
    }

}
