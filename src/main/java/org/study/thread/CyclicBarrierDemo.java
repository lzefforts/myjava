package org.study.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 多线程并发控制工具,与CountDownLatch类似,也能实现计数器的方式,
 *
 * Created by ArnoldLee on 17/11/28.
 */
public class CyclicBarrierDemo {

    public static class Soldier implements Runnable{
        private String soldier;
        private final CyclicBarrier cyclic;

        public Soldier(CyclicBarrier cyclic, String soldier) {
            this.cyclic = cyclic;
            this.soldier = soldier;
        }

        @Override
        public void run() {

            try {
//                System.out.println("await...");
                cyclic.await();
//                System.out.println("1st await end");
                doWork();
//                System.out.println("dowork end");
                cyclic.await();
//                System.out.println("2st await end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }


        }

        void doWork(){
            try {
                Thread.sleep(Math.abs(new Random().nextInt()%10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier+":任务完成");

        }


    }

    public static class BarrierRun implements Runnable{
        boolean flag;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if(flag){
                System.out.println("司令:[士兵"+N+"个,任务完成!]");
            }else{
                System.out.println("司令:[士兵"+N+"个,集合完毕!]");
                flag = true;
            }

        }
    }


    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N,new BarrierRun(flag,N));

        //设置屏障点,主要是为了执行这个方法
        System.out.println("集合队伍!");

        for (int i=0;i<N;i++){
            System.out.println("士兵"+i+"报道!");
            allSoldier[i] = new Thread(new Soldier(cyclic,"士兵"+i));
            allSoldier[i].start();
        }

    }





}
