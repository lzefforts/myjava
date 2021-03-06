package org.study.thread;

/**
 * synchronized修饰的变量 ,错误的修饰方法
 * Created by ArnoldLee on 17/11/13.
 */
public class AccountingSyncBad implements Runnable {
    static AccountingSyncBad instance = new AccountingSyncBad();
    static int i = 0;

    public synchronized void increase(){
        i++;
    }

    @Override
    public void run() {
        for(int j=0;j<10000000;j++){
//            synchronized (instance){
//                i++;
//            }
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AccountingSyncBad());
        Thread t2 = new Thread(new AccountingSyncBad());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
