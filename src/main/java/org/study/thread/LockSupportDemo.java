package org.study.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport工具类,可以在线程任意位置让线程阻塞
 * Created by ArnoldLee on 17/11/29.
 */
public class LockSupportDemo {

    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name){
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u){
                System.out.println("in "+getName());
                LockSupport.park();
                System.out.println(getName()+" parking");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        System.out.println(t1.getName()+" unpark");
        LockSupport.unpark(t2);
        System.out.println(t2.getName()+" unpark");
        t1.join();
        t2.join();
    }



}
