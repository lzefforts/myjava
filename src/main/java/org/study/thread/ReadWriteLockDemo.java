package org.study.thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写分离锁
 * Created by ArnoldLee on 17/11/22.
 */
public class ReadWriteLockDemo {

    private static Lock lock = new ReentrantLock();//普通的重入锁
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();//读写分离锁

    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private static int value;

    //模拟读操作
    public Object handleRead(Lock lock) throws InterruptedException{

        try{
            System.out.println("read......");
            lock.lock();//模拟读操作
            Thread.sleep(1000);//读操作的耗时越多,读写锁的优势就明显
            return value;
        }finally {
            lock.unlock();
        }
    }

    //模拟写操作
    public void handlerWrite(Lock lock,int index) throws InterruptedException{
        try {
            System.out.println("write......");
            lock.lock();
            Thread.sleep(1000);
            value = index;
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);//读写锁控制的读
//                    demo.handleRead(lock);//普通的重入锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handlerWrite(writeLock,new Random().nextInt());//读写锁控制的写
//                    demo.handlerWrite(lock,new Random().nextInt());//普通的重入锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        for(int i=0;i<18;i++){
            new Thread(readRunnable).start();
        }

        for(int i=18;i<20;i++){
            new Thread(writeRunnable).start();
        }

    }


}
