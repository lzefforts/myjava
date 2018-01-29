package org.study.thread;

/**
 * 错误的加锁方式
 * Created by ArnoldLee on 17/11/13.
 */
public class BadLockOnInteger implements Runnable {
    public static Integer i = 0;
    static BadLockOnInteger instance = new BadLockOnInteger();

    @Override
    public void run() {
        for(int j=0;j<10000000;j++){
            //由于i的类型是Integer,Integer是不变对象,所以i++本质上是用Integer.valueOf(i)方法新增了一个i++的对象
            //所以,由于i是变化的,在i上加入synchronized,并不起作用
//            synchronized (i){
//                i++;
//            }

            //改为修饰instance即可保证线程的安全
            synchronized (instance){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
