package org.study.jvm;

/**
 * Created by ArnoldLee on 17/11/1.
 */
public class HoldCPUMain {

    public static class HoldCPUTask implements Runnable{
        @Override
        public void run() {
            while (true){
                double a = Math.random()*Math.random();//占用内存
            }
        }
    }

    public static class LazyTask implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);//空闲线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new HoldCPUTask()).start();
        new Thread(new LazyTask()).start();
        new Thread(new LazyTask()).start();
        new Thread(new LazyTask()).start();
    }


}
